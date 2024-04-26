package Vue;
import javax.swing.*;

public class Fenetre extends JFrame{
    JMenu menu = new JMenu("Menu");  
    JMenu item1 = new JMenu("Gestion des chambres");
    JMenu item2 = new JMenu("Gestion des clients");
    JMenu item3 = new JMenu("Gestion des reservations");
    JMenuBar barre = new JMenuBar();

    public Fenetre(){

        this.setJMenuBar(barre);
        barre.add(menu);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);



        this.setTitle("Gestion d'hotel");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
    

}
