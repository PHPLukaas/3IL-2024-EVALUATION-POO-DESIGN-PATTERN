package app.Personne;

import app.Reservation.Reservation;

public class Responsable extends Personne {

        private Reservation reservation;

        public Responsable() {
            super();
            // Par defaut, un responsable n'a pas de réservation
            this.reservation = null;
        }
}
