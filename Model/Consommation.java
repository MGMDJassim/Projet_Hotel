package Model;
public class Consommation {
    public Sejour sejour;
    public int quantite;
    public Produit produit;

 public Consommation(Produit produit,  int quantite, Sejour sejour) {
        this.quantite = quantite;
        this.produit = produit;
        this.sejour = sejour;
    }

    public void setQuantite(int quatite) {
        this.quantite = quatite;
    }
    
    public int getQuantite() {
        return quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    //Methode ajout de conso
    public void addConsommation(int quantite) {
        this.quantite += quantite;
    }
    //Methode suppression de conso

    public void removeConsommation(int quantite) {
        this.quantite -= quantite;
    }

    //vÃ©rfier si la quantitÃ© est suffisante
    public boolean checkQuantite(int quantite) {
        if (this.quantite >= quantite) {
            return true;
        } else {
            return false;
        }
    }
    //calculer le prix de la consommation
    public int calculerPrix() {
        return quantite * getProduit().getPrix();
    }

}
