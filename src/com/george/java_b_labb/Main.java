package com.george.java_b_labb;

public class Main {

    public static void main(String[] args) {
        // Creating a new instance of the Game class to initialize and start the game.
        // The playGame variable holds the reference to the game instance.
        Game playGame = new Game();

        // Welcome message and game information
        System.out.println(Colors.BLUE_BOLD +
                "========================================\n" +
                " Hello and welcome to my Java_B project\n" +
                "         'Dungeon Run' GAME!\n" +
                "   (C) GEORGE YOUSSEF - STI 2023\n" +
                "========================================" + Colors.RESET);

        //Game start and the Player have to put his name
        System.out.println("Please enter your name: ");

        // Invoking the mainMenu method from the playGame instance to initiate and display the main menu of the game.
        playGame.mainMenu();
    }
}