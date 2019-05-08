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
public class Unite implements Serializable{

   

    private int id;
    private String libelle;
    private String description;
    private double prix;
    
    public Unite(int id, String libelle, String description, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
    }
     @Override
    public String toString() {
        return "Unite{" + "id=" + id + ", libelle=" + libelle + ", description=" + description + ", prix=" + prix + '}';
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
