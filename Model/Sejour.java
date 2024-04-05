
//import java.io.*;
import java.util.*;

public class Sejour {

    public Reservation listeRes;
    public Vector<Consommation> listConsommation;
    public AgentEntretien agent;
    
    public Sejour(Reservation listeRes, Vector<Consommation> listConsommation, AgentEntretien agent) {
        this.listeRes = listeRes;
        this.listConsommation = listConsommation;
        this.agent = agent;
    }

    public void setListeRes(Reservation listeRes) {
        this.listeRes = listeRes;
    }

    public Reservation getListeRes() {
        return listeRes;
    }

    public void setListConsommation(Vector<Consommation> listConsommation) {
        this.listConsommation = listConsommation;
    }

    public Vector<Consommation> getListConsommation() {
        return listConsommation;
    }

    public void setAgent(AgentEntretien agent) {
        this.agent = agent;
    }

    public AgentEntretien getAgent() {
        return agent;
    }
    // consommation bar

    public boolean consommationBar(){
         for (int i = 0; i < listConsommation.size(); i++) {
            Consommation consommation = listConsommation.get(i);
            if (consommation.getQuantite() > 0) {
                return true; 
            }
        }
        return false;
    }
    // Methode facturation
    public double facturationSejour()
    {
        double total = 0.0;
        for (int i = 0; i < listeConsommation.length; i++){
            Consommation consommation = listeConsommation.get(i);
            Produit produit = consommation.getProduit();
            total += produit.getPrix() * consommation.getQuantite();
        }
        return total;
    }

}
