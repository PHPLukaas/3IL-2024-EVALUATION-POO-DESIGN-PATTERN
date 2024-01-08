package app;

public class Entreprise {
    private String nom;
    private static Entreprise instance = null;

    private Entreprise(String nom) {
        this.nom = nom;
    }

    public static Entreprise getInstance() {
        if (instance == null) {
            instance = new Entreprise("LocaLux");
        }
        return instance;
    }

    public String getNom() {
        return nom;
    }
}
