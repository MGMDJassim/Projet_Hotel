
package Model;
public class Employe {

    public String nomEmploye;
    public int numEmploye;
    public String prenomEmploye;
    
    public Employe(String nomEmploye, int numEmploye, String prenomEmploye) {
        this.nomEmploye = nomEmploye;
        this.numEmploye = numEmploye;
        this.prenomEmploye = prenomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
    public String getNomEmploye() {
        return this.nomEmploye;
    }
    public void setNumEmploye(int numEmploye) {

        if (numEmploye <=0) {
            System.out.println("Le numéro employé doit commencer par 2021 et doit être positif.");
        } else {
        this.numEmploye = numEmploye;
        }
    }
    public int getNumEmploye() {
        return this.numEmploye;
    }
    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }
    public String getPrenomEmploye() {
        return this.prenomEmploye;
    }
//affichage info de l'employe
 public void afficherInfo() {
        System.out.println("Nom: " + nomEmploye);
        System.out.println("Numéro: " + numEmploye);
        System.out.println("Prénom: " + prenomEmploye);
    }
}
