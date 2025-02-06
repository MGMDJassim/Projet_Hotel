package Vue;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Hotel;

public class VueAffEmploye extends JPanel{
    Hotel hotel;
    Fenetre fenetre;

    Vector<String> columnNames = new Vector<String>();
    Vector<Vector<Object>> data;
    public VueAffEmploye(Hotel hotel, Fenetre fenetre){
        this.hotel = hotel;
        this.fenetre = fenetre;

        columnNames.add("Nom");
        columnNames.add("Prenom");
        columnNames.add("Poste");

        data = new Vector<Vector<Object>>();
        for (int i = 0; i < hotel.getListeEmployes().size(); i++) {
            Vector<Object> row = new Vector<Object>();
            row.add(hotel.getListeEmployes().get(i).getNomEmploye());
            row.add(hotel.getListeEmployes().get(i).getPrenomEmploye());
            row.add(hotel.getListeEmployes().get(i).getPoste());
            data.add(row);
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }
}
