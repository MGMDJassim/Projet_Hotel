package Vue;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Consommation;
import Model.Produit;
import Model.Reservation;
import Model.Sejour;
import Model.Hotel;

public class VueAjoutSejour extends JPanel {
    Hotel hotel;
    Reservation reservation;
    Sejour sejour;
    Fenetre fenetre;
    Vector<Produit> produits = new Vector<Produit>();
    Consommation consommation;

    JLabel produit = new JLabel("Produit");
    JComboBox<String> listeProduits = new JComboBox<String>();

    JLabel quantite = new JLabel("QuantitÃ©");
    JComboBox<Integer> listeQuantite = new JComboBox<Integer>();

    JButton ajouter = new JButton("Ajouter");


    public VueAjoutSejour(Reservation reservation, Hotel hotel, Fenetre fenetre) {
        this.reservation = reservation;
        this.hotel = hotel;
        this.fenetre = fenetre;

      
        add(produit);
        add(listeProduits);
    
        for (Produit produit : hotel.listProduit) {
            listeProduits.addItem(produit.getNom());
        }

        add(quantite);
        add(listeQuantite);

        for (int i = 1; i <= 10; i++) {
            listeQuantite.addItem(i);
        }

        add(ajouter);

        ajouter.addActionListener(e -> {
            if (sejour == null) {
                // Initialize sejour or handle the null scenario
                sejour = new Sejour(reservation);
                // or throw an exception, log an error, etc.
            }
            Produit produit = hotel.listProduit.get(listeProduits.getSelectedIndex());
            int quantite = listeQuantite.getSelectedIndex() + 1;
            Consommation consommation = new Consommation(produit, quantite, sejour);
            sejour.addConsommation(consommation);
            hotel.listConsommation.add(consommation);
            hotel.listSejour.add(sejour);
            System.out.println("Consommation ajoutÃ©e : " + consommation.getProduit().getNom() + " " + consommation.getQuantite());
            System.out.println("Sejour ajoutÃ© : " + sejour.getConsommation());
            System.out.println("Reservation : " + sejour.getReservation().getClient().getNomClient());

        });

        setVisible(true);
    }


}
