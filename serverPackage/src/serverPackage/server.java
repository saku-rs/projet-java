
package serverPackage;
import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");

            Socket socket = serverSocket.accept();
            System.out.println("Un client est connecté!");

            socket.close();
            serverSocket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
}


