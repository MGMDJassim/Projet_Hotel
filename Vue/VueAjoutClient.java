package Vue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import Controler.ControleAjoutClient;
import Model.Hotel;

public class VueAjoutClient extends JPanel{
    Hotel hotel;
    Fenetre fenetre;

    JLabel nom = new JLabel("Nom du client");
    JTextField nomClient = new JTextField(20);

    JLabel prenom = new JLabel("Prenom du client");
    JTextField prenomClient = new JTextField(20);

    JLabel dateDeNaissance = new JLabel("Date de naissance");
    JTextField dateDeNaissanceClient = new JTextField(20);

    JLabel tel = new JLabel("Numero de telephone");
    JTextField telClient = new JTextField(20);

    JButton ajoutClient = new JButton("Ajouter");

    public VueAjoutClient(Hotel hotel, Fenetre fenetre){
        super(new BorderLayout());
        setLayout(null);

        this.hotel = hotel;
        this.fenetre = fenetre;

        add(nom);
        nom.setBounds(10, 10, 200, 20);

        add(nomClient);
        nomClient.setBounds(220, 10, 200, 20);

        add(prenom);
        prenom.setBounds(10, 40, 200, 20);

        add(prenomClient);
        prenomClient.setBounds(220, 40, 200, 20);

        add(dateDeNaissance);
        dateDeNaissance.setBounds(10, 70, 200, 20);

        add(dateDeNaissanceClient);
        dateDeNaissanceClient.setBounds(220, 70, 200, 20);

        add(tel);
        tel.setBounds(10, 100, 200, 20);

        add(telClient);
        telClient.setBounds(220, 100, 200, 20);

        add(ajoutClient);
        ajoutClient.setBounds(220, 130, 200, 20);

        ControleAjoutClient controleAjoutClient = new ControleAjoutClient(nomClient, prenomClient, dateDeNaissanceClient, telClient, hotel, fenetre);
    }
    }
    

