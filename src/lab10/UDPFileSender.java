package lab10;

import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPFileSender {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 9876;
        String filePath = "src/lab10/testfile.txt"; // file to send 

        try (
            DatagramSocket socket = new DatagramSocket();
            FileInputStream fileInputStream = new FileInputStream(filePath);
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            InetAddress serverIp = InetAddress.getByName(serverAddress);

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                DatagramPacket packet = new DatagramPacket(buffer, bytesRead, serverIp, port);
                socket.send(packet);
            }

            // send an empty packet to indicate end of file transfer
            DatagramPacket endPacket = new DatagramPacket(new byte[0], 0, serverIp, port);
            socket.send(endPacket);

            System.out.println("File sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
