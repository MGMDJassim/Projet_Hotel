package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Hotel;

public class FenetreConsulSejour extends JFrame {
    Hotel hotel;
    JPanel left;
    public FenetreConsulSejour(Hotel hotel){
        this.hotel = hotel;
        this.left = new JPanel();
        this.add(left, BorderLayout.CENTER);
        this.pack();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null); // Centre la fenêtre
        this.setVisible(true);
    }
}
