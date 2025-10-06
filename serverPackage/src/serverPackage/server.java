
package serverPackage;
import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");

            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Un client est connecté!");
            int x;
            do {
                x = in.readInt(); 
                System.out.println("Reçu du client: " + x);
                if (x != 0) {
                    int result = x * 5;
                    out.writeInt(result);
                    System.out.println("Résultat envoyé: " + result);
                }

            } while (x != 0);

            System.out.println("Fin de la communication.");
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            e.printStackTrace();
        }     
    }
}


