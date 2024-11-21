package Vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Controler.BouttonEditeur;
import Controler.FiltreChambre;
import Model.*;

public class VueAffChambre extends JPanel {
    private Hotel hotel;
    private Fenetre fenetre;
    private Vector<String> nomColonne;
    private Vector<Vector<Object>> donnees;
    private JTable table;
    private DefaultTableModel model;
    private FiltreChambre filtreChambre;

    public VueAffChambre(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.filtreChambre = new FiltreChambre(hotel);

        // Initialisation des colonnes et des données du tableau
        nomColonne = new Vector<>();
        donnees = new Vector<>();
        nomColonne.add("Numéro");
        nomColonne.add("Type");
        nomColonne.add("Etage");
        nomColonne.add("Supprimer");

        for (Chambre chambre : hotel.listeChambre) {
            Vector<Object> ligne = new Vector<>();
            ligne.add(chambre.getNumeroPorte());
            ligne.add(chambre.getType());
            ligne.add(chambre.getEtage());
            ligne.add("Supprimer");
            donnees.add(ligne);
        }

        model = new DefaultTableModel(donnees, nomColonne);
        table = new JTable(model);
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new BouttonEditeur(new JCheckBox(), hotel, fenetre));
        JScrollPane scrollPane = new JScrollPane(table);

        // Création du formulaire de filtrage
        JPanel filterPanel = new JPanel();

        JLabel typeLabel = new JLabel("Type:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Tous", "Normale", "Presidentiel"});
        JButton filterButton = new JButton("Filtrer");

        filterPanel.add(typeLabel);
        filterPanel.add(typeComboBox);
        filterPanel.add(filterButton);

        // Ajout d'un écouteur d'événements pour le bouton de filtrage
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeText = (String) typeComboBox.getSelectedItem();
                donnees = filtreChambre.filtrerChambres(typeText);
                model.setDataVector(donnees, nomColonne);
            }
        });

        // Création du formulaire d'ajout de chambre
        JPanel addPanel = new JPanel();

        JLabel etageLabel = new JLabel("Etage:");
        JTextField etageField = new JTextField(10);
        JLabel typeAddLabel = new JLabel("Type:");
        JComboBox<String> typeAddComboBox = new JComboBox<>(new String[]{"Normale", "Presidentiel"});
        JButton addButton = new JButton("Ajouter");

        addPanel.add(etageLabel);
        addPanel.add(etageField);
        addPanel.add(typeAddLabel);
        addPanel.add(typeAddComboBox);
        addPanel.add(addButton);

        // Ajout d'un écouteur d'événements pour le bouton d'ajout
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int etage = Integer.parseInt(etageField.getText());
                    String type = (String) typeAddComboBox.getSelectedItem();
                    Chambre nouvelleChambre;
                    if (type.equals("Normale")) {
                        nouvelleChambre = new Normale(etage, hotel, true);
                    } else {
                        nouvelleChambre = new Presidentiel(etage, hotel, true);
                    }
                    hotel.ajouterChambre(nouvelleChambre);
                    Vector<Object> ligne = new Vector<>();
                    ligne.add(nouvelleChambre.getNumeroPorte());
                    ligne.add(nouvelleChambre.getType());
                    ligne.add(nouvelleChambre.getEtage());
                    ligne.add("Supprimer");
                    donnees.add(ligne);
                    model.fireTableDataChanged();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un étage valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ajout des panneaux au JSplitPane
        JPanel leftPanel = new JPanel(new BorderLayout());
        JSplitPane leftSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, filterPanel, addPanel);
        leftSplitPane.setDividerLocation(150);
        leftPanel.add(leftSplitPane, BorderLayout.CENTER);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scrollPane);
        mainSplitPane.setDividerLocation(200);
        this.add(mainSplitPane, BorderLayout.CENTER);
    }
}