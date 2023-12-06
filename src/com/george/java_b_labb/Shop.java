package com.george.java_b_labb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Shop class for handling player interactions with the in-game shop
public class Shop {
    // List to store available weapons in the shop
    List<Weapon> weaponList = new ArrayList<>();

    // Method to initiate shopping for items in the shop
    public void shopForItems(Player player) {

        System.out.println("===== WELCOME TO THE GAME SHOP =====\nPlease select a weapon for purchase:\n" + getWeaponList());


        boolean isShopping = true;
        Scanner scanner = new Scanner(System.in);

        // Loop to allow the player to continue shopping until they choose to exit
        do {
            System.out.println("Player's currency: " + player.getCurrency());
            System.out.println("""
                    1 - Cleaver   - price: 50
                    2 - Knife - price: 70
                    3 - Spear   - price: 200
                    4 - Exit the shop
                    ==============================""");

            try {
                // Switch statement to handle player choices in the shop
                switch (scanner.next()) {
                    case "1" -> {
                        if (checkIfOutOfCurrency(player)) {
                            isShopping = false;
                        } else if (player.getCurrency() - weaponList.get(0).getPrice() <= 0) {
                            System.out.println("No Money to purchase this item.");
                        } else {
                            System.out.println("You bought a Cleaver for " + weaponList.get(0).getPrice());
                            player.setCurrency(player.getCurrency() - weaponList.get(0).getPrice());
                            player.getCurrentWeapon().add(weaponList.get(0));
                        }
                    }
                    case "2" -> {
                        if (checkIfOutOfCurrency(player)) {
                            isShopping = false;
                        } else if (player.getCurrency() - weaponList.get(1).getPrice() <= 0) {
                            System.out.println("No Money to purchase this item.");
                        } else {
                            System.out.println("You bought a Knife for " + weaponList.get(1).getPrice());
                            player.setCurrency(player.getCurrency() - weaponList.get(1).getPrice());
                            player.getCurrentWeapon().add(weaponList.get(1));
                        }
                    }
                    case "3" -> {
                        if (checkIfOutOfCurrency(player)) {
                            isShopping = false;
                        } else if (player.getCurrency() - weaponList.get(2).getPrice() <= 0) {
                            System.out.println("No Money to purchase this item.");
                        } else {
                            System.out.println("You bought a Spear for " + weaponList.get(2).getPrice());
                            player.setCurrency(player.getCurrency() - weaponList.get(2).getPrice());
                            player.getCurrentWeapon().add(weaponList.get(2));
                        }
                    }
                    case "4" -> {
                        System.out.println("Exiting the shop!");
                        isShopping = false;
                    }
                    default -> System.out.println("Please choose an item.");
                }

            } catch (Exception e) {
                scanner.next();
                System.out.println("Try Again!");
            }
        } while (isShopping);
    }

    // Method to check if the player is out of currency
    public boolean checkIfOutOfCurrency(Player player) {
        if (player.getCurrency() <= 0) {
            System.out.println("Insufficient funds! Thank you, visit us again when your coffers are fuller.");
            return true;
        } else {
            return false;
        }
    }

    // Method to add weapons to the shop's weapon list
    public void addWeaponToList() {
        weaponList.add(new Cleaver("Cleaver", 15, 50));
        weaponList.add(new Knife("Knife", 10, 70));
        weaponList.add(new Spear("Spear", 30, 200));
    }

    // Getter method to retrieve the shop's weapon list
    public List<Weapon> getWeaponList() {
        return weaponList;
    }
}