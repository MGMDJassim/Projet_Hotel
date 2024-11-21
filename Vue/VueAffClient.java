package Vue;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Model.Client;
import Model.Hotel;
import Controler.ButtonEditeurSuppClient;
import Controler.ControlRechercheClient;
public class VueAffClient extends JPanel {
    
    public Vector<String> nomColonne;
    public Vector<Vector<Object>> donnees;
    public JTextField nomClient;
    public JLabel nom = new JLabel("Nom du client : ");
    private JTable table;

    public VueAffClient(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.nomColonne = new Vector<String>();
        this.donnees = new Vector<Vector<Object>>();

        nomColonne.add("Nom");
        nomColonne.add("Prénom");
        nomColonne.add("Date de naissance");
        nomColonne.add("Téléphone");
        nomColonne.add("Supprimer");

        for (Client client : hotel.listeClient) {
            Vector<Object> ligne = new Vector<Object>();
            ligne.add(client.getNomClient());
            ligne.add(client.getPrenomClient());
            ligne.add(client.getDateDeNaissance());
            ligne.add(client.getTelClient());
            ligne.add("Supprimer");

            this.donnees.add(ligne);
        }
        nomClient = new JTextField(20);
        JButton bouton = new JButton("Rechercher");
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(nom);
        panel.add(nomClient);
        panel.add(bouton);
        add(panel, BorderLayout.NORTH);
        DefaultTableModel model = new DefaultTableModel(donnees, nomColonne);
        table = new JTable(model);
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditeurSuppClient(new JCheckBox(), hotel, fenetre));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        bouton.addActionListener(new ControlRechercheClient(hotel, nomClient, fenetre,this, table));
    }
}
