package Controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Hotel;
import Model.Client;
import Model.Reservation;
import Vue.Fenetre;
import Vue.VueAffClient;
public class ButtonEditeurSuppClient extends DefaultCellEditor {
    private Hotel hotel;
    private Fenetre fenetre;
    private JButton bouton;
    private JTable table;
    private int ligne;
    public ButtonEditeurSuppClient(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.bouton = new JButton();
        this.bouton.setOpaque(true);
        this.bouton.addActionListener(new BoutonActionListener());
    }

    public Component getTableCellEditorComponent(JTable table, Object valeur, boolean estSelectionne, int ligne, int colonne) {
        this.table = table;
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
            Client client = hotel.listeClient.get(ligne);
            hotel.supprimerClient(client);
            for (int i = hotel.listeReservation.size() - 1; i >= 0; i--) {
                Reservation r = hotel.listeReservation.get(i);
                if (r.getClient().equals(client)) {
                    hotel.listeReservation.remove(i);
                }
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if (ligne < model.getRowCount()) {
                model.removeRow(ligne);
            }
            fenetre.setContentPane(new VueAffClient(hotel, fenetre));
            fenetre.revalidate();
        }
    }
}