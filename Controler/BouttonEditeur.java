package Controler;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Chambre;
import Model.Hotel;
import Model.Reservation;
import Vue.Fenetre;

public class BouttonEditeur extends DefaultCellEditor {
    private Hotel hotel;
    private Fenetre fenetre;
    private JButton bouton;
    private JTable table;
    private int ligne;

    public BouttonEditeur(JCheckBox checkBox, Hotel hotel, Fenetre fenetre) {
        super(checkBox);
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.bouton = new JButton();
        this.bouton.setOpaque(true);
        this.bouton.addActionListener(new BoutonActionListener());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object valeur, boolean estSelectionne, int ligne, int column) {
        this.table = table;
        this.ligne = ligne;
        if (valeur == null) {
            bouton.setText("");
        } else {
            bouton.setText(valeur.toString());
        }
        return bouton;
    }
    private class BoutonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
            if (ligne < table.getRowCount()) {
                int modeleLigne = table.convertRowIndexToModel(ligne);
                Chambre chambre = hotel.listeChambre.get(modeleLigne);
                for (Reservation r : chambre.getListeReservation()) {
                    hotel.supprimerReservation(r);
                }
                hotel.supprimerChambre(chambre);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(modeleLigne);
                fenetre.setContentPane(new Vue.VueAffChambre(hotel, fenetre));
                fenetre.revalidate();
            }
        }
    }
}