package lab10;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPMulticastReceiver {
    public static void main(String[] args) {
        String multicastGroup = "224.0.0.1";
        int port = 9876;

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastGroup);
            socket.joinGroup(group);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Listening for multicast messages...");
            socket.receive(packet);

            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + receivedMessage);

            socket.leaveGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
