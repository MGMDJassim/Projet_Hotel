package Vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

import Model.Chambre;
import Model.Hotel;

public class VueGestionMenage extends JPanel {
    private Hotel hotel;
    private JTable table;
    private DefaultTableModel model;

    public VueGestionMenage(Hotel hotel) {
        super(new BorderLayout());
        this.hotel = hotel;

        // Initialisation des colonnes et des données du tableau
        Vector<String> nomColonne = new Vector<>();
        nomColonne.add("Numéro");
        nomColonne.add("Type");
        nomColonne.add("Etage");
        nomColonne.add("Etat");

        Vector<Vector<Object>> donnees = new Vector<>();
        for (Chambre chambre : hotel.listeChambre) {
            Vector<Object> ligne = new Vector<>();
            ligne.add(chambre.getNumeroPorte());
            ligne.add(chambre.getType());
            ligne.add(chambre.getEtage());
            ligne.add(chambre.getEtatChambre() ? "Propre" : "Sale");
            donnees.add(ligne);
        }

        model = new DefaultTableModel(donnees, nomColonne);
        table = new JTable(model);

        // Vérifiez que le nombre de colonnes est correct
        if (table.getColumnCount() != nomColonne.size()) {
            throw new IllegalStateException("Le nombre de colonnes dans le modèle de table ne correspond pas au nombre de colonnes attendu.");
        }

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}