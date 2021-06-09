/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenserver;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.IExamen;
import service.ImplIExamen;

/**
 *
 * @author berose
 */
public class ExamenServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
                System.setSecurityManager(new SecurityManager());
                IExamen iRemote = new ImplIExamen();
                Registry r = LocateRegistry.createRegistry(5222);
                r.bind("Examen", iRemote);
                System.out.println("Server lance sur le port 5222");        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
