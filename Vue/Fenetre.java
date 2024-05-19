package Vue;
import java.awt.event.ActionListener;


import Model.*;

import Controler.ControleAffChambre;
import java.awt.event.ActionEvent;


import Controler.ControlReservation;

import javax.swing.*;
// Import the TableModel class


public class Fenetre extends JFrame{
    JMenuBar barre = new JMenuBar();  

    JMenu gchambre = new JMenu("Gestion des chambres");

    JMenu greservation = new JMenu("Gestion des reservations");
    JMenu gemploye = new JMenu("Gestion des employes");
    JMenu gmenage = new JMenu("Gestion du menage");

    JMenuItem ajouterchambre = new JMenuItem("Ajouter une chambre");
    JMenuItem afficherChambre = new JMenuItem("Afficher les chambres");

    JMenuItem affReservations = new JMenuItem("Afficher les reservations");
    JMenuItem ajouterReservation = new JMenuItem("Ajouter une reservation");

    
    JMenuItem ajouterEmploye = new JMenuItem("Ajouter un employe");
    JMenuItem supprimerEmploye = new JMenuItem("Supprimer un employe");
    JMenuItem afficherEmploye = new JMenuItem("Afficher les employes");

    
    JMenuItem ajouterMenage = new JMenuItem("Ajouter une tache de menage");
    JMenuItem supprimerMenage = new JMenuItem("Supprimer une tache de menage");
    JMenuItem afficherMenage = new JMenuItem("Afficher les taches de menage");
    
    JPanel currentPanel = new JPanel();
    Hotel hotel;
    Chambre chambre;

    public Fenetre(Hotel h){
        hotel = h;
        this.setJMenuBar(barre);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        barre.add(gchambre);
        barre.add(greservation);
        barre.add(gemploye);
        barre.add(gmenage);


        gchambre.add(ajouterchambre);
        gchambre.add(afficherChambre);

        greservation.add(affReservations);
        greservation.add(ajouterReservation);

        gemploye.add(ajouterEmploye);
        gemploye.add(supprimerEmploye);
        gemploye.add(afficherEmploye);


        gmenage.add(ajouterMenage);
        gmenage.add(supprimerMenage);
        gmenage.add(afficherMenage);


        ajouterchambre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAjout vue = new VueAjout(hotel, Fenetre.this);
                setContentPane(vue);
            }
        });
        afficherChambre.addActionListener(new ControleAffChambre(hotel, this));

        ajouterReservation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAjoutReservation vue = new VueAjoutReservation(hotel, Fenetre.this, chambre);
                setContentPane(vue);
            }
        });

        affReservations.addActionListener(new ControlReservation(hotel, this));
    
        this.pack();
        this.setSize(1000, 500);
        this.setVisible(true);

    }

    public void setContentPane(JPanel panel) {
        getContentPane().remove(currentPanel);
        currentPanel = panel;
        getContentPane().add(currentPanel);
        revalidate();
        repaint();
    }
}





