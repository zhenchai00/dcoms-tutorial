package lab4;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class client {
    public static void main (String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        addinterface obj = (addinterface) Naming.lookup("rmi://localhost:1040/add");
        System.out.println("The number is: " + obj.add(5, 7));
    }
}
