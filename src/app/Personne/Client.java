package app.Personne;

import java.util.ArrayList;
import java.util.List;

import app.Choix.Choosable;
import app.Reservation.Reservation;

public class Client extends Personne implements Choosable {

    private List<Reservation> reservations;

    public Client() {
        super();
        // Par defaut, un client n'a pas de réservation
        this.reservations = new ArrayList<Reservation>();

    }


    @Override
    public String describe() {
        return this.getNom() + " " + this.getPrenom();
    }
}
