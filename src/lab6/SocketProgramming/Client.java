package lab6.SocketProgramming;

import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Client(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to the chat server.");

            // set up input and output streams
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            // start a new thread to read messages from the server
            new Thread(new MessageReader()).start();
            
            // read user input and send it to the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while((message = userInput.readLine()) != null) {
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // inner class to read messages from the server
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
            }
        }
    }

    public static void main(String[] args) {
        new Client("localhost", 8000);
    }
}
