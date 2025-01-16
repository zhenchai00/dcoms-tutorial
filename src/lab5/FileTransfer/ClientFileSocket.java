package lab5.FileTransfer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;

public class ClientFileSocket {
    public static void main(String[] args) throws UnknownHostException, IOException, Exception {
        // get the file name and file size
        String fileName = "src/lab5/test.txt";
        File file = new File(fileName);
        int fileSize = (int) file.length();
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        System.out.println(fileName + " size: " + fileSize + " bytes " + "content: " + new String(fileBytes));

        // create socket and send the file name and file size
        Socket socket = new Socket("localhost", 6666);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        dos.writeUTF(fileName);
        dos.writeInt(fileSize);
        dos.write(fileBytes);
        dos.flush();

        // receive the server response
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println("Server response: " + dis.readUTF());
        
        dos.close();
        dis.close();
        socket.close();
    }
}
