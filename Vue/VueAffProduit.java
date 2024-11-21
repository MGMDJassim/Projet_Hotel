package Vue;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Hotel;
import Model.Produit;
import Controler.BouttonStock;
import Controler.ControlRechercheProduit;

public class VueAffProduit extends JPanel {
    public Hotel hotel;
    public Fenetre fenetre;

    private JLabel nomProduit = new JLabel("Nom du produit");
    private JComboBox<String> nom = new JComboBox<>(new String[]{"Produit 1", "Produit 2", "Produit 3", "Produit 4", "Produit 5"});
    private JButton rechercher = new JButton("Rechercher");

    public JTable table;
    public Vector<String> nomColonne;
    private Vector<Vector<Object>> donnees;
    private DefaultTableModel model;

    private JPanel panel = new JPanel();

    public VueAffProduit(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;
        nomColonne = new Vector<>();
        donnees = new Vector<>();
        nomColonne.add("Nom");
        nomColonne.add("Prix");
        nomColonne.add("Stock");
        nomColonne.add("Ajouter");

        for (Produit produit : hotel.getListeProduit()) {
            Vector<Object> ligne = new Vector<>();
            ligne.add(produit.getNom());
            ligne.add(produit.getPrix());
            ligne.add(produit.getStock());
            ligne.add("Ajouter");
            donnees.add(ligne);
        }

        model = new DefaultTableModel(donnees, nomColonne);
        table = new JTable(model);
        table.getColumn("Ajouter").setCellRenderer(new ButtonRenderer());
        table.getColumn("Ajouter").setCellEditor(new BouttonStock(new JCheckBox(), hotel, this, fenetre));

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        panel.add(nomProduit);
        panel.add(nom);
        panel.add(rechercher);
        this.add(panel, BorderLayout.NORTH);

        rechercher.addActionListener(new ControlRechercheProduit(nom, hotel, fenetre, this, table, model));
    }

    public DefaultTableModel getModel() {
        return model;
    }
    public Vector<String> getNomColonne() {
        return nomColonne;
    }
    
}
