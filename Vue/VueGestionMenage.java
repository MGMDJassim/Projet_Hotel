package Vue;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.AgentEntretien;
import Model.Chambre;
import Model.Employe;
import Model.Hotel;

public class VueGestionMenage extends JPanel{
    Hotel hotel;
    JLabel ag = new JLabel("Affecter un agent d'entretien : ");
    JButton affecButton = new JButton("Affecter");
    JComboBox <Integer> emplBox = new JComboBox<Integer>();
    private JTable table;
    public Vector<String> nomColonne;
    public Vector<Vector<Object>> data;
    JPanel panel;
    JPanel panel2;

    public VueGestionMenage(Hotel hotel){
        super(new BorderLayout());
        this.hotel=hotel;

        this.nomColonne = new Vector<String>();
        this.data = new Vector<Vector<Object>>();

        nomColonne.add("n° Chambre");
        nomColonne.add("Etage");
        nomColonne.add("Type");
        nomColonne.add("Sélectionner");

        for(Chambre chambre : hotel.chambreSalle(LocalDate.now())){
            Vector<Object> row = new Vector<Object>();
            row.add(chambre.getNumeroPorte());
            row.add(chambre.getEtage());
            row.add(chambre.getType());
            row.add(Boolean.FALSE);
            data.add(row);
        }

        panel = new JPanel(new FlowLayout());
        panel.add(ag);
        panel.add(emplBox);
        panel.add(affecButton);
        //panel.setBackground(Color.CYAN);
        add(panel, BorderLayout.NORTH);

        for (Employe employe : hotel.getListEmployes()) {
            if (employe instanceof AgentEntretien) {
            emplBox.addItem(employe.getNumEmploye());
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, nomColonne) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) { // Index de la colonne "Sélectionner"
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        

        table = new JTable(model);
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
