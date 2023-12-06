package com.george.java_b_labb;

import java.util.Scanner;

import static com.george.java_b_labb.Monster.random;

// MonsterEncounter class for handling player interactions during a monster encounter
public class MonsterEncounter {

    // Scanner for user input during the monster battle
    Scanner scanner = new Scanner(System.in);

    // Method to handle the monster battle interaction
    public void monsterBattle(Player player, Monster monster) {

        // Loop for the ongoing battle until either the player or the monster is defeated
        do {
            System.out.println("""
                    What do you want to do next?
                    1: Attack
                    2: Check health status
                    3: Flee
                    4: Return to Main Menu
                    5: Exit The Game"""
            );

            try {
                // Switch statement to handle player choices during the battle
                switch (scanner.nextInt()) {
                    case 1 -> {
                        // Player attacks the monster
                        monster.defend(player);

                        // Check if the monster is still alive
                        if (monster.isAlive()) {
                            // Monster counterattacks
                            player.defend(monster);
                        } else {
                            // Player defeats the monster
                            player.setMonstersKilled(player.getMonstersKilled() + 1);
                            System.out.println("Congratulations! You killed the monster.\nReturning to the main menu.");
                        }
                    }

                    case 2 -> System.out.println("\nPlayer health: " + player.getHealth() +
                            "\nMonster health: " + monster.monsterStats() + "\n"
                    );

                    case 3 -> {
                        // Attempt to flee from the battle
                        double fleeChance = random.nextDouble();

                        if (fleeChance <= 0.5) {
                            System.out.println("SUCCESS! You managed to Escape.");
                        } else {
                            System.out.println("FAIL! You didn't manage to Escape.");
                        }

                        // Check if the player successfully flees
                        if (player.playerDidFlee()) {
                            monster.setHealth(0);
                        }
                    }

                    case 4 -> {
                        // Return to the main menu
                        System.out.println("Returning to Main Menu");
                        return;
                    }

                    case 5 -> {
                        // Exit the game
                        System.out.println("Exiting The Game. Welcome Back Again");
                        System.exit(0);
                    }

                    default -> System.out.println("Please Try Again.");
                }
            } catch (Exception e) {
                // Handle input exceptions
                scanner.next();
                System.out.println("Only numbers are allowed. Try again.");
            }
        } while (player.isAlive() && monster.isAlive());
    }
}