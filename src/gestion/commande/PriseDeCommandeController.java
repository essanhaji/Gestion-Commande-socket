/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commande;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ~FakeFaker~
 */
public class PriseDeCommandeController implements Initializable {

    @FXML
    ComboBox comboS;
    @FXML
    ComboBox comboB;
    @FXML
    ComboBox comboP;
    @FXML
    Button btnCmd;
    @FXML
    TextField numTab;
    
//    public static Unite findId(ArrayList<PlatPrincipale> u , int id){
//        for(int i=0;i<u.size();i++){
//            if(id == u.get(i).getId()){
//                return u.get(i);
//            }
//        }
//        return null;
//    }
    ArrayList<PlatPrincipale> plats = new ArrayList<PlatPrincipale>();
    ArrayList<Boisson> boissons = new ArrayList<Boisson>();
    ArrayList<Salade> salades = new ArrayList<Salade>();
    PlatPrincipale p1 = new PlatPrincipale(1, "hamberger", "dfdfd", 30);
    PlatPrincipale p2 = new PlatPrincipale(2, "tajine", "dfdsv sssss", 50);
    Boisson b1 = new Boisson(1, "Cola", "dfsd ", 10);
    Boisson b2 = new Boisson(2, "Cafe", "ddddd", 15);
    Salade s1 = new Salade(1, "cesar", "rrttt", 20);
    Salade s2 = new Salade(2, "vegetarienne", "fgggh", 20);
    int nTable;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        plats.add(p1);plats.add(p2);boissons.add(b1);boissons.add(b2);salades.add(s1);salades.add(s2);
        
        
//            ObservableList listS = FXCollections.observableArrayList(p1.getId()+"- "+p1.getLibelle(), "LA VÉGÉTARIENNE", "L'ERGOT ROSSINI", "LA SAUCE MAISON");
    //Liste des salades

comboS.setValue("--Nos Salades--");
ObservableList listS = FXCollections.observableArrayList();
    salades.forEach((object) -> {
                listS.add(object.getId()+"- "+object.getLibelle());
        });
        comboS.setItems(listS);
        //liste des salades
        comboB.setValue("--Nos Boissons--");
        ObservableList listB = FXCollections.observableArrayList();
    boissons.forEach((object) -> {
                listB.add(object.getId()+"- "+object.getLibelle());
        });

        comboB.setItems(listB);
        //liste des plats
        comboP.setValue("--Nos Plats--");
        ObservableList listP = FXCollections.observableArrayList();
    plats.forEach((object) -> {
                listP.add(object.getId()+"- "+object.getLibelle());
        });
        
        comboP.setItems(listP);
//        ObjectOutputStream oos;
//        Socket socket = null;
        
            
            btnCmd.setOnAction((ActionEvent e) -> {
            try {
            Socket socket = new Socket(InetAddress.getLocalHost(),3500);
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//            PrintWriter out = new PrintWriter(socket.getOutputStream());
            int id_salade = Character.getNumericValue(comboS.getValue().toString().charAt(0));
            int id_boisson = Character.getNumericValue(comboB.getValue().toString().charAt(0));
            int id_plat = Character.getNumericValue(comboP.getValue().toString().charAt(0));
            nTable = Integer.parseInt(numTab.getText());
            Salade ObjS = Salade.findId(salades, id_salade);
            Boisson ObjB = Boisson.findId(boissons, id_boisson);
            PlatPrincipale ObjP = PlatPrincipale.findId(plats, id_plat);
            oos.writeObject(ObjS);
            oos.writeObject(ObjB);
            oos.writeObject(ObjP);
//            out.println(nTable);
            oos.close();
//            out.close();
            socket.close();
            
    } catch (IOException ex) {
            ex.printStackTrace();
        }
        });
        
    }    
    
}
