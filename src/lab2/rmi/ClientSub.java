package lab2.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientSub {
   public static void main (String args[]) throws RemoteException, NotBoundException, MalformedURLException {
      rmiinterface obj = (rmiinterface) Naming.lookup("rmi://localhost:1040/add"); 
      System.out.println("The number is: " + obj.subtract(20, 8));
   } 
}
