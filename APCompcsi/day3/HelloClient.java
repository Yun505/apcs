package day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloClient {
    public static final int PORT = 54321;
//    public static final String IP = "34.224.6.10";
    public static final String IP = "127.0.0.1";
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner (System.in);
        System.out.println("What is your name?");

        String n = in.nextLine();
        in.close();

        Socket socket = new Socket(IP, PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        out.println(n);
        out.flush();

        System.out.println("Sent message");
        String res = input.readLine();

        System.out.println("Response: " + res);
        socket.close();

    }


}
