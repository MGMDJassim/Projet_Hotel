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

    // methode afficher les consommations
    public void afficherConsommation() {
        for (Consommation consommation : consommations) {
            System.out.println(consommation);
        }
    }


}
