package Model;
import java.util.*;

public class Produit {

    public String nom;
    public int prix;
    public int quantite;
    public Hotel hotel;
    public Vector<Consommation> consommation;
    
    // Constructeur avec paramètres
    public Produit(String nom, int prix, Hotel hotel, int quantite, Vector<Consommation> consommation) {
        this.nom = nom;
        this.prix = prix;
        this.hotel = hotel;
        this.quantite = quantite;
        this.consommation = consommation;
    }
    
    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }
    
    //prix modification
    public void setPrix(int prix) {
        
     if (prix <= 0){
        System.out.println("Le prix doit être supérieur à zéro.");
            
    } else if (nouveauPrix > 15) {
        System.out.println("Le prix ne peut pas dépasser 15 euros.");
            
    } else {
        this.prix = prix;
        System.out.println("Le prix a été modifié avec succès.");
    }
    }

    public int getQuantite(){
        return quantite;
    }
    public void setQuantite(int quantite){
        
        if (quantite <=0){
            System.out.println("la quantité rentrée doit être supérieure à 0.");
    
        } else {
        this.quantite = quantite;
        }
    }
    public Hotel getHotel() {
        return hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public Vector<Consommation> getConsommation() {
        return consommation;
    }
    public void setConsommation(Vector<Consommation> consommation) {
        this.consommation = consommation;
    }
    
    // methode ajouter une nouvelle consommation
    
   public void ajouterConsommation(Consommation nouvelleConso) {
       
    if (nouvelleConso != null) { // Vérification que la consommation à ajouter n'est pas nulle
        if (!consommation.contains(nouvelleConso)) { // Vérification que la consommation n'existe pas déjà
            consommation.add(nouvelleConso);
            System.out.println("La consommation a été ajoutée avec succès.");
        } else {
            System.out.println("Cette consommation existe déjà.");
        }
    } else {
        System.out.println("La consommation à ajouter est nulle.");
    }
}

public void retirerConsommation(Consommation suppConso) {
    
    if (suppConso != null) { // Vérification que la consommation à retirer n'est pas nulle
        if (consommation.contains(suppConso)) { // Vérification que la consommation à retirer existe dans la liste
            consommation.remove(suppConso);
            System.out.println("La consommation a été retirée avec succès.");
        } else {
            System.out.println("Cette consommation n'existe pas dans la liste.");
        }
    } else {
        System.out.println("La consommation à retirer est nulle.");
    }
}
    // methode verifier disponibilite produit
        
    public boolean verifierDisponibilite(){
       return quantite > 0;

    // methode affichage
    public void afficherInfo(){
        System.out.println("Nom du produit :" + getNom());
        System.out.println("Prix :" + getPrix() + "euros");
        System.out.println("Quantite en Stock" + getQuantiteStock());
        System.out.println("Consommation");
        for(Consommation cons : consommation){
            System.out.println("," + cons.produit.nom);
        }
    }
}
