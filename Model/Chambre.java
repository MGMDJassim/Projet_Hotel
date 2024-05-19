package Model;
import java.util.List;
import java.util.Vector;
import java.time.*;

public class Chambre {
    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listReservation = new Vector<Reservation>();
    public Hotel hotel;
    public String type;
    public String etatChambre;

    public Chambre(int etage, int numPorte, String type, Hotel hotel, String etatChambre) {
        this.etage = etage;
        this.numeroPorte = numPorte;
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

    public List<Reservation> getListReservation() {
        return listReservation;
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

    



    // Recherche des chambres libres
    public boolean isFree(LocalDate debut, LocalDate fin) {
        for (Reservation reservation : listReservation) {
            if ((reservation.getDateDebut().isBefore(fin) && reservation.getDateFin().isAfter(debut)) ||
                reservation.getDateDebut().isEqual(debut) || 
                reservation.getDateFin().isEqual(fin) ||
                (debut.isBefore(reservation.getDateDebut()) && fin.isAfter(reservation.getDateFin()))) {
                return false;
            }
        }
        return true;
    }


    public String toString() {
        return "Chambre " + type + " à l'étage " + etage + ", à la porte " + numeroPorte;
    }
}