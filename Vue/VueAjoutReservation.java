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
    JLabel dateDebut = new JLabel("Date de début (Année-Mois-Jour) :");
    JTextField Ddebut = new JTextField();

    JLabel dateFin = new JLabel("Date de fin (Année-Mois-Jour) :");
    JTextField Dfin = new JTextField();

    JLabel typeChambre = new JLabel("Type de chambre");
    JComboBox<String> type = new JComboBox<>(new String[]{"Normale", "Presidentielle"});

    JButton rechercher = new JButton("Rechercher");
    JLabel nomClient = new JLabel("Nom du client");
    JTextField nom = new JTextField();

    JLabel prenomClient = new JLabel("Prénom du client");
    JTextField prenom = new JTextField();

    JLabel dateNaissance = new JLabel("Date de naissance (Année-Mois-Jour) :");
    JTextField date = new JTextField();

    JLabel telClient = new JLabel("Téléphone du client");
    JTextField tel = new JTextField();


    JLabel consommation = new JLabel("Consommation");

    JCheckBox produit1 = new JCheckBox("Produit 1");
    JCheckBox produit2 = new JCheckBox("Produit 2");
    JCheckBox produit3 = new JCheckBox("Produit 3");
    JCheckBox produit4 = new JCheckBox("Produit 4");
    JCheckBox produit5 = new JCheckBox("Produit 5");

    JComboBox<Integer> quantite1 = new JComboBox<>(new Integer[]{0,1, 2, 3, 4, 5});
    JComboBox<Integer> quantite2 = new JComboBox<>(new Integer[]{0,1, 2, 3, 4, 5});
    JComboBox<Integer> quantite3 = new JComboBox<>(new Integer[]{0,1, 2, 3, 4, 5});
    JComboBox<Integer> quantite4 = new JComboBox<>(new Integer[]{0,1, 2, 3, 4, 5});
    JComboBox<Integer> quantite5 = new JComboBox<>(new Integer[]{0,1, 2, 3, 4, 5});

    
    JButton ajouter = new JButton("Ajouter");

    JTable table = new JTable();

    LocalDate debut;
    LocalDate fin;

    Vector<String> nomColonne;
    Vector<Vector<Object>> data;
    Vector<Chambre> chambresLibres;

    public VueAjoutReservation(Hotel hotel, Fenetre fenetre, Chambre chambre) {
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.chambre = chambre;
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        gbc.gridy = 8;

        leftPanel.add(consommation, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        leftPanel.add(produit1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        leftPanel.add(quantite1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        leftPanel.add(produit2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        leftPanel.add(quantite2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        leftPanel.add(produit3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        leftPanel.add(quantite3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        leftPanel.add(produit4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        leftPanel.add(quantite4, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        leftPanel.add(produit5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        leftPanel.add(quantite5, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 15;
        leftPanel.add(ajouter, gbc);

        JScrollPane scrollPane = new JScrollPane(table);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scrollPane);
        splitPane.setDividerLocation(0.5);

        add(splitPane, BorderLayout.CENTER);
    }

    public void afficherTableau(Vector<Chambre> chambresLibres) {
        Vector<String> nomColonne = new Vector<>();
        nomColonne.add("Numéro de porte");
        nomColonne.add("Type");
        nomColonne.add("Étage");
        nomColonne.add("Prix");
        nomColonne.add("Sélectionner");

        LocalDate debut = LocalDate.parse(Ddebut.getText());
        LocalDate fin = LocalDate.parse(Dfin.getText());

        long diff = ChronoUnit.DAYS.between(debut, fin);

        Vector<Vector<Object>> data = new Vector<>();
        for (Chambre chambre : chambresLibres) {
            Vector<Object> row = new Vector<>();
            row.add(chambre.getNumeroPorte());
            row.add(chambre.getType());
            row.add(chambre.getEtage());
            row.add(chambre.getPrix() * diff + "€");
            row.add(Boolean.FALSE);
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, nomColonne) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class;
                }
                return String.class;
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
                    int modelRow = table.convertRowIndexToModel(selectedRow);
                    chambre = chambresLibres.get(modelRow);

                    for (ActionListener al : ajouter.getActionListeners()) {
                        ajouter.removeActionListener(al);
                    }

                    JCheckBox[] produits = new JCheckBox[]{produit1, produit2, produit3, produit4, produit5};
                    JComboBox<Integer>[] quantites = new JComboBox[]{quantite1, quantite2, quantite3, quantite4, quantite5};

                    ControlAjoutReservation control = new ControlAjoutReservation(hotel, Ddebut, Dfin, nom, prenom, date, tel, chambre, fenetre, produits, quantites);
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
