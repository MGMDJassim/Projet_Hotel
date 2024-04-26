import java.io.File;  
import java.io.IOException;
import java.util.Vector;
import java.time.LocalDate;
import Vue.Fenetre;

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
  
    Fenetre f = new Fenetre();

  }

}
