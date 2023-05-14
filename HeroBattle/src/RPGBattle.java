import java.util.Random;
import java.util.Scanner;

public class RPGBattle {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Character attributes
        String characterName = "Hero";
        int characterHealth = 100;
        int characterSpellPower = 20;

        // Dragon attributes
        String dragonName = "Dragon";
        int dragonHealth = 200;

        System.out.println("A fierce battle begins between " + characterName + " and " + dragonName + "!\n");

        while (characterHealth > 0 && dragonHealth > 0) {
            // Character's turn
            System.out.println("Choose your action:");
            System.out.println("1. Attack with a spell");
            System.out.println("2. Use an item to restore health");

            int playerChoice = scanner.nextInt();

            if (playerChoice == 1) {
                int spellDamage = random.nextInt(characterSpellPower);
                dragonHealth -= spellDamage;
                System.out.println(characterName + " casts a spell on " + dragonName + " and deals " + spellDamage + " damage.");
            } else if (playerChoice == 2) {
                int healthRestored = random.nextInt(30) + 10; // Random health restoration between 10 and 40
                characterHealth += healthRestored;
                System.out.println(characterName + " uses an item and restores " + healthRestored + " health.");
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            // Dragon's turn
            int dragonAttackDamage = random.nextInt(30);
            characterHealth -= dragonAttackDamage;

            System.out.println(dragonName + " attacks " + characterName + " and deals " + dragonAttackDamage + " damage.\n");

            // Check if either the character or dragon has been defeated
            if (characterHealth <= 0) {
                System.out.println(characterName + " has been defeated. " + dragonName + " is victorious!");
            } else if (dragonHealth <= 0) {
                System.out.println(dragonName + " has been defeated. " + characterName + " is victorious!");
            }
        }
    }
}
