package lab10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 9876;

        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello, Echo Server!";
            byte[] sendData = message.getBytes();

            InetAddress serverIp = InetAddress.getByName(serverAddress);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIp, serverPort);
            socket.send(sendPacket);
            System.out.println("Message sent: " + message);

            // receive echo response
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + receivedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
