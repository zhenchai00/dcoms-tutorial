package dcoms.lab2.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface rmiinterface extends Remote {
    public int add(int x, int y) throws RemoteException;
}
