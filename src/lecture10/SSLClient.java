package lecture10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8443; // secure port

        try {
            // set trust store (optional if using a self-signed certificate)
            System.setProperty("javax.net.ssl.trustStore", "src/lecture10/keystore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "password");

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            try (
                SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            ) {
                writer.println("Hello SSL Server!");
                System.out.println("Server response: " + reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
