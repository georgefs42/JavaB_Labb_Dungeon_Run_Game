package com.george.java_b_labb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.george.java_b_labb.Colors.*;

// The Player class implements the Combatant interface
public class Player implements Combatant{
    private static final String RESET = String.valueOf(0);
    public Random random = new Random();

    // Player stats
    private String playerName;
    private int strength = 0;
    private int intelligence = 0;
    private int agility = 0;
    private int health = 50;
    private int maxHealth = 50;
    private int level = 1;
    private int minDamage = 5;
    private int maxDamage = 10;
    private int currency = 0;
    private int experience = 0;
    private int maxExperience = 20;
    private int monstersDestroyed = 0;

    // List to store the current weapon(s) of the player
    List<Weapon> currentWeapon = new ArrayList<>();

    // Overriding the isAlive method from the Combatant interface
    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    // Method to check if the player leveled up
    public void checkIfLevelUp() {

        if (experience >= maxExperience) {
            System.out.println("\nLEVEL UP!\nCongratulations! Your prowess has grown, enhancing your abilities!");

            level += 1;
            experience = 0;
            maxExperience += 15;
            maxHealth += 10;
            health = maxHealth;
            strength += 2;
            intelligence += 2;
            agility += 2;
            minDamage += 1;
            maxDamage += 1;
        }
    }

    // Overriding the fight method from the Combatant interface
    @Override
    public int fight() {
        return calculateDamage();
    }
    // Overriding the calculateDamage method from the Combatant interface
    @Override
    public int calculateDamage() {

        int damageDone = 0;
        int noWeaponDamage = ((random.nextInt(minDamage, maxDamage)) + strength);

        if (currentWeapon.isEmpty()) {
            // If the player has no weapon, calculate damage without a weapon
            if ( intelligence >= random.nextInt(1,30) ) {
                damageDone += noWeaponDamage * 2;
            }else {
                damageDone += noWeaponDamage;
            }
        } else { // If the player has a weapon, calculate damage with the weapon
            if ( intelligence >= random.nextInt(1,30) ) {
                damageDone += ((noWeaponDamage + currentWeapon.get(0).getDamage()) * 2);
            }else {
                damageDone += noWeaponDamage + currentWeapon.get(0).getDamage();
            }
        }
        return damageDone;
    }
    // Method to handle player defending against a monster
    public void defend(Monster monster) {

        if (playerDidDodge()) {
            System.out.println("You skillfully evaded the monster's strike, narrowly avoiding its attack.");
        } else {
            int damageTaken = monster.fight();

            // Display the damage taken and update player health
            System.out.println("You took " + damageTaken + " damage.");
            health -= damageTaken;

            // Check if the player's health goes below zero
            if (health <= 0) {
                System.out.println("Your journey ends here. The shadows claim you, and the game comes to a somber conclusion. " + monster.getName() + " Win the Game!");
            }
        }
    }
    // Method to check if the player dodged an attack
    public boolean playerDidDodge() {

        boolean didDodge;
        int dodge = random.nextInt(1,50);
        // Calculate if the dodge was successful based on player agility
        didDodge = dodge >= 1 && dodge <= getAgility();

        return didDodge;
    }

    // Method to check if the player decides to flee
    public boolean playerDidFlee() {
        return random.nextInt(10) == 1;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getAgility() {
        return agility;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getLevel() {
        return level;
    }
    public int getMinDamage() {
        return minDamage;
    }
    public int getMaxDamage() {
        return maxDamage;
    }
    public int getCurrency() {
        return currency;
    }
    public void setCurrency(int currency) {
        this.currency = currency;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
        checkIfLevelUp();
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getMaxExperience() {
        return maxExperience;
    }
    public int getMonstersKilled() {
        return monstersDestroyed;
    }
    public void setMonstersKilled(int monstersKilled) {
        this.monstersDestroyed = monstersKilled;
    }
    public List<Weapon> getCurrentWeapon() {
        return currentWeapon;
    }
    public String playerStats() {
        return  Colors.RED_BOLD + "PLAYER STATS: " + Colors.RESET + BLUE +
                "\n- PLAYER'S NAME: " + playerName + Colors.BLUE +
                "\n- STRENGTH: " + RESET + strength +
                "\n- INTELLIGENCE: " + RESET + intelligence +
                "\n- AGILITY: " + RESET + agility +
                "\n- HEALTH: " + RESET + health +
                "\n- LEVEL: " + RESET + level +
                "\n- MIN DAMAGE: " + RESET + minDamage +
                "\n- MAX DAMAGE: " + RESET + maxDamage +
                "\n- CURRENCY: " + RESET + currency +
                "\n- EXPERIENCE: " + RESET + experience + RESET + RED_BOLD +
                "\n- ===============================" + Colors.RESET;
    }
}