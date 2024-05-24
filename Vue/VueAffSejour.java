package Vue;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controler.ButtonConsulSejour;
import Model.Hotel;
import Vue.Fenetre;
import Model.Sejour;


public class VueAffSejour extends JPanel{
    private Hotel hotel;
    private Fenetre fenetre;
    public Vector<String> nomColonne;
    public Vector<Vector<Object>> data;
    private JTable table;

    public VueAffSejour(Hotel hotel, Fenetre fenetre){
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.nomColonne = new Vector<String>();
        this.data = new Vector<Vector<Object>>();

        nomColonne.add("numéro de séjour ");
        nomColonne.add("n° de réservation");
        nomColonne.add("date de début");
        nomColonne.add("date de fin");
        nomColonne.add("Consulter");

        for(Sejour sejour : hotel.listSejour){
            Vector<Object> row = new Vector<Object>();
            row.add(sejour.numSejour());
            row.add(sejour.getReservation().getNumRes());
            row.add(sejour.getDateDebut());
            row.add(sejour.getDateFin());
            row.add("Consulter");
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data,nomColonne);
        table = new JTable(model);
        table.getColumn("Consulter").setCellRenderer(new BottonRendu());
        table.getColumn("Consulter").setCellEditor(new ButtonConsulSejour(new JCheckBox(), hotel));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
