package Vue;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Consommation;
import Model.Hotel;
import Model.Sejour;

public class VueAffConsulSejour extends JFrame {
    Hotel hotel;
    Sejour sejour;

    public VueAffConsulSejour (Hotel hotel, Sejour sejour){
        this.hotel = hotel;
        this.sejour = sejour;
         Vector<String> columnNames = new Vector<String>();
        columnNames.add("Nom du produit");
        columnNames.add("Prix du produit");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for (Consommation consommation : sejour.getConsommation()) {
            Vector<Object> row = new Vector<Object>();
            row.add(consommation.getProduit().getNom());
            row.add(consommation.calculerPrix() + "€");
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        this.pack();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null); // Centre la fenêtre
        this.setVisible(true);
    }
}
