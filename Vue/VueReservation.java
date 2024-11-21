package Vue;
import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import Model.Chambre;
import Model.Hotel;
public class VueReservation extends JPanel {
    Hotel hotel;
    Vector<String> nomColonne;
    Vector<Vector<Object>> donnees;

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
        donnees = new Vector<Vector<Object>>();
        DefaultTableModel model = new DefaultTableModel(donnees, nomColonne);
        JTable table = new JTable(model);
        for (int i = 0; i < hotel.listeReservation.size(); i++) {
            Vector<Object> ligne= new Vector<Object>();
            ligne.add(hotel.listeReservation.get(i).getNumRes());
            ligne.add(hotel.listeReservation.get(i).getClient().getNomClient());
            ligne.add(hotel.listeReservation.get(i).getClient().getPrenomClient());

            Chambre chambre = hotel.listeReservation.get(i).getChambre();
            if (chambre != null) {
                ligne.add(hotel.listeReservation.get(i).getChambre().getNumeroPorte());
                ligne.add(hotel.listeReservation.get(i).getChambre().getClass().getSimpleName());
                ligne.add(hotel.listeReservation.get(i).getChambre().getEtage());
            }
            ligne.add(hotel.listeReservation.get(i).getDateDebut());
            ligne.add(hotel.listeReservation.get(i).getDateFin());
            ligne.add("Supprimer");
            donnees.add(ligne);

            table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
            table.getColumn("Supprimer").setCellEditor(new Controler.BouttonEditeurRes(new JCheckBox(), hotel, fenetre));
        }
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
