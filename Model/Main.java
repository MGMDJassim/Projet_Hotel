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

Hotel hotel = new Hotel("HotelParis", "91 boulevard de l'essone", "0101010101", "mail@example.com");
        Chambre chambre = new Chambre(4, 24, "presidentielle", hotel);
        Employe employe = new Employe("MORIN", 27, "Thomas");
        Sejour s = new Sejour(new Reservation(), new Vector<>(), employe);
        Sejour s1 = new Sejour();
        Produit produit = new Produit("NomProduit", 10, hotel, new Vector<>());
        Date dateDebut = new Date(2024,5,10);
        Date dateFin = new Date(2024,5,15);
        Reservation reservation = new Reservation(dateDebut, dateFin, new Vector<>(), chambre, new Client());
        Consommation cons = new Consommation(s, produit);
        cons.afficherInfo();
}
