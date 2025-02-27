package lab10;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPFileReceiver {
    public static void main(String[] args) {
        int port = 9876;
        String filePath = "src/lab10/receivedfile.txt"; // file to save received data

        try (
            DatagramSocket socket = new DatagramSocket(port);
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ) {
            byte[] buffer = new byte[1024];
            System.out.println("Waiting for file...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                if (packet.getLength() == 0) {
                    break; // end of file transfer
                }

                fileOutputStream.write(buffer, 0, packet.getLength());
            }

            System.out.println("File received successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
