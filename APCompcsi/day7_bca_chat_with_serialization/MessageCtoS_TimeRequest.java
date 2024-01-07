package day7_bca_chat_with_serialization;
import java.util.ArrayList;


public class MessageCtoS_TimeRequest extends Message{
    public ArrayList<String> b = new ArrayList<String>(100);

    public MessageCtoS_TimeRequest(ArrayList<String> b){
        this.b = b;
    }
}
