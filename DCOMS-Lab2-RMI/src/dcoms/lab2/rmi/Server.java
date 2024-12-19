package dcoms.lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements rmiinterface {
    public Server() throws RemoteException {
        super();
    }
    
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
