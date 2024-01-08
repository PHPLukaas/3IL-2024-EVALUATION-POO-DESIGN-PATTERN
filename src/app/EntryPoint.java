package app;

import app.Choix.Choix;
import app.Personne.Client;
import app.Personne.Responsable;
import app.Voiture.Voiture;
import app.Reservation.Reservation;
import app.Voiture.VoitureFactory;
import app.Voiture.VoitureType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class EntryPoint {

    public static void main(String[] args) {
        // configurez ici votre école :
        // - Instantiation de vos voitures, clients, responsables...

        Entreprise entreprise = Entreprise.getInstance();

        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();

        List<Client> clients = List.of(client1, client2, client3);

        Responsable responsable1 = new Responsable();
        Responsable responsable2 = new Responsable();

        List<Responsable> responsables = List.of(responsable1, responsable2);

        // Voitures LUXE
        Voiture voiture1 = VoitureFactory.createVoiture(460, VoitureType.LUXE);
        Voiture voiture2 = VoitureFactory.createVoiture(245, VoitureType.LUXE);

        // Voitures STANDARD
        Voiture voiture3 = VoitureFactory.createVoiture(120, VoitureType.STANDARD);
        Voiture voiture4 = VoitureFactory.createVoiture(90, VoitureType.STANDARD);

        // Voitures DAUBE
        Voiture voiture5 = VoitureFactory.createVoiture(55, VoitureType.DAUBE);
        Voiture voiture6 = VoitureFactory.createVoiture(35, VoitureType.DAUBE);


        List<Voiture> voitures = List.of(voiture1, voiture2, voiture3, voiture4, voiture5, voiture6);

        // - Le programme est déjà pré écrit, il ne reste qu'à compléter les TODO

        System.out.println("/_\\ Bienvenue sur " + entreprise.getNom() + " car manager!");

        // la app.Console permet de faciliter la récupération d'une saisie de l'utilisateur dans la console
        Console console = new Console();
        int functionToRun = -1;
        do {
            System.out.println("Qu'est-ce que tu veux faire?");
            System.out.println("1 - Lister les voitures disponibles");
            System.out.println("2 - Effectuer une réservation");
            System.out.println("3 - J'ai fini");

            functionToRun = console.captureInt(1, 4);
                // contrôle de la saisie
                switch(functionToRun) {
                    case 1:
                        avalaibleCars(voitures);
                        break;
                    case 2:
                        reserver(voitures, clients, responsables);
                        break;
                    case 3:
                        System.out.println("A la prochaine!");
                    default:
                        System.err.println("Saisie invalide... tu dois choisir entre 1 et 3");
                }
            System.out.println("###################################################");

        } while(functionToRun != 3);

    }

    private static void avalaibleCars(List<Voiture> voitures) {
        System.out.println("Voici la liste des voitures disponibles aujourd'hui :");
        // On recupere la date du jour JJ/MM/AAAA en java
        String date = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy").format(java.time.LocalDate.now());
        // Pour chaque voiture on vérifie si elle est disponible pour la date du jour
        List<Voiture> voituresDispo = new ArrayList<>();
        for (Voiture voiture : voitures) {
            boolean dispo = voiture.isAvailable(date);
            if (dispo) {
                voituresDispo.add(voiture);
            }
        }
        // On affiche la liste des voitures disponibles
        for (Voiture voiture : voituresDispo) {
            System.out.println("- " + voiture.describe());
        }
    }


    private static void reserver(List<Voiture> voitures, List<Client> clients, List<Responsable> responsables) {
        System.out.println("A quelle date souhaitez vous réserver ?");
        Console console = new Console();
        String date = console.captureString();

        Choix<Voiture> choix = new Choix<>();
        Voiture voiture = choix.choice(voitures, "Quelle voiture souhaitez vous réserver ?", date);

        // On vérifie que la voiture n'est pas déjà réservée pour la date
        if (!voiture.isAvailable(date)) {
            System.out.println("La voiture est déjà réservée pour cette date");
            return;
        }

        Choix<Responsable> choixResponsable = new Choix<>();
        Responsable responsable = choixResponsable.choice(responsables, "Quel responsable souhaitez vous réserver ?");

        Choix<Client> choixClient = new Choix<>();
        Client client = choixClient.choice(clients, "Quel client souhaitez vous réserver ?");

        Reservation resa = new Reservation(date, responsable, client, voiture);
        System.out.println(client.describe() + " a réservé " + voiture.describe() + " pour le " + date + " et " + responsable.describe() + " est le responsable de la location.");
    }
}
