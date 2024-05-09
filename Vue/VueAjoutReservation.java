package Vue;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Vector;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controler.ControlRecherche;
import Model.Chambre;
import Model.Hotel;

public class VueAjoutReservation extends JPanel {
    Hotel hotel;
    Fenetre fenetre;
    Chambre chambre;
    JLabel dateDebut = new JLabel("Date de debut");
    JTextField Ddebut = new JTextField();

    JLabel dateFin = new JLabel("Date de fin");
    JTextField Dfin = new JTextField();

    JButton rechercher = new JButton("Rechercher");

    JTable table = new JTable();

    LocalDate debut;
    LocalDate fin;

    Vector<String> nomColonne;
    Vector<Vector<Object>> data;
    Vector<Chambre> freeRooms ;

    public VueAjoutReservation (Hotel hotel, Fenetre fenetre, Chambre chambre){
        this.hotel = hotel;
        this.fenetre = fenetre;
        this.chambre = chambre;
        setLayout(null);

        add(dateDebut);
        add(Ddebut);

        dateDebut.setBounds(10, 10, 200, 20);
        Ddebut.setBounds(200, 10, 200, 20);

        add(dateFin);
        add(Dfin);

        dateFin.setBounds(10, 40, 200, 20);
        Dfin.setBounds(200, 40, 200, 20);

        add(rechercher);
        rechercher.setBounds(10, 70, 200, 20);

        //rechercher.addActionListener(new Controler.ControlRecherche(Ddebut, Dfin, hotel, fenetre));
        rechercher.addActionListener(new ControlRecherche(hotel, Ddebut, Dfin, table, this));

    }

        }
    

