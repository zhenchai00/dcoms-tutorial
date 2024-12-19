package dcoms.lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Registry {
    public static void main (String args[]) throws RemoteException {
        java.rmi.registry.Registry reg = LocateRegistry.createRegistry(1040);
        reg.rebind("add", new Server());
    }
}
