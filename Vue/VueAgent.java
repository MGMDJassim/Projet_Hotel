package Vue;

import java.awt.BorderLayout;
import java.util.Vector;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.AgentEntretien;
import Model.Employe;
import Model.Hotel;
import Model.Receptionniste;

public class VueAgent extends JPanel {
    Hotel hotel;
    Fenetre fenetre;

    public JTable table;
    public Vector<String> nomColonne;
    private Vector<Vector<Object>> donnees;
    private DefaultTableModel model;


        public VueAgent(Hotel hotel, Fenetre fenetre) {
        super(new BorderLayout());
        this.hotel = hotel;
        this.fenetre = fenetre;
    
        nomColonne = new Vector<>();
        donnees = new Vector<>();
    
        nomColonne.add("Nom");
        nomColonne.add("ID");
        nomColonne.add("Rôle");
        nomColonne.add("Tâche");
    
        for (Employe agent : hotel.getListeEmployes()) {
            Vector<Object> ligne = new Vector<>();
            ligne.add(agent.getNomEmploye());
            ligne.add(agent.getIdEmploye());
    
            // Déterminer le rôle de l'employé
            if (agent instanceof Receptionniste) {
                ligne.add("Receptionniste");
            } else if (agent instanceof AgentEntretien) {
                ligne.add("Agent d'entretien");
            } else {
                ligne.add("Employé");
            }
            ligne.add("Tache");
    
            donnees.add(ligne);
        }
    
        model = new DefaultTableModel(donnees, nomColonne);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
