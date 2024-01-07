package day7_bca_chat_with_serialization;
import java.util.ArrayList;
public class MessageCtoS_ListRequest extends Message{
    public ArrayList<String> a = new ArrayList<String>(100);

    public MessageCtoS_ListRequest(ArrayList<String> a){
        this.a = a;
    }
}
