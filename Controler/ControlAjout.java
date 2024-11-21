package Controler;
import Model.Chambre;
import Model.Hotel;
import Model.Normale;
import Model.Presidentiel;
import Vue.Fenetre;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControlAjout implements ActionListener {
    private Chambre chambre;
    private Hotel hotel;
    private Fenetre fenetre;

    private String[] typeChambre;
    private JTextField numeroEtage;
    public ControlAjout( String[] type, JTextField numeroEtage, Hotel hotel, Fenetre fenetre) {
        this.typeChambre = type;
        this.numeroEtage = numeroEtage;
        this.hotel = hotel;
        this.fenetre = fenetre;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int etage = Integer.parseInt(numeroEtage.getText());
        if (typeChambre[0].equals("Normale")) {
            chambre = new Normale(etage, hotel, true);
        } else {
            chambre = new Presidentiel(etage, hotel, true);
        }
        hotel.ajouterChambre(chambre);
        new Vue.VueAjout(hotel, fenetre);
    }
}
