package Vue;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import Controler.ControlAjoutReservation;
import Controler.ControlRecherche;
import Model.Chambre;
import Model.Hotel;

public class VueAjoutReservation extends JPanel {
    private Hotel hotel;
    private Fenetre fenetre;
    private Chambre chambre;

    // Elements pour chercher une chambre libre
    JLabel dateDebut = new JLabel("Date de début (Année-Mois-Jour) :");
    JTextField Ddebut = new JTextField();

    JLabel dateFin = new JLabel("Date de fin (Année-Mois-Jour) :");
    JTextField Dfin = new JTextField();

    JLabel typeChambre = new JLabel("Type de chambre");
    JComboBox<String> type = new JComboBox<>(new String[]{"Normale", "Presidentielle"});

    JButton rechercher = new JButton("Rechercher");

    // Elements pour ajouter le client
    JLabel nomClient = new JLabel("Nom du client");
    JTextField nom = new JTextField();

    JLabel prenomClient = new JLabel("Prenom du client");
    JTextField prenom = new JTextField();

    JLabel dateNaissance = new JLabel("Date de naissance (Année-Mois-Jour) :");
    JTextField date = new JTextField();

    JLabel telClient = new JLabel("Telephone du client");
    JTextField tel = new JTextField();

    // Element pour ajouter un séjour
    JCheckBox sejour = new JCheckBox("Séjour");
    JLabel produit = new JLabel("Produit");
    JComboBox<String> prod = new JComboBox<>(new String[]{"Produit1", "Produit2", "Produit3", "Produit4", "Produit5"});
    JLabel quantite = new JLabel("Quantité");
    JTextField qte = new JTextField();

    JButton ajouter = new JButton("Ajouter");

    JTable table = new JTable();

    LocalDate debut;
    LocalDate fin;

    Vector<String> nomColonne;
    Vector<Vector<Object>> data;
    Vector<Chambre> freeRooms;

    public VueAjoutReservation(Hotel hotel, Fenetre fenetre, Chambre chambre) {
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.chambre = chambre;
        setLayout(new BorderLayout());

        // Panel gauche pour le formulaire
        JPanel leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Ajout des éléments du formulaire
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(dateDebut, gbc);
        gbc.gridx = 1;
        leftPanel.add(Ddebut, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(dateFin, gbc);
        gbc.gridx = 1;
        leftPanel.add(Dfin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        leftPanel.add(typeChambre, gbc);
        gbc.gridx = 1;
        leftPanel.add(type, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        leftPanel.add(rechercher, gbc);

        ControlRecherche r = new ControlRecherche(hotel, Ddebut, Dfin, type, VueAjoutReservation.this);
        rechercher.addActionListener(r);

        gbc.gridx = 0;
        gbc.gridy = 4;
        leftPanel.add(nomClient, gbc);
        gbc.gridx = 1;
        leftPanel.add(nom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        leftPanel.add(prenomClient, gbc);
        gbc.gridx = 1;
        leftPanel.add(prenom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        leftPanel.add(dateNaissance, gbc);
        gbc.gridx = 1;
        leftPanel.add(date, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        leftPanel.add(telClient, gbc);
        gbc.gridx = 1;
        leftPanel.add(tel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        leftPanel.add(ajouter, gbc);
        // Panel droit pour le tableau
        JScrollPane scrollPane = new JScrollPane(table);
        // Split pane pour diviser la fenêtre en deux moitiés égales
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scrollPane);
        splitPane.setDividerLocation(0.5); // Diviser la fenêtre en deux moitiés égales

        add(splitPane, BorderLayout.CENTER);
    }

    public void afficherTableau(Vector<Chambre> freeRooms) {
        Vector<String> nomColonne = new Vector<>();
        nomColonne.add("Numero de porte");
        nomColonne.add("Type");
        nomColonne.add("Etage");
        nomColonne.add("Prix");
        nomColonne.add("Selectionner");

        LocalDate debut = LocalDate.parse(Ddebut.getText());
        LocalDate fin = LocalDate.parse(Dfin.getText());

        long diff = ChronoUnit.DAYS.between(debut, fin);

        Vector<Vector<Object>> data = new Vector<>();
        for (Chambre room : freeRooms) {
            Vector<Object> row = new Vector<>();
            row.add(room.getNumeroPorte());
            row.add(room.getType());
            row.add(room.getEtage());
            row.add(room.getPrix() * diff + "€");
            row.add(Boolean.FALSE); // Ajouter une valeur Boolean pour la case à cocher
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, nomColonne) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) { // La colonne de la case à cocher est de type Boolean
                    return Boolean.class;
                }
                return String.class; // Toutes les autres colonnes sont de type String
            }
        };

        table.setModel(model);
        table.repaint();
        table.revalidate();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int modelRow = table.convertRowIndexToModel(selectedRow); // Get the correct model index
                    chambre = freeRooms.get(modelRow);

                    for (ActionListener al : ajouter.getActionListeners()) {
                        ajouter.removeActionListener(al);
                    }
                    ControlAjoutReservation control = new ControlAjoutReservation(hotel, Ddebut, Dfin, nom, prenom, date, tel, chambre, fenetre);
                    ajouter.addActionListener(control);
                    if (chambre == null) {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une chambre");
                        return;
                    }
                }
            }
        });
    }
}