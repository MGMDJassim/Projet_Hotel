package Vue;
import java.awt.BorderLayout;
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
    Hotel hotel;
    Fenetre fenetre;
    public Vector<String> nomColonne;
    public Vector<Vector<Object>> donnees;
    private JTable table;

    public VueAffSejour(Hotel hotel, Fenetre fenetre){
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.nomColonne = new Vector<String>();
        this.donnees = new Vector<Vector<Object>>();
        nomColonne.add("numéro de séjour ");
        nomColonne.add("n° de réservation");
        nomColonne.add("date de début");
        nomColonne.add("date de fin");
        nomColonne.add("Autres");

        for(Sejour sejour : hotel.getListeSejour()){
            Vector<Object> ligne = new Vector<Object>();
            ligne.add(sejour.numeroSejour());
            ligne.add(sejour.getReservation().getNumRes());
            ligne.add(sejour.getDateDebut());
            ligne.add(sejour.getDateFin());
            ligne.add("Autres");
            donnees.add(ligne);
        }
        DefaultTableModel model = new DefaultTableModel(donnees, nomColonne);
        table = new JTable(model);
        table.getColumn("Autres").setCellRenderer(new ButtonRenderer());
        for(int i = 0; i < table.getRowCount(); i++) {
            Sejour sejour = hotel.listeSejour.get(i);
            table.getColumn("Autres").setCellEditor(new ButtonConsulSejour(new JCheckBox(), hotel, sejour));
        }
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
