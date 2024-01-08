package app.Personne;

import java.util.ArrayList;
import java.util.List;

import app.Choix.Choosable;
import app.Reservation.Reservation;

public class Client extends Personne {

    private List<Reservation> reservations;

    public Client() {
        super();
        // Par defaut, un client n'a pas de réservation
        this.reservations = new ArrayList<Reservation>();
    }

    public void setReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
