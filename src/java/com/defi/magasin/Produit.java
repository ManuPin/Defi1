/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.defi.magasin;

/**
 *
 * @author Formation16
 */
public class Produit {
    private int reference;
    private String nom;
    private float prix;
    private int quantiteStock;

    /**
     *
     */
    public Produit(){
    
}
    /**
 *
 *  
     * @param reference Index des produis
     * @param nom nom du produit
     * @param prix Prix du produit
     * @param QuantiteStock Quantite en stock du produit
     
 */
    public Produit(int reference, String nom, float prix, int QuantiteStock) {
        this.reference = reference;
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = QuantiteStock;
    }

    /**
     *
     * @return retourne la reference du produit
     */
    public int getReference() {
        return reference;
    }

    /**
     *
     * @param reference change la reference du porduit
     */
    public void setReference(int reference) {
        this.reference = reference;
    }

    /**
     *
     * @return retourne le nom du produit
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom Change le nom du porduit
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return retourne le prix du porduit
     */
    public float getPrix() {
        return prix;
    }

    /**
     *
     * @param prix change le prix du porduit
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     *
     * @return retourne la quantite present en stock du porduit
     */
    public int getQuantiteStock() {
        return quantiteStock;
    }

    /**
     *
     * @param QuantiteStock
     */
    public void setQuantiteStock(int QuantiteStock) {
        this.quantiteStock = QuantiteStock;
    }
    /**
     *
     * @param NombreCommande : Entier 
     */
    public void setQuantiteRetiredDuStock(int NombreCommande) throws Exception {
       if(0>  this.quantiteStock - NombreCommande)
           throw new Exception();
       else {
        this.quantiteStock = this.quantiteStock - NombreCommande; 
       }
    }
}
