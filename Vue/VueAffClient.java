package Vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Client;
import Model.Hotel;

public class VueAffClient extends JPanel {
    Hotel hotel;
    Fenetre fenetre;

    Vector<String> nomColonne;
    Vector<Vector<Object>> data;
    JTextField nomClient;
    JLabel nom = new JLabel("Nom du client : ");

    public VueAffClient(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;

        this.nomColonne = new Vector<String>();
        this.data = new Vector<Vector<Object>>();

        this.nomColonne.add("Nom");
        this.nomColonne.add("Prenom");
        this.nomColonne.add("Date de naissance");
        this.nomColonne.add("Telephone");
        this.nomColonne.add("Supprimer");

        for (Client client : hotel.listClient) {
            Vector<Object> row = new Vector<Object>();
            row.add(client.getNomClient());
            row.add(client.getPrenomClient());
            row.add(client.getDateDeNaissance());
            row.add(client.getTelClient());
            row.add("Supprimer");

            this.data.add(row);
        }

        nomClient = new JTextField(20);

        JButton button = new JButton("Rechercher");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(nom);
        panel.add(nomClient);
        panel.add(button);

        add(panel, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(data, nomColonne);
        JTable table = new JTable(model);
        table.getColumn("Supprimer").setCellRenderer(new BottonRendu());
        //table.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox(), hotel, fenetre));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
