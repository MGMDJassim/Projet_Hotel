
//import java.io.*;
import java.util.*;

public class Client {

    public String nomClient;
    public String prenomClient;
    public int dateDeNaissance;
    public String adresseClient;
    public int telClient;
    public int codePostale;
    public String villeClient;
    public Vector<Reservation> listReservation;
    public Hotel hôtel;

    public Client(String nomClient, String prenomClient, int dateDeNaissance, String adresseClient, int telClient, int codePostale, String villeClient, Hotel hôtel) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateDeNaissance = dateDeNaissance;
        this.adresseClient = adresseClient;
        this.telClient = telClient;
        this.codePostale = codePostale;
        this.villeClient = villeClient;
        this.hôtel = hôtel;
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

    public void setDateDeNaissance(int dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public int getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setTelClient(int telClient) {
        this.telClient = telClient;
    }

    public int getTelClient() {
        return telClient;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public void setHôtel(Hotel hôtel) {
        this.hôtel = hôtel;
    }

    public Hotel getHôtel() {
        return hôtel;
    }

    

}