package com.george.java_b_labb;
// Weapon class represents a generic weapon in the game
public class Weapon {
    // Attributes of the weapon
    private final String name;
    private final int damage;
    private final int price;

    // Constructor to create a new Weapon instance with specified attributes
    public Weapon(String name, int damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    // Getter method to retrieve the damage of the weapon
    public int getDamage() {
        return damage;
    }

    // Getter method to retrieve the price of the weapon
    public int getPrice() {
        return price;
    }

    // Override toString method to provide a formatted string representation of the weapon
    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", price=" + price +
                '}';
    }
}