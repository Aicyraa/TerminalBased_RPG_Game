import java.util.InputMismatchException;
import java.util.Scanner;

import character.util.Character;
import Heroes.Archer;
import Heroes.Assassin;
import Heroes.Mage;
import Heroes.Warrior;

public class Main {

    // GOAL
    // select random enemy
    // select random stats for enemy
    // gameplay

    private static final Scanner INPUT = new Scanner(System.in);
    static Character hero;

    public static void main(String[] args) {
        hero = chooseCharacter();
        gameConfirm();
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

    private static void  gameConfirm() {

        int confirmation;

        while (true) {
            try {

                System.out.print("Play(1) | Quit(2) | Change Hero(3) ");
                confirmation = INPUT.nextInt();

                if (confirmation == 1) break;
                else if (confirmation == 2) break;
                else if (confirmation == 3) chooseCharacter();
                else { throw new InputMismatchException("Invalid input!"); }

            } catch (InputMismatchException e){ System.out.print("Invalid Value!"); }

        }

    }


    private static void gameplay(){

    }
}
