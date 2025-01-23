package lab6.SocketProgramming;

import java.io.*;
import java.net.*;

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
            // set up input and output streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // ask for the client's name
            clientName = in.readLine();
            System.out.println(clientName + " has joined the chat.");

            // broadcast that the client has joined
            ChatServer.broadcastMessage(clientName + " has joined the chat.", this);

            String message;
            //read message from the client
            while((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                ChatServer.broadcastMessage(clientName + ": " + message, this);
            }
        } catch (IOException e) {
            System.out.println("Error in client communications");
        } finally {
            // clean up when a client disconnects
            try {
                ChatServer.removeClient(this);
                socket.close();
                System.out.println(clientName + " has left the chat.");
                ChatServer.broadcastMessage(clientName + " has left the chat.", this);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    // send a message to client
    public void sendMessage(String message) {
        out.println(message);
    }
}
