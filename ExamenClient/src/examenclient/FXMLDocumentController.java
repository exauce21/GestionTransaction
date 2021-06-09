/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenclient;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Client;
import model.Transaction;
import service.IExamen;

/**
 *
 * @author berose
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXTextField code;
    @FXML
    private JFXTextField montant;
    @FXML
    private JFXTextField numExp;
    @FXML
    private JFXTextField nomExp;
    @FXML
    private JFXTextField numDest;
    @FXML
    private JFXTextField nomDest;
    @FXML
    private Label notifier;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
     public IExamen getImplement() throws Exception{
        System.setSecurityManager(new SecurityManager());
        Registry r = LocateRegistry.getRegistry("localhost",5222);
        IExamen im;
        im = (IExamen) r.lookup("Examen");
                
        return im;
    }

    @FXML
    private void transactionInfo(javafx.scene.input.MouseEvent event) throws Exception {
        Transaction ts = new Transaction();
        Client cl;
        Client cls;
        IExamen im = getImplement();
        
       ts = im.findTransaction(code.getText());
       
       if(ts!=null){
           cl = im.findClient(ts.getIdExp().getId());
           cls = im.findClient(ts.getIdDest().getId());
       
           montant.setText(ts.getMontant()+"");
           numExp.setText(cl.getNumero());
           nomExp.setText(cl.getNom());
           nomDest.setText(cls.getNom());
       }else{
           code.setText("");
           montant.setText("");
           numExp.setText("");
           nomExp.setText("");
           nomDest.setText("");
           notifier.setText("Le code n'existe pas");
       }  
    }

    @FXML
    private void Ajouter(ActionEvent event) throws Exception {
       Transaction ts = new Transaction();
       Client cl = new Client();
       IExamen im = getImplement();
       
       ts = im.findTransaction(code.getText());
       cl = im.findClient(ts.getIdDest().getId());
       cl.setNumero(numDest.getText()); 
       im.updateClient(cl);
       im.updateTransaction(ts);
       
       code.setText("");
       montant.setText("");
       numExp.setText("");
       nomExp.setText("");
       numDest.setText("");
       nomDest.setText("");
        
       notifier.setText("L'opération mise à jour avec success");
       
    }
    
   
    
}
