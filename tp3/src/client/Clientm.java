package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;    
import java.net.Socket;
import java.util.Scanner;

public class Clientm {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            int port = 1234;
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server at " + host + ":" + port);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String msg= socket.getRemoteSocketAddress().toString();
            System.out.println("connected");
            out.writeUTF(msg);

            in.close();
            out.close();
            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();}}}