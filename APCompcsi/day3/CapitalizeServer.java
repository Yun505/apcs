package day3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeServer {
   public static void main(String[] args) throws Exception {
       try (ServerSocket listener = new ServerSocket(54322)) {
           System.out.println("Capitalization server is running.");
           System.out.println("Port: " + listener.getLocalPort());

           while(true) {
               Socket socket = listener.accept();
               Runnable r = new Capitalizer(socket);
               Thread t = new Thread(r);
                t.start();
           }
       }
   } 
}

class Capitalizer implements Runnable {
    private Socket socket;

    public Capitalizer(Socket s) {
        socket = s;
    }

    public void run() {
        System.out.println("Connected: " + socket);
        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (in.hasNextLine()) {
                String text = in.nextLine();
                System.out.printf("%s:%d sent %s\n", socket.getInetAddress(), socket.getPort(),
                text);
                out.println(text.toUpperCase());
            }
            
        }
        catch (Exception e) {
            System.out.println("Error: " + socket);
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException ioe) {}
        }
    }
}
