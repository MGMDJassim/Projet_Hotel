package Controler;

import Model.Chambre;
import Model.Hotel;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vue.Fenetre;
import Model.Presidentiel;
import Model.Normale;


public class ControlAjout implements ActionListener {
    Chambre chambre;
    Hotel hotel;
    Fenetre fenetre;
    JTextField numChambre;
    String[] typeChambre;
    JTextField numEtag;
    public ControlAjout(JTextField numChambre, String[] type, JTextField numEtag2,Hotel h, Fenetre fenetre) {
        
        this.numChambre = numChambre;
        this.typeChambre = type;
        this.numEtag = numEtag2;
        this.hotel = h;
        this.fenetre = fenetre;

    }
	@Override
    public void actionPerformed(ActionEvent e) {
    
        if (typeChambre[0].equals("Normale")) {
            chambre = new Normale(Integer.parseInt(numEtag.getText()), hotel, typeChambre[0], true);
        } else {
            chambre = new Presidentiel(Integer.parseInt(numEtag.getText()), hotel, typeChambre[0], true);
        hotel.addChambre(chambre);
        new Vue.VueAjout(hotel, fenetre);
        System.out.println("Ajouter une chambre");
        
    }
    
}
}
