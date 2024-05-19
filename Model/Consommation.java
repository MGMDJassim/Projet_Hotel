package Model;

public class Consommation {
    public int quantite;
    public boolean consomme;
    public Sejour sejour;
    public Produit produit;

 public Consommation(Sejour s, Produit p, int quantite, boolean consomme) {
        this.quantite = 0;
        this.consomme = false;
        this.sejour = s;
        this.produit = p;
    }

    public void setQuantite(int quatite) {
        this.quantite = quatite;
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
    public void addConsommation(int quantite) {
        this.quantite += quantite;
    }
    //Methode suppression de conso

    public void removeConsommation(int quantite) {
        this.quantite -= quantite;
    }

    //vérfier si la quantité est suffisante
    public boolean checkQuantite(int quantite) {
        if (this.quantite >= quantite) {
            return true;
        } else {
            return false;
        }
    }

    //Methode pour ajouter une consomation à un sejour
    public void addConsommationToSejour(Sejour sejour, int quantite) {
        if (checkQuantite(quantite)) {
            addConsommation(quantite);
            sejour.addConsommation(this, quantite);
        }
    }

    //Methode pour supprimer une consomation à un sejour
    public void removeConsommationToSejour(Sejour sejour, int quantite) {
        if (checkQuantite(quantite)) {
            removeConsommation(quantite);
            sejour.removeConsommation(this, quantite);
        }
    }

}
