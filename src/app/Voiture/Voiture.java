package app.Voiture;

import java.util.ArrayList;
import java.util.List;
import app.Reservation.Reservation;
import app.Choix.Choosable;

public class Voiture implements Choosable{
    private String marque;
    private String modele;
    private int kilometrage;
    private int prixLocation;

    private List<Reservation> reservations;

    public Voiture(String marque, String modele, int kilometrage, int prixLocation) {
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.prixLocation = prixLocation;
        this.reservations = new ArrayList<Reservation>();
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public int getPrixLocation() {
        return prixLocation;
    }

    public String toString() {
        return "app.Voiture{" + "marque=" + marque + ", modele=" + modele + ", kilometrage=" + kilometrage + ", prixLocation=" + prixLocation + '}';
    }

    public String getResaForDate(String date) {
        // Si la voiture n'a pas de réservation, elle est disponible
        if (reservations == null) {
            return "[Disponible]";
        }
        for (Reservation reservation : reservations) {
            if (reservation.getDateLocation().equals(date)) {
                return "[Réservée] par " + reservation.getClient().getNom() + " " + reservation.getClient().getPrenom() + "(Responsable : " + reservation.getResponsable().getNom() + " " + reservation.getResponsable().getPrenom() + ")";
            }
        }
        return "[Disponible]";
    }

    public void setReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public boolean isAvailable(String date) {
        // Si la voiture n'a pas de réservation, elle est disponible
        if (reservations == null) {
            return true;
        }
        for (Reservation reservation : reservations) {
            if (reservation.getDateLocation().equals(date)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String describe() {
        return "Voiture " + this.getMarque() + " " + this.getModele() + " " + this.getKilometrage() + "km " + this.getPrixLocation() + "€/jour";
    }

}
