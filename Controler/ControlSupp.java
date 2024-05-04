package Controler;



import Model.Hotel;
import Vue.VueAffChambre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlSupp implements ActionListener{
    Hotel hotel;
     VueAffChambre vueAffChambre;

    public ControlSupp(Hotel hotel, VueAffChambre vueAffChambre) {
        //TODO Auto-generated constructor stub
        this.vueAffChambre = vueAffChambre;
        this.hotel = hotel;
        
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
