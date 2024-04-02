
//import java.io.*;
//import java.util.*;

public class Presidentiel extends Chambre {

    public int litDouble;
    public double prix;
    public Presidentiel(int litDouble, double prix) {
        super(litDouble, litDouble); // Add this line to invoke the superclass constructor
        this.litDouble= litDouble;
        this.prix=prix;
    }

    public void setLitDouble (int litDouble) {
        this.litDouble = litDouble;
    }

    public int getLitDouble (){
        return litDouble;
    }

    public void setPrix(double prix){
        this.prix = prix;
    }

    public double getPrix(){
        return prix;
    }
}