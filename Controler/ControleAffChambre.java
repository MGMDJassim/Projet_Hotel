package Controler;

import Vue.Fenetre;
import Vue.VueAffChambre;
import Model.Hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControleAffChambre implements ActionListener {
    Hotel hotel;
    Fenetre fenetre;


    public ControleAffChambre(Hotel hotel, Fenetre fenetre) {  
        this.hotel = hotel;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VueAffChambre vue = new VueAffChambre(hotel, fenetre);
        fenetre.setContentPane(vue);
        fenetre.revalidate();
        fenetre.repaint();
    }
}