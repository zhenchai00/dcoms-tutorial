package lab9lecture;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udp {
    public static void main(String[] args) {
        try {
            // create udp socket
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

            // message to send
            String message = "Hello, World!";
            byte[] sendData = message.getBytes();

            // send message to server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            clientSocket.send(sendPacket);
            System.out.println("Sent: " + message);

            // receive response from server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            // convert response to string
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + response);

            // close socket
            clientSocket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
