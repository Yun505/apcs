package day7_bca_chat_with_serialization;

import java.io.ObjectInputStream;

public class ChatClientSocketListener implements Runnable {
    private ObjectInputStream socketIn;

    public ChatClientSocketListener(ObjectInputStream socketIn) {
        this.socketIn = socketIn;
    }

    private void processChatMessage(MessageStoC_Chat m) {
        System.out.println(m.userName + ": " + m.msg);
    }

    private void processWelcomeMessage(MessageStoC_Welcome m) {
        System.out.println(m.userName + " joined the server!");
    }

    private void processExitMessage(MessageStoC_Exit m) {
        System.out.println(m.userName + " left the server!");
    }

    private void processListMessage(MessageS_to_C_ListResponse m){
        System.out.println("Users: ");
        for (int i = 0; i < m.a.size(); i++){
            System.out.println("User: " + m.a.get(i));
        }
    }
    private void processTimeMessage(MessageStoC_TimeResponse m){
        System.out.println("User Times: ");
        for (int i = 0; i < m.v.size(); i++){
            System.out.println(i + ": " + m.v.get(i));
        }
    }
    @Override
    public void run() {
        try {
            while (true) {
                Message msg = (Message) socketIn.readObject();

                if (msg instanceof MessageStoC_Welcome) {
                    processWelcomeMessage((MessageStoC_Welcome) msg);
                }
                else if (msg instanceof MessageStoC_Chat) {
                    processChatMessage((MessageStoC_Chat) msg);
                }
                else if (msg instanceof MessageStoC_Exit) {
                    processExitMessage((MessageStoC_Exit) msg);
                }
                else if (msg instanceof MessageS_to_C_ListResponse){
                    processListMessage((MessageS_to_C_ListResponse) msg);
                }
                else if (msg instanceof MessageStoC_TimeResponse){
                    processTimeMessage( (MessageStoC_TimeResponse)msg);
                }
                else {
                    System.out.println("Unhandled message type: " + msg.getClass());
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception caught in listener - " + ex);
        } finally{
            System.out.println("Client Listener exiting");
        }
    }
}
