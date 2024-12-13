/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms.lab2.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author GIGABYTE
 */
public interface rmiinterface extends Remote {
    public int add(int x, int y) throws RemoteException;
}
