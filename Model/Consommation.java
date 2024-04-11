
//import java.io.*;
//import java.util.*;

public class Consommation {
    public int quantite;
    public boolean consomme;
    public Sejour sejour;
    public Produit produit;

 public Consommation(Sejour s, Produit p) {
        this.quantite = 0;
        this.consomme = false;
        this.sejour = s;
        this.produit = p;
    }

<<<<<<< HEAD
    public void setQuatité(int quatité) {
        this.quantite = quatité;
    }
    public int getQuatite() {
=======
    public void setQuantite(int quatité) {
        this.quantite = quatité;
    }
    public int getQuantite() {
>>>>>>> cbe003bc8186b99ef2dcab923e6155cac5f7b9f4
        return quantite;
    }
    public void setConsomme(boolean consomme) {
        this.consomme = consomme;
    }
    public boolean getConsomme() {
        return consomme;
    }
    public void setSejour(Sejour Sejour) {
        this.sejour = Sejour;
    }
    public Sejour getSejour() {
        return sejour;
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
    	} else { 
    		System.out.println("la quantité à retirer est supérieur à la quantité consommée");
    	}
    }
    }
}
}