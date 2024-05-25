package Model;
import java.util.*;

public class AgentEntretien extends Employe {
    public boolean menageEffectue;
    public Vector<Sejour> listNettoyage;
    
    public AgentEntretien(String nomEmploye, String prenomEmploye) {
        super(nomEmploye, prenomEmploye);
    }

    public void afficherInfo(){
        super.afficherInfo();
        System.out.println("Menage effectué :" + (menageEffectue ? "Oui" : "Non"));
        System.out.println("Nombre de nettoyage effectés" + listNettoyage.size());
    }

    public void setMenageEffectue(boolean menageEffectue) {
        this.menageEffectue = menageEffectue;
    }

    public boolean getMenageEffectue() {
        return menageEffectue;
    }

    public void setListNettoyage(Vector<Sejour> listNettoyage) {
        this.listNettoyage = listNettoyage;
    }

    public Vector<Sejour> getListNettoyage() {
        return listNettoyage;
    }

    public void nettoyerChambre(Sejour sejour) {
        if (!listNettoyage.contains(sejour)) {
            listNettoyage.add(sejour);
        } else {
            return -1;
        }
    }

    public void afficherListNettoyage() {
        System.out.println("Liste des nettoyages effectués :");
        for (Sejour sejour : listNettoyage) {
            System.out.println(sejour);
        }
    }

    public boolean verifieMenage(Sejour sejour) {
        return listNettoyage.contains(sejour);
    }
    
    public void afficherDetailsNettoyage(Sejour sejour) {
        if (listNettoyage.contains(sejour)) {
            System.out.println("Détails du nettoyage pour le séjour : " + sejour);
        } else {
            System.out.println("Aucun nettoyage effectué pour ce séjour.");
        }
    }

}
