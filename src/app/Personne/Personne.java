package app.Personne;

import app.Choix.Choosable;
import app.NamesGenerator;

import static app.NamesGenerator.generateNames;

public class Personne implements Choosable {

    private String nom;
    private String prenom;

    public Personne() {
        NamesGenerator.Names names = generateNames();
        this.nom = names.getLastName();
        this.prenom = names.getFirstName();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String describe() {
        return this.getNom() + " " + this.getPrenom();
    }
}
