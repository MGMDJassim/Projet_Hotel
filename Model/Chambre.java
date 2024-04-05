
//import java.io.*;
import java.util.*;
import java.util.Date;

public class Chambre {
    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listReservation;
    public Hotel hôtel;
    public String type;

    public Chambre(int etage, int numeroPorte, String type, Hotel hôtel) {
        this.etage = etage;
        this.numeroPorte = numeroPorte;
        this.type = type;
        this.hôtel = hôtel;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }
    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public void setListReservation(Vector<Reservation> listReservation) {
        this.listReservation = listReservation;
    }
    public void setHotel(Hotel hôtel) {
        this.hôtel = hôtel;
    }
    public int getEtage() {
        return etage;
    }
    public int getNumeroPorte() {
        return numeroPorte;
    }

    public Vector<Reservation> getListReservation() {
        return listReservation;
    }
    public Hotel getHotel() {
        return hôtel;
    }
    //Recherche des chambres libres
    public boolean isFree(Date debutD, Date finD) {
        for (Reservation reservation : listReservation) {
            if (reservation.getDateDebut().before(debutD) && reservation.getDateFin().after(finD)) {
                return false; 
            }
        }
        return true; 
    }

    

}