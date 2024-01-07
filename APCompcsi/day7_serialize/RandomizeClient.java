package day7_serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class RandomizeClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What's the server IP? ");
        String serverip = userInput.nextLine();
        System.out.println("What's the server port? ");
        int port = userInput.nextInt();
        userInput.nextLine();

        try (Socket socket = new Socket(serverip, port)){

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream() ); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            
            System.out.print("Enter a max range: ");
            while(userInput.hasNextLine()) { 
                RandomIntMessage m = new RandomIntMessage(Integer.parseInt(userInput.nextLine()));
                out.writeObject(m);
                out.flush();
                m = (RandomIntMessage) in.readObject();
                System.out.println("\nServer responded with: " + m.getRandInt());
                System.out.print("Enter a max range: ");
            }
        }

        userInput.close();
    }
}

