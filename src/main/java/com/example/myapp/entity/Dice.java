package com.example.myapp.entity;

import java.util.Random;

public class Dice {
    int noOfDice = 1;
    Random random;
    int rolledDice = 0;
    boolean shouldSupportMMultipleDice = false;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
        random = new Random();
    }

    public Dice(int noOfDice, boolean shouldSupportMMultipleDice) {
        this.noOfDice = noOfDice;
        random = new Random();
        this.shouldSupportMMultipleDice = shouldSupportMMultipleDice;
    }

    public boolean rollDice() {
        int low = noOfDice;
        int high = noOfDice * 6;
        int dice = random.nextInt(high - low) + low;
        rolledDice += dice;
        return dice % high == 0;
    }

    public int getRolledDice() {
        int diceValue = rolledDice % (3 * noOfDice * 6);
        rolledDice = 0;
        return diceValue;
    }



}
