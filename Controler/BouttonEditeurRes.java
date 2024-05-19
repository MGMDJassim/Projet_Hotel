package Controler;


import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import Model.Hotel;
import Model.Reservation;
import Vue.Fenetre;


public class BouttonEditeurRes extends DefaultCellEditor {
    private Hotel hotel;
    private Reservation reservation;
    
    private JButton button;
    private JTable table;
    private int row;

    public BouttonEditeurRes(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.button = new JButton();
            this.button.setOpaque(true);
            this.button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    hotel.removeReservation(reservation);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                    fenetre.setContentPane(new Vue.VueReservation(hotel, fenetre));
                    fenetre.revalidate();
                    System.out.println("Reservation : " + hotel.getListReservation());
                }
            });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        this.reservation = hotel.listReservation.get(row);
        button.setText((value == null) ? "" : value.toString());
        return button;
    }
}


