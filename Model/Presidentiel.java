
package Model;
public class Presidentiel extends Chambre {
    public int litDouble;
    public static int prix;
    
    public Presidentiel(int numPorte, int etage, Hotel hotel, String type, int litDouble, String etatChambre) {
        super(numPorte, etage, type, hotel, etatChambre);
        this.litDouble = litDouble;
        prix = 100;
    }
    
    public void setLitDouble(int litDouble) {
        this.litDouble = litDouble;
    }

    public int getLitDouble() {
        return litDouble;
    }

    public static int getPrix() {
        return prix;
    }

    public static void setPrix(int prix) {
        Presidentiel.prix = prix;
    }
    
    
}