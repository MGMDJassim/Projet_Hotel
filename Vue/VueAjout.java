package Vue;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import Model.*;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controler.ControlAjout;


public class VueAjout extends JPanel{
    
  
    JLabel numPorte = new JLabel("Numero de la porte");
    JTextField numP = new JTextField(20);

    JLabel typeChambre = new JLabel("Type de la chambre");
    JTextField type = new JTextField(20);

    JLabel label4 = new JLabel("Numero de l'etage");
    JTextField numEtag = new JTextField(20);


    JButton ajoutButton = new JButton("Ajouter");

    public VueAjout(){
        setLayout(new GridLayout(4,1,10,10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        add(numPorte);
        add(numP);
    
        add(typeChambre);
        add(type);

        add(label4);
        add(numEtag);

        add(ajoutButton, gbc);



    }
}