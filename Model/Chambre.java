import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Chambre {
    public int etage;
    public int numeroPorte;
    private List<Reservation> listReservation;
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

    public void setListReservation(List<Reservation> listReservation) {
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
    public boolean isFree(Date debutD, Date finD) {
        for (Reservation reservation : listReservation) {
            if (reservation.getDateDebut().before(debutD) && reservation.getDateFin().after(finD)) {
                return true;
            }
        }
        return false;
    }

    // Méthode pour afficher les chambres libres
    public static void afficherChambresLibres(List<Chambre> chambres, Date debut, Date fin) {
        boolean libre = false;
        for (Chambre chambre : chambres) {
            if (chambre.isFree(debut, fin)) {
                libre = true;
                System.out.println("Chambre " + chambre.type + " à l'étage " + chambre.etage + ", à la porte " + chambre.numeroPorte);
            }
        }
        if (libre = false) {
            System.out.println("Aucune chambre n'est disponible sur la période du " + debut + " au " + fin + ".");
        }
    }

    }
}
