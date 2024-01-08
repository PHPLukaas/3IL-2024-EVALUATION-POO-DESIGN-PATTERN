package app.Choix;

import java.util.List;
import app.Console;

public class Choix<Type extends Choosable>{

    public Type choice(List<Type> possibleChoices, String message, String date){
        System.out.println(message);
        for (int i = 0; i < possibleChoices.size(); i++) {
            System.out.println(i + " - " + possibleChoices.get(i).describe(date));
        }
        Console console = new Console();
        int choice = console.captureInt(0, possibleChoices.size() - 1);

        // Return the choice with message "Vous avez choisi ..."
        System.out.println("Vous avez choisi " + possibleChoices.get(choice).describe(date));
        return possibleChoices.get(choice);
    }

    public Type choice(List<Type> possibleChoices, String message){
        System.out.println(message);
        for (int i = 0; i < possibleChoices.size(); i++) {
            System.out.println(i + " - " + possibleChoices.get(i).describe());
        }
        Console console = new Console();
        int choice = console.captureInt(0, possibleChoices.size() - 1);

        // Return the choice with message "Vous avez choisi ..."
        System.out.println("Vous avez choisi " + possibleChoices.get(choice).describe());
        return possibleChoices.get(choice);
    }
}