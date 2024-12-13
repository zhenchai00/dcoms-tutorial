/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms.lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author GIGABYTE
 */
public class Registry {
    public static void main (String args[]) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1040);
        reg.rebind("add", new Server());
    }
}
