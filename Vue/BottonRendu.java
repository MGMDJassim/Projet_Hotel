package Vue;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BottonRendu extends JButton implements TableCellRenderer{
    public BottonRendu(){
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        if (value == null) {
            setText("Supprimer");
        } else {
            setText(value.toString());
        }
        return this;
    }
}

