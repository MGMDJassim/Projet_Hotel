import java.time.*;
//import java.util.*;
import Vue.Fenetre;
import Model.*;


public class Main {
  public static void main(String[] args) {
Hotel hotel = new Hotel("Hotel", "adresse", 123456, "mail");

Chambre c1 = new Chambre(1, 1, "simple", hotel);
Chambre c2 = new Chambre(2, 2,"double", hotel);
Chambre c3 = new Chambre(3, 1,"simple", hotel);
Chambre c4 = new Chambre(4,  2,"double", hotel);
Chambre c5 = new Chambre(5,  1,"simple", hotel);
Chambre c6 = new Chambre(6,  2,"simple", hotel);
Chambre c7 = new Chambre(7,  1,"simple", hotel);
Chambre c8 = new Chambre(8,  2,"simple", hotel);
Chambre c9 = new Chambre(9,  1,"simple", hotel);
Chambre c10 = new Chambre(10,  2,"simple", hotel);

Client client = new Client("nom", "prenom", 1990, "adresse", 123456, 12345, "ville", hotel);

Reservation r1 = new Reservation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), c1, client);

Normale n1 = new Normale(12, 1, hotel, "simple", 1);

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

hotel.addReservation(r1);
    Fenetre fenetre = new Fenetre(hotel);

    System.out.println(client.getNomClient());
    System.out.println(n1.getLitSimple());
    System.out.println(r1.getDateDebut());
  }

}
