package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clientudp {

    public static void main(String argv[]) throws Exception {
 DatagramSocket socket = new DatagramSocket();
String ch= "Hello serveur UDP";
 int length = ch.length();
 byte buffer[] = ch.getBytes();
DatagramPacket donneesEmises = new
DatagramPacket(buffer,length,InetAddress.getByName("localhost"), 1234);
 socket.send(donneesEmises);
 DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);

 socket.receive(paquet);
 String s=new String(paquet.getData(),0, paquet.getLength());
 System.out.println("Reçu: " +s );
 }
}
