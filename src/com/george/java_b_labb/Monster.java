package com.george.java_b_labb;

import java.util.Random;

// Monster class implements the Combatant interface
public class Monster implements Combatant {
    static Random random = new Random();

    // Monster attributes
    private final String name;
    private int health;
    private final int minBaseDamage;
    private final int maxBaseDamage;

    // Method to create a new Monster encounter based on the provided type
    public static Monster newMonsterEncounter(int monsterType) {
        if (monsterType == 1) {
            return new Monster("Goblin", 30, 2, 5);
        } else if (monsterType == 2) {
            return new Monster("Serpent", 70, 4, 10);
        } else if (monsterType == 3) {
            return new Monster("Wyvern", 100, 10, 15);
        } else {
            return new Monster("Leviathan", 300, 20, 30);
        }
    }
    // Constructor for creating a Monster instance
    public Monster(String name, int health, int minBaseDamage, int maxBaseDamage) {
        this.name = name;
        this.health = health;
        this.minBaseDamage = minBaseDamage;
        this.maxBaseDamage = maxBaseDamage;
    }

    // Overriding the isAlive method from the Combatant interface
    @Override
    public boolean isAlive() {
        return health > 0;
    }

    // Overriding the fight method from the Combatant interface
    @Override
    public int fight() {
        return calculateDamage();
    }

    // Overriding the calculateDamage method from the Combatant interface
    @Override
    public int calculateDamage() {
        // Calculate a random damage value within the specified range
        return random.nextInt(minBaseDamage, maxBaseDamage + 1);
    }

    // Method for the Monster to defend against a Player's attack
    public void defend(Player player) {
        int damageTaken = player.fight();
        health -= damageTaken;
        System.out.println("\nMonster took " + damageTaken + " damage.");
    }

    // Setter method to update the Monster's health
    public void setHealth(int health) {
        this.health = health;
    }

    // Getter method to retrieve the Monster's name
    public String getName() {
        return name;
    }

    // Method to get a formatted string of Monster statistics
    public String monsterStats() {
        return "Monster{" +
                "name = '" + name + '\'' +
                ", health = " + health +
                '}';
    }
}