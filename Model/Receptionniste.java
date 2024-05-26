package Model;

import java.util.*;

public class Receptionniste extends Employe {
    public Vector<Reservation> listeReservations;
    public Receptionniste(String nomEmploye, String prenomEmploye) {
        super(nomEmploye, prenomEmploye);
    }
    public Vector<Reservation> getListeResa() {
        return listeReservations;
    }
    public void setListeResa(Vector<Reservation> listeReservations) {
        this.listeReservations = listeReservations;
    }
    public void ajouterReservation(Reservation resavation) {
        this.listeReservations.add(resavation);
    }
    public void supprimerReservation(Reservation resavation) {
        this.listeReservations.remove(resavation);
    }
}
