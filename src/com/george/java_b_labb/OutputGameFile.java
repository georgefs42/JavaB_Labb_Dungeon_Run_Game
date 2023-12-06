package com.george.java_b_labb;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.io.FileWriter;
import java.io.IOException;

@RunWith(Enclosed.class)
public class OutputGameFile {

    // Constant for the output file name
    private static final String OUTPUT_FILE_NAME = "OutputGameFile.txt";

    /**
     * Main method to demonstrate writing player stats to a file.
     * Creates a Player instance and writes its stats to the output file.
     */
    public static void main(String[] args) {
        // Create a Player instance
        Player player = new Player();

        // Write player stats to the output file
        writePlayerStatsToFile(player, OUTPUT_FILE_NAME);
    }

    /**
     * Writes the player's stats to the specified output file.
     *
     * @param player   The Player instance whose stats will be written.
     * @param fileName The name of the output file.
     */
    public static void writePlayerStatsToFile(Player player, String fileName) {
        try (FileWriter playerFileWriter = new FileWriter(fileName)) {
            // Write player stats to the file
            playerFileWriter.write(
                    player.getPlayerName() +
                            "\nLevel reached: " + player.getLevel() +
                            "\nWeapon used: " + player.getCurrentWeapon() +
                            "\nMonsters defeated: " + player.getMonstersKilled()
            );

            // Inform the user about the successful write
            System.out.println("Check the text-file named '" + fileName + "' to see final score stats.");
        } catch (IOException e) {
            // Handle IOException (e.g., file not found, permission issues)
            e.printStackTrace();
            System.out.println("Error writing to file: " + fileName);
        }
    }
}
