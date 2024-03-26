
//import java.io.*;
import java.util.*;

/**
 * 
 */
public class Hotel {

    public String nom;
    public String adresse;
    public int telephone;
    public String mail;
    public Set<Chambre> listechambre;
    public Set<Client> listClient;
    public Set<Produit> listProdiot;
    
    public Hotel (String nom, String adresse, int telephone, String mail){
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.listechambre = new HashSet<Chambre>();
        this.listClient = new HashSet<Client>();
        this.listProdiot = new HashSet<Produit>();
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
        this.listProdiot.add(produit);
    }

    public void removeProduit(Produit produit){
        this.listProdiot.remove(produit);
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

    public void setListechambre(Set<Chambre> listechambre) {
        this.listechambre = listechambre;
    }

    public Set<Chambre> getListechambre() {
        return listechambre;
    }

    public void setListClient(Set<Client> listClient) {
        this.listClient = listClient;
    }

    public Set<Client> getListClient() {
        return listClient;
    }

    public void setListProdiot(Set<Produit> listProdiot) {
        this.listProdiot = listProdiot;
    }

    public Set<Produit> getListProdiot() {
        return listProdiot;
    }

}