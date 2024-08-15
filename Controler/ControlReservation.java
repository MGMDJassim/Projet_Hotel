package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Hotel;
import Vue.Fenetre;
import Vue.VueReservation;

public class ControlReservation implements ActionListener{
    Hotel hotel;
    Fenetre fenetre;

    public ControlReservation(Hotel hotel, Fenetre fenetre) {
        
        this.hotel = hotel;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Afficher les reservations");
        VueReservation vue = new VueReservation(hotel, fenetre);
        
        fenetre.setContentPane(vue);
        fenetre.revalidate();
        fenetre.repaint();
    }
    
}
