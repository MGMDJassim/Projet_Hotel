package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

public class Sejour {
    private Reservation reservation;
    private Vector<Consommation> consommations;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Sejour(Reservation reservation) {
        this.reservation = reservation;
        this.dateDebut = reservation.getDateDebut();
        this.dateFin = reservation.getDateFin();
        this.consommations = new Vector<>();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Vector<Consommation> getConsommations() {
        return consommations;
    }

    public void setConsommations(Vector<Consommation> consommations) {
        this.consommations = consommations;
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

    public void addConsommation(Consommation consommation) {
        consommations.add(consommation);
    }

    public void removeConsommation(Consommation consommation) {
        consommations.remove(consommation);
    }

    public void afficherConsommations() {
        for (Consommation consommation : consommations) {
            System.out.println(consommation.getProduit().getNom() + " " + consommation.getQuantite());
        }
    }

    public double calculerPrixTotal() {
        double prixTotal = 0;
        for (Consommation consommation : consommations) {
            prixTotal += consommation.getProduit().getPrix() * consommation.getQuantite();
        }
        return prixTotal + reservation.calculerPrix();
    }

    public long getDuree() {
        return ChronoUnit.DAYS.between(dateDebut, dateFin);
    }

    //afficher reservation

    public void afficherReservation() {
        System.out.println("Sejour{" + "reservation=" + getReservation() + ", consommations=" + getConsommations() + ", dateDebut=" + getDateDebut() + ", dateFin=" + getDateFin() + '}');
    }
}

