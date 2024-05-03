import java.time.*;
//import java.util.*;
import Vue.*;



public class Main {
  public static void main(String[] args) {

    Hotel hotel = new Hotel("Hotel", "1234 Rue", 1234567890, "hotel@example.com");

    Chambre chambre = new Chambre(1, 1, "simple", hotel);
    Client client = new Client("Doe", "John", 1990, "1234 Rue", 1234567890, 1234, "City", hotel);
    hotel.addChambre(chambre);
    hotel.addClient(client);

    Reservation r1=new Reservation(LocalDate.of(2020, 12, 21), LocalDate.of(2020, 12, 25) ,chambre, client);
    Reservation r2=new Reservation(LocalDate.of(2020, 10, 21), LocalDate.of(2020, 10, 25),chambre, client);
    chambre.addReservation(r1);
    chambre.addReservation(r2);
    chambre.isFree(LocalDate.of(2020,10,21), LocalDate.of(2020,10,25));
    chambre.isFree(LocalDate.of(2020,12,21), LocalDate.of(2020,12,25));

    System.out.println(hotel.getNom());
    System.out.println(hotel.getAdresse());
    System.out.println(hotel.getTelephone());
    System.out.println(hotel.getMail());
    System.out.println(hotel.listechambre);
    System.out.println(hotel.listClient);
    System.out.println(hotel.listProduit);

    Fenetre fenetre = new Fenetre();


  }

}
