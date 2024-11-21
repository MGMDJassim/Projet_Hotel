package Vue;

import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import Controler.ControlRecherche;
import Model.Chambre;
import Model.Hotel;
import Model.Presidentiel;
import Model.Receptionniste;

public class VueAjoutReservation extends JPanel {
    private Hotel hotel;
    Fenetre fenetre;
    Chambre chambre;
    Receptionniste receptionniste;

    // Composants de l'interface
    JLabel dateDebut = new JLabel("Date de début (AAAA-MM-JJ) :");
    JTextField Ddebut = new JTextField();

    JLabel dateFin = new JLabel("Date de fin (AAAA-MM-JJ) :");
    JTextField Dfin = new JTextField();

    JLabel typeChambre = new JLabel("Type de chambre :");
    JComboBox<String> type = new JComboBox<>(new String[]{"Normale", "Presidentielle"});

    JButton rechercher = new JButton("Rechercher");

    JLabel nomClient = new JLabel("Nom du client :");
    JTextField nom = new JTextField();

    JLabel prenomClient = new JLabel("Prénom du client :");
    JTextField prenom = new JTextField();

    JLabel dateNaissance = new JLabel("Date de naissance (AAAA-MM-JJ) :");
    JTextField date = new JTextField();

    JLabel telClient = new JLabel("Téléphone du client :");
    JTextField tel = new JTextField();

    JLabel consommation = new JLabel("Consommation :");
    JCheckBox produit1 = new JCheckBox("Produit 1");
    JCheckBox produit2 = new JCheckBox("Produit 2");
    JCheckBox produit3 = new JCheckBox("Produit 3");
    JCheckBox produit4 = new JCheckBox("Produit 4");
    JCheckBox produit5 = new JCheckBox("Produit 5");

    JComboBox<Integer> quantite1 = new JComboBox<>(new Integer[]{0, 1, 2, 3, 4, 5});
    JComboBox<Integer> quantite2 = new JComboBox<>(new Integer[]{0, 1, 2, 3, 4, 5});
    JComboBox<Integer> quantite3 = new JComboBox<>(new Integer[]{0, 1, 2, 3, 4, 5});
    JComboBox<Integer> quantite4 = new JComboBox<>(new Integer[]{0, 1, 2, 3, 4, 5});
    JComboBox<Integer> quantite5 = new JComboBox<>(new Integer[]{0, 1, 2, 3, 4, 5});

    JButton ajouter = new JButton("Ajouter");
    JTable table = new JTable();

    Vector<Chambre> chambresLibres;

    // Constructeur
    public VueAjoutReservation(Hotel hotel, Fenetre fenetre, Chambre chambre, Receptionniste receptionniste) {
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.chambre = chambre;
        this.receptionniste = receptionniste;

        setLayout(new BorderLayout());
        initializeUI();
    }

    // Méthode pour initialiser l'interface utilisateur
    private void initializeUI() {
        JPanel leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Ajout des composants au panneau gauche
        int y = 0;
        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(dateDebut, gbc);
        gbc.gridx = 1;
        leftPanel.add(Ddebut, gbc);

        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(dateFin, gbc);
        gbc.gridx = 1;
        leftPanel.add(Dfin, gbc);

        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(typeChambre, gbc);
        gbc.gridx = 1;
        leftPanel.add(type, gbc);

        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(rechercher, gbc);

        // Configuration du contrôleur de recherche
        ControlRecherche controlRecherche = new ControlRecherche(hotel, Ddebut, Dfin, type, this);
        rechercher.addActionListener(controlRecherche);

        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(nomClient, gbc);
        gbc.gridx = 1;
        leftPanel.add(nom, gbc);

        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(prenomClient, gbc);
        gbc.gridx = 1;
        leftPanel.add(prenom, gbc);

        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(dateNaissance, gbc);
        gbc.gridx = 1;
        leftPanel.add(date, gbc);

        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(telClient, gbc);
        gbc.gridx = 1;
        leftPanel.add(tel, gbc);

        // Consommation
        gbc.gridx = 0; gbc.gridy = y++;
        leftPanel.add(consommation, gbc);
        addProduit(leftPanel, gbc, produit1, quantite1, y++);
        addProduit(leftPanel, gbc, produit2, quantite2, y++);
        addProduit(leftPanel, gbc, produit3, quantite3, y++);
        addProduit(leftPanel, gbc, produit4, quantite4, y++);
        addProduit(leftPanel, gbc, produit5, quantite5, y++);

        gbc.gridx = 0; gbc.gridy = y;
        leftPanel.add(ajouter, gbc);

        // Table des chambres disponibles
        JScrollPane scrollPane = new JScrollPane(table);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scrollPane);
        splitPane.setDividerLocation(0.5);

        add(splitPane, BorderLayout.CENTER);
    }

    // Méthode pour ajouter un produit et sa quantité à l'interface
    private void addProduit(JPanel panel, GridBagConstraints gbc, JCheckBox produit, JComboBox<Integer> quantite, int y) {
        gbc.gridx = 0; gbc.gridy = y;
        panel.add(produit, gbc);
        gbc.gridx = 1;
        panel.add(quantite, gbc);
    }

    // Méthode pour afficher les chambres disponibles dans un tableau
    public void afficherTableau(Vector<Chambre> chambresLibres) {
        // Colonnes
        Vector<String> nomColonne = new Vector<>();
        nomColonne.add("Numéro de porte");
        nomColonne.add("Type");
        nomColonne.add("Étage");
        nomColonne.add("Prix");
        nomColonne.add("Sélectionner");

        // Données
        Vector<Vector<Object>> data = new Vector<>();
        for (Chambre chambre : chambresLibres) {
            Vector<Object> row = new Vector<>();
            row.add(chambre.getNumeroPorte());
            row.add(chambre instanceof Presidentiel ? "Presidentielle" : "Normale");
            row.add(chambre.getEtage());
            row.add(chambre.getPrix() + " €");
            row.add(Boolean.FALSE);
            data.add(row);
        }

        // Modèle de tableau
        DefaultTableModel model = new DefaultTableModel(data, nomColonne) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };

        table.setModel(model);
        table.repaint();
        table.revalidate();
    }
}
