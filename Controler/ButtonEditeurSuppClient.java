package Controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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
        bouton.setText((valeur == null) ? "" : valeur.toString());
        return bouton;
    }
    private class BoutonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nom = String.valueOf(table.getValueAt(ligne, 0));
            String prenom = String.valueOf(table.getValueAt(ligne, 1));
            LocalDate date = LocalDate.parse(String.valueOf(table.getValueAt(ligne, 2)));
            int tel = Integer.parseInt(String.valueOf(table.getValueAt(ligne, 3)));

            Client clientASupprimer = null;
            for (Client client : hotel.listeClient) {
                if (client.getNomClient().equals(nom) && client.getPrenomClient().equals(prenom) &&
                    client.getDateDeNaissance().equals(date) && client.getTelClient() == tel) {
                    clientASupprimer = client;
                    break;
                }
            }
            if (clientASupprimer != null) {
                hotel.supprimerClient(clientASupprimer);
                for (int i = hotel.listeReservation.size() - 1; i >= 0; i--) {
                    Reservation reservation = hotel.listeReservation.get(i);
                    if (reservation.getClient().equals(clientASupprimer)) {
                        hotel.listeReservation.remove(i);
                    }
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(ligne);
            }

            fenetre.setContentPane(new VueAffClient(hotel, fenetre));
            fenetre.revalidate();
        }
    }
}