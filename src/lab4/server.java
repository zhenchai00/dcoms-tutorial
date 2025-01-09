package lab4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject implements addinterface {
    public server() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }
}
