import java.io.IOException;
import java.io.StringReader;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

@ServerEndpoint("/endpoint")
public class WebSocketServer {
    SessionManager sessionManager = new SessionManager();
    
    private void enviarListaTodos(){
        try {
            String JSONSessoes = sessionManager.sessionsIdToJSON();
        
            for(Session sessao : sessionManager.getSessoes().values()){
                    sessao.getBasicRemote().sendText(JSONSessoes);
            }
        } catch (IOException ex) {
            Logger.getLogger(WebSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen::" + session.getId());  
        sessionManager.addSession(session);
                
        enviarListaTodos();
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose::" +  session.getId());
        sessionManager.removeSession(session);
        
        enviarListaTodos();
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("onMessage::de=" + session.getId() + " Menssagem=" + message);

        try {
            String pessoaJSON = message;         
            JsonReader reader = Json.createReader(new StringReader(pessoaJSON));         
            JsonObject pessoaObjeto = reader.readObject();
            reader.close();
            
            String remetente = pessoaObjeto.getString("remetente");
            String destinatario = "";
            if(pessoaObjeto.getJsonString("destinatario")!=null)
                destinatario = pessoaObjeto.getString("destinatario");
            
            String mensagem = pessoaObjeto.getString("mensagem");
            
            if(destinatario==null||destinatario.equals("")){
                for(Session sessao : sessionManager.getSessoes().values()){
                    if(!sessao.getId().equals(session.getId()))
                        sessao.getBasicRemote().sendText(mensagem);
                }
            }else{
                if(sessionManager.getSessoes().containsKey(destinatario))
                    sessionManager.getSessoes().get(destinatario).getBasicRemote().sendText(mensagem);
            }  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println("onError::" + t.getMessage());
    }
}
