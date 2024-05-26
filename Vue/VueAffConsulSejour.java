package Vue;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Model.Consommation;
import Model.Hotel;
import Model.Sejour;
public class VueAffConsulSejour extends JFrame {
    Hotel hotel;
    Sejour sejour;

    JPanel panel;
    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;

    public VueAffConsulSejour(Hotel hotel, Sejour sejour) {
        this.hotel = hotel;
        this.sejour = sejour;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Nom du produit");
        columnNames.add("Prix du produit");
        columnNames.add("Quantité");
        columnNames.add("Prix total");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for (Consommation consommation : sejour.getConsommations()) {
            Vector<Object> row = new Vector<Object>();
            row.add(consommation.getProduit().getNom());
            row.add(consommation.getProduit().getPrix() + "€");
            row.add(consommation.getQuantite());
            row.add(consommation.calculerPrix() + "€");
            data.add(row);
        }

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(300, 100));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        label2 = new JLabel("Nom du client: " + sejour.getReservation().getClient().getNomClient());
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentY(Component.CENTER_ALIGNMENT);
        label2.setBorder(new EmptyBorder(10, 10, 10, 10));

        label3 = new JLabel("Prénom du client: " + sejour.getReservation().getClient().getPrenomClient());
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setAlignmentY(Component.CENTER_ALIGNMENT);
        label3.setBorder(new EmptyBorder(10, 10, 10, 10));

        label4 = new JLabel("Numéro de la chambre: " + sejour.getReservation().getChambre().getNumeroPorte());
        label4.setAlignmentX(Component.CENTER_ALIGNMENT);
        label4.setAlignmentY(Component.CENTER_ALIGNMENT);
        label4.setBorder(new EmptyBorder(10, 10, 10, 10));

        label5 = new JLabel("Prix de la réservation: " + sejour.getReservation().calculerPrix() + "€");
        label5.setAlignmentX(Component.CENTER_ALIGNMENT);
        label5.setAlignmentY(Component.CENTER_ALIGNMENT);
        label5.setBorder(new EmptyBorder(10, 10, 10, 10));

        label6 = new JLabel("Prix total des Consommations : " + sejour.calculerPrixConsommations() + "€");
        label6.setAlignmentX(Component.CENTER_ALIGNMENT);
        label6.setAlignmentY(Component.CENTER_ALIGNMENT);
        label6.setBorder(new EmptyBorder(10, 10, 10, 10));

        label = new JLabel("Prix total : " + sejour.calculerPrix() + "€");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label);

        add(panel, BorderLayout.WEST);

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        this.pack();
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
