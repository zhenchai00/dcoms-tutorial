/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms.lab2.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
   public static void main (String args[]) throws RemoteException, NotBoundException, MalformedURLException {
      // lookup method to find reference of remote object - finding the server 
      rmiinterface obj = (rmiinterface) Naming.lookup("rmi://localhost:1040/add"); 
      System.out.println("The number is: " + obj.add(5, 8)); // method called `obj.add()`
   } 
}
