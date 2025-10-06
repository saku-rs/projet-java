package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Client connecté au serveur.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            int x;
            do {
                System.out.print("Entrez un entier (0 pour quitter) : ");
                x = scanner.nextInt();

                out.writeInt(x); 

                if (x != 0) {
                    int result = in.readInt(); 
                    System.out.println("Résultat reçu du serveur : " + result);
                }

            } while (x != 0);

            System.out.println("Fin de la communication.");
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }}
