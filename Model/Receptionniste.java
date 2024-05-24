package Model;
//import java.io.*;
import java.util.*;

public class Receptionniste extends Employe {
    public Vector<Reservation> listResa;
    public Receptionniste(String nomEmploye, int numEmploye, String prenomEmploye, Vector<Reservation> listResa) {
        super(nomEmploye, numEmploye, prenomEmploye);
        this.listResa = listResa;
    }

    public Vector<Reservation> getListResa() {
        return listResa;
    }

    public void setListResa(Vector<Reservation> listResa) {
        this.listResa = listResa;
    }

    //ajouter reservation au receptionnsite
    public void associerResa(Reservation reservation){
        if(!listResa.contains(reservation)){
            listResa.add(reservation);
                reservation.setReceptionniste(this);
        }
    }
    
}
