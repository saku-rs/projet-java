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
                System.out.println("choisir un operation : ");
                System.out.println("1) addition");
                System.out.println("2) soustraction");
                System.out.println("3) multiplication");
                System.out.println("4) division");
                System.out.println("5) quitter");
                System.out.println("Votre choix : ");
                x = scanner.nextInt();
                out.writeInt(x);
                System.out.println("Envoyé au serveur: " + x);
                switch (x) {
                    case 1:
                        System.out.println(" donner deux nombres pour addition");
                        int a1 = scanner.nextInt();
                        int b1 = scanner.nextInt();
                        out.writeInt(a1);
                        out.writeInt(b1);
                        break;
                    case 2:
                        System.out.println(" donner deux nombres pour soustraction");   
                        int a2 = scanner.nextInt();
                        int b2 = scanner.nextInt();
                        out.writeInt(a2);
                        out.writeInt(b2);
                        break;
                    case 3:
                        System.out.println(" donner deux nombres pour multiplication"); 
                        int a3 = scanner.nextInt();
                        int b3 = scanner.nextInt();
                        out.writeInt(a3);
                        out.writeInt(b3);
                        break;
                    case 4:
                        System.out.println(" donner deux nombres pour division"); 
                        int a4 = scanner.nextInt();
                        int b4 = scanner.nextInt();
                        out.writeInt(a4);
                        out.writeInt(b4);
                        break;
                    case 5:
                        System.out.println(" quitter");
                        break;
                }    


            } while (x != 5);


            System.out.println("Fin de la communication.");
            scanner.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }}
