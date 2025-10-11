
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
                System.out.println("Le client a envoyé: " + x);

                if (x==1) {   
                    System.out.println(" client choisi addition");
                    int a1 = in.readInt();
                    int b1 = in.readInt();
                    System.out.println("resultat :" + (a1+b1));

                } else if (x==2) {
                    System.out.println(" client choisi soustraction");
                    int a2 = in.readInt();
                    int b2 = in.readInt();
                    System.out.println("resultat :" + (a2-b2));
                }
                else if (x==3) {
                    System.out.println(" client choisi multiplication");
                    int a3 = in.readInt();
                    int b3 = in.readInt();  
                    System.out.println("resultat :" + (a3*b3));
                }
                else if (x==4) {
                    System.out.println(" client choisi division");
                    int a4 = in.readInt();
                    int b4 = in.readInt();  
                    System.out.println("resultat :" + (a4/b4));
                    
                }
                else if (x==5) {
                    System.out.println(" client choisi quitter");
                    
                }
                else {
                    System.out.println("choix invalide");
                }

            } while (x != 5);

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


