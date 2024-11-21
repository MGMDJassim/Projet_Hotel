package Vue;

import java.awt.BorderLayout;
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
    Vector<Vector<Object>> donnees;

    public VueAffChambre(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;
        nomColonne = new Vector<String>();
        donnees = new Vector<Vector<Object>>();
        nomColonne.add("Numéro");
        nomColonne.add("Type");
        nomColonne.add("Etage");
        nomColonne.add("Supprimer");

        for (Chambre chambre : hotel.listeChambre) {
            Vector<Object> ligne = new Vector<Object>();
            ligne.add(chambre.getNumeroPorte());
            ligne.add(chambre.getType());
            ligne.add(chambre.getEtage());
            ligne.add("Supprimer");
            donnees.add(ligne);
        }
        DefaultTableModel model = new DefaultTableModel(donnees, nomColonne);
        JTable table = new JTable(model);
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new BouttonEditeur(new JCheckBox(), hotel, fenetre));
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

}
