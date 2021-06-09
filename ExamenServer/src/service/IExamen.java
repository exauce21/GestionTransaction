/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Client;
import model.Transaction;

/**
 *
 * @author berose
 */
public interface IExamen extends Remote{
    
    public Client findClient(int id) throws RemoteException;
    public void updateClient(Client cl) throws RemoteException;
    
    public Transaction findTransaction(String code) throws RemoteException;
    public void updateTransaction(Transaction ts) throws RemoteException;
}
