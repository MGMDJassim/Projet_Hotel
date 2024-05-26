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
    private Fenetre fenetre;

    private JLabel nomProduit = new JLabel("Nom du produit");
    private JComboBox<String> nom = new JComboBox<>(new String[]{"Produit 1", "Produit 2", "Produit 3", "Produit 4", "Produit 5"});
    private JButton rechercher = new JButton("Rechercher");

    public JTable table = new JTable();
    public Vector <String> nomColonne;
    Vector <Vector<Object>> donnees;
    DefaultTableModel model;

    private JPanel panel = new JPanel();
    
    public VueAffProduit(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;

        panel.add(nomProduit);
        panel.add(nom);
        panel.add(rechercher);

        nomColonne = new Vector<String>();
        donnees = new Vector<Vector<Object>>();

        nomColonne.add("Nom");
        nomColonne.add("Stock");
        nomColonne.add("Faire les stocks");

        for (Produit produit : hotel.getListeProduit()) {
            Vector<Object> ligne = new Vector<Object>();
            ligne.add(produit.getNom());
            ligne.add(produit.getStock());
            ligne.add("Faire les stocks");

            donnees.add(ligne);
        }

        this.add(panel, BorderLayout.NORTH);
        model = new DefaultTableModel(donnees, nomColonne);
        table.setModel(model);
        table.getColumn("Faire les stocks").setCellRenderer(new BottonRendu());
        for(int i = 0; i < table.getRowCount(); i++) {
            Produit produit = hotel.listeProduit.get(i);
            table.getColumn("Faire les stocks").setCellEditor(new BouttonStock(new JCheckBox(), hotel, produit, this, fenetre));
        }
        rechercher.addActionListener(new ControlRechercheProduit(nom ,hotel, fenetre, this, table, model));
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
