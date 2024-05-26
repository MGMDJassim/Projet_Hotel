
package Model;
import java.util.Vector;
import java.time.*;

public abstract class Chambre {
    private static int compteurId = 0;

    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listeReservation = new Vector<Reservation>();
    public Hotel hotel;
    public String type;
    public boolean etat;
    public abstract float getPrix();

    public Chambre(int etage, String type, Hotel hotel, boolean etat) {

        this.etage = etage;
        this.numeroPorte = ++compteurId;
        this.type = type;
        this.hotel = hotel;
        this.etat = etat;
    }

    public void setEtatChambre(boolean etat) {
        this.etat = etat;
    }

    public boolean getEtatChambre() {
        return etat;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public void ajouterReservation(Reservation reservation) {
        listeReservation.add(reservation);
    }

    public Vector<Reservation> getListeReservation() {
        return listeReservation;
    }
    public void setListeReservation(Vector<Reservation> listeReservation) {
        this.listeReservation = listeReservation;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getEtage() {
        return etage;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    //méthodes pour supprimer la chambre

    public void supprimerReservation(Reservation reservation) {
        listeReservation.remove(reservation);
    }

    public void supprimerToutesReservations() {
        listeReservation.clear();
    }

    // Recherche des chambres libres
    public boolean estLibre(LocalDate dateDebut, LocalDate dateFin) {
        for (Reservation reservation : listeReservation) {
            if ((dateDebut.isEqual(reservation.getDateDebut()) || dateDebut.isAfter(reservation.getDateDebut())) && dateDebut.isBefore(reservation.getDateFin())) {
                return false;
            }
            if (dateFin.isAfter(reservation.getDateDebut()) && (dateFin.isBefore(reservation.getDateFin()) || dateFin.isEqual(reservation.getDateFin()))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "Chambre " + type + " à l'étage " + etage + ", à la porte " + numeroPorte + "\n";
    }

    //Recherche des chambres sales

    public boolean estSale(LocalDate ajd){
        for(Reservation r : listeReservation){
            if(ajd.isAfter(r.getDateFin())){
                return true;
            }
        }
        return false;
    }
}
