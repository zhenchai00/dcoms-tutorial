package lab4;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class rmiregistry {
    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1040);
        reg.rebind("add", new server());
    }
}
