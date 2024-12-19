package dcoms.lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// unicastremoteobject is a class that provides support for point-to-point active object references
// and for the activation of objects by remote clients
// making this Server object as remote object
public class Server extends UnicastRemoteObject implements rmiinterface {
    public Server() throws RemoteException {
        super();
    }
    
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public double calculateCircleArea(int radius) throws RemoteException {
        return (int) (Math.PI * radius * radius);
    }
}
