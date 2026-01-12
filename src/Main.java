import java.util.Scanner;

import Heroes.Archer;
import Heroes.Assassin;
import Heroes.Mage;
import Heroes.Warrior;
import character.util.Character;

public class Main {

    // GOAL
    // Choose Character.Character
    // Print Chosen Character.Character Info
    // Print option (Change or Play)
    // select random enemy
    // select random stats for enemy
    // gameplay

    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        Object hero = chooseCharacter();
    }

    private static Character chooseCharacter(){

        System.out.print("Enter username: ");
        String username = INPUT.next();

        System.out.print("Archer(1), Assassin(2), Mage(3), Warrior(4): ");
        int heroChoice = INPUT.nextInt();

        Character chosenHero =  switch (heroChoice) {
            case 1 -> new Archer(username);
            case 2 -> new Assassin(username);
            case 3 -> new Mage(username);
            case 4 -> new Warrior(username);
            default -> throw new IllegalStateException("Unexpected value: " + heroChoice);
        };

        System.out.printf("Username: %s \n", chosenHero.getUser());
        System.out.printf("Hero: %s \n", chosenHero.getHeroName());
        System.out.printf("Health: %s \n", chosenHero.getMaxHealth());

        return chosenHero;
    }
}
