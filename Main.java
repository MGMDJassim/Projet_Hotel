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

    Produit p1 = new Produit("Produit1", hotel, 10, 100);
    Produit p2 = new Produit("Produit2", hotel, 20, 100);
    Produit p3 = new Produit("Produit3", hotel, 30, 100);
    Produit p4 = new Produit("Produit4", hotel, 40, 100);
    Produit p5 = new Produit("Produit5", hotel, 50, 100);

    Sejour sejour1 = new Sejour(r2);
    Consommation consommation1 = new Consommation(p1,2, sejour1);

    AgentEntretien ag = new AgentEntretien("nom", "prenom" );

    //Ajout des agents d'entretien
    hotel.addEmploye(ag);
    //Ajout des produits
    hotel.addProduit(p1);
    hotel.addProduit(p2);
    hotel.addProduit(p3);
    hotel.addProduit(p4);
    hotel.addProduit(p5);

    //Ajout des chambres
    hotel.addChambre(c11);
    hotel.addChambre(c12);
    hotel.addChambre(c13);
    hotel.addChambre(c14);

    hotel.addChambre(c21);
    hotel.addChambre(c22);
    hotel.addChambre(c23);
    hotel.addChambre(c24);

    //Ajout des clients
    hotel.addClient(client2);
    hotel.addClient(client3);
    hotel.addClient(client4);


    c11.addReservation(r2);
    c12.addReservation(r3); 
    c24.addReservation(r4);
       
    //Ajout des consommations au séjour
    hotel.addReservation(r2);
    hotel.addReservation(r4);

    r2.addSejour(sejour1);
    sejour1.addConsommation(consommation1);

    hotel.addSejour(sejour1);
    hotel.addConsommation(consommation1);

    new Fenetre(hotel);
  }

}
