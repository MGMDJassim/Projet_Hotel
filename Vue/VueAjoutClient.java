package Vue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import Model.Hotel;


public class VueAjoutClient extends JPanel{
    Hotel hotel;
    Fenetre fenetre;

    JLabel nom = new JLabel("Nom du client");
    JTextField nomClient = new JTextField(20);

    JLabel prenom = new JLabel("Prénom du client");
    JTextField prenomClient = new JTextField(20);

    JLabel dateDeNaissance = new JLabel("Date de naissance");
    JTextField dateDeNaissanceClient = new JTextField(20);

    JLabel tel = new JLabel("Numéro de téléphone");
    JTextField telClient = new JTextField(20);

    JButton ajoutClient = new JButton("Ajouter");

    JPanel panel;

    public VueAjoutClient(Hotel hotel, Fenetre fenetre){
        super(new BorderLayout());
        setLayout(null);

        this.hotel = hotel;
        this.fenetre = fenetre;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(400, 200);
        panel.setLocation(250, 100);

        panel.add(nom);
        nom.setBounds(10, 20, 150, 20);

        panel.add(nomClient);
        nomClient.setBounds(200, 20, 150, 20);

        panel.add(prenom);
        prenom.setBounds(10, 50, 150, 20);

        panel.add(prenomClient);
        prenomClient.setBounds(200, 50, 150, 20);

        panel.add(dateDeNaissance);
        dateDeNaissance.setBounds(10, 80, 150, 20);

        panel.add(dateDeNaissanceClient);
        dateDeNaissanceClient.setBounds(200, 80, 150, 20);

        panel.add(tel);
        tel.setBounds(10, 110, 150, 20);

        panel.add(telClient);
        telClient.setBounds(200, 110, 150, 20);

        panel.add(ajoutClient);
        ajoutClient.setBounds(200, 140, 150, 20);

        add(panel, BorderLayout.CENTER);
        
        
    }
}