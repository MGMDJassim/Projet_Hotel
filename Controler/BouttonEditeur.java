package Controler;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Chambre;
import Model.Hotel;
import Model.Reservation;
import Vue.Fenetre;

public class BouttonEditeur extends DefaultCellEditor {
    public Hotel hotel;
    public Fenetre fenetre;
    private JButton button;
    private JTable table;
    private int row;

    public BouttonEditeur(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.button = new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                if (row < table.getRowCount()) {
                    int modelRow = table.convertRowIndexToModel(row);
                    Chambre chambre = hotel.listechambre.get(modelRow);
                    // Supprimer toutes les réservations de la chambre
                    for (Reservation r : chambre.getListReservation()) {
                        hotel.removeReservation(r);
                    }
                    hotel.removeChambre(chambre);
                    // Mettre à jour la table après la suppression
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(modelRow);
                    fenetre.setContentPane(new Vue.VueAffChambre(hotel, fenetre));
                    fenetre.revalidate();

                    System.out.println("Chambre supprimée: " + hotel.getListechambre() + "\n");
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        button.setText((value == null) ? "" : value.toString());
        return button;
    }
}
