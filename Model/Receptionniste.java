
import java.io.*;
import java.util.*;

public class Receptionniste extends Employe {
    
    public String nomEmploye;
    public int numEmploye;
    public Vector<Reservation> listResa;
    public Receptionniste(String nomEmploye, int numEmploye) {
        this.nomEmploye = nomEmploye;
        this.numEmploye = numEmploye;

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