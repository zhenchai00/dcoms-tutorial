package lab5.SimpleChat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running on port 1234");

            while (true) {
                // accept new client connection
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // create new handler for this client and add it to the list 
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandlers.add(clientHandler);

                // start a new thread to handle client communication
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void boardcastMessage(String message, ClientHandler excludeClient) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (clientHandler != excludeClient) {
                clientHandler.sendMessage(message);
            }
        }
    }

    public static void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }
}
