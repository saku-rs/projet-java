package server;

import java.net.ServerSocket;
import java.net.Socket;

public class servermultithread {
    private static int count = 0;
    private static int nbroperation = 0;

    public servermultithread() {
        nbroperation++;
        System.out.println("Number of operations performed: " + nbroperation);
    }
    public static void main(String[] args) {
        try {
        int port = 1234;
        ServerSocket  server = new ServerSocket(port);
        while (true) {
            Socket socketclient = server.accept();
            count++;
            System.out.println("Client connected: " + count);
            
            Thread t = new Thread(new ClientHandler(socketclient,count));
            t.start();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}}