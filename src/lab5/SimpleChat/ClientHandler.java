package lab5.SimpleChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // setup input and output streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // ask for the client name
            out.println("Enter your name:");
            clientName = in.readLine();
            System.out.println(clientName + " has joined the chat.");

            // boardcast message to client has joined 
            ChatServer.boardcastMessage(clientName + " has joined the chat.", this);

            // read message from the client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                ChatServer.boardcastMessage(clientName + ": " + message, this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // clean up when a client disconnects
            try {
                ChatServer.removeClient(this);
                socket.close();
                System.out.println(clientName + " has left the chat.");
                ChatServer.boardcastMessage(clientName + " has left the chat.", this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // send a message to client
    public void sendMessage(String message) {
        out.println(message);
    }
}
