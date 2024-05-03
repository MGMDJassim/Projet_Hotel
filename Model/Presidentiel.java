
package Model;
public class Presidentiel extends Chambre {
    public int litDouble;
    
    public Presidentiel(int numPorte, int etage, Hotel hotel, String type, int litDouble) {
        super(numPorte, etage, type, hotel);
        this.litDouble = litDouble;
    }
    
    public void setLitDouble(int litDouble) {
        this.litDouble = litDouble;
    }

    public int getLitDouble() {
        return litDouble;
    }
}