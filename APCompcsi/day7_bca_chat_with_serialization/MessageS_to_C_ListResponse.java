package day7_bca_chat_with_serialization;
import java.util.List;
import java.util.ArrayList;
public class MessageS_to_C_ListResponse extends Message{
    public ArrayList<String> a = new ArrayList<String>(100);

    public MessageS_to_C_ListResponse(List<ClientConnectionData> b){
        for (int i = 0; i < b.size(); i ++){
            a.add(b.get(i).getUserName());
        }
    }
}