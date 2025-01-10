package Vue;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Employe;
import Model.Hotel;
import Model.Receptionniste;

public class FenetreReceptionniste extends JFrame {
    Hotel hotel;
    Receptionniste receptionniste;
    JLabel label = new JLabel("Veuillez vous connecter");
    JButton ajouter = new JButton("Commencer la journée");
    JPanel contenue = new JPanel();

    JComboBox<Integer> numeroReceptionnistes;
    public FenetreReceptionniste(Hotel hotel) {
        this.hotel = hotel;
        this.setLayout(new GridBagLayout());
        setTitle("Hotel");
        GridBagConstraints gbc = new GridBagConstraints();
        contenue.setLayout(new BoxLayout(contenue, BoxLayout.Y_AXIS));

        numeroReceptionnistes = new JComboBox<Integer>();
        for (Employe employe : hotel.getListeEmployes()) {
            if (employe instanceof Receptionniste) {
                Receptionniste receptionniste = (Receptionniste) employe;
                numeroReceptionnistes.addItem(receptionniste.numEmploye);
            }
        }
        numeroReceptionnistes.setPreferredSize(new Dimension(40, 20));
        ajouter.setPreferredSize(new Dimension(200, 30));
        contenue.add(label);
        contenue.add(numeroReceptionnistes);
        contenue.add(Box.createRigidArea(new Dimension(0, 10)));
        contenue.add(ajouter);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(contenue, gbc);
        
        ajouter.addActionListener(e -> {
            Receptionniste receptionniste = null;
            for (Employe employe : hotel.getListeEmployes()) {
                if (employe instanceof Receptionniste) {
                    Receptionniste r = (Receptionniste) employe;
                    if (r.numEmploye == (int) numeroReceptionnistes.getSelectedItem()) {
                        receptionniste = r;
                    }
                }
            }
            if(receptionniste != null) {
                new Fenetre(hotel, receptionniste);
                this.dispose();
            }
        });
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
}
