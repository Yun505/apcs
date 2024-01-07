package day7_bca_chat_with_serialization;
import java.util.List;
import java.util.ArrayList;

public class MessageStoC_TimeResponse extends Message{
    public ArrayList<String> v = new ArrayList<String>(100);

    public MessageStoC_TimeResponse(List<ClientConnectionData> b){
        for (int i = 0; i < b.size(); i ++){
            v.add(b.get(i).getUserName() + ": " + b.get(i).getTime());
        }
    }
}
