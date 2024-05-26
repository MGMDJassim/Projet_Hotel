package Model;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class Reservation {
    private static int compteur = 0;
    public int numRes;
    public LocalDate dateDebut;
    public LocalDate dateFin;
    public Vector<Sejour> sejour = new Vector<Sejour>();
    public Chambre chambre;
    public Client client;
    public Receptionniste receptionniste;

    public Reservation(LocalDate dateDebut, LocalDate dateFin, Chambre chambre, Client client, Receptionniste receptionniste) {
        this.numRes = ++compteur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chambre = chambre;
        this.client = client;
        this.receptionniste = receptionniste;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setSejour(Vector<Sejour> sejour) {
        this.sejour = sejour;
    }

    public Vector<Sejour> getSejour() {
        return sejour;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Chambre getChambre() {
        return this.chambre;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void ajouterSejour(Sejour sejour) {
        this.sejour.add(sejour);
    }

    public void supprimerSejour(Sejour sejour) {
        this.sejour.remove(sejour);
    }

    public void ajouterChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void supprimerChambre(Chambre chambre) {
        this.chambre = null;
    }
    public void ajouterClient(Client client) {
        this.client = client;
    }
    public void supprimerClient(Client client) {
        this.client = null;
    }
    public void setNumRes(int numRes) {
        this.numRes = numRes;
    }
    
    public int getNumRes() {
        return numRes;
    }

    public void setListeSejour(Vector<Sejour> sejour) {
        this.sejour = sejour;
    }

    public Vector<Sejour> getListeSejour() {
        return sejour;
    }

    public float calculerPrix() {
        long jours = ChronoUnit.DAYS.between(getDateDebut(), getDateFin());
        return jours * chambre.getPrix();
    }
}
