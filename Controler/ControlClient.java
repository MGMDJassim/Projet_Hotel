package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Model.Client;
import Model.Hotel;
import Vue.Fenetre;
import Vue.VueAffClient;

public class ControlClient implements ActionListener  {

    Hotel hotel;
    Fenetre fenetre;
    Vector<Client> listClient;
    
    public ControlClient(Hotel hotel, Fenetre fenetre) {
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.listClient = hotel.getListClient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VueAffClient vue = new VueAffClient(hotel, fenetre);        
        fenetre.setContentPane(vue);
        fenetre.revalidate();
        fenetre.repaint();
    }
    
}
