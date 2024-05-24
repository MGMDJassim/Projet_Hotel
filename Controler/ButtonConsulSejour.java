package Controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import Model.Hotel;


public class ButtonConsulSejour extends DefaultCellEditor {
    Hotel hotel;
    private JButton button;
    private JTable table;
    int row;
    public ButtonConsulSejour(JCheckBox checkBox, Hotel hotel) {
        super(checkBox);
        this.hotel=hotel;
        this.button= new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(null, "Votre message personnalisé ici");
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
