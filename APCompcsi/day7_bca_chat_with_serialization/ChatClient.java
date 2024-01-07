package day7_bca_chat_with_serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;

//time stuff hehe
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ChatClient {
    private Socket socket;
    private ObjectOutputStream socketOut;
    private ObjectInputStream socketIn;
    public static ArrayList<String> names_list = new ArrayList<String>(100);
    public static ArrayList<String> times_list = new ArrayList<String>(100);

    public ChatClient(String ip, int port) throws Exception {
        socket = new Socket(ip, port);
        socketOut = new ObjectOutputStream(socket.getOutputStream());
        socketIn = new ObjectInputStream(socket.getInputStream());
    }

    // start a thread to listen for messages from the server
    private void startListener() {
        new Thread(new ChatClientSocketListener(socketIn)).start();
    }

    private void sendMessage(Message m) throws Exception {
        socketOut.writeObject(m);
//        socketOut.flush();
    }

    private void mainLoop(Scanner in) throws Exception {
        System.out.print("Chat sessions has started - enter a user name: ");
        String name = in.nextLine().trim();
        names_list.add(name);
        
        String time_String = java.time.LocalDate.now().toString();
        time_String += java.time.LocalTime.now();
        times_list.add(time_String);

        sendMessage(new MessageCtoS_Join(name));
        String line = in.nextLine().trim();
        while (!line.toLowerCase().startsWith("/quit")) {
            
            if (line.toLowerCase().startsWith("/list")){
                sendMessage(new MessageCtoS_ListRequest(names_list));
            }
            else if(line.toLowerCase().startsWith("/time")){
                sendMessage(new MessageCtoS_TimeRequest(times_list));
            }
            sendMessage(new MessageCtoS_Chat(line));
            line = in.nextLine().trim();
        }
        sendMessage(new MessageCtoS_Quit());
    }

    private void closeSockets() throws Exception {
        socketIn.close();
        socketOut.close();
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What's the server IP? ");
        String serverip = userInput.nextLine();

        System.out.println("What's the server port? ");
        int port = userInput.nextInt();
        userInput.nextLine();

        ChatClient cc = new ChatClient(serverip, port);

        cc.startListener();
        cc.mainLoop(userInput);

        userInput.close();
        cc.closeSockets();
    }

}
