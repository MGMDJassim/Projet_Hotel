package Model;
import java.time.LocalDate;
import java.util.Vector;
public class Sejour {
    private int compteur = 1;
    private int numeroSejour;
    private Reservation reservation;
    private Vector<Consommation> consommations = new Vector<Consommation>();
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Sejour(Reservation reservation) {
        this.numeroSejour = compteur++;
        this.reservation = reservation;
        this.dateDebut = reservation.getDateDebut();
        this.dateFin = reservation.getDateFin();
    }

    public int numeroSejour(){
        return numeroSejour;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Vector<Consommation> getConsommations() {
        return consommations;
    }

    public void setConsommations(Vector<Consommation> consommations) {
        this.consommations = consommations;
    }

    public void ajouterConsommation(Consommation consommation) {
        this.consommations.add(consommation);
    }

    public void supprimerConsommation(Consommation consommation) {
        this.consommations.remove(consommation);
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public float calculerPrixConsommations() {
        float prix = 0;
        for (Consommation consommation : consommations) {
            prix = prix + consommation.calculerPrix();
        }
        return prix;
    }

    public float calculerPrix() {
        float prix = 0;
        for (Consommation consommation : consommations) {
            prix = prix + consommation.calculerPrix();
        }
        return prix + reservation.calculerPrix();
    }
}
