package Controler;

import Model.Chambre;
import Model.Hotel;

import java.util.Vector;

public class FiltreChambre {
    private Hotel hotel;

    public FiltreChambre(Hotel hotel) {
        this.hotel = hotel;
    }

    public Vector<Vector<Object>> filtrerChambres(String typeText) {
        Vector<Vector<Object>> donnees = new Vector<>();
        for (Chambre chambre : hotel.listeChambre) {
            boolean match = true;
            if (!typeText.equals("Tous") && !chambre.getType().equals(typeText)) {
                match = false;
            }
            if (match) {
                Vector<Object> ligne = new Vector<>();
                ligne.add(chambre.getNumeroPorte());
                ligne.add(chambre.getType());
                ligne.add(chambre.getEtage());
                ligne.add("Supprimer");
                donnees.add(ligne);
            }
        }
        return donnees;
    }
}