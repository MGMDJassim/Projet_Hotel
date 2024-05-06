
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

    //mettre nom de famille en majuscule
    public void setNomEmploye(String nomEmploye) {

        String[]nom = nomEmploye;
        StringBuilder nomDeFamilleMajuscule = new StringBuilder();
        for(int i = 0; i<nom.length;i++){
            nomFamilleMajuscule.append(partiesNom[i].toUpperCase());
        }
        this.nomEmploye = nomFamilleMajuscule.toString();
    }
    
    public String getNomEmploye() {
        return this.nomEmploye;
    }
    public void setNumEmploye(int numEmploye) {

        if (numEmploye <=0) {
            System.out.println("Le numéro employé doit être positif.");
        } else {
        this.numEmploye = numEmploye;
        }
    }
    public int getNumEmploye() {
        return this.numEmploye;
    }
    public void setPrenomEmploye(String prenomEmploye) {

        if (prenomEmploye != null && !prenomEmploye.isEmpty()) { 
            
        StringBuilder prenomMajuscule = new StringBuilder();
        prenomMajuscule.append(Character.toUpperCase(prenomEmploye.charAt(0))); 
            
        if (prenomEmploye.length() > 1) { 
            prenomMajuscule.append(prenomEmploye.substring(1)); 
        }
        this.prenomEmploye = prenomMajuscule.toString();
            
    } else {
        System.out.println("Le prénom ne peut pas être null ou vide.");
    }
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
