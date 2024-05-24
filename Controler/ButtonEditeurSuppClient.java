package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;

import Model.Hotel;
import Model.Client;
import Model.Reservation;
import Vue.Fenetre;
import Vue.VueAffClient;

public class ButtonEditeurSuppClient extends DefaultCellEditor {
    public Hotel hotel;
    public Fenetre fenetre;
    private JButton button;
    private JTable table;
    private int row;

    public ButtonEditeurSuppClient(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
       super(checkBox);
       this.hotel = hotel;
       this.fenetre = fenetre;

        this.button = new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                Client client = hotel.listClient.get(row);
                hotel.removeClient(client);
                System.out.println("Client : " + hotel.getListClient() + "\n");  
                for(Client c : hotel.listClient){
                    System.out.println("Client : " + c.getNomClient() + "\n");
                }
                for (int i = hotel.listReservation.size() - 1; i >= 0; i--) {
                    Reservation r = hotel.listReservation.get(i);
                    if (r.getClient().equals(client)) {
                        hotel.listReservation.remove(i);
                    }
                }
                System.out.println("resevation : " + hotel.listReservation + "\n");

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                    if (row < model.getRowCount()) {
                        model.removeRow(row);
                    }
                    fenetre.setContentPane(new VueAffClient(hotel, fenetre));
                    fenetre.revalidate();
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
