import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Chambre {
    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listReservation = new Vector<>();
    public Hotel hotel;
    public String type;

    public Chambre(int etage, int numeroPorte, String type, Hotel hotel) {
        this.etage = etage;
        this.numeroPorte = numeroPorte;
        this.type = type;
        this.hotel = hotel;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public void setListReservation(Vector<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getEtage() {
        return etage;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public Hotel getHotel() {
        return hotel;
    }

    // Recherche des chambres libres
    public boolean isFree (Date debut, Date fin) {
        for (Reservation reservation : listReservation) {
            if (reservation.dateD.before(debut) && reservation.datef.after(debut)) {
                return false;
            }
            if (reservation.dateD.before(fin) && reservation.datef.after(fin)) {
                return false;
            }
            if (reservation.dateD.after(debut) && reservation.datef.before(fin)) {
                return false;
            }
        }
        return true;
    }

    // Méthode pour afficher les chambres libres
    public static void afficherChambresLibres(List<Chambre> chambres, Date debut, Date fin) {
        for (Chambre chambre : chambres) {
            if (chambre.isFree(debut, fin)) {
                System.out.println("Chambre " + chambre.type + " à l'étage " + chambre.etage + ", à la porte " + chambre.numeroPorte);
            }
        }
        System.out.println("Aucune chambre n'est disponible sur la période du " + debut + " au " + fin + ".");
    }

}

