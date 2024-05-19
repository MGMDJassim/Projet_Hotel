package Vue;

import java.time.LocalDate;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controler.ControlAjoutReservation;
import Controler.ControlRecherche;
import Vue.BottonRendu;
import Model.Chambre;
import Model.Hotel;
import Model.Normale;
import Model.Presidentiel;

public class VueAjoutReservation extends JPanel {
    Hotel hotel;
    Fenetre fenetre;
    Chambre chambre;

    JLabel dateDebut = new JLabel("Date de debut (Année-Mois-Jour) :");
    JTextField Ddebut = new JTextField();

    JLabel dateFin = new JLabel("Date de fin (Année-Mois-Jour) :");
    JTextField Dfin = new JTextField();

    JLabel typeChambre = new JLabel("Type de chambre");
    JComboBox<String> type = new JComboBox<String>();
    String[] types = {"Normale", "Presidentielle"};

    JButton rechercher = new JButton("Rechercher");

    JLabel nomCLient = new JLabel("Nom du client");
    JTextField nom = new JTextField();

    JLabel prenomClient = new JLabel("Prenom du client");
    JTextField prenom = new JTextField();

    JLabel dataNaissance = new JLabel("Date de naissance (Année-Mois-Jour) :");
    JTextField date = new JTextField();

    JLabel telClient = new JLabel("Telephone du client");
    JTextField tel = new JTextField();

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
        setLayout(null);

        add(dateDebut);
        add(Ddebut);
        dateDebut.setBounds(10, 10, 200, 20);
        Ddebut.setBounds(250, 10, 200, 20);

        add(dateFin);
        add(Dfin);
        dateFin.setBounds(10, 40, 200, 20);
        Dfin.setBounds(250, 40, 200, 20);

        add(typeChambre);
        add(type);
        type.addItem("");
        type.addItem("Normale");
        type.addItem("Presidentielle");
        typeChambre.setBounds(10, 70, 200, 20);
        type.setBounds(250, 70, 200, 20);

        add(rechercher);
        rechercher.setBounds(10, 100, 200, 20);
        rechercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ControlRecherche r = new ControlRecherche(hotel, Ddebut, Dfin, table, VueAjoutReservation.this, type, VueAjoutReservation.this);
                r.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            }
        });

        add(nomCLient);
        add(nom);
        nomCLient.setBounds(10, 130, 200, 20);
        nom.setBounds(250, 130, 200, 20);

        add(prenomClient);
        add(prenom);
        prenomClient.setBounds(10, 160, 200, 20);
        prenom.setBounds(250, 160, 200, 20);

        add(dataNaissance);
        add(date);
        dataNaissance.setBounds(10, 190, 230, 20);
        date.setBounds(250, 190, 200, 20);

        add(telClient);
        add(tel);
        telClient.setBounds(10, 220, 200, 20);
        tel.setBounds(250, 220, 200, 20);

        add(ajouter);
        ajouter.setBounds(10, 250, 200, 20);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(500, 10, 400, 400);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void afficherTableau(Vector<Chambre> freeRooms) {
        Vector<String> nomColonne = new Vector<String>();
        nomColonne.add("Numero de porte");
        nomColonne.add("Type");
        nomColonne.add("Etage");
        nomColonne.add("Prix");
        nomColonne.add("Selectionner");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for (Chambre room : freeRooms) {
            Vector<Object> row = new Vector<Object>();
            row.add(room.getNumeroPorte());
            row.add(room.getType());
            row.add(room.getEtage());
            if (room instanceof Presidentiel) {
                row.add(Presidentiel.getPrix() + "€");
            } else if (room instanceof Normale) {
                row.add(((Normale) room).getPrix() + "€");
            } else {
                row.add("N/A");
            }
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

        //table.getColumn("Selectionner").setCellRenderer(new BottonRendu());
        
        
        table.repaint();
        table.revalidate();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String typeChambre = (String) table.getModel().getValueAt(selectedRow, 1);
                    for (Chambre room : freeRooms) {
                        if (room.getType().equals(typeChambre)) {
                            chambre = room;
                            break;
                        }
                    }
                }

                for (ActionListener al : ajouter.getActionListeners()) {
                    ajouter.removeActionListener(al);
                }

                ControlAjoutReservation control = new ControlAjoutReservation(hotel, Ddebut, Dfin, nom, prenom, date, tel, table, chambre);
                ajouter.addActionListener(control);

                if (chambre == null) {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une chambre");
                    return;
                }
            }
        });
    }
}
