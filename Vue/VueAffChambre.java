package Vue;

import java.awt.*;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import Model.*;

public class VueAffChambre extends JPanel {
    Hotel hotel;
    Fenetre fenetre;
    Vector<String> nomColonne;
    Vector<Vector<Object>> data;

    public VueAffChambre(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;

        nomColonne = new Vector<String>();
        nomColonne.add("Numéro de la chambre");
        nomColonne.add("Type de chambre");
        nomColonne.add("Numéro de l'étage");

        data = new Vector<Vector<Object>>();

        for (int i = 0; i < hotel.listechambre.size(); i++) {
            Vector<Object> row = new Vector<Object>();
            row.add(hotel.listechambre.get(i).getNumeroPorte());
            row.add(hotel.listechambre.get(i).getType());
            row.add(hotel.listechambre.get(i).getEtage());
            data.add(row);
            
        }

        
        JTable table = new JTable(data, nomColonne);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.NORTH);

    }

}