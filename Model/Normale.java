package Model;

public class Normale extends Chambre {

    public int litSimple;
    public float prix;

    public Normale(int etage, Hotel hotel, boolean etatChambre) {
        super(etage, hotel, etatChambre);
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