package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Hotel;
import Model.Produit;
import Vue.ButtonRenderer;
import Vue.Fenetre;
import Vue.VueAffProduit;

public class ControlRechercheProduit implements ActionListener {
    private JComboBox<String> nom;
    private Hotel hotel;
    private VueAffProduit vueAffProduit;
    private Fenetre fenetre;
    private JTable table;
    private DefaultTableModel model;

    public ControlRechercheProduit(JComboBox<String> nom, Hotel hotel, Fenetre fenetre, VueAffProduit vueAffProduit, JTable table, DefaultTableModel model) {
        this.nom = nom;
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.vueAffProduit = vueAffProduit;
        this.table = table;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = nom.getSelectedItem().toString();
        Vector<Vector<Object>> donnees = new Vector<>();

        if (!n.isEmpty()) {
            for (Produit produit : hotel.getListeProduit()) {
                if (produit.getNom().equals(n)) {
                    Vector<Object> produitVector = new Vector<>();
                    produitVector.add(produit.getNom());
                    produitVector.add(produit.getPrix());
                    produitVector.add(produit.getStock());
                    produitVector.add("Faire les stocks");
                    donnees.add(produitVector);
                }
            }

            Vector<String> nomColonne = new Vector<>(vueAffProduit.getNomColonne());
            nomColonne.add("Faire les stocks");

            DefaultTableModel newModel = new DefaultTableModel(donnees, nomColonne);
            table.setModel(newModel);
            table.getColumn("Faire les stocks").setCellRenderer(new ButtonRenderer());
            for (int i = 0; i < table.getRowCount(); i++) {
                Produit produit = hotel.getProduitParNom((String) table.getValueAt(i, 0));
                table.getColumn("Faire les stocks").setCellEditor(new BouttonStock(new JCheckBox(), hotel, vueAffProduit, fenetre));
            }
            newModel.fireTableDataChanged(); // Notifier le modèle de table que les données ont changé
        }
    }
}
