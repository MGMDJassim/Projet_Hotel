package Vue;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class BottonRendu extends JButton implements TableCellRenderer {
    public BottonRendu() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object valeur, boolean estSelectionne, boolean aLeFocus, int ligne, int colonne) {
        if (valeur == null) {
            setText("Supprimer");
        } else {
            setText(valeur.toString());
        }
        return this;
    }
}
