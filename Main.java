import java.time.*;
import java.util.spi.LocaleNameProvider;

//import java.util.*;
import Vue.Fenetre;
import Model.*;


public class Main {
  public static void main(String[] args) {
Hotel hotel = new Hotel("Hotel", "adresse", 123456, "mail");

Chambre c1 = new Chambre(1, 1, "simple",hotel, "Propre");
Chambre c2 = new Chambre(2, 2,"double", hotel, "Propre");
Chambre c3 = new Chambre(3, 3,"simple", hotel, "Propre");
Chambre c4 = new Chambre(4,  4,"double", hotel, "Propre");
Chambre c5 = new Chambre(5,  5,"simple", hotel, "Sale");
Chambre c6 = new Chambre(6,  6,"simple", hotel, "Sale");
Chambre c7 = new Chambre(7,  7,"simple", hotel, "Sale");
Chambre c8 = new Chambre(8,  8,"simple", hotel, "Sale");
Chambre c9 = new Chambre(9,  9,"simple", hotel, "Sale");
Chambre c10 = new Chambre(10,  10,"simple", hotel, "Sale");

Client client = new Client("ElKasmi", "Nisrine", LocalDate.of(2003, 9, 3), "adresse", 123456, 12345, "C-E", hotel);
Client client2 = new Client("Mougamadou", "Jassim", LocalDate.of(2000, 6, 19), "adresse2", 123456, 12345, "C-E", hotel);

Reservation r1 = new Reservation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), c1, client);
Reservation r2 = new Reservation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), c2, client2);

Normale n1 = new Normale(12, 1, hotel, "simple", 1, "Propre");

hotel.addChambre(c1);
hotel.addChambre(c2);
hotel.addChambre(c3);
hotel.addChambre(c4);
hotel.addChambre(c5);
hotel.addChambre(c6);
hotel.addChambre(c7);
hotel.addChambre(c8);
hotel.addChambre(c9);
hotel.addChambre(c10);

hotel.addClient(client);
hotel.addClient(client2);

hotel.addReservation(r1);
hotel.addReservation(r2);




    Fenetre fenetre = new Fenetre(hotel);
  }

}
