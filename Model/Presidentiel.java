package Model;

public class Presidentiel extends Chambre {
    public int litDouble;
    public float prix;

    public Presidentiel(int etage, Hotel hotel, boolean etatChambre) {
        super(etage, hotel, etatChambre);
        this.prix = 100;
    }

    public void setLitDouble(int litDouble) {
        this.litDouble = litDouble;
    }

    public int getLitDouble() {
        return litDouble;
    }

    @Override
    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}