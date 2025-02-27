package lab10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPMulticastSender {
    public static void main(String[] args) {
        String multicastGroup = "224.0.0.1"; // reserved multicast address
        int port = 9876;

        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello, Multicast Group!";
            byte[] buffer = message.getBytes();

            InetAddress group = InetAddress.getByName(multicastGroup);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Multicast message sent: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
