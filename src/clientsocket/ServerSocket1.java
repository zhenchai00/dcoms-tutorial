package clientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept(); 
        System.out.println("client connected");

        InputStreamReader In = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(In);
        String str = bf.readLine();
        System.out.println("client: " + str);
    }
}
