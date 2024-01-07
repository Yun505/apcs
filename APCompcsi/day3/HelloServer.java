package day3;

import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static final int PORT = 54321;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server start...");
        System.out.println("IP: " + Inet4Address.getLocalHost().getHostAddress());
        System.out.println("Port: " + serverSocket.getLocalPort());

        while(true) {
            Socket socket = serverSocket.accept();

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String name = input.readLine();
            System.out.println("Connection from: " + name);

            out.println("Hi, " + name);
            out.flush();
            //added because annoying prob
            serverSocket.close();   
        }
    }
    
}
