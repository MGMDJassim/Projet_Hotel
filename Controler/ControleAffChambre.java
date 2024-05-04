package Controler;

import Vue.Fenetre;
import Vue.VueAffChambre;

import Model.Chambre;
import Model.Hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class ControleAffChambre implements ActionListener {
    Hotel hotel;
    Vector<Chambre> listechambre;
    Fenetre fenetre;


    public ControleAffChambre(Hotel hotel, Fenetre fenetre) {  
        //TODO Auto-generated constructor stub
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.listechambre = hotel.getListechambre();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VueAffChambre vue = new VueAffChambre(hotel);
        fenetre.setContentPane(vue); // Utilisation directe du JPanel dans la fenêtre
        fenetre.revalidate();
        fenetre.repaint();
    }
    
    
}
