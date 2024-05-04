package Controler;

import Model.Chambre;
import Model.Hotel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vue.Fenetre;


public class ControlAjout implements ActionListener {
    Chambre chambre;
    Hotel hotel;
    Fenetre fenetre;

    JTextField numChambre;
    JTextField typeChambre;

    JTextField numEtag;



    public ControlAjout(JTextField numChambre, JTextField numP, JTextField numEtag,Hotel h, Fenetre fenetre) {
        //TODO Auto-generated constructor stub
        this.numChambre = numChambre;
        this.typeChambre = numP;
        this.numEtag = numEtag;
        this.hotel = h;
        this.fenetre = fenetre;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        chambre = new Chambre(Integer.parseInt(numEtag.getText()), Integer.parseInt(numChambre.getText()), typeChambre.getText(), hotel);
        hotel.addChambre(chambre);
        Vue.VueAjout vue = new Vue.VueAjout(hotel, fenetre);
        fenetre.setContentPane(vue); // Utilisation directe du JPanel dans la fenêtre
        fenetre.revalidate();
        fenetre.repaint();

        System.out.println("Ajouter une chambre");

        
    }
    
}
