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
    private Hotel hotel;
    private JButton boutton;
    JTable table;
    private Sejour sejour;
    int ligne;

    public ButtonConsulSejour(JCheckBox checkBox, Hotel hotel, Sejour sejour) {
        super(checkBox);
        this.hotel = hotel;
        this.sejour = sejour;
        this.boutton = new JButton();
        this.boutton.setOpaque(true);
        this.boutton.addActionListener(new ButtonActionListener());
    }
    public Component getTableCellEditorComponent(JTable table, Object valeur, boolean estSelectionne, int ligne, int column) {
        this.table = table;
        this.ligne = ligne;
        boutton.setText(valeur.toString());
        return boutton;
    }
    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new VueAffConsulSejour(hotel, sejour);
        }
    }
}