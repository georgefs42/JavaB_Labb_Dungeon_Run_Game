package com.george.java_b_labb;

import java.util.Scanner;

import static com.george.java_b_labb.Monster.newMonsterEncounter;

// Game class for managing the main game flow
public class Game {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player();
    Shop shop = new Shop();
    MonsterEncounter monsterEncounter = new MonsterEncounter();
    OutputGameFile outputFile;

    public Game() {
        outputFile = new OutputGameFile();
    }


    // Method for displaying and managing the main game menu
    public void mainMenu() {

        // Set player name from user input
        player.setPlayerName(scanner.nextLine());
        // Add weapons to the shop's weapon list
        shop.addWeaponToList();
        boolean continueGame;

        do {
            continueGame = true;

            // Greeting message and main menu options
            System.out.println(Colors.PURPLE_BOLD + "\nHello " + player.getPlayerName() + "! \nPlease choose a number to start the game: \n" + Colors.RESET);
            System.out.println(
                    """
                            MAIN MENU
                            ===========================
                             1 - Fight a Monster
                             2 - Player status
                             3 - Shop
                             4 - Exit"""
            );

            try {
                // Switch statement to handle player choices in the main menu
                switch (scanner.nextInt()) {
                    case 1 -> {
                        // Fight a monster option
                        System.out.println("""
                                Select the Monster you want to fight?
                                1 - Goblin (Easy)
                                2 - Serpent  (Normal)
                                3 - Wyvern (Hard)
                                4 - Leviathan (Very Hard)""");

                        try {
                            // Get user's choice of monster to fight
                            int monsterChoice = scanner.nextInt();
                            System.out.println("\nYou selected monster: " + monsterChoice);

                            // Initiate a monster battle
                            monsterEncounter.monsterBattle(player, newMonsterEncounter(monsterChoice));

                            // Update player stats based on battle outcome
                            if (player.isAlive()) {
                                player.setHealth(player.getMaxHealth());
                                player.setExperience(player.getExperience() + 15);
                                player.checkIfLevelUp();
                                player.setCurrency(player.getCurrency() + 20);
                            } else {
                                continueGame = false;
                            }

                        } catch (Exception e) {
                            // Handle invalid input
                            scanner.next();
                            System.out.println("You can only choose from the available numbers");
                        }
                    }

                    case 2 -> {
                        // Player status option
                        if (player.currentWeapon.size() == 1) {
                            System.out.println("Player current status:\n" + player.playerStats());
                            System.out.println("Current weapon:\n" + player.getCurrentWeapon());
                        } else {
                            System.out.println("Player current status:\n" + player.playerStats());
                        }
                    }

                    case 3 -> shop.shopForItems(player); // Shop option

                    case 4 -> {
                        // Exit the game option
                        System.out.println("Exiting the Game");

                        if (player.currentWeapon.size() == 1) {
                            Object playerStats = null;
                            playerStats.toString();
                        }

                        continueGame = false;
                    }

                    default -> System.out.println("Please Choose an available action!.");
                }

            } catch (Exception e) {
                // Handle invalid input
                scanner.next();
                System.out.println("Only numbers are allowed. Try again.");
            }
        } while (continueGame);

        System.out.println(Colors.BLUE_BOLD +
                "=================================================\n" +
                " The adventure concludes. Thank you for playing!\n" +
                "=================================================" + Colors.RESET);
    }
}
