package Model;

public class Normale extends Chambre {

    public int litSimple;

    public Normale(int numPorte, int etage, Hotel hotel, String type, int litSimple, String etatChambre) {
        super(numPorte, etage, type, hotel, etatChambre);
        this.litSimple = litSimple;
    }

    public void setLitSimple(int litSimple) {
        this.litSimple = litSimple;
    }

    public int getLitSimple() {
        return litSimple;
    }




}