package Model;

public class Consommation {
    public int quantite;
    public Sejour sejour;
    public Produit produit;

 public Consommation(Sejour s, Produit p, int quantite) {
        this.quantite = quantite;
        this.sejour = s;
        this.produit = p;
    }

    public void setQuantite(int quatite) {
        this.quantite = quatite;
    }
    public int getQuantite() {
        return quantite;
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
    public void ajouterConsommation(int quantite) {
        this.quantite += quantite;
    }
    //Methode suppression de conso

    public void retirerConsommation(int quantite) {
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
    public void ajouterConsommationToSejour(Sejour sejour, int quantite) {
        if (checkQuantite(quantite)) {
            ajouterConsommation(quantite);
            sejour.addConsommation(this);
        }
    }

    //Methode pour supprimer une consomation à un sejour
    public void retirerConsommationToSejour(Sejour sejour, int quantite) {
        if (checkQuantite(quantite)) {
            retirerConsommation(quantite);
            sejour.removeConsommation(this);
        }
    }

    public String toString() {
        return "Consommation{" + "quantite=" + getQuantite() + ", sejour=" + getSejour() + ", produit=" + getProduit() + '}';
    }

    //afficher les consommations

    public void afficherConsommations() {
        System.out.println("Consommation{" + "quantite=" + getQuantite() + ", sejour=" + getSejour() + ", produit=" + getProduit() + '}');
    }
}
