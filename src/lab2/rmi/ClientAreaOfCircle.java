package lab2.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientAreaOfCircle {
    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException {
        rmiinterface obj = (rmiinterface) Naming.lookup("rmi://localhost:1040/calculateCircleArea");
        double area = obj.calculateCircleArea(3);
        System.out.println("The area of the circle is: " + Math.round(area) + "  area: " + area); 
    }
}
