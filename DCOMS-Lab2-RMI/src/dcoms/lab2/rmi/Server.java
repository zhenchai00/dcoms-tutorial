/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms.lab2.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author GIGABYTE
 */
public class Server extends UnicastRemoteObject implements rmiinterface {
    public Server() throws RemoteException {
        super();
    }
    
    @Override
    public init add(int a, int b) throws RemoteException {
        return a + b;
    }
}
