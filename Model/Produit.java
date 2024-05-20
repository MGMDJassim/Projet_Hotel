package Model;
import java.util.*;

public class Produit {

    public String nom;
    public int prix;
    public int quantite;
    public Hotel hotel;
    public Vector<Consommation> consommations;
    
    // Constructeur avec paramètres
    public Produit(String nom,  Hotel hotel,int prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.hotel = hotel;
        this.quantite = quantite;
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
    public int getQuantite(){
        return quantite;
    }
    public void setQuantite(int quantite){
        this.quantite = quantite;
    }
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Vector<Consommation> getConsommations() {
        return consommations;
    }

    public void setConsommations(Vector<Consommation> consommations) {
        this.consommations = consommations;
    }

    // Méthode pour ajouter une consommation
    public void addConsommation(Consommation consommation) {
        this.consommations.add(consommation);
    }

    // Méthode pour supprimer une consommation
    public void removeConsommation(Consommation consommation) {
        this.consommations.remove(consommation);
    }

    // Méthode pour vérifier si la quantité est suffisante
    public boolean checkQuantite(int quantite) {
        if (this.quantite >= quantite) {
            return true;
        } else {
            return false;
        }
    }

}
