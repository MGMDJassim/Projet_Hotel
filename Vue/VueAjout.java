package Vue;

import java.awt.BorderLayout;

import Model.*;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import Controler.ControlAjout;



public class VueAjout extends JPanel{
    
    
  
    JLabel numPorte = new JLabel("Numero de la porte");
    JTextField numP = new JTextField(20);

    JLabel typeChambre = new JLabel("Type de la chambre");
    /*JTextField type = new JTextField(20);*/

    JComboBox<String> tChambre = new JComboBox<String>();
    String[] type = {"Simple", "Double", "Suite"};

    JLabel label4 = new JLabel("Numero de l'etage");
    JTextField numEtag = new JTextField(20);


    JButton ajoutButton = new JButton("Ajouter");
    Hotel hotel;
    Fenetre fenetre;
    public VueAjout(Hotel hotel, Fenetre fenetre){
        super(new BorderLayout());
        this.hotel = hotel;
        setLayout(null);
        /*GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);*/

        add(numPorte);
        add(numP);
        numPorte.setBounds(10, 10, 200, 20);
        numP.setBounds(200, 10, 200, 20);


        add(typeChambre);
        add(tChambre);
        tChambre.addItem("Simple");
        tChambre.addItem("Double");
        tChambre.addItem("Suite");
        typeChambre.setBounds(10, 40, 200, 20);
        tChambre.setBounds(200, 40, 200, 20);

        add(label4);
        add(numEtag);

        label4.setBounds(10, 70, 200, 20);
        numEtag.setBounds(200, 70, 200, 20);

        add(ajoutButton);

        ajoutButton.setBounds(200, 100, 200, 20);

        ControlAjout controlAjout = new ControlAjout(numP, type, numEtag, hotel, fenetre);   
        ajoutButton.addActionListener(controlAjout);


    }
}