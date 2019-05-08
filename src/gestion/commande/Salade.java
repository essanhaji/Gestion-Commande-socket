/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commande;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ~FakeFaker~
 */
public class Salade extends Unite implements Serializable {
    
    public Salade(int id, String libelle, String description, double prix) {
        super(id, libelle, description, prix);
    }
    public static Salade findId(ArrayList<Salade> u , int id){
        for(int i=0;i<u.size();i++){
            if(id == u.get(i).getId()){
                return u.get(i);
            }
        }
        return null;
    }
}
