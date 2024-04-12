import java.util.*;

public class Produit {

    public String nom;
    public int prix;
    public Hotel hotel;
    public Vector<Consommation> consommation;
    
    // Constructeur avec paramètres
    public Produit(String nom, int prix, Hotel hotel, Vector<Consommation> consommation) {
        this.nom = nom;
        this.prix = prix;
        this.hotel = hotel;
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

    public Vector<Consommation> getConsommation() {
        return consommation;
    }

    public void setConsommation(Vector<Consommation> consommation) {
        this.consommation = consommation;
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