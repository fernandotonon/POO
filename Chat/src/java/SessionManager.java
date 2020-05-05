
import java.util.HashMap;
import java.util.Map;
import javax.websocket.Session;


public class SessionManager {
    private static Map<String,Session> sessoes = new HashMap<>();

    public static Map<String, Session> getSessoes() {
        return sessoes;
    }

    public static void addSession(Session session) {
        sessoes.put(session.getId(), session);
    }

    public static void removeSession(Session session) {
        sessoes.remove(session.getId());
    }    
    
    public static String sessionsIdToJSON(){
        String JSONSessoes = "{\"sessoes\":[";
        for(String id:sessoes.keySet()){
            JSONSessoes += "\""+id+"\",";   
        }
        JSONSessoes = JSONSessoes.substring(0, JSONSessoes.length()-1);
        JSONSessoes += "]}";
        return JSONSessoes;
    }
    
}
