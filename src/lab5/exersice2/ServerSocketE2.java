package lab5.exersice2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketE2 {
    public static void main (String[] args) throws Exception {
        // create server socket and accept the client connection
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // send and receive messages from client
        String str = "", str2 = "";
        System.out.println("waiting for client...");
        System.out.println("type 'stop' to exit");
        System.out.println("Type something to send to client once received from client...");
        while(!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("client says: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        socket.close();
        serverSocket.close();
    }
}
