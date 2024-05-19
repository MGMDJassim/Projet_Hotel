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
import Vue.Fenetre;


public class BouttonEditeur extends DefaultCellEditor {
    private Hotel hotel;
    private Chambre chambre;
    
    private JButton button;
    private JTable table;
    private int row;

    public BouttonEditeur(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.button = new JButton();
            this.button.setOpaque(true);
            this.button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    hotel.removeChambre(chambre);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                    fenetre.setContentPane(new Vue.VueAffChambre(hotel, fenetre));
                    fenetre.revalidate();
                    System.out.println(hotel.getListechambre());
                }
            });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        this.chambre = hotel.listechambre.get(row);
        button.setText((value == null) ? "" : value.toString());
        return button;
    }
}


