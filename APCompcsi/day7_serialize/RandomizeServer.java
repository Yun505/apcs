package day7_serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomizeServer {
    public static final int PORT = 54325;

    public static void main(String[] args) throws Exception {
        // try with resources, closes serverSocket in case of error
        try (ServerSocket listener = new ServerSocket(PORT)) {
            System.out.println("Server started.");
            System.out.println("Local IP: " + Inet4Address.getLocalHost().getHostAddress());
            System.out.println("Local Port: " + listener.getLocalPort());

            // In Java, you should never create threads directly;
            // instead, employ a thread pool and use an executor service to manage the
            // threads.
            // Limiting the thread pool size protects us against being swamped with millions
            // of clients.

            ExecutorService pool = Executors.newFixedThreadPool(50);
            while (true) {
                Socket socket = listener.accept();
                Runnable r = new CapitalizeHandler(socket);
                pool.execute(r);
            }
        }
    }

    static class CapitalizeHandler implements Runnable {
        private Socket socket;

        CapitalizeHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Connected: " + socket);
            try {
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 

                RandomIntMessage m;
                while (true) {
                    m = (RandomIntMessage) in.readObject();
                    System.out.printf("%s:%d sent \"%s\"\n", socket.getInetAddress(), socket.getPort(), m);

                    // Create new message or edit old one to send back
                    m.setRandInt((int) (Math.random() * m.getMaxInt()));
                    out.writeObject(m);
                    out.flush();
                }

            } catch (Exception e) {
                System.out.println("Error: " + socket);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
                System.out.println("Closed: " + socket);
            }

        }
    }
}
