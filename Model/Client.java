package Model;
import java.time.LocalDate;
import java.time.Period;
//import java.io.*;
import java.util.*;

public class Client {

    public String nomClient;
    public String prenomClient;
    public LocalDate dateDeNaissance;
    public int telClient;
    public Vector<Reservation> listReservation;
    public Hotel hotel;

    public Client(String nomClient, String prenomClient, LocalDate dateDeNaissance, int telClient, Hotel hotel) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateDeNaissance = dateDeNaissance;
        this.telClient = telClient;
        this.hotel = hotel;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setTelClient(int telClient) {
        this.telClient = telClient;
    }

    public int getTelClient() {
        return telClient;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }
    public void addReservation(Reservation reservation) {
        this.listReservation.add(reservation);
    }
    public void removeReservation(Reservation reservation) {
        this.listReservation.remove(reservation);
    }
    public void setListReservation(Vector<Reservation> listReservation) {
        this.listReservation = listReservation;
    }
    public Vector<Reservation> getListReservation() {
        return listReservation;
    }

    public void addClient(Client client) {
        this.listReservation.add(client.getListReservation().get(0));
    }

    public void removeClient(Client client) {
        this.listReservation.remove(client.getListReservation().get(0));
    }

    public boolean estmineur(LocalDate dateDeNaissance){
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateDeNaissance, now);
        if (period.getYears() < 18) {
            return false;
        }
    return true;
    }

}
