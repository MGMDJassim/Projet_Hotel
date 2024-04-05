import java.io.File;  
import java.io.IOException; 
import java.io.FileWriter;

public class Main {
  public static void main(String[] args) {
    try {
      File myObj = new File("projet.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        FileWriter writer = new FileWriter(myObj);
        writer.write("test succes");
        writer.close();
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  Hotel hotel = new Hotel("HotelParis", "91 boulevard de l'essone", 0101010101, "mail@example.com");
    Chambre c = new Chambre(4, 24, "presidentielle", hotel());
    Employe employe = new Employe("MORIN", 27, "Thomas");
    Sejour s = new Sejour(Reservation(), Vector<consommation>, employe());
    Consommation cons = new Consommation(Sejour(),Produit());
  
}
