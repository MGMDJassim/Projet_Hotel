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
import Vue.BottonRendu;
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
        Vector<Vector<Object>> donnees = new Vector<Vector<Object>>();
        
        if (!n.isEmpty()) {
            for (Produit produit : hotel.getListeProduit()) {
                if (produit.getNom().equals(n)) {
                    Vector<Object> produitVector = new Vector<Object>();
                    produitVector.add(produit.getNom());
                    produitVector.add(produit.getPrix());
                    // Ajoutez d'autres attributs du produit ici
                    donnees.add(produitVector);
                }
            }
            
            Vector<String> nomColonne = new Vector<String>(vueAffProduit.nomColonne);
            nomColonne.add("Faire les stocks");
            for (Vector<Object> ligne : donnees) {
                ligne.add("Faire les stocks");
            }
            DefaultTableModel model = new DefaultTableModel(donnees, vueAffProduit.nomColonne);
            table.setModel(model);
            table.getColumn("Faire les stocks").setCellRenderer(new BottonRendu());
            for(int i = 0; i < table.getRowCount(); i++) {
                Produit produit = hotel.getListeProduit().get(i);
                table.getColumn("Faire les stocks").setCellEditor(new BouttonStock(new JCheckBox(), hotel, produit, vueAffProduit, fenetre));
            }
        }
    }
    
}
