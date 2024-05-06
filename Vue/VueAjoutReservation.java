package Vue;

import javax.swing.*;

import Controler.ControlAjoutReservation;
import Model.Hotel;


public class VueAjoutReservation extends JPanel {

    Hotel hotel;
    Fenetre fenetre;

    
    JLabel nom = new JLabel("Nom du client");
    JTextField nomClient = new JTextField(20);

    JLabel numPorte = new JLabel("Numero de la porte");
    JTextField numP = new JTextField(20);

    JLabel typeChambre = new JLabel("Type de la chambre");
    JComboBox<String> type = new JComboBox<String>();

    JLabel label4 = new JLabel("Numero de l'etage");
    JTextField numEtag = new JTextField(20);

    JLabel label5 = new JLabel("Date de debut");
    

    JButton   ajoutButton = new JButton("Ajouter");




    public VueAjoutReservation(Hotel hotel, Fenetre fenetre){
        this.hotel = hotel;
        this.fenetre = fenetre;
        
        setLayout(null);


        add(nom);
        add(nomClient);

        nom.setBounds(10, 10, 200, 20);
        nomClient.setBounds(200, 10, 200, 20);

        add(numPorte);
        add(numP);

        numPorte.setBounds(10, 40, 200, 20);
        numP.setBounds(200, 40, 200, 20);


        add(typeChambre);
        add(type);
        type.addItem("Simple");
        type.addItem("Double");
        type.addItem("Suite");

        typeChambre.setBounds(10, 70, 200, 20);
        type.setBounds(200, 70, 200, 20);


        add(label4);
        add(numEtag);

        label4.setBounds(10, 100, 200, 20);
        numEtag.setBounds(200, 100, 200, 20);



        add(ajoutButton);

        ajoutButton.setBounds(200, 130, 200, 20);
        

        ControlAjoutReservation controlAjout = new ControlAjoutReservation(nomClient, numP, type, hotel, fenetre);
        ajoutButton.addActionListener(controlAjout);

    }

}
