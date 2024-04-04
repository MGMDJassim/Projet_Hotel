
import java.io.*;
import java.util.*;

public class Receptionniste extends Employe {
    public Vector<Reservation> listResa;
    public Receptionniste(String nomEmploye, int numEmploye, String prenomEmploye, Vector<Reservation> listResa) {
        super(nomEmploye, numEmploye,prenomEmploye);
        this.listResa = listResa;

    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
    public String getNomEmploye() {
        return this.nomEmploye;
    }
    public void setNumEmploye(int numEmploye) {
        this.numEmploye = numEmploye;
    }
    public int getNumEmploye() {
        return this.numEmploye;
    }
    


}