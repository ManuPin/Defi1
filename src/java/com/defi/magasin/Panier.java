/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.defi.magasin;

import java.util.Objects;

/**
 *
 * @author Formation16
 */
public class Panier {
    Produit produit;
    int quantite;

    public Panier(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }
 public Panier() {
        
    }
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
     public void setAjoutQuantite(int quantite){
        this.quantite = this.quantite + quantite;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Panier other = (Panier) obj;
        if (!Objects.equals(this.produit, other.produit)) {
            return false;
        }
        return true;
    }
     
}
