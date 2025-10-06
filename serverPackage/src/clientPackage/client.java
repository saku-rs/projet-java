package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {
try {
            System.out.println("Je suis un client pas encore connecté…");
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Je suis un client connecté!");

            socket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            e.printStackTrace();
    }
    }}
