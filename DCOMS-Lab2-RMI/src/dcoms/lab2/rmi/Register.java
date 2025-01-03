package dcoms.lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Register {
    public static void main (String args[]) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1050);
        reg.rebind("add", new Server()); // register the Server object with the name "add"
        reg.rebind("subtract", new Server()); // register the Server object with the name "subtract"
        reg.rebind("calculateCircleArea", new Server()); // register the Server object with the name "calculateCircleArea"
    }
}
