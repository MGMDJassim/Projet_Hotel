package Vue;

import javax.swing.*;

import Controler.ControleClient;

public class Fenetre extends JFrame{
    JMenuBar barre = new JMenuBar();  

    JMenu gchambre = new JMenu("Gestion des chambres");
    JMenu gclient = new JMenu("Gestion des clients");
    JMenu greservation = new JMenu("Gestion des reservations");

    JMenuItem ajouterchambre = new JMenuItem("Ajouter une chambre");
    JMenuItem supprimerchambre = new JMenuItem("Supprimer une chambre");

    JMenuItem ajouterclient = new JMenuItem("Ajouter un client");
    JMenuItem supprimerclient = new JMenuItem("Supprimer un client");

    JMenuItem ajouterreservation = new JMenuItem("Ajouter une reservation");
    JMenuItem supprimerreservation = new JMenuItem("Supprimer une reservation");



    public Fenetre(){

        this.setJMenuBar(barre);

        barre.add(gchambre);
        barre.add(gclient);
        barre.add(greservation);

        gchambre.add(ajouterchambre);
        gchambre.add(supprimerchambre);
        
        gclient.add(ajouterclient);
        gclient.add(supprimerclient);

        greservation.add(ajouterreservation);
        greservation.add(supprimerreservation);

      
        this.setTitle("Gestion d'hotel");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    

}
