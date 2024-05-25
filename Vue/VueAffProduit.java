package Vue;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Hotel;
import Model.Produit;

public class VueAffProduit extends JPanel {
    private Hotel hotel;
    private Fenetre fenetre;

    JLabel nomProduit = new JLabel("Nom du produit");
    JComboBox<String> nom = new JComboBox<>(new String[]{"Produit1", "Produit2", "Produit3", "Produit4", "Produit5"});
    JButton rechercher = new JButton("Rechercher");

    JTable table = new JTable();
    Vector <String> nomColonne;
    Vector <Vector<Object>> data;

    JPanel panel = new JPanel();
    
    public VueAffProduit(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;

        panel.add(nomProduit);
        panel.add(nom);
        panel.add(rechercher);

        nomColonne = new Vector<String>();
        data = new Vector<Vector<Object>>();

        nomColonne.add("Nom");
        nomColonne.add("Stock");
        nomColonne.add("Faire les stocks");

        for (Produit produit : hotel.getListProduit()) {
            Vector<Object> row = new Vector<Object>();
            row.add(produit.getNom());
            row.add(produit.getStock());
            row.add("Faire les stocks");

            data.add(row);
        }
        this.add(panel, BorderLayout.NORTH);
        DefaultTableModel model = new DefaultTableModel(data, nomColonne);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
}
