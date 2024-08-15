package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Model.Chambre;
import Model.Client;
import Model.Consommation;
import Model.Hotel;
import Model.Produit;
import Model.Receptionniste;
import Model.Reservation;
import Model.Sejour;
import Vue.Fenetre;

public class ControlAjoutReservation implements ActionListener {

    private Hotel hotel;
    private Receptionniste receptionniste;
    private JTextField ddebut;
    private JTextField dfin;
    private JTextField nom;
    private JTextField prenom;
    private JTextField date;
    private JTextField tel;
    private Chambre chambre;
    private Fenetre fenetre;
    private JCheckBox[] produits;
    private JComboBox<Integer>[] quantites;

    public ControlAjoutReservation(Hotel hotel, JTextField ddebut, JTextField dfin, JTextField nom, JTextField prenom, JTextField date, JTextField tel, Chambre chambre, Fenetre fenetre, JCheckBox[] produits, JComboBox<Integer>[] quantites, Receptionniste receptionniste) {
        this.hotel = hotel;
        this.receptionniste = receptionniste;
        this.ddebut = ddebut;
        this.dfin = dfin;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.tel = tel;
        this.chambre = chambre;
        this.fenetre = fenetre;
        this.produits = produits;
        this.quantites = quantites;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ddebut.getText().isEmpty() && !dfin.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty() && !date.getText().isEmpty() && !tel.getText().isEmpty()) {
            if (chambre == null) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner une chambre avant d'ajouter une réservation.");
                return;
            }
            LocalDate dn = LocalDate.parse(date.getText());
            if(dn.isAfter(LocalDate.now().minusYears(18))) {
                JOptionPane.showMessageDialog(null, "Le client doit être majeur pour effectuer une réservation.");
                return;
            }
            int t = Integer.parseInt(tel.getText());
            Client client = new Client(nom.getText(), prenom.getText(), dn, t, hotel);
            Reservation reservation = new Reservation(LocalDate.parse(ddebut.getText()), LocalDate.parse(dfin.getText()), chambre, client, receptionniste);
            Sejour sejour = new Sejour(reservation);
            Consommation consommation;
            for (int i = 0; i < produits.length; i++) {
                System.out.println(produits[i].isSelected() + " " + quantites[i].getSelectedItem());
                if (produits[i].isSelected() && (Integer)quantites[i].getSelectedItem() > 0) {
                    Produit produit = hotel.getProduitParNom(produits[i].getText());
                    int quantite = (Integer)quantites[i].getSelectedItem();
                    if (produit != null) {
                        consommation = new Consommation(produit, quantite,sejour);
                        sejour.ajouterConsommation(consommation);
                        hotel.ajouterConsommation(consommation);
           
                    }
                }
            }
            reservation.ajouterSejour(sejour);
            hotel.ajouterSejour(sejour);
            reservation.ajouterClient(client);
            chambre.ajouterReservation(reservation);
            reservation.ajouterChambre(chambre);
            hotel.ajouterReservation(reservation);
            fenetre.revalidate();
            fenetre.repaint();
        }
    }
}
