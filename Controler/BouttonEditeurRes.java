package Controler;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import Model.Chambre;
import Model.Hotel;
import Model.Reservation;
import Model.Sejour;
import Vue.Fenetre;

public class BouttonEditeurRes extends DefaultCellEditor {
    private Hotel hotel;
    private Fenetre fenetre;
    private JButton bouton;
    private JTable tableau;
    private int ligne;
    public BouttonEditeurRes(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.bouton = new JButton();
        this.bouton.setOpaque(true);
        this.bouton.addActionListener(new BoutonActionListener());
    }
    public Component getTableCellEditorComponent(JTable table, Object valeur, boolean selectionne, int ligne, int column) {
        this.tableau = table;
        this.ligne = ligne;
        if (valeur == null) {
            bouton.setText("");
        } else {
            bouton.setText(valeur.toString());
        }
        return bouton;
    }
    private class BoutonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
            Reservation reservation = hotel.listeReservation.get(ligne);
            Chambre chambre = reservation.getChambre();
            Sejour sejour = hotel.listeSejour.get(ligne);
            chambre.supprimerReservation(reservation);
            hotel.supprimerReservation(reservation);
            hotel.supprimerSejour(sejour);
            DefaultTableModel model = (DefaultTableModel) tableau.getModel();
            model.removeRow(ligne);
            fenetre.setContentPane(new Vue.VueReservation(hotel, fenetre));
            fenetre.revalidate();
        }
    }
}

