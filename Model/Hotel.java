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

    public void addReservation(Reservation reservation){
        this.listReservation.add(reservation);
    }
    
    public void removeReservation(Reservation reservation){
        this.listReservation.remove(reservation);
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

    //Recherche des chambres libres 
    public Vector<Chambre> getFreeRooms(LocalDate dateDebut, LocalDate dateFin){
        Vector<Chambre> freeRooms = new Vector<Chambre>();
        for(int i=0;i<listechambre.size();i++){
            if(listechambre.get(i).isFree(dateDebut, dateFin)){
                freeRooms.add(listechambre.get(i));
            }   
        }
    
        return freeRooms;
    }

    //Affichage des chambres libres
    public void displayFreeRooms(LocalDate dateDebut, LocalDate dateFin){
        Vector<Chambre> freeRooms = getFreeRooms(dateDebut, dateFin);
        for(int i=0;i<freeRooms.size();i++){
            System.out.println("Chambre: "+freeRooms.get(i).getNumeroPorte());
        }
    }

}