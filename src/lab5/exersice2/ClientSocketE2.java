package lab5.exersice2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSocketE2 {
    public static void main(String[] args) throws Exception {
        // create socket and send and receive messages from server
        Socket socket = new Socket("localhost", 6666);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // send and receive messages from server
        String str = "", str2 = "";
        System.out.println("Client started, type 'stop' to exit");
        System.out.println("Type something to send to server...");
        while (!str.equals("stop")) {
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Server says: " + str2);
        }

        din.close();
        socket.close();
    }
}
