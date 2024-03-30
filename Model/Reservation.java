
//import java.io.*;
import java.util.*;

public class Reservation {

    public Date dateD;
    public Date datef;
    public Vector<Sejour> sejour;
    public Chambre chambre;
    public Client client;
    public Reservation(Date dateD, Date datef, Vector<Sejour> sejour, Chambre chambre, Client client) {
        this.dateD = dateD;
        this.datef = datef;
        this.sejour = sejour;
        this.chambre = chambre;
        this.client = client;
    }


    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }

    public Date getDateD() {
        return dateD;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }

    public Date getDatef() {
        return datef;
    }

    public void setSejour(Vector<Sejour> sejour) {
        this.sejour = sejour;
    }

    
    



}