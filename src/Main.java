import java.util.InputMismatchException;
import java.util.Scanner;

import character.util.Character;
import character.util.Enemy;
import Heroes.Archer;
import Heroes.Assassin;
import Heroes.Mage;
import Heroes.Warrior;
import character.util.Skill;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static Character hero;
    private static int totalRounds = 0;
    private static int enemiesDefeated = 0;

    public static void main(String[] args) {
        displayWelcome();
        hero = chooseCharacter();
        gameConfirm();
        INPUT.close();
    }

    private static void displayWelcome() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   WELCOME TO BATTLE ARENA RPG!     ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println();
    }

    private static Character chooseCharacter() {
        String username = getValidUsername();
        int heroChoice = getValidHeroChoice();

        Character chosenHero = switch (heroChoice) {
            case 1 -> new Archer(username);
            case 2 -> new Assassin(username);
            case 3 -> new Mage(username);
            case 4 -> new Warrior(username);
            default -> throw new IllegalStateException("Unexpected value: " + heroChoice);
        };

        System.out.println("\n═══════════════════════════════════");
        chosenHero.getAllDetails();
        System.out.println("═══════════════════════════════════\n");

        return chosenHero;
    }

    private static String getValidUsername() {
        while (true) {
            try {
                System.out.print("Enter username: ");
                String username = INPUT.next();
                if (username.trim().isEmpty()) {
                    System.out.println("Username cannot be empty!");
                    continue;
                }
                return username;
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                INPUT.nextLine();
            }
        }
    }

    private static int getValidHeroChoice() {
        while (true) {
            try {
                System.out.println("\nChoose your hero:");
                System.out.println("1. Archer   - Balanced ranged fighter");
                System.out.println("2. Assassin - High damage, quick strikes");
                System.out.println("3. Mage     - Powerful spells, high mana");
                System.out.println("4. Warrior  - Tank with high health");
                System.out.print("\nYour choice (1-4): ");

                int choice = INPUT.nextInt();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
                System.out.println("Please enter a number between 1 and 4!");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                INPUT.nextLine();
            }
        }
    }

    private static void gameConfirm() {
        while (true) {
            try {
                System.out.println("\n┌─────────────────────────────┐");
                System.out.println("│  1. Start Battle            │");
                System.out.println("│  2. Quit Game               │");
                System.out.println("│  3. Change Hero             │");
                System.out.println("└─────────────────────────────┘");
                System.out.print("Select option: ");

                int confirmation = INPUT.nextInt();

                switch (confirmation) {
                    case 1 -> {
                        gameplay();
                        return;
                    }
                    case 2 -> {
                        System.out.println("\nThanks for playing! Goodbye!");
                        return;
                    }
                    case 3 -> hero = chooseCharacter();
                    default -> System.out.println("Invalid option! Choose 1-3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                INPUT.nextLine();
            }
        }
    }

    private static void gameplay() {
        System.out.println("\n⚔️  THE BATTLE BEGINS! ⚔️\n");

        while (hero.isAlive()) {
            Enemy currentEnemy = new Enemy().getEnemy();
            System.out.println("\n🎯 A wild " + currentEnemy.getCharacterName() + " appears!");

            boolean heroWon = battleRound(currentEnemy);

            if (heroWon) {
                enemiesDefeated++;
                System.out.println("\n✨ Victory! Enemy defeated!");
                System.out.println("Enemies defeated: " + enemiesDefeated);

                // Restore some health and mana after victory
                hero.restoreAfterBattle();

                if (!continuePlaying()) {
                    break;
                }
            } else {
                gameOver();
                return;
            }
        }

        if (!hero.isAlive()) {
            gameOver();
        }
    }

    private static boolean battleRound(Enemy currentEnemy) {
        int roundNumber = 0;

        while (hero.isAlive() && currentEnemy.isAlive()) {
            roundNumber++;
            totalRounds++;

            gameDisplay(roundNumber, hero, currentEnemy);

            // Hero's turn
            Skill heroSkill = getPlayerSkillChoice();
            if (heroSkill == null) continue;

            if (hero.getCurrentMana() < heroSkill.getMana()) {
                System.out.println("❌ Not enough mana! Need " + heroSkill.getMana() + " but have " + hero.getCurrentMana());
                continue;
            }

            // Execute hero attack
            hero.setMana(heroSkill.getMana());
            currentEnemy.setDamage(heroSkill.getDamage());
            System.out.println("⚡ " + hero.getUser() + " used " + heroSkill.getName() + "!");
            System.out.println("💥 Dealt " + heroSkill.getDamage() + " damage!");

            if (!currentEnemy.isAlive()) {
                return true;
            }

            // Enemy's turn
            System.out.println("\n--- Enemy's Turn ---");
            Skill enemySkill = currentEnemy.getRandomSkill();

            if (currentEnemy.getCurrentMana() >= enemySkill.getMana()) {
                currentEnemy.setMana(enemySkill.getMana());
                hero.setDamage(enemySkill.getDamage());
                System.out.println("🔥 " + currentEnemy.getCharacterName() + " used " + enemySkill.getName() + "!");
                System.out.println("💢 You took " + enemySkill.getDamage() + " damage!");
            } else {
                System.out.println("😴 " + currentEnemy.getCharacterName() + " is out of mana!");
            }

            System.out.println("\nPress Enter to continue...");
            try {
                System.in.read();
                INPUT.nextLine();
            } catch (Exception e) {
                // Ignore
            }
        }

        return hero.isAlive();
    }

    private static Skill getPlayerSkillChoice() {
        hero.getSkillSet().displaySkills();

        while (true) {
            try {
                System.out.print("\nSelect skill (0-" + (hero.getSkillSet().getSkillCount() - 1) + "): ");
                int choice = INPUT.nextInt();

                Skill skill = hero.getSkillSet().getSkill(choice);
                if (skill != null) {
                    return skill;
                }
                System.out.println("Invalid skill choice!");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                INPUT.nextLine();
            }
        }
    }

    private static boolean continuePlaying() {
        System.out.print("\nContinue to next battle? (1=Yes, 2=No): ");
        try {
            int choice = INPUT.nextInt();
            return choice == 1;
        } catch (InputMismatchException e) {
            INPUT.nextLine();
            return false;
        }
    }

    private static void gameOver() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║          GAME OVER!                ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("\n📊 Final Statistics:");
        System.out.println("   Enemies Defeated: " + enemiesDefeated);
        System.out.println("   Total Rounds: " + totalRounds);
        System.out.println("\nThanks for playing!");
    }

    private static void gameDisplay(int roundNumber, Character hero, Character enemy) {
        System.out.println("\n╔═══════════════════ ROUND " + roundNumber + " ═══════════════════╗");
        System.out.printf("║ %-20s vs %-20s  ║%n", hero.getCharacterName(), enemy.getCharacterName());
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.printf("║ Hero: %-38s  ║%n", hero.getUser());
        System.out.printf("║ ❤️  Health: %-6s 🔵 Mana: %-6s           ║%n", hero.getCurrentHealth() + "/" + hero.getMaxHealth(),hero.getCurrentMana() + "/" + hero.getMaxMana());
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.printf("║ Enemy: %-38s ║%n", enemy.getCharacterName());
        System.out.printf("║ ❤️  Health: %-6s 🔵 Mana: %-6s          ║%n", enemy.getCurrentHealth() + "/" + enemy.getMaxHealth(), enemy.getCurrentMana() + "/" + enemy.getMaxMana());
        System.out.println("╚═══════════════════════════════════════════════╝\n");
    }
}