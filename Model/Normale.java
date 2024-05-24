package Model;

public class Normale extends Chambre {

    public int litSimple;
    public float prix;

    public Normale(int etage, Hotel hotel, String type, boolean etatChambre) {
        super(etage, type, hotel, etatChambre);
        this.prix = 50;
    }

    public void setLitSimple(int litSimple) {
        this.litSimple = litSimple;
    }

    public int getLitSimple() {
        return litSimple;
    }

    @Override
    public float getPrix() {
        return this.prix;
    }



}