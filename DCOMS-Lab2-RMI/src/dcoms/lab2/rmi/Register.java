package dcoms.lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Register {
    public static void main (String args[]) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1040);
        reg.rebind("add", new Server());
    }
}
