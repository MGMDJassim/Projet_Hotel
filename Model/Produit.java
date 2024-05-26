package Model;
import java.time.LocalDate;
import java.util.*;


public class Produit {

    public String nom;
    public int prix;
    public int stock;
    public Hotel hotel;
    public Vector<Consommation> consommations;
    
    public Produit(String nom,  Hotel hotel,int prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.hotel = hotel;
        this.stock = stock;
    }
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
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    public void ajouterQuantite(int quantite) {
        this.stock += quantite;
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
    public void ajouterConsommation(Consommation consommation) {
        this.consommations.add(consommation);
    }
    public void supprimerConsommation(Consommation consommation) {
        this.consommations.remove(consommation);
    }
    public void retirerStock(int quantite){
        if(hotel.listeReservation.size() > 0) {
            for (Reservation reservation : hotel.listeReservation) {
                if (reservation.getDateDebut().isBefore(LocalDate.now()) && reservation.getDateFin().isAfter(LocalDate.now())) {
                    this.stock -= quantite;
                    break;
                }
            }
        }
    }
    public boolean estDisponible(int quantite){
        return quantite <= stock && quantite > 0;
    }
    public void ajouterStock(int quantite){
        if( quantite > 0){
            this.stock += quantite;
        }
    }
}
