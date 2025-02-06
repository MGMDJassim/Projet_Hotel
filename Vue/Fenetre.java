package Vue;

import java.awt.event.ActionListener;
import Model.*;
import java.awt.event.ActionEvent;
import javax.swing.*;



// Importer la classe TableModel


public class Fenetre extends JFrame{
    JMenuBar barre = new JMenuBar();  

    JLabel label = new JLabel("Projet Hôtel", HEIGHT);

    JButton reservation = new JButton("Réservations");
    JButton agentEntretien = new JButton("Agent d'entretien");
    JButton employe = new JButton("Employés");

    JMenu gchambre = new JMenu("Gestion des chambres");
    JMenu gclient = new JMenu("Gestion des clients");
    JMenu greservation = new JMenu("Gestion des réservations");
    JMenu gsejour = new JMenu("Gestion des séjours");
    JMenu gemploye = new JMenu("Gestion des employés");
    JMenu gmenage = new JMenu("Gestion du ménage");
    JMenu gproduit = new JMenu("Gestion des produits");

    JMenuItem ajouterChambre = new JMenuItem("Ajouter une chambre");
    JMenuItem afficherChambre = new JMenuItem("Afficher les chambres");

    JMenuItem ajouterClient = new JMenuItem("Ajouter un client");
    JMenuItem afficherClient = new JMenuItem("Afficher les clients");

    JMenuItem affReservations = new JMenuItem("Afficher les réservations");


    JMenuItem affSejour = new JMenuItem("Afficher les séjours");
    JMenuItem ajouterSejour = new JMenuItem("Ajouter un sejour");

    JMenuItem affProduit = new JMenuItem("Afficher les produits");
    
    JMenuItem ajouterEmploye = new JMenuItem("Ajouter un employé");
    JMenuItem supprimerEmploye = new JMenuItem("Supprimer un employé");
    JMenuItem afficherEmploye = new JMenuItem("Afficher les employés");
    
    JMenuItem ajouterMenage = new JMenuItem("Ajouter une tâche de ménage");
    
    JPanel currentPanel = new JPanel();
    Hotel hotel;
    Receptionniste receptionniste;
    Chambre chambre;

    public Fenetre(Hotel h, Receptionniste r){
        hotel = h;
        receptionniste = r;

        this.setJMenuBar(barre);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        barre.add(gchambre);
        barre.add(gclient);
        barre.add(greservation);
        barre.add(gsejour);
        barre.add(gemploye);
        barre.add(gproduit);
        barre.add(gmenage);

        gchambre.add(afficherChambre);

        gclient.add(ajouterClient);
        gclient.add(afficherClient);

        greservation.add(affReservations);
        gsejour.add(ajouterSejour);

        gsejour.add(affSejour);

        gproduit.add(affProduit);

        gemploye.add(ajouterEmploye);
        gemploye.add(supprimerEmploye);
        gemploye.add(afficherEmploye);

        gmenage.add(ajouterMenage);
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

        ajouterSejour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAjoutReservation vue = new VueAjoutReservation(hotel, Fenetre.this, chambre, receptionniste);
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


        affProduit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                VueAffProduit vue = new VueAffProduit(hotel, Fenetre.this);
                setContentPane(vue);
            }
        });

        ajouterMenage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueGestionMenage vue = new VueGestionMenage(hotel);
                setContentPane(vue);
                revalidate();
                repaint();
            }
        });

        afficherEmploye.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VueAffEmploye vue = new VueAffEmploye(hotel, Fenetre.this);
                setContentPane(vue);
            }
        });

        this.pack();
        this.setSize(1280, 720 );
        this.setLocationRelativeTo(null);
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
