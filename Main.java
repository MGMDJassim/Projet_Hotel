import java.time.*;


//import java.util.*;
import Vue.Fenetre;
import Model.*;


public class Main {
  public static void main(String[] args) {
    Hotel hotel = new Hotel("Hotel", "adresse", 123456, "mail");

    Presidentiel c11 = new Presidentiel( 1, hotel, "Presidentielle", "Propre");
    Presidentiel c12 = new Presidentiel( 1, hotel, "Presidentielle", "Propre");
    Presidentiel c13 = new Presidentiel( 1, hotel, "Presidentielle", "Propre");
    Presidentiel c14 = new Presidentiel( 1, hotel, "Presidentielle", "Propre");

    Normale c21 = new Normale( 2, hotel, "Normale", "Propre");
    Normale c22 = new Normale( 2, hotel, "Normale", "Propre");
    Normale c23 = new Normale( 2, hotel, "Normale", "Propre");
    Normale c24 = new Normale( 2, hotel, "Normale", "Propre");



    Client client2 = new Client("nom", "prenom", LocalDate.of(1999, 1, 1), 123456, hotel);
    Client client3 = new Client("nom2", "prenom2", LocalDate.of(1999, 1, 1), 123456, hotel);

    Reservation r2 = new Reservation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), c11, client2);
    Reservation r3 = new Reservation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), c12, client3);

    Produit p1 = new Produit("Produit1", hotel, 10, 1);
    Produit p2 = new Produit("Produit2", hotel, 20, 2);
    Produit p3 = new Produit("Produit3", hotel, 30, 3);
    Produit p4 = new Produit("Produit4", hotel, 40, 4);
    Produit p5 = new Produit("Produit5", hotel, 50, 5);

    Sejour sejour1 = new Sejour(r2);
    Consommation consommation1 = new Consommation(sejour1, p1, 2);



    hotel.addProduit(p1);
    hotel.addProduit(p2);
    hotel.addProduit(p3);
    hotel.addProduit(p4);
    hotel.addProduit(p5);

    hotel.addChambre(c11);
    hotel.addChambre(c12);
    hotel.addChambre(c13);
    hotel.addChambre(c14);

    hotel.addChambre(c21);
    hotel.addChambre(c22);
    hotel.addChambre(c23);
    hotel.addChambre(c24);

    c11.addReservation(r2);
    hotel.addClient(client2);
    hotel.addReservation(r2);
    r2.addSejour(sejour1);
    sejour1.addConsommation(consommation1);

    c12.addReservation(r3);
    hotel.addClient(client3);
    hotel.addReservation(r3);

    sejour1.setReservation(r2);

    hotel.addSejour(sejour1);
    hotel.addConsommation(consommation1);

    hotel.afficherReservations();

    sejour1.afficherReservation();

  //Fenetre fenetre = new Fenetre(hotel);
  }

}
