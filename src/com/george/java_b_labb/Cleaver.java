package com.george.java_b_labb;
// Cleaver class is a subclass of the Weapon class
public class Cleaver extends Weapon {
    // Constructor for creating a Cleaver instance
    public Cleaver(String name, int damage, int price) {
        // Call the constructor of the superclass (Weapon) with the provided parameters
        super(name, damage, price);
    }
}
