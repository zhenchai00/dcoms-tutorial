package lab4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface addinterface extends Remote{
    public int add(int x, int y) throws RemoteException;
}
