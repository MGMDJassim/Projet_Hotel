package Model;
import java.util.Vector;
import java.time.*;

public abstract class Chambre {
    private static int compteurId = 0;

    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listeReservation = new Vector<Reservation>();
    public Hotel hotel;

    public boolean etat;
    public abstract float getPrix();

    public Chambre(int etage, Hotel hotel, boolean etat) {
        this.etage = etage;
        this.numeroPorte = ++compteurId;
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

    public String getType() {
        return this instanceof Normale ? "Normale" : 
               this instanceof Presidentiel ? "Presidentielle" : "Inconnu";
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

    public void supprimerReservation(Reservation reservation) {
        listeReservation.remove(reservation);
    }

    public void supprimerToutesReservations() {
        listeReservation.clear();
    }

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

    public boolean estSale(LocalDate ajd) {
        for (Reservation r : listeReservation) {
            if (ajd.isAfter(r.getDateFin())) {
                return true;
            }
        }
        return false;
    }
}