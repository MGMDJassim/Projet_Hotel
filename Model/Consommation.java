
//import java.io.*;
//import java.util.*;

public class Consommation {
    public int quatité;
    public boolean consomme;
    public Sejour Sejour;
    public Produit produit;

    public Consommation() {
    }

    public void setQuatité(int quatité) {
        this.quatité = quatité;
    }
    public int getQuatité() {
        return quatité;
    }
    public void setConsomme(boolean consomme) {
        this.consomme = consomme;
    }
    public boolean getConsomme() {
        return consomme;
    }
    public void setSejour(Sejour Sejour) {
        this.Sejour = Sejour;
    }
    public Sejour getSejour() {
        return Sejour;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    public Produit getProduit() {
        return produit;
    }
    



}