package app.Personne;

import app.Choix.Choosable;
import app.Reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Responsable extends Personne {
        private List<Reservation> reservations;

        public Responsable() {
            super();
            // Par defaut, un responsable n'a pas de réservation
            this.reservations = new ArrayList<Reservation>();
        }

    public void setReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
