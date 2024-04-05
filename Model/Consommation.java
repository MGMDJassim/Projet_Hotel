
//import java.io.*;
//import java.util.*;

public class Consommation {
    public int quatité;
    public boolean consomme;
    public Sejour Sejour;
    public Produit produit;

 public Consommation(Sejour s, Produit p) {
        this.quantite = 0;
        this.consomme = false;
        this.sejour = s;
        this.produit = p;
    }

    public void setQuatité(int quatité) {
        this.quatité = quatité;
    }
    public int getQuatité() {
        return quatité;
    }
    public void setConsomme(boolean consomme) {
        this.consomme = consomme;
    }
    public boolean getConsomme() {
        return consomme;
    }
    public void setSejour(Sejour Sejour) {
        this.Sejour = Sejour;
    }
    public Sejour getSejour() {
        return Sejour;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    public Produit getProduit() {
        return produit;
    }
    //Methode ajout de conso
    
    public void ajoutConsommation(int quantite) {
    	this.quantite += quantite;
    	this.consomme = true;
    }
    
    // Methode suppression conso
    
    public void retirerConsommation(int quantite) {
    		if (this.quantite >= quantite){
    			this.quantite -= quantite;
                   if(this.quantite == 0) {
    		        this.consomme = true;
    	} else { // else ou catch ??
    		System.out.println("la quantité à retirer est supérieur à la quantité consommée");
    	}
    	}
}
