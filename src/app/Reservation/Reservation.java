package app.Reservation;

import app.Personne.Responsable;
import app.Voiture.Voiture;
import app.Personne.Client;

import java.util.Date;

public class Reservation {

    private Responsable responsable;
    private Client client;
    private Voiture voiture;
    private String dateLocation;

    public Reservation(String dateLocation, Responsable responsable, Client client, Voiture voiture) {
        this.dateLocation = dateLocation;
        this.responsable = responsable;
        this.client = client;
        this.voiture = voiture;
        this.voiture.setReservation(this);
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public Client getClient() {
        return client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public String getDateLocation() {
        return dateLocation;
    }

}
