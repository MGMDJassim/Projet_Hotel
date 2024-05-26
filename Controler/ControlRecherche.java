package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Model.Chambre;
import Model.Hotel;
import Vue.VueAjoutReservation;

public class ControlRecherche implements ActionListener {
    private Hotel hotel;
    private JTextField Ddebut;
    private JTextField Dfin;
    private JComboBox<String> type;
    private VueAjoutReservation vueAjoutReservation;
    public ControlRecherche(Hotel hotel, JTextField Ddebut, JTextField Dfin, JComboBox<String> type, VueAjoutReservation panel) {
        this.hotel = hotel;
        this.Ddebut = Ddebut;
        this.Dfin = Dfin;
        this.type = type;
        this.vueAjoutReservation = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Ddebut.getText().isEmpty() && !Dfin.getText().isEmpty() && !type.getSelectedItem().toString().isEmpty()) {
            try {
                LocalDate debut = LocalDate.parse(Ddebut.getText());
                LocalDate fin = LocalDate.parse(Dfin.getText());
                String typeChambre = type.getSelectedItem().toString();
                Vector<Chambre> freeRooms = hotel.getChambresLibres(debut, fin);
                if (freeRooms != null) {
                    Vector<Chambre> filteredRooms = new Vector<Chambre>();
                    for (Chambre chambre : freeRooms) {
                        if (chambre.getType().equals(typeChambre)){
                            filteredRooms.add(chambre);
                        }
                    }
                    if (filteredRooms.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Il n'y a pas de chambres disponibles pour le type de chambre sélectionné.");
                    } else {
                        vueAjoutReservation.afficherTableau(filteredRooms);
                        vueAjoutReservation.repaint();
                        vueAjoutReservation.revalidate();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aucune chambre libre pour les dates spécifiées.");
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer une date valide au format YYYY-MM-DD.");
            }
        }
    }

}