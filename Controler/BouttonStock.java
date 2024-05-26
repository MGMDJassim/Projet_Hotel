package Controler;

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Hotel;
import Model.Produit;
import Vue.Fenetre;
import Vue.VueAffConsulSejour;
import Vue.VueAffProduit;
import Vue.VueQuantitStock;

public class BouttonStock extends DefaultCellEditor{

    private Hotel hotel;
    private Fenetre fenetre;
    private JButton boutton;
    private Produit produit;
    private JTable table;
    private DefaultTableModel model;
    private VueAffProduit vueAffProduit;
    private int ligne;


    public BouttonStock(JCheckBox checkBox, Hotel hotel, Produit produit, VueAffProduit vueAffProduit, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.produit = produit;
        this.vueAffProduit = vueAffProduit;
        this.boutton = new JButton();
        this.boutton.setOpaque(true);
        this.boutton.addActionListener(new ButtonActionListener());
    }

    public Component getTableCellEditorComponent(JTable table, Object valeur, boolean estSelectionne, int ligne, int column) {
        this.table = table;
        this.ligne = ligne;
        boutton.setText(valeur.toString());
        return boutton;
    }

    private class ButtonActionListener implements ActionListener {
        Produit produit = hotel.getListeProduit().get(ligne);
        public void actionPerformed(ActionEvent e) {
            new VueQuantitStock(produit, vueAffProduit, fenetre, hotel);
        }
    }
    
}
