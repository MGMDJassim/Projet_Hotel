
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




}