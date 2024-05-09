package Vue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import Controler.ControlAjoutClient;
import Model.Hotel;

public class VueAjoutClient extends JPanel{

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
        setLayout(null);

        add(nom);
        nom.setBounds(10, 10, 200, 20);

        add(nomClient);
        nomClient.setBounds(200, 10, 200, 20);

        add(prenom);
        prenom.setBounds(10, 20, 200, 20);

        add(prenomClient);
        prenomClient.setBounds(200, 20, 200, 20);

        add(dateDeNaissance);
        dateDeNaissance.setBounds(10, 40, 200, 20);

        add(tel);
        tel.setBounds(10, 50, 200, 20);

        add(ajoutClient);
        ajoutClient.setBounds(200, 70, 200, 20);

        //ControlAjoutClient ajoutclient = new ControlAjoutClient(nomClient, prenomClient, dateDeNaissanceClient, telClient, hotel, fenetre);
        //ajoutClient.addActionListener(ajoutclient);

    }
    


}
