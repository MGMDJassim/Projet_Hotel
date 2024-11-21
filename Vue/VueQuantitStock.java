package Vue;

import javax.swing.*;
import Model.Produit;
import Model.Hotel;

public class VueQuantitStock extends JFrame {
    private Produit produit;
    private VueAffProduit vueAffProduit;
    private Fenetre fenetre;
    private Hotel hotel;

    public VueQuantitStock(Produit produit, VueAffProduit vueAffProduit, Fenetre fenetre, Hotel hotel) {
        this.produit = produit;
        this.vueAffProduit = vueAffProduit;
        this.fenetre = fenetre;
        this.hotel = hotel;

        setTitle("Ajouter Stock");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Quantité à ajouter : ");
        JTextField textField = new JTextField(10);
        JButton ajouterButton = new JButton("Ajouter");

        ajouterButton.addActionListener(e -> {
            try {
                int quantite = Integer.parseInt(textField.getText());
                produit.ajouterQuantite(quantite);
                int row = findRowByProductName(produit.getNom());
                if (row >= 0) {
                    vueAffProduit.getModel().setValueAt(produit.getStock(), row, 2);
                    vueAffProduit.getModel().fireTableDataChanged(); // Notifier le modèle de table que les données ont changé
                }
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer une quantité valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(ajouterButton);
        add(panel);

        // Affichez la fenêtre
        setVisible(true);
    }

    private int findRowByProductName(String productName) {
        for (int i = 0; i < vueAffProduit.table.getRowCount(); i++) {
            if (vueAffProduit.table.getValueAt(i, 0).equals(productName)) {
                return i;
            }
        }
        return -1;
    }
}
