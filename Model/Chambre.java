
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Chambre {
    public int etage;
    public int numeroPorte;
    public boolean fenetre;
    public Set<Reservation> listresarvation;
    public Hotel hôtel;

    public Chambre() {

    }

    public void setEtage(int etage) {
        this.etage = etage;
    }
    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }
    public void setFenetre(boolean fenetre) {
        this.fenetre = fenetre;
    }
    public void setListReservation(Set<Reservation> listReservation) {
        this.listresarvation = listReservation;
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
    public boolean getFenetre() {
        return fenetre;
    }
    public Set<Reservation> getListReservation() {
        return listresarvation;
    }
    public Hotel getHotel() {
        return hôtel;
    }
    

}