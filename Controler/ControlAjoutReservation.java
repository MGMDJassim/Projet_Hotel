package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Model.Chambre;
import Model.Client;
import Model.Hotel;
import Model.Reservation;

public class ControlAjoutReservation implements ActionListener {

    private Hotel hotel;
    private JTextField ddebut;
    private JTextField dfin;
    private JTextField nom;
    private JTextField prenom;
    private JTextField date;
    private JTextField tel;
    private JTable table;
    private Chambre chambre;

    public ControlAjoutReservation(Hotel hotel, JTextField ddebut, JTextField dfin, JTextField nom, JTextField prenom, JTextField date, JTextField tel, JTable table, Chambre chambre) {
        this.hotel = hotel;
        this.ddebut = ddebut;
        this.dfin = dfin;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.tel = tel;
        this.table = table;
        this.chambre = chambre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ddebut.getText().isEmpty() && !dfin.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty() && !date.getText().isEmpty() && !tel.getText().isEmpty()) {
            if (chambre == null) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner une chambre avant d'ajouter une réservation.");
                return;
            }
            LocalDate dn = LocalDate.parse(date.getText());
            int t = Integer.parseInt(tel.getText());
            Client client = new Client(nom.getText(), prenom.getText(), dn, t, hotel);
            Reservation reservation = new Reservation(LocalDate.parse(ddebut.getText()), LocalDate.parse(dfin.getText()), chambre, client);
            reservation.addClient(client);
            chambre.addReservation(reservation);
            reservation.addChambre(chambre);
            hotel.addReservation(reservation);
            //System.out.println("Reservation ajoutée");
            //System.out.println(reservation.toString());
        }
    }
}
