package Controler;

import Model.Chambre;
import Model.Hotel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlAjout implements ActionListener {
    Chambre chambre;
    Hotel hotel;

    JTextField numChambre;
    JTextField typeChambre;

    JTextField numEtag;



    public ControlAjout(JTextField numChambre, JTextField numP, JTextField numEtag,Hotel h) {
        //TODO Auto-generated constructor stub
        this.numChambre = numChambre;
        this.typeChambre = numP;
        this.numEtag = numEtag;
        this.hotel = h;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        chambre = new Chambre(Integer.parseInt(numEtag.getText()), Integer.parseInt(numChambre.getText()), typeChambre.getText(), hotel);
        hotel.addChambre(chambre);
        
    }
    
}
