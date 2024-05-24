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
    public Hotel hotel;
    public Fenetre fenetre;
    private JButton button;
    private JTable table;
    private int row;

    public BouttonEditeurRes(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.button = new JButton();
            this.button.setOpaque(true);
            this.button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    Reservation reservation = hotel.listReservation.get(row);
                    Chambre chambre = reservation.getChambre();
                    Sejour sejour = hotel.listSejour.get(row);
                    chambre.removeReservation(reservation);
                    hotel.removeReservation(reservation);
                    hotel.removeSejour(sejour);
                    System.out.println("Reservation : " + hotel.getListReservation()+ "\n");
                    System.out.println("Chambre : " + chambre.getListReservation()+ "\n");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                    fenetre.setContentPane(new Vue.VueReservation(hotel, fenetre));
                    fenetre.revalidate();
                    System.out.println("Reservation : " + hotel.getListReservation()+ "\n");
                }
            });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        button.setText((value == null) ? "" : value.toString());
        return button;
    }
}


