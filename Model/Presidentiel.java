
package Model;
public class Presidentiel extends Chambre {
    public int litDouble;
    public float prix;
    
    public Presidentiel(int etage, Hotel hotel, String type, boolean etatChambre)  {
        super(etage, type, hotel, etatChambre);

        prix = 100;
    }
    
    public void setLitDouble(int litDouble) {
        this.litDouble = litDouble;
    }

    public int getLitDouble() {
        return litDouble;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    public float getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
}