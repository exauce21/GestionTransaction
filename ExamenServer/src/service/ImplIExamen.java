/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Client;
import model.Transaction;

/**
 *
 * @author berose
 */
public class ImplIExamen extends UnicastRemoteObject implements IExamen{
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExamenServerPU");
    EntityManager em;
    
    public EntityManager getEntityManager(){
      return factory.createEntityManager();
    }
    
    public ImplIExamen() throws RemoteException{
        
    }
    
    @Override
    public Client findClient(int id) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Client.findById",Client.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateClient(Client cl) throws RemoteException {
        em = getEntityManager();
        
        Client c = findClient(cl.getId());  
        c.setNumero(cl.getNumero());
        
        EntityTransaction tx = em.getTransaction(); 
       
        try {  
             tx.begin();
             em.merge(c);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Transaction findTransaction(String code) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Transaction.findByCode",Transaction.class)
                    .setParameter("code", code).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateTransaction(Transaction ts) throws RemoteException {
         em = getEntityManager();
        
        Transaction t = findTransaction(ts.getCode());  
        t.setStatus(1);
        
        EntityTransaction tx = em.getTransaction(); 
        try {  
             tx.begin();
             em.merge(t);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    
}
