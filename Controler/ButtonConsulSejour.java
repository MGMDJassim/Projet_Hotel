package Controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import Model.Hotel;
import Model.Sejour;
import Vue.VueAffConsulSejour;



public class ButtonConsulSejour extends DefaultCellEditor {
    Hotel hotel;
    private JButton button;
    private JTable table;
    private Sejour sejour;
    int row;
    public ButtonConsulSejour(JCheckBox checkBox, Hotel hotel, Sejour sejour) {
        super(checkBox);
        this.hotel=hotel;
        this.sejour = sejour;
        this.button= new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                new VueAffConsulSejour(hotel, sejour);
            }
        });
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        button.setText(value.toString());
        return button;
    }
}
