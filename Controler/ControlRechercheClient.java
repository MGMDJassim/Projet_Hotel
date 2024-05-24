package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;

import Model.Client;
import Model.Hotel;
import Vue.Fenetre;
import Vue.VueAffClient;

public class ControlRechercheClient implements ActionListener {
    private Hotel hotel;
    public Fenetre fenetre;
    public JTable table;
    private JTextField recherche;
    private VueAffClient vueAffClient;

    public ControlRechercheClient(Hotel hotel, JTextField recherche, Fenetre fenetre, VueAffClient vueAffClient,
            JTable table) {
        this.hotel = hotel;
        this.table = table;
        this.recherche = recherche;
        this.fenetre = fenetre;
        this.vueAffClient = vueAffClient;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String query = recherche.getText();
        Vector<Vector<Object>> data;
        if(!query.isEmpty()){
             data = hotel.rechercheClient(query);
            vueAffClient.aJour(data);
            System.out.println("Recherche client effectuée");
        }
        return;
    }
}
