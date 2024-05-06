package Controler;

import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Vue.Fenetre;
import Model.Hotel;
import Model.Reservation;

public class ControlAjoutReservation implements ActionListener{

    Hotel hotel;
    Fenetre fenetre;
    Reservation reservation;

    JTextField nomClient;
    JTextField type;
    LocalDate dateDebut;
    LocalDate dateFin;
    JTextField numChambre;
    JTextField numClient;



    public ControlAjoutReservation(JTextField nomClient, JTextField numP, JComboBox<String> type2 , Hotel hotel, Fenetre fenetre) {
        
        this.hotel = hotel;
        this.fenetre = fenetre;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ajouter une reservation");
        reservation = new Reservation(nomClient.getText(), numClient.getText(), numChambre.getText(), type.getText(), dateDebut, dateFin, hotel);
        hotel.addReservation(reservation);
        Vue.VueAjoutReservation vue = new Vue.VueAjoutReservation(hotel, fenetre);
    }
    
}
