
//import java.io.*;
//import java.util.*;

public class Normale extends Chambre {

    public int litSimple;

    public Normale(int numPorte, int prix, int litSimple) {
        super(numPorte, prix);
        this.litSimple = litSimple;
    }

    public void setLitSimple(int litSimple) {
        this.litSimple = litSimple;
    }

    public int getLitSimple() {
        return litSimple;
    }




}