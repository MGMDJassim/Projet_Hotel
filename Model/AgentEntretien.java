package Model;
import java.util.*;
public class AgentEntretien extends Employe {
    public boolean menageEffectue;
    public Vector<Chambre> listeNettoyage = new Vector<Chambre>();
    
    public AgentEntretien(String nomEmploye, String prenomEmploye) {
        super(nomEmploye, prenomEmploye);
    }

    public void setMenageEffectue(boolean menageEffectue) {
        this.menageEffectue = menageEffectue;
    }
    public boolean getMenageEffectue() {
        return menageEffectue;
    }
    public void setListeNettoyage(Vector<Chambre> listeNettoyage) {
        this.listeNettoyage = listeNettoyage;
    }
    public Vector<Chambre> getListeNettoyage() {
        return listeNettoyage;
    }
    public void nettoyerChambre(Chambre chambre) {
        if (!listeNettoyage.contains(chambre)) {
            listeNettoyage.add(chambre);
        } 
    }


}
