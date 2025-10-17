package client;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import shared.operation;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Client connecté au serveur.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            int a1,a2;
            String x;
            boolean t;
        do{
                System.out.println("Entrez un entier : "); 
                a1 = scanner.nextInt();
                System.out.println("Entrez un opperation + - / * : ");
                x = scanner.next();
                System.out.println("Entrez un entier : ");
                a2 = scanner.nextInt();
                operation op= new operation(a1,x,a2);
                out.writeObject(op);
                String res = in.readUTF();
                System.out.println("Résultat reçu du serveur: " + res);
                System.out.println("Voulez-vous continuer? (true/false)");
                 t = scanner.nextBoolean();
                out.writeBoolean(t);
            }while(t);
            System.out.println("Fin de la communication.");

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
    }
    }}