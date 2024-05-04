package Vue;
import java.awt.event.ActionListener;

import Model.*;

import Controler.ControleAffChambre;
import java.awt.event.ActionEvent;

import Controler.ControlAjout;
import Controler.ControlReservation;

import javax.swing.*;


public class Fenetre extends JFrame{
    JMenuBar barre = new JMenuBar();  

    JMenu gchambre = new JMenu("Gestion des chambres");
    JMenu gclient = new JMenu("Gestion des clients");
    JMenu greservation = new JMenu("Gestion des reservations");

    JMenuItem ajouterchambre = new JMenuItem("Ajouter une chambre");
    JMenuItem supprimerchambre = new JMenuItem("Supprimer une chambre");
    JMenuItem afficherChambre = new JMenuItem("Afficher les chambres");

    JMenuItem ajouterclient = new JMenuItem("Ajouter un client");
    JMenuItem supprimerclient = new JMenuItem("Supprimer un client");

    JMenuItem affReservations = new JMenuItem("Afficher les reservations");

    
    JPanel currentPanel = new JPanel();
    Hotel hotel;

    public Fenetre(Hotel h){
        hotel = h;

        this.setJMenuBar(barre);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        barre.add(gchambre);
        barre.add(gclient);
        barre.add(greservation);

        gchambre.add(ajouterchambre);
        gchambre.add(supprimerchambre);
        gchambre.add(afficherChambre);
        
        gclient.add(ajouterclient);
        gclient.add(supprimerclient);

        greservation.add(affReservations);

        ajouterchambre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAjout vue = new VueAjout(hotel, Fenetre.this);
                getContentPane().remove(currentPanel);
                currentPanel = vue;
                getContentPane().add(currentPanel);
                revalidate();
                repaint();
        
            }
        });
        afficherChambre.addActionListener(new ControleAffChambre(hotel, this));
        affReservations.addActionListener(new ControlReservation(hotel, this));
   

        this.pack();
        this.setSize(500, 500);
        this.setVisible(true);

    }

    public void setContentPane(JPanel panel){
        getContentPane().remove(currentPanel);
        currentPanel = panel;
        getContentPane().add(currentPanel);
        revalidate();
        repaint();
    }

}




