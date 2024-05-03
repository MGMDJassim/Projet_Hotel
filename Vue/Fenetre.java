package Vue;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;
import Model.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;


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

    
    JPanel currentPanel = new JPanel();


    public Fenetre(){

        this.setJMenuBar(barre);

        


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        barre.add(gchambre);
        barre.add(gclient);
        barre.add(greservation);

        gchambre.add(ajouterchambre);
        gchambre.add(supprimerchambre);
        
        gclient.add(ajouterclient);
        gclient.add(supprimerclient);

        greservation.add(ajouterreservation);
        greservation.add(supprimerreservation);

        ajouterchambre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                affAjoutChambre();
            }
        });

        this.pack();
        this.show();
        this.setSize(500, 500);
        this.setVisible(true);

    }

    public void affAjoutChambre(){
        VueAjout vue = new VueAjout();
        replaceContentPane(vue);
    }

    private void replaceContentPane(JPanel panel){
        getContentPane().remove(currentPanel);
        currentPanel = panel;
        getContentPane().add(currentPanel);
        revalidate();
        repaint();
    }
}




