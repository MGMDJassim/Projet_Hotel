import java.time.*;


//import java.util.*;
import Vue.Fenetre;
import Model.*;


public class Main {
  public static void main(String[] args) {
    Hotel hotel = new Hotel("Hotel", "adresse", 123456, "mail");

    Presidentiel c11 = new Presidentiel( 1, hotel, "Presidentielle", true);
    Presidentiel c12 = new Presidentiel( 1, hotel, "Presidentielle", true);
    Presidentiel c13 = new Presidentiel( 1, hotel, "Presidentielle", true);
    Presidentiel c14 = new Presidentiel( 1, hotel, "Presidentielle", true);

    Normale c21 = new Normale( 2, hotel, "Normale", true);
    Normale c22 = new Normale( 2, hotel, "Normale", true);
    Normale c23 = new Normale( 2, hotel, "Normale", true);
    Normale c24 = new Normale( 2, hotel, "Normale", true);

    Client client2 = new Client("nom", "prenom", LocalDate.of(1999, 1, 1), 123456, hotel);
    Client client3 = new Client("nom2", "prenom2", LocalDate.of(1999, 1, 1), 123456, hotel);
    Client client4 = new Client("Mougamadou", "Jassim", LocalDate.of(2000, 06, 19), 78281, hotel);

    Reservation r2 = new Reservation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), c11, client2);
    Reservation r3 = new Reservation(LocalDate.of(2024, 05, 21), LocalDate.of(2024,05, 23), c12, client3);
    Reservation r4 = new Reservation(LocalDate.of(2024, 05,27), LocalDate.of(2024, 05, 29), c24, client4);

    Produit p1 = new Produit("Produit 1", hotel, 10, 100);
    Produit p2 = new Produit("Produit 2", hotel, 20, 100);
    Produit p3 = new Produit("Produit 3", hotel, 30, 100);
    Produit p4 = new Produit("Produit 4", hotel, 40, 100);
    Produit p5 = new Produit("Produit 5", hotel, 50, 100);

    Sejour sejour1 = new Sejour(r2);
    Consommation consommation1 = new Consommation(p1,2, sejour1);

    AgentEntretien ag = new AgentEntretien("nom", "prenom" );

    //Ajout des agents d'entretien
    hotel.ajouterEmploye(ag);
    //Ajout des produits
    hotel.ajouterProduit(p1);
    hotel.ajouterProduit(p2);
    hotel.ajouterProduit(p3);
    hotel.ajouterProduit(p4);
    hotel.ajouterProduit(p5);

    //Ajout des chambres
    hotel.ajouterChambre(c11);
    hotel.ajouterChambre(c12);
    hotel.ajouterChambre(c13);
    hotel.ajouterChambre(c14);

    hotel.ajouterChambre(c21);
    hotel.ajouterChambre(c22);
    hotel.ajouterChambre(c23);
    hotel.ajouterChambre(c24);

    //Ajout des clients
    hotel.ajouterClient(client2);
    hotel.ajouterClient(client3);
    hotel.ajouterClient(client4);


    c11.ajouterReservation(r2);
    c12.ajouterReservation(r3); 
    c24.ajouterReservation(r4);
       
    //Ajout des consommations au séjour
    hotel.ajouterReservation(r2);
    hotel.ajouterReservation(r4);

    r2.ajouterSejour(sejour1);
    sejour1.ajouterConsommation(consommation1);

    hotel.ajouterSejour(sejour1);
    hotel.ajouterConsommation(consommation1);

      hotel.chambreSale(LocalDate.now());
      for (Chambre c : hotel.chambreSale(LocalDate.now())) {
        System.out.println("Chambre : " + c.getNumeroPorte()+" " + c.getEtage() +" Type + " + c.getType());
  
        
      }

    new Fenetre(hotel);
  }

}
