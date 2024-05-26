package Controler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import Model.Hotel;
import Vue.Fenetre;
import Vue.VueAffClient;
public class ControlRechercheClient implements ActionListener {
    private Hotel hotel;
    public Fenetre fenetre;
    public JTable table;
    private JTextField champRecherche;
    private VueAffClient vueAffClient;

    public ControlRechercheClient(Hotel hotel, JTextField champRecherche, Fenetre fenetre, VueAffClient vueAffClient, JTable table) {
        this.hotel = hotel;
        this.table = table;
        this.champRecherche = champRecherche;
        this.fenetre = fenetre;
        this.vueAffClient = vueAffClient;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String requete = champRecherche.getText();
        Vector<Vector<Object>> donnees;
        if (!requete.isEmpty()) {
            donnees = hotel.rechercherClient(requete);
            vueAffClient.aJour(donnees);
        }
        return;
    }
}
