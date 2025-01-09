package clientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket1 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4999);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        InputStreamReader In = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(In);

        pr.println("Hello");
        pr.flush();

        String str = bf.readLine();
        System.out.println("server: " + str);
        s.close();
    }
}
