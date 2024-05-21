package Vue;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Chambre;
import Model.Hotel;
import Model.Presidentiel;
import Model.Normale;

public class VueReservation extends JPanel {
    Hotel hotel;
    Vector<String> nomColonne;
    Vector<Vector<Object>> data;

    public VueReservation(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;

        nomColonne = new Vector<String>();
        nomColonne.add("N°");
        nomColonne.add("Nom du client");
        nomColonne.add("Prénom du client");
        nomColonne.add("Numéro de la chambre");
        nomColonne.add("Type de chambre");
        nomColonne.add("Numéro de l'étage");
        nomColonne.add("Date de début");
        nomColonne.add("Date de fin");
        nomColonne.add("Supprimer");

        data = new Vector<Vector<Object>>();

        DefaultTableModel model = new DefaultTableModel(data, nomColonne);
        JTable table = new JTable(model);

        for (int i = 0; i < hotel.listReservation.size(); i++) {
            Vector<Object> row = new Vector<Object>();
            row.add(hotel.listReservation.get(i).getNumRes());
            row.add(hotel.listReservation.get(i).getClient().getNomClient());
            row.add(hotel.listReservation.get(i).getClient().getPrenomClient());

             Chambre chambre = hotel.listReservation.get(i).getChambre();
            
            // Vérifiez si la chambre n'est pas null
            if (hotel.listReservation.get(i).getChambre() != null) {
                row.add(hotel.listReservation.get(i).getChambre().getNumeroPorte());
                row.add(hotel.listReservation.get(i).getChambre().getType());
                row.add(hotel.listReservation.get(i).getChambre().getEtage());
            } else {
                row.add("N/A");  // ou une autre valeur par défaut appropriée
                row.add("N/A");
                row.add("N/A");
            }
            
            row.add(hotel.listReservation.get(i).getDateDebut());
            row.add(hotel.listReservation.get(i).getDateFin());
            row.add("Supprimer");
            data.add(row);

            table.getColumn("Supprimer").setCellRenderer(new BottonRendu());
            table.getColumn("Supprimer").setCellEditor(new Controler.BouttonEditeurRes(new javax.swing.JCheckBox(), hotel, fenetre, hotel.listReservation.get(0)));
        }


        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
    }
}
