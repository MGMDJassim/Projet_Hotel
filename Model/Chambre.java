package Model;
import java.util.Vector;
import java.time.*;

public abstract class Chambre {
    private static int idCounter = 0;

    public int etage;
    public int numeroPorte;
    private Vector<Reservation> listReservation = new Vector<Reservation>();
    public Hotel hotel;
    public String type;
    public boolean etat;
    public abstract float getPrix();

    public Chambre(int etage, String type, Hotel hotel, boolean etat) {

        this.etage = etage;
        this.numeroPorte = ++idCounter;
        this.type = type;
        this.hotel = hotel;
        this.etat = etat;
    }

    public void setEtatChambre(boolean etat) {
        this.etat = etat;
    }

    public boolean getEtatChambre() {
        return etat;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public void addReservation(Reservation reservation) {
        listReservation.add(reservation);
    }

    public Vector<Reservation> getListReservation() {
        return listReservation;
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


    public Hotel getHotel() {
        return hotel;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    //methodes pour enlever la chambre

    public void removeReservation(Reservation reservation) {
        listReservation.remove(reservation);
    }

    public void removeAllReservations() {
        listReservation.clear();
    }

    // Recherche des chambres libres
    public boolean isFree(LocalDate dateDebut, LocalDate dateFin) {
        for (Reservation reservation : listReservation) {
            if ((dateDebut.isEqual(reservation.getDateDebut()) || dateDebut.isAfter(reservation.getDateDebut())) && dateDebut.isBefore(reservation.getDateFin())) {
                return false;
            }
            if (dateFin.isAfter(reservation.getDateDebut()) && (dateFin.isBefore(reservation.getDateFin()) || dateFin.isEqual(reservation.getDateFin()))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "Chambre " + type + " à l'étage " + etage + ", à la porte " + numeroPorte + "\n";
    }

    //Recherche des chambres salles

    public void cSalle(LocalDate ajd){
        for(Reservation r : listReservation){
            if(ajd.isAfter(r.getDateFin())){
                setEtatChambre(false);
            }
        }
    }

    //Chambre salle

    public boolean ChambreSalle(LocalDate dateFin){
        for(Reservation r : listReservation){
            if(!r.getChambre().getEtatChambre()){
                return true;
            }
        }
        
        return false;

    }
}
