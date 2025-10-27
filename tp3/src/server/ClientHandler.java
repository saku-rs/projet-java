package server;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import shared.operation;

public class ClientHandler implements Runnable {
    private Socket socketclient;
    private int clientNumber;

    public ClientHandler(Socket socketclient, int clientNumber) {
        this.socketclient = socketclient;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socketclient.getInputStream());
            DataOutputStream out = new DataOutputStream(socketclient.getOutputStream());
            boolean t;
            do {
                operation operation = (operation) in.readObject();
                servermultithread ser = new servermultithread();
                int a1 = operation.getA1();
                String op = operation.getOp();
                int a2 = operation.getA2();
                               String result;

                switch (op) {
                    case "+":
                        result = Integer.toString(a1 + a2);
                        break;
                    case "-":
                        result = Integer.toString(a1 - a2);
                        break;
                    case "*":
                        result = Integer.toString(a1 * a2);
                        break;
                    case "/":
                        if (a2 != 0) {
                            result = Integer.toString(a1 / a2);
                        } else {
                            result = "error";
                        }
                        break;
                    default:
                        result = "error";
                }

                out.writeUTF(result);
                t = in.readBoolean();
            } while (t);

            in.close();
            out.close();
            socketclient.close();
            System.out.println("Client " + clientNumber + " disconnected.");
        } catch (Exception e) {
            e.printStackTrace();

}
    }}