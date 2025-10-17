
package server;
import java.io.*;
import java.net.*;
import shared.operation;
public class server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");
            Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Un client est connecté!");
            boolean t ;
            do{            
            operation op = (operation) in.readObject(); 
            System.out.println("Reçu du client: " + op);
            int a1 = op.getFirstop();
            String x = op.getOperateur();
            int a2 = op.getSecondop();
            String res;
            switch (x) {
                case "+":
                     res = String.valueOf(a1 + a2);
                     out.writeUTF(res);
                    break;
                case "-":
                     res = String.valueOf(a1 - a2);
                        out.writeUTF(res);
                     break;
                case "*":
                    res = String.valueOf(a1 * a2);
                    out.writeUTF(res);
                     break;
                case "/":
                    if (a2==0) {
                        System.out.println("Erreur: Division par zéro.");
                        res="error";
                        out.writeUTF(res);
                        break;
                    }else{
                     res = String.valueOf(a1 / a2);
                     out.writeUTF(res);
                     break;
                    }
                    
                default:
                    System.out.println("Opérateur non valide reçu: " + x);
                    res="error";
                    out.writeUTF(res);
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