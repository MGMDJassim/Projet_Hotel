package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Hotel;
import Vue.Fenetre;
import Vue.VueAffClient;

public class ControlClient implements ActionListener  {

    private Hotel hotel;
    private Fenetre fenetre;
    
    public ControlClient(Hotel hotel, Fenetre fenetre) {
        this.hotel = hotel;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VueAffClient vue = new VueAffClient(hotel, fenetre);        
        fenetre.setContentPane(vue);
        fenetre.revalidate();
        fenetre.repaint();
    }
    
}
