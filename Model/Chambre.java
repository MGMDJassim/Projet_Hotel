package Model;
import java.util.List;
import java.util.Vector;
import java.time.*;

public abstract class Chambre {
    private static int idCounter = 0;

    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listReservation = new Vector<Reservation>();
    public Hotel hotel;
    public String type;
    public String etatChambre;
    public abstract float getPrix();

    public Chambre(int etage, String type, Hotel hotel, String etatChambre) {

        this.etage = etage;
        this.numeroPorte = ++idCounter;
        this.type = type;
        this.hotel = hotel;
        this.etatChambre = etatChambre;
    }

    public void setEtatChambre(String etatChambre) {
        this.etatChambre = etatChambre;
    }

    public String getEtatChambre() {
        return etatChambre;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public void addReservation(Reservation reservation) {
        listReservation.add(reservation);
    }

    public Vector<Reservation> getListReservation() {
        return listReservation;
    }
    public void setListReservation(Vector<Reservation> listReservation) {
        this.listReservation = listReservation;
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

    public String getEtat() {
        return etatChambre;
    }

    //methodes pour enlever la chambre

    public void removeReservation(Reservation reservation) {
        listReservation.remove(reservation);
    }

    public void removeAllReservations() {
        listReservation.clear();
    }

    // Recherche des chambres libres
    public boolean isFree(LocalDate dateDebut, LocalDate dateFin) {
        for (Reservation reservation : listReservation) {
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
}