package lecture10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSL {
    public static void main(String[] args) {
        int port = 8443; // secure port

        try {
            // load the keystone
            KeyStore keyStore = KeyStore.getInstance("JKS");
            try (FileInputStream fis = new FileInputStream("src/lecture10/keystore.jks")) {
                keyStore.load(fis, "password".toCharArray());
            }

            // initialize KeyManagerFactory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keyStore, "password".toCharArray());

            // initialize SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), null, null);

            // create ssl server socket
            SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
            System.out.println("SSL Server started on port " + port);

            while (true) {
                try (
                    SSLSocket socket = (SSLSocket) serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    System.out.println("Client Connected.");
                    String received = reader.readLine();
                    System.out.println("Received: " + received);

                    writer.println("Hello from SSL Server");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
