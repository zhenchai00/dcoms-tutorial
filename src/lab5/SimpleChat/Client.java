package lab5.SimpleChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Client(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to chat server");

            // setup input and output streams
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            // start a new thread for reading message from the server
            new Thread(new MessageReader()).start();

            // read user input and send it to server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while((message = userInput.readLine()) != null) {
                writer.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }

    private class MessageReader implements Runnable {
        @Override
        public void run() {
            try {
                String message;
                while((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Connection closed");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Connection lost");
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args) {
        new Client("localhost", 1234);
    }
}

