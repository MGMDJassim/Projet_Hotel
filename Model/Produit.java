package Model;
import java.time.LocalDate;
import java.util.*;

public class Produit {

    public String nom;
    public int prix;
    public int stock;
    public Hotel hotel;
    public Vector<Consommation> consommations;
    
    // Constructeur avec paramètres
    public Produit(String nom,  Hotel hotel,int prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.hotel = hotel;
        this.stock = stock;
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
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
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

    //Méthodes qui enleve la quantité de stock en fonction de la date

    public void removeStock(int quantite){
        if(hotel.listReservation.size() > 0) {
            for (Reservation reservation : hotel.listReservation) {
                if (reservation.getDateDebut().isBefore(LocalDate.now()) && reservation.getDateFin().isAfter(LocalDate.now())) {
                    this.stock -= quantite;
                    break;
                }
            }
        }
    }



}
