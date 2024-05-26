package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.AgentEntretien;
import Model.Chambre;
import Model.Employe;
import Model.Hotel;


public class ControlAffecMenage implements ActionListener {
    Hotel hotel;
    JTable table;
    JComboBox<Integer> cmbEmploye;

    public ControlAffecMenage(Hotel hotel, JTable table, JComboBox<Integer> cmbEmploye) {
        this.hotel = hotel;

        this.table = table;
        this.cmbEmploye = cmbEmploye;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numEmploye = (int) cmbEmploye.getSelectedItem();
        AgentEntretien agentEntretien = null;
        for(Employe employe : hotel.getListeEmployes()) {
            if(employe.getNumEmploye() == numEmploye) {
                if(employe instanceof AgentEntretien) {
                    agentEntretien = (AgentEntretien) employe;
                    break;
                }
            }
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean selected = (Boolean) model.getValueAt(i, 3);
            Chambre chambre = null;
            if (selected) {
                int numChambre = (int) model.getValueAt(i, 0);
                for(Chambre c : hotel.getListeChambre()){
                    if(c.getNumeroPorte() == numChambre){
                        chambre = c;
                        break;
                    }
                }
                agentEntretien.nettoyerChambre(chambre);



            }
        }
    }
}
