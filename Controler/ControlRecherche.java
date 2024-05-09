package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import Model.Chambre;
import Model.Hotel;

public class ControlRecherche implements ActionListener {
    private Hotel hotel;
    private JTextField Ddebut;
    private JTextField Dfin;
    private JTable table;
    private JPanel panel;

    public ControlRecherche(Hotel hotel, JTextField Ddebut, JTextField Dfin, JTable table, JPanel panel) {
        this.hotel = hotel;
        this.Ddebut = Ddebut;
        this.Dfin = Dfin;
        this.table = table;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Ddebut.getText().isEmpty() && !Dfin.getText().isEmpty()) {
            Vector<String> nomColonne = new Vector<String>();
            nomColonne.add("Numero de porte");
            nomColonne.add("Type");
            nomColonne.add("Etage");
            nomColonne.add("Selectionner");

            LocalDate debut = LocalDate.parse(Ddebut.getText());
            LocalDate fin = LocalDate.parse(Dfin.getText());
            Vector<Chambre> freeRooms = hotel.getFreeRooms(debut, fin);
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            for (Chambre room : freeRooms) {
                Vector<Object> row = new Vector<Object>();
                row.add(room.getNumeroPorte());
                row.add(room.getType());
                row.add(room.getEtage());
                row.add(new JCheckBox());
                data.add(row);
                System.out.println(room.toString());
            }

            DefaultTableModel model = new DefaultTableModel(data, nomColonne);
            table.setModel(model);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(500, 10, 400, 400);
            panel.add(scrollPane, BorderLayout.CENTER);
        }
    }
}