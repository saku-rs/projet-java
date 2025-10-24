package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import shared.operation;

public class Clientm {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            int port = 1234;
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server at " + host + ":" + port);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            boolean t;
            do {
                System.out.print("Enter first integer: ");
                int a1 = scanner.nextInt();
                System.out.print("Enter operator (+, -, *, /): ");
                String op = scanner.next();
                System.out.print("Enter second integer: ");
                int a2 = scanner.nextInt();
                operation operation= new operation(a1,op,a2);

                out.writeObject(operation);

                String result = in.readUTF();
                System.out.println("Result: " + result);

                System.out.print("Do you want to perform another operation? (true/false): ");
                t = scanner.nextBoolean();
                out.writeBoolean(t);
            } while (t);

            in.close();
            out.close();
            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();}}}