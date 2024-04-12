import java.io.File;  
import java.io.IOException;
import java.util.Vector;


public class Main {
  public static void main(String[] args) {

    Hotel hotel = new Hotel("Hotel", "1234 Rue", 1234567890, "hotel@example.com");

    
    Client client1 = new Client("Doe", "John", 07070707, hotel);
    Chambre chambre1 = new Chambre(1, 101, "Normale", hotel);
    Chambre chambre2 = new Chambre(2, 201, "Normale", hotel);
    Chambre chambre3 = new Chambre(3, 301, "Normale", hotel);
    Reservation reservation1 = new Reservation("2021-01-01", "2021-01-02", chambre1, sejour, client1);
    
    Sejour sejour = new Sejour(reservation1, null);
    Consommation consommation1 = new Consommation(25, true, sejour, null);

    Reservation reservation1 = new Reservation("2021-01-01", "2021-01-02", chambre1, sejour, client1);
    Produit coca = new Produit("Coca", 2.5, hotel, consommation1);


    
    

    

    hotel.addChambre(chambre1);
    hotel.addChambre(chambre2);
    hotel.addChambre(chambre3);

    


  }

}
