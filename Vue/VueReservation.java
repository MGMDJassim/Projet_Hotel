package Vue;


import java.awt.BorderLayout;
import java.util.Vector;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Hotel;

public class VueReservation extends JPanel {
    Hotel hotel;
    Vector<String> nomColonne;
    Vector<Vector<Object>> data;

    public VueReservation(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;

        nomColonne = new Vector<String>();
        nomColonne.add("Nom du client");
        nomColonne.add("Numéro de la chambre");
        nomColonne.add("Type de chambre");
        nomColonne.add("Numéro de l'étage");
        nomColonne.add("Date de début");
        nomColonne.add("Date de fin");
        
        data = new Vector<Vector<Object>>();

        for (int i = 0; i < hotel.listReservation.size(); i++) {
            Vector<Object> row = new Vector<Object>();
            row.add(hotel.listReservation.get(i).getClient().getNomClient());
            row.add(hotel.listReservation.get(i).getChambre().getNumeroPorte());
            row.add(hotel.listReservation.get(i).getChambre().getType());
            row.add(hotel.listReservation.get(i).getChambre().getEtage());
            row.add(hotel.listReservation.get(i).getDateDebut());
            row.add(hotel.listReservation.get(i).getDateFin());
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, nomColonne);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
        

    }

    
}
