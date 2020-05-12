
import java.util.HashMap;
import java.util.Map;
import javax.websocket.Session;

public class SessionManager {
    private static Map<String,MinhaSessao> sessoes = new HashMap<>();

    public static Map<String, MinhaSessao> getSessoes() {
        return sessoes;
    }

    public static void addSession(Session session) {
        sessoes.put(session.getId(), new MinhaSessao(session));
    }

    public static void removeSession(Session session) {
        sessoes.remove(session.getId());
    }    
    
    public static String sessionsIdToJSON(){
        String JSONSessoes = "{\"sessoes\":[";
        for(MinhaSessao m:sessoes.values()){
            JSONSessoes += "\""+m.getNome()+"\",";   
        }
        JSONSessoes = JSONSessoes.substring(0, JSONSessoes.length()-1);
        JSONSessoes += "]}";
        return JSONSessoes;
    }
    
    public static void updateNome(Session session, String nome){
        sessoes.get(session.getId()).setNome(nome);
    }
    
    public static Session getSessaoDestinatario(String nome){
        
        Session s = null;
        
        for(MinhaSessao sessao : getSessoes().values()){
            if(sessao.getNome()!=null&&sessao.getNome().equals(nome)){
                s = sessao.getSessao();
                break;
            }
        }
        
        return s;
    }
}
