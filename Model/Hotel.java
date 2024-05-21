package Model;
import java.util.*;
import java.time.LocalDate;

public class Hotel {

    public String nom;
    public String adresse;
    public int telephone;
    public String mail;
    public Vector<Chambre> listechambre = new Vector<Chambre>();
    public Vector<Client> listClient = new Vector<Client>();
    public Vector<Produit> listProduit = new Vector<Produit>();
    public Vector<Reservation> listReservation = new Vector<Reservation>();
    public Vector<Sejour> listSejour = new Vector<Sejour>();
    public Vector<Consommation> listConsommation = new Vector<Consommation>();
    
    public Hotel (String nom, String adresse, int telephone, String mail){
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
    }

    public void addChambre(Chambre chambre){
        this.listechambre.add(chambre);
    }

    public void removeChambre(Chambre chambre){
        this.listechambre.remove(chambre);
    }

    public void addClient(Client client){
        this.listClient.add(client);
    }

    public void removeClient(Client client){
        this.listClient.remove(client);
    }

    public void addProduit(Produit produit){
        this.listProduit.add(produit);
    }

    public void removeProduit(Produit produit){
        this.listProduit.remove(produit);
    }

    public void addSejour(Sejour sejour){
        this.listSejour.add(sejour);
    }

    public void removeSejour(Sejour sejour){
        this.listSejour.remove(sejour);
    }

    public void addReservation(Reservation reservation){
        this.listReservation.add(reservation);
    }
    
    public void removeReservation(Reservation reservation) {
        this.listReservation.remove(reservation);
    }

    public void addConsommation(Consommation consommation){
        this.listConsommation.add(consommation);
    }

    public void removeConsommation(Consommation consommation){
        this.listConsommation.remove(consommation);
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setListechambre(Vector<Chambre> listechambre) {
        this.listechambre = listechambre;
    }

    public Vector<Chambre> getListechambre() {
        return listechambre;
    }

    public void setListClient(Vector<Client> listClient) {
        this.listClient = listClient;
    }

    public Vector<Client> getListClient() {
        return listClient;
    }

    public void setListProduit(Vector<Produit> listProduit) {
        this.listProduit = listProduit;
    }

    public Vector<Produit> getListProduit() {
        return listProduit;
    }

    public void setListReservation(Vector<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public Vector<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListSejour(Vector<Sejour> listSejour) {
        this.listSejour = listSejour;
    }

    public Vector<Sejour> getListSejour() {
        return listSejour;
    }

    public void setListConsommation(Vector<Consommation> listConsommation) {
        this.listConsommation = listConsommation;
    }

    public Vector<Consommation> getListConsommation() {
        return listConsommation;
    }


    //Recherche des chambres libres 
    public Vector<Chambre> getFreeRooms(LocalDate dateDebut, LocalDate dateFin) {
        if (dateFin.isBefore(dateDebut)) {
            LocalDate temp = dateDebut;
            dateDebut = dateFin;
            dateFin = temp;
        }
        Vector<Chambre> freeRooms = new Vector<Chambre>();
        for (Chambre chambre : listechambre) {
            if (chambre.isFree(dateDebut, dateFin)) {
                freeRooms.add(chambre);
            }
        }
        return freeRooms;
    }

    // Affichage des chambres libres
    public void displayFreeRooms(LocalDate dateDebut, LocalDate dateFin) {
        Vector<Chambre> freeRooms = getFreeRooms(dateDebut, dateFin);
        System.out.println("Chambres libres :");
        for (Chambre chambre : freeRooms) {
            System.out.println(chambre);
        }
    }

    public String toString(){
        return listechambre.toString();
    }

    public void afficherChambres(){
        for (Chambre chambre : listechambre) {
            System.out.println(chambre);
        }
    }

    public void afficherClients(){
        for (Client client : listClient) {
            System.out.println(client);
        }
    }

    public void afficherProduits(){
        for (Produit produit : listProduit) {
            System.out.println(produit);
        }
    }

    public void afficherReservations(){
        for (Reservation reservation : listReservation) {
            System.out.println(reservation + "\n");
        }
    }


    
}