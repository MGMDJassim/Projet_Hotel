package Controler;

import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class loginClient extends JFrame {
    private Vector<String> utilisateurs;
    private Vector<String> motsDePasse;

    private JTextField nomUtilisateur;
    private JPasswordField motDePasse;
    private JButton btnConnexion;

    public loginClient() {
        // Initialiser les vecteurs
        utilisateurs = new Vector<>();
        motsDePasse = new Vector<>();

        // Ajouter quelques utilisateurs et mots de passe fictifs
        utilisateurs.add("alice");
        motsDePasse.add("azerty");
        utilisateurs.add("bob");
        motsDePasse.add("123456");

        // Créer les composants de l'interface
        nomUtilisateur = new JTextField();
        motDePasse = new JPasswordField();
        btnConnexion = new JButton("Connexion");

        // Définir la disposition
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nom d'utilisateur :"));
        panel.add(nomUtilisateur);
        panel.add(new JLabel("Mot de passe :"));
        panel.add(motDePasse);
        panel.add(btnConnexion);

        // Ajouter l'action au bouton
        btnConnexion.addActionListener(e -> {
            String nom = nomUtilisateur.getText();
            String mdp = String.valueOf(motDePasse.getPassword());

            // Vérifier les informations de connexion
            if (authentifier(nom, mdp)) {
                // Afficher un message de succès et fermer la page
                JOptionPane.showMessageDialog(null, "Connexion réussie !");
                dispose();
            } else {
                // Afficher un message d'erreur
                JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Afficher la page
        this.setContentPane(panel);
        this.setTitle("Connexion");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private boolean authentifier(String nom, String mdp) {
        // Itérer sur les utilisateurs et comparer les informations
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).equals(nom) && motsDePasse.get(i).equals(mdp)) {
                return true;
            }
        }
        return false;
    }
}
