package Model;
import java.time.*;
import java.util.*;

public class Reservation {

    public int numRes;
    public LocalDate dateD;
    public LocalDate datef;
    public Vector<Sejour> sejour = new Vector<Sejour>();
    public Chambre chambre;
    public Client client;


    public Reservation(LocalDate dateD, LocalDate dateF, Chambre chambre, Client client) {
        this.dateD = dateD;
        this.datef = dateF;
        this.chambre = chambre;
        this.client = client;
    }


    public void setDateD(LocalDate dateD) {
        this.dateD = dateD;
    }

    public LocalDate getDateDebut() {
        return dateD;
    }

    public void setDateFin(LocalDate datef) {
        this.datef = datef;
    }

    public LocalDate getDateFin() {
        return datef;
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
        return chambre;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void addSejour(Sejour sejour) {
        this.sejour.add(sejour);
    }

    public void removeSejour(Sejour sejour) {
        this.sejour.remove(sejour);
    }

    public void addChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void removeChambre(Chambre chambre) {
        this.chambre = null;
    }

    public void addClient(Client client) {
        this.client = client;
    }

    public void removeClient(Client client) {
        this.client = null;
    }
    public void setNumRes(int numRes) {
        this.numRes = numRes;
    }
    
    public int getNumRes() {
        return numRes;
    }

    public void addReservation(Reservation reservation) {
        this.sejour.add(reservation.getSejour().get(0));
        this.chambre = reservation.getChambre();
        this.client = reservation.getClient();
    }

    public void removeReservation(Reservation reservation) {
        this.sejour.remove(reservation.getSejour().get(0));
        this.chambre = null;
        this.client = null;
    }

    public void setListSejour(Vector<Sejour> sejour) {
        this.sejour = sejour;
    }

    public Vector<Sejour> getListSejour() {
        return sejour;
    }

}