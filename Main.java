import java.time.*;
import Vue.FenetreReceptionniste;
import Model.*;


public class Main {
  public static void main(String[] args) {
    Hotel hotel = new Hotel("Hotel", "adresse", 123456, "mail");
    Receptionniste receptionniste = new Receptionniste("nom", "prenom");
    Receptionniste receptionniste2 = new Receptionniste("nom2", "prenom2");
    Receptionniste receptionniste3 = new Receptionniste("nom3", "prenom3");

    Presidentiel c11 = new Presidentiel(1, hotel, true);
    Presidentiel c12 = new Presidentiel(1, hotel, true);
    Presidentiel c13 = new Presidentiel(1, hotel, true);
    Presidentiel c14 = new Presidentiel(1, hotel, true);

    Normale c21 = new Normale( 2, hotel, true);
    Normale c22 = new Normale( 2, hotel, true);
    Normale c23 = new Normale( 2, hotel, true);
    Normale c24 = new Normale( 2, hotel, true);

    Client client2 = new Client("nom", "prenom", LocalDate.of(1999, 1, 1), 123456, hotel);
    Client client3 = new Client("nom2", "prenom2", LocalDate.of(1999, 1, 1), 123456, hotel);
    Client client4 = new Client("Mougamadou", "Jassim", LocalDate.of(2000, 06, 19), 78281, hotel);

    Reservation r2 = new Reservation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), c11, client2, receptionniste);
    Reservation r3 = new Reservation(LocalDate.of(2024, 05, 21), LocalDate.of(2024,05, 23), c12, client3, receptionniste2);
    Reservation r4 = new Reservation(LocalDate.of(2024, 05,27), LocalDate.of(2024, 05, 29), c24, client4, receptionniste3);

    Produit p1 = new Produit("Produit 1", hotel, 10, 100);
    Produit p2 = new Produit("Produit 2", hotel, 20, 100);
    Produit p3 = new Produit("Produit 3", hotel, 30, 100);
    Produit p4 = new Produit("Produit 4", hotel, 40, 100);
    Produit p5 = new Produit("Produit 5", hotel, 50, 100);

    Sejour sejour1 = new Sejour(r2);
    Consommation consommation1 = new Consommation(p1,2, sejour1);

    AgentEntretien ag = new AgentEntretien("nom4", "prenom" );
    AgentEntretien ag2 = new AgentEntretien("nom5", "prenom2" );

   

    //Ajout des agents d'entretien
    hotel.ajouterEmploye(ag);
    hotel.ajouterEmploye(ag2);
    hotel.ajouterEmploye(receptionniste);
    hotel.ajouterEmploye(receptionniste2);
    hotel.ajouterEmploye(receptionniste3);
    
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

    p1.ajouterQuantite(12);
    p2.ajouterQuantite(10);

    FenetreReceptionniste fenetre = new FenetreReceptionniste(hotel);
  }

}
