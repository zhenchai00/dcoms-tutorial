package lab2.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface rmiinterface extends Remote {
    public int add(int x, int y) throws RemoteException;
    public int subtract(int x, int y) throws RemoteException;
    public double calculateCircleArea(int radius) throws RemoteException;
}
