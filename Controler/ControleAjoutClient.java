package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;

import Model.Client;
import Model.Hotel;
import Vue.Fenetre;


public class ControleAjoutClient implements ActionListener {
    private JTextField nomClient;
    private JTextField prenomClient;
    private JTextField dateDeNaissanceClient;
    private JTextField telClient;
    private Hotel hotel;
    public Fenetre fenetre;
    public ControleAjoutClient(JTextField nomClient, JTextField prenomClient, JTextField dateDeNaissanceClient,
            JTextField telClient, Hotel hotel, Fenetre fenetre) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateDeNaissanceClient = dateDeNaissanceClient;
        this.telClient = telClient;
        this.hotel = hotel;
        this.fenetre = fenetre;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!nomClient.getText().isEmpty() && !prenomClient.getText().isEmpty() && !dateDeNaissanceClient.getText().isEmpty()
                && !telClient.getText().isEmpty()) {
            LocalDate date = LocalDate.parse(dateDeNaissanceClient.getText());
            Integer tel = Integer.parseInt(telClient.getText());
            Client  client = new Client(nomClient.getText(), prenomClient.getText(), date, tel, hotel);
            hotel.ajouterClient(client);
        }
    }
    
}
