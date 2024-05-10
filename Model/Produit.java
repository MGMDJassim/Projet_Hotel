package Model;
import java.util.*;

public class Produit {

    public String nom;
    public int prix;
    public int quantite;
    public Hotel hotel;
    public Vector<Consommation> consommations;
    
    // Constructeur avec paramètres
    public Produit(String nom, int prix, Hotel hotel, int quantite, Vector<Consommation> consommations) {
        this.nom = nom;
        this.prix = prix;
        this.hotel = hotel;
        this.quantite = quantite;
        this.consommations = consommations;
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
    public Vector<Consommation> getConsommation() {
        return consommations;
    }
    public void setConsommation(Vector<Consommation> consommation) {
        this.consommations = consommation;
    }
    
    // methode modifier le prix
    public void modifPrix(int prix){
          if (prix <= 0){
        System.out.println("Le prix doit être supérieur à zéro.");
              
    } else {
        this.prix = prix;
    }    
   }

    // methode modifier
    public void modifQuantite(int quantite){
         if (quantite <=0){
            System.out.println("la quantité rentrée doit être supérieure à 0.");
    
        } else {
        this.quantite = quantite;
        }
    }
    
    // methode ajouter une nouvelle consommation
    
    public void addConsommation(Consommation consommation) {
        this.consommations.add(consommation);
    }

    // methode supprimer une consommation
    public void removeConsommation(Consommation consommation) {
        this.consommations.remove(consommation);
    }

    // methode afficher les consommations
    public void afficherConsommation() {
        for (Consommation consommation : consommations) {
            System.out.println(consommation);
        }
    }


}
