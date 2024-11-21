package Vue;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.AgentEntretien;
import Model.Chambre;
import Model.Employe;
import Model.Hotel;
import Controler.ControlAffecMenage;


public class VueGestionMenage extends JPanel {
    Hotel hotel;
    JLabel lblAgent = new JLabel("Affecter un agent d'entretien : ");
    JButton boutonAffecter = new JButton("Affecter");
    JComboBox<Integer> cmbEmploye = new JComboBox<Integer>();
    private JTable table;
    public Vector<String> nomColonne;
    public Vector<Vector<Object>> donnees;
    JPanel panel;
    JPanel panel2;

    public VueGestionMenage(Hotel hotel) {
        super(new BorderLayout());
        this.hotel = hotel;

        this.nomColonne = new Vector<String>();
        this.donnees = new Vector<Vector<Object>>();

        nomColonne.add("n° Chambre");
        nomColonne.add("Etage");
        nomColonne.add("Sélectionner");

        for (Chambre chambre : hotel.chambreSale(LocalDate.now())) {
            Vector<Object> row = new Vector<Object>();
            row.add(chambre.getNumeroPorte());
            row.add(chambre.getEtage());
            row.add(Boolean.FALSE);
            donnees.add(row);
        }
        panel = new JPanel(new FlowLayout());
        panel.add(lblAgent);
        panel.add(cmbEmploye);
        panel.add(boutonAffecter);
        add(panel, BorderLayout.NORTH);

        for (Employe employe : hotel.getListeEmployes()) {
            if (employe instanceof AgentEntretien) {
                cmbEmploye.addItem(employe.getNumEmploye());
            }
        }
        DefaultTableModel model = new DefaultTableModel(donnees, nomColonne) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) { 
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        table = new JTable(model);
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        ControlAffecMenage controlAffecMenage = new ControlAffecMenage(hotel, table, cmbEmploye);
        boutonAffecter.addActionListener(controlAffecMenage);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
