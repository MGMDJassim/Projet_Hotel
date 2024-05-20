package Model;
//import java.io.*;
import java.util.*;

public class Sejour {

    public Reservation reservation;
    public Vector<Consommation> consommations = new Vector<Consommation>();
    public AgentEntretien agent;
    
    public Sejour(Reservation reservation, Produit produit) {
        this.reservation = reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }
    
    public void setListConsommation(Vector<Consommation> listConsommation) {
        this.consommations = listConsommation;
    }

    public Vector<Consommation> getListConsommation() {
        return consommations;
    }

    public void setAgent(AgentEntretien agent) {
        this.agent = agent;
    }

    public AgentEntretien getAgent() {
        return agent;
    }
    // consommation bar

    public boolean consommationBar(){
         for (int i = 0; i < consommations.size(); i++) {
            Consommation consommation = consommations.get(i);
            if (consommation.getQuantite() > 0) {
                return true; 
            }
        }
        return false;
    }
    // Methode facturation
    
    public float facturation() {
        float facture = 0;
        for (int i = 0; i < consommations.size(); i++) {
            Consommation consommation = consommations.get(i);
            facture += consommation.getQuantite() * consommation.getProduit().getPrix();
        }
        return facture;
    }

    // Methode pour ajouter une consomation
    public void addConsommation(Consommation consommation) {
        consommations.add(consommation);
    }

    // Methode pour supprimer une consomation

    public void removeConsommation(Consommation consommation) {
        consommations.remove(consommation);
    }

}
