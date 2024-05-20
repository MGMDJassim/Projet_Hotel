package Vue;

import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controler.BouttonEditeur;

import Model.*;

public class VueAffChambre extends JPanel {
    Hotel hotel;
    Fenetre fenetre;
    Vector<String> nomColonne;
    Vector<Vector<Object>> data;

    public VueAffChambre(Hotel hotel, Fenetre fenetre) {
        this.hotel = hotel;
        this.fenetre = fenetre;

        this.nomColonne = new Vector<String>();
        this.data = new Vector<Vector<Object>>();
        
        this.nomColonne.add("Numéro");
        this.nomColonne.add("Type");
        this.nomColonne.add("Etage");
        this.nomColonne.add("Supprimer");

        for (Chambre chambre : hotel.listechambre) {
            Vector<Object> row = new Vector<Object>();
            row.add(chambre.getNumeroPorte());
            row.add(chambre.getType());
            row.add(chambre.getEtage());
            row.add("Supprimer");

            this.data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, nomColonne);
        JTable table = new JTable(model);
        table.getColumn("Supprimer").setCellRenderer(new BottonRendu());
        table.getColumn("Supprimer").setCellEditor(new BouttonEditeur(new JCheckBox(), hotel, fenetre));
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);


    }

}
