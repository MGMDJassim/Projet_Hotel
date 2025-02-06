package Model;
import java.util.*;
import java.time.LocalDate;


public class Hotel {

    public String nom;
    public String adresse;
    public int telephone;
    public String mail;
    public Vector<Chambre> listeChambre = new Vector<Chambre>();
    public Vector<Client> listeClient = new Vector<Client>();
    public Vector<Produit> listeProduit = new Vector<Produit>();
    public Vector<Reservation> listeReservation = new Vector<Reservation>();
    public Vector<Sejour> listeSejour = new Vector<Sejour>();
    public Vector<Consommation> listeConsommation = new Vector<Consommation>();
    public Vector<Employe> listeEmploye = new Vector<Employe>();
    public Sejour[] listSejour;
    
    public Hotel (String nom, String adresse, int telephone, String mail){
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
    }

    public void ajouterChambre(Chambre chambre){
        this.listeChambre.add(chambre);
    }

    public void supprimerChambre(Chambre chambre){
        this.listeChambre.remove(chambre);
    }

    public void ajouterClient(Client client){
        this.listeClient.add(client);
    }

    public void supprimerClient(Client client){
        this.listeClient.remove(client);
    }

    public void ajouterProduit(Produit produit){
        this.listeProduit.add(produit);
    }

    public void supprimerProduit(Produit produit){
        this.listeProduit.remove(produit);
    }

    public void ajouterSejour(Sejour sejour){
        this.listeSejour.add(sejour);
    }

    public void supprimerSejour(Sejour sejour){
        this.listeSejour.remove(sejour);
    }
    public void ajouterReservation(Reservation reservation){
        this.listeReservation.add(reservation);
    }
    public void supprimerReservation(Reservation reservation) {
        this.listeReservation.remove(reservation);
    }
    public void ajouterConsommation(Consommation consommations){
        this.listeConsommation.add(consommations);
    }
    public void supprimerConsommation(Consommation consommation){
        this.listeConsommation.remove(consommation);
    }
    public void ajouterEmploye(Employe employe){
        this.listeEmploye.add(employe);
    }
    public void supprimerEmploye(Employe employe){
        this.listeEmploye.remove(employe);
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
    public void setListeChambre(Vector<Chambre> listeChambre) {
        this.listeChambre = listeChambre;
    }
    public Vector<Chambre> getListeChambre() {
        return listeChambre;
    }
    public void setListeClient(Vector<Client> listeClient) {
        this.listeClient = listeClient;
    }
    public Vector<Client> getListeClient() {
        return listeClient;
    }
    public void setListeProduit(Vector<Produit> listeProduit) {
        this.listeProduit = listeProduit;
    }
    public Vector<Produit> getListeProduit() {
        return listeProduit;
    }   
    public  Produit getProduitParNom(String nom) {
        for (Produit produit : listeProduit) {
            if (produit.getNom().equals(nom)) {
                return produit;
            }
        }
        return null;
    }
    public void setListeReservation(Vector<Reservation> listeReservation) {
        this.listeReservation = listeReservation;
    }
    public Vector<Reservation> getListeReservation() {
        return listeReservation;
    }
    public void setListeSejour(Vector<Sejour> listeSejour) {
        this.listeSejour = listeSejour;
    }
    public Vector<Sejour> getListeSejour() {
        return listeSejour;
    }
    public void setListeConsommation(Vector<Consommation> listeConsommation) {
        this.listeConsommation = listeConsommation;
    }
    public Vector<Consommation> getListeConsommation() {
        return listeConsommation;
    }
    public Vector<Employe> getListeEmployes(){
        return listeEmploye;
    }
    public Employe getEmployeParNumero(int numero) {
        for (Employe employe : listeEmploye) {
            if (employe.getNumEmploye() == numero) {
                return employe;
            }
        }
        return null;
    }

    // public Employe getEmployeParPoste()

    

    //Recherche des chambres libres 
    public Vector<Chambre> getChambresLibres(LocalDate dateDebut, LocalDate dateFin) {
        if (dateFin.isBefore(dateDebut) || dateDebut.isBefore(LocalDate.now()) || dateFin.isBefore(LocalDate.now()) || dateDebut.isEqual(dateFin)) {
            return null;
        }
        Vector<Chambre> chambresLibres = new Vector<Chambre>();
        for (Chambre chambre : listeChambre) {
            if (chambre.estLibre(dateDebut, dateFin)) { // Supprimez le "!" pour vérifier si la chambre est libre
                chambresLibres.add(chambre);
            }
        }
        return chambresLibres;
    }
    public Vector<Vector<Object>> rechercherClient(String nom) {
        Vector<Client> listeClient = getListeClient();
        Vector<Vector<Object>> clientsTrouves = new Vector<Vector<Object>>();
        for (Client client : listeClient) {
            if (client.getNomClient().equals(nom)) {
                Vector<Object> donneesClient = new Vector<Object>();
                donneesClient.add(client.getNomClient());
                donneesClient.add(client.getPrenomClient());
                donneesClient.add(client.getDateDeNaissance());
                donneesClient.add(client.getTelClient());
                clientsTrouves.add(donneesClient);
            }
        }
        return clientsTrouves;
    }

    public Vector<Chambre> chambreSale(LocalDate ajd){
       Vector <Chambre> cs = new Vector<Chambre>();
       for(Chambre c : listeChambre){
        if(c.estSale(ajd)){
        cs.add(c);
        }
       }
       return cs;
    }

    public Vector<Vector<Object>> rechercheProduit(String nom){
        Vector<Produit> listeProduit = getListeProduit();
        Vector<Vector<Object>> produitsTrouves = new Vector<Vector<Object>>();
        for (Produit produit : listeProduit) {
            if (produit.getNom().equals(nom)) {
                Vector<Object> donneesProduit = new Vector<Object>();
                donneesProduit.add(produit.getNom());
                donneesProduit.add(produit.getStock());
                produitsTrouves.add(donneesProduit);
            }
        }
        return produitsTrouves;
    }
}
