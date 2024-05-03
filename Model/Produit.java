package Model;
import java.util.*;

public class Produit {

    public String nom;
    public int prix;
    public Hotel hotel;
    public int quantite;
    public Vector<Consommation> consommation;
    
    // Constructeur avec paramètres
    public Produit(String nom, int prix, Hotel hotel, int quantite, Vector<Consommation> consommation) {
        this.nom = nom;
        this.prix = prix;
        this.hotel = hotel;
        this.quantite = quantite;
        this.consommation = consommation;
    }
    
    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public int getQuantite(){
        return quantite;
    }
    public void setQuantite(int quantite){
        this.quantite = quantite;
    }
    public Vector<Consommation> getConsommation() {
        return consommation;
    }
    public void setConsommation(Vector<Consommation> consommation) {
        this.consommation = consommation;
    }
    
    // methode modifier prix
    
    public void modifierPrix(int nouveauPrix){
        setPrix(nouveauPrix);
    }
    
    // methode ajouter une consommation
    
    public void ajouterConsommation(Consommation nouvelleConso){
        consommation.add(nouvelleConso);
    }

    //methode pour retirer une consommation
        
    public void retirerConsommation(Consommation suppConso){
        consommation.remove(suppConso);
    }

    
    // methode verifier disponibilite produit
        
    public boolean verifierDisponibilite(){
       return quantite > 0;
    //methode calcul prix

    public void calculPrixTotalConso(){
    int prixTotal = 0;
    for(Consommation cons : consommation){
           prixTotal += cons.getQuantite() * cons.getProduit().getPrix();
    }
    return prixTotal;
    }
    // methode affichage
    public void afficherInfo(){
        System.out.println("Nom du produit :" + getNom());
        System.out.println("Prix :" + getPrix() + "euros");
        System.out.println("Hôtel" + hotel.getNom());
        System.out.println("Consommation");
        for(Consommation cons : consommation){
            System.out.println("," + cons.produit.nom);
        }
    }
}
