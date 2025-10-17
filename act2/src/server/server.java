
package server;
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
            int a1, a2;
            String x;
            boolean t ;
            do{
            a1 = in.readInt(); 
            System.out.println("Reçu du client: " + a1);
            x = in.readUTF(); 
            System.out.println("Reçu du client: " + x);
            a2 = in.readInt();                
            System.out.println("Reçu du client: " + a2);
            switch (x) {
                case "+":
                    String resAdd = String.valueOf(a1 + a2);
                    out.writeUTF(resAdd);
                    System.out.println("resultat = " + resAdd);
                    break;
                case "-":
                    String resSub = String.valueOf(a1 - a2);
                    out.writeUTF(resSub);
                    System.out.println("resultat = " + resSub);
                    break;
                case "*":
                    String resMul = String.valueOf(a1 * a2);
                    out.writeUTF(resMul);
                    System.out.println("resultat = " + resMul);
                    break;
                case "/":
                    String resDiv = String.valueOf(a1 / a2);
                    out.writeUTF(resDiv);
                    System.out.println("resultat = " + resDiv);
                    break;
                default:
                    System.out.println("Opérateur non valide reçu: " + x);
                    out.writeUTF("error");
                    break;
            }
            t= in.readBoolean();
            }while(t);

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