package Controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import Model.Hotel;
import Model.Produit;
import Vue.Fenetre;
import Vue.VueAffProduit;
import Vue.VueQuantitStock;

public class BouttonStock extends DefaultCellEditor {

    private Hotel hotel;
    private Fenetre fenetre;
    private JButton bouton;
    private VueAffProduit vueAffProduit;

    public BouttonStock(JCheckBox checkBox, Hotel hotel, VueAffProduit vueAffProduit, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.vueAffProduit = vueAffProduit;
        this.bouton = new JButton();
        this.bouton.setOpaque(true);
        this.bouton.addActionListener(new ButtonActionListener());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object valeur, boolean estSelectionne, int ligne, int column) {
        if (valeur != null) {
            bouton.setText(valeur.toString());
        } else {
            bouton.setText("");
        }
        return bouton;
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = vueAffProduit.table.getSelectedRow();
            String nomProduit = vueAffProduit.table.getValueAt(row, 0).toString();
            Produit produit = hotel.getProduitParNom(nomProduit);
            if (produit != null) {
                VueQuantitStock vueQuantitStock = new VueQuantitStock(produit, vueAffProduit, fenetre, hotel);
                vueQuantitStock.setVisible(true); // Assurez-vous de rendre la fenêtre visible
            }
        }
    }
}
