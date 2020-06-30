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
        
            for(MinhaSessao sessao : sessionManager.getSessoes().values()){
                    sessao.getSessao().getBasicRemote().sendText(JSONSessoes);
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
            
            if(pessoaObjeto.containsKey("nome")){
                Pessoa pessoa;
                int idade = Integer.valueOf(pessoaObjeto.getString("idade"));
                if(idade<18)
                    pessoa = new Crianca();
                else
                    pessoa = new Adulto();
                
                pessoa.setNome(pessoaObjeto.getString("nome"));
                pessoa.setIdade(idade);
                
                SessionManager.updatePessoa(session, pessoa);
            }
            else{
                String destinatario = "";
                if(pessoaObjeto.getJsonString("destinatario")!=null)
                    destinatario = pessoaObjeto.getString("destinatario");

                String mensagem = pessoaObjeto.getString("mensagem");
                String mensagemEnvio = "{\"remetente\":\""+SessionManager.getSession(session.getId()).getNome()+"\",\"mensagem\":\""+mensagem+"\"}";

                if(destinatario==null||destinatario.equals("")){
                    for(MinhaSessao sessao : sessionManager.getSessoes().values()){
                        if(!sessao.getSessao().getId().equals(session.getId()))
                            sessao.getSessao().getBasicRemote().sendText(mensagemEnvio);
                    }
                }else{
                    Session destino = sessionManager.getSessaoDestinatario(destinatario);
                    if(destino!=null)
                        destino.getBasicRemote().sendText(mensagemEnvio);
                }                  
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
