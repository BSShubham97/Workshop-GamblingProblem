package com.bridgelabz;

import java.util.Random;

public class GamblingSimulation {
    public static final int STAKE = 100;
    public static final int BET = 1;

    /**
     * @UC-2 :Win or Lose
     */
    public void winOrLoss(){
        Random random = new Random();
        int value= random.nextInt(2);
        if(value == 1)
            System.out.println("WON BET");
        else
            System.out.println("LOST BET");
    }

    public static void main(String[] args) {
        GamblingSimulation gamblerSimulation = new GamblingSimulation();
        System.out.println("WELCOME TO GAMBLING SIMULATION PROGRAM");
        gamblerSimulation.winOrLoss();
    }
}
