package lab5.FileTransfer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFileSocket {
    public static void main(String[] args) throws IOException {
        // create server socket and accept the client connection
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        // receive the file name and file size from client
        DataInputStream din = new DataInputStream(socket.getInputStream());
        String fileName = din.readUTF();
        int fileSize = din.readInt();
        byte[] fileBytes = new byte[fileSize];
        din.readFully(fileBytes);

        System.out.println("Client incoming file: " + fileName);
        System.out.println("File size: " + fileSize + " bytes");

        // write the received file to disk
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(fileBytes);
        fos.close();

        // send the server response to client
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        dout.writeUTF("File received successfully");

        din.close();
        dout.close();
        socket.close();
        serverSocket.close();
    }
}
