package Vue;
import java.awt.event.ActionListener;
import Model.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


// Import the TableModel class


public class Fenetre extends JFrame{
    JMenuBar barre = new JMenuBar();  

    JLabel label = new JLabel("Porjet Hôtel", HEIGHT);

    JButton reservation = new JButton("Réservations");
    JButton agentEntretient = new JButton("Agent d'entretient");
    JButton employe = new JButton("Employes");

    JMenu gchambre = new JMenu("Gestion des chambres");
    JMenu gclient = new JMenu("Gestion des clients");
    JMenu greservation = new JMenu("Gestion des reservations");
    JMenu gsejour = new JMenu("Gestion des sejours");
    JMenu gemploye = new JMenu("Gestion des employes");
    JMenu gmenage = new JMenu("Gestion du menage");

    JMenuItem ajouterchambre = new JMenuItem("Ajouter une chambre");
    JMenuItem afficherChambre = new JMenuItem("Afficher les chambres");

    JMenuItem ajouterClient = new JMenuItem("Ajouter un client");
    JMenuItem afficherClient = new JMenuItem("Afficher les clients");

    JMenuItem affReservations = new JMenuItem("Afficher les reservations");
    JMenuItem ajouterReservation = new JMenuItem("Ajouter une reservation");

    JMenuItem affSejour = new JMenuItem("Afficher les séjours");
    
    JMenuItem ajouterEmploye = new JMenuItem("Ajouter un employe");
    JMenuItem supprimerEmploye = new JMenuItem("Supprimer un employe");
    JMenuItem afficherEmploye = new JMenuItem("Afficher les employes");
    
    JMenuItem ajouterMenage = new JMenuItem("Ajouter une tache de menage");
    JMenuItem supprimerMenage = new JMenuItem("Supprimer une tache de menage");
    JMenuItem afficherMenage = new JMenuItem("Afficher les taches de menage");
    
    JPanel currentPanel = new JPanel();
    Hotel hotel;
    Chambre chambre;

    public Fenetre(Hotel h){
        hotel = h;

        this.setJMenuBar(barre);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        barre.add(gchambre);
        barre.add(gclient);
        barre.add(greservation);
        barre.add(gsejour);
        barre.add(gemploye);
        barre.add(gmenage);

        gchambre.add(ajouterchambre);
        gchambre.add(afficherChambre);

        gclient.add(ajouterClient);
        gclient.add(afficherClient);

        greservation.add(affReservations);
        greservation.add(ajouterReservation);

        gsejour.add(affSejour);

        gemploye.add(ajouterEmploye);
        gemploye.add(supprimerEmploye);
        gemploye.add(afficherEmploye);

        gmenage.add(ajouterMenage);
        gmenage.add(afficherMenage);
        ajouterchambre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAjout vue = new VueAjout(hotel, Fenetre.this);
                setContentPane(vue);
            }
        });

        afficherChambre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAffChambre vue = new VueAffChambre(hotel, Fenetre.this);
                setContentPane(vue);
            }
        
        });
        ajouterClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAjoutClient vue = new VueAjoutClient(hotel, Fenetre.this);
                setContentPane(vue);
            }
        });

        afficherClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAffClient vue = new VueAffClient(hotel, Fenetre.this);
                setContentPane(vue);
            }
        
        });

        ajouterReservation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAjoutReservation vue = new VueAjoutReservation(hotel, Fenetre.this, chambre);
                setContentPane(vue);
            }
        });

        affReservations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueReservation vue = new VueReservation(hotel, Fenetre.this);
                setContentPane(vue);
            }
        });
        affSejour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                VueAffSejour vue = new VueAffSejour(hotel, Fenetre.this);
                setContentPane(vue);
            }
        });


        afficherMenage.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                VueGestionMenage vue = new VueGestionMenage(hotel);
                setContentPane(vue);
            }
        });
        this.pack();
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null); // Centre la fenêtre
        this.setVisible(true);
        
    }

    public void setContentPane(JPanel panel) {
        getContentPane().remove(currentPanel);
        currentPanel = panel;
        getContentPane().add(currentPanel);
        revalidate();
        repaint();
    }
}





