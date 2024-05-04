package Model;

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

    public void setQuantite(int quatité) {
        this.quantite = quatité;
    }
    public int getQuantite() {
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
        if (quantite > 0) {
    	    this.quantite += quantite;
    	    this.consomme = true;
        } else {
            System.out.println("La quantité ajoutée doit être positive.");
        }
    }
    
    // Methode suppression conso
    
    public void retirerConsommation(int quantite) {
    		if (quantite > 0 && this.quantite >= quantite){
    			this.quantite -= quantite;
                   if(this.quantite == 0) {
    		        this.consomme = false;
    	} else { 
    		System.out.println("la quantité à retirer doit être positive et ne doit pas dépasser la quantité consommée.");
    	}
    }
    }
}
