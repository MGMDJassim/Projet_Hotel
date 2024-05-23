package Model;

import java.time.LocalDate;
import java.util.Vector;


public class Sejour {
    private Reservation reservation;
    private Vector<Consommation> consommation = new Vector<Consommation>();
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Sejour(Reservation reservation) {
        this.reservation = reservation;
        this.dateDebut = reservation.getDateDebut();
        this.dateFin = reservation.getDateFin();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Vector<Consommation> getConsommation() {
        return consommation;
    }

    public void setConsommation(Vector<Consommation> consommation) {
        this.consommation = consommation;
    }

    public void addConsommation(Consommation consommation) {
        this.consommation.add(consommation);
    }

    public void removeConsommation(Consommation consommation) {
        this.consommation.remove(consommation);
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    //calculer le prix du sejour

    public float calculerPrix() {
        float prix = 0;
        for (Consommation consommation : consommation) {
            prix = prix + consommation.calculerPrix();
        }
        return prix + reservation.calculerPrix();
    }

    //afficher reservation

    public void afficherReservation() {
        System.out.println("Sejour{" + "reservation=" + getReservation() + ", consommations=" + getConsommation() + ", dateDebut=" + getDateDebut() + ", dateFin=" + getDateFin() + '}');
    }
}

