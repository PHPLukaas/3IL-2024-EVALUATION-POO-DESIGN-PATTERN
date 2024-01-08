package app.Voiture;

public class VoitureFactory {

    private VoitureType voitureType;


    public static Voiture createVoiture(int prixParJour, VoitureType voitureType) {
        switch (voitureType) {
            // Si le prix est au dessus de 400 euros par jour et que le type est "Luxe", on met une
            case LUXE:
                if (prixParJour > 400) {
                    return new Voiture("Mercedes", "Classe A", 30000, prixParJour);
                } else if (prixParJour > 200) {
                    return new Voiture("Audi", "A3", 30000, prixParJour);
                } else {
                    return new Voiture("BMW", "Serie 1", 20000, prixParJour);
                }
            case STANDARD:
                if (prixParJour > 100) {
                    return new Voiture("Peugeot", "208", 20000, prixParJour);
                } else {
                    return new Voiture("Renault", "Clio", 10000, prixParJour);
                }
            case DAUBE:
                if (prixParJour > 50) {
                    return new Voiture("Citroen", "C3", 30000, prixParJour);
                } else {
                    return new Voiture("Renault", "Twingo", 100000, prixParJour);
                }
            default:
                return new Voiture("Renault", "Twingo", 100000, prixParJour);
        }
    }

}
