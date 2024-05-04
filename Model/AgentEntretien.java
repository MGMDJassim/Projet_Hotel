package Model;

//import java.io.*;
import java.util.*;

public class AgentEntretien extends Employe {
    public boolean menageEffectue;
    public Vector<Sejour> listNettoyage;
    
    public AgentEntretien(String nomEmploye, int numEmploye, String prenomEmploye, boolean menageEffectue, Vector<Sejour> listNettoyage) {
        super(nomEmploye, numEmploye, prenomEmploye);
        this.menageEffectue = menageEffectue;
        this.listNettoyage = listNettoyage;
    
    }

    public void afficherInfo(){
        super.afficherInfo();
        System.out.println("Menage effectué :" + (menageEffectue ? "Oui" : "Non"));
        System.out.println("Nombre de nettoyage effectés" + listNettoyage.size());
    }
}
