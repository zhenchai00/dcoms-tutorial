package dcoms.lab2.rmi;

import java.net.MalformedURLException;
// import java.rmi.Naming; // this method used for local host
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
   public static void main (String args[]) throws RemoteException, NotBoundException, MalformedURLException {
      // lookup method to find reference of remote object - finding the server 
      // this method used for local host 
      // rmiinterface obj = (rmiinterface) Naming.lookup("rmi://192.168.0.11:5500/add"); 
      // rmiinterface obj = (rmiinterface) Naming.lookup("add");

      // this method used for remote host
      Registry reg = LocateRegistry.getRegistry("192.168.0.11", 5500);
      rmiinterface obj = (rmiinterface) reg.lookup("add");
      System.out.println("The number is: " + obj.add(5, 8)); // method called `obj.add()`
   } 
}
