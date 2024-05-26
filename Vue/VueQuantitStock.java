package Vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Produit;
import Model.Hotel;
import Vue.Fenetre;
import Vue.VueAffProduit;

public class VueQuantitStock extends JFrame{

    private Produit produit;
    private DefaultTableModel model;
    private Hotel hotel;
    private Fenetre fenetre;

    JLabel label = new JLabel("Quantité");
    JTextField quantite = new JTextField(20);
    JButton valider = new JButton("Valider");
    VueAffProduit vueAffProduit;

    
    public VueQuantitStock(Produit produit, VueAffProduit vueAffProduit, Fenetre fenetre, Hotel hotel) {
        this.produit = produit;
        this.vueAffProduit = vueAffProduit;
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.setTitle("Quantité de stock");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        

        label.setBounds(10, 10, 100, 20);
        quantite.setBounds(120, 10, 100, 20);
        valider.setBounds(100, 100, 100, 20);
        this.add(label);
        this.add(quantite);
        this.add(valider);

        valider.addActionListener(e -> {
            if (produit != null) {
                int quantiteAjoutee = Integer.parseInt(quantite.getText());
                produit.ajouterQuantite(quantiteAjoutee);
                vueAffProduit.model.setValueAt(produit.getStock(), vueAffProduit.table.getSelectedRow(), 1);
                quantiteAjoutee = 0;
                this.dispose();
            } else {
                System.out.println("Le produit est null");
            }
        });
    }
}
