
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Suite_Double extends Chambre {

    public boolean fenetre;
    public int litDouble;
    public boolean belleVue;
    

    public Suite_Double() {
    
        this.fenetre = fenetre;
        this.litDouble = litDouble;
        this.belleVue = belleVue;
    }

    public void setFenetre(boolean fenetre) {
        this.fenetre = fenetre;
    }
    public void setLitDouble(int litDouble) {
        this.litDouble = litDouble;
    }
    public void setBelleVue(boolean belleVue) {
        this.belleVue = belleVue;
    }
    public boolean getFenetre() {
        return fenetre;
    }
    public int getLitDouble() {
        return litDouble;
    }
    public boolean getBelleVue() {
        return belleVue;
    }


}