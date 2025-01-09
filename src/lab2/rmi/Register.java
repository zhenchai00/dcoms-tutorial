package lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Register {
    public static void main (String args[]) throws RemoteException {
        System.setProperty("java.rmi.server.hostname", "192.168.0.11");
        Registry reg = LocateRegistry.createRegistry(5500);
        reg.rebind("add", new Server()); // register the Server object with the name "add"
        reg.rebind("subtract", new Server()); // register the Server object with the name "subtract"
        reg.rebind("calculateCircleArea", new Server()); // register the Server object with the name "calculateCircleArea"
    }
}
