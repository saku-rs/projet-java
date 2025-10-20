package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socketclient;
    private int clientNumber;

    public ClientHandler(Socket socketclient, int clientNumber) {
        this.socketclient = socketclient;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(socketclient.getInputStream());
            DataOutputStream out = new DataOutputStream(socketclient.getOutputStream());
            String message = in.readUTF();
            System.out.println("Received from client " + clientNumber + ": " + message);
            in.close();
            out.close();
            socketclient.close();
            System.out.println("Client " + clientNumber + " disconnected.");
        } catch (Exception e) {
            e.printStackTrace();

}
    }}