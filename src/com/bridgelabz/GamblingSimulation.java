package com.bridgelabz;

import java.util.Random;

public class GamblingSimulation {
    public static final int STAKE = 100;
    public static final int BET = 1;
    public static final float STAKE_VALUE=0.5f;
    public int winningAmount, losingAmount,stake;

    /**
     * @UC-2 :Win or Lose
     */
    public void winOrLoss(){
        Random random = new Random();
        int value= random.nextInt(2);
        if(value == 1) {
            System.out.println("WON BET");
            stake++;
        }
        else {
            System.out.println("LOST BET");
            stake--;
        }
    }

    /**
     * @UC-3 Resign for day if loss reached 50 and gain reached 150
     */
    public int resignStake(){
        losingAmount = (int) Math.round(STAKE*STAKE_VALUE);
        winningAmount =(int)Math.round(STAKE+(STAKE*STAKE_VALUE));
        boolean stop = true;
        stake = STAKE;
        while(stop == true){

            winOrLoss();
            if(stake == losingAmount){
                stop = false;
            }
            if(stake == winningAmount){
                stop = false;
            }
        }
        return stake;
    }

    public static void main(String[] args) {
        GamblingSimulation gamblerSimulation = new GamblingSimulation();
        System.out.println("WELCOME TO GAMBLING SIMULATION PROGRAM");
        System.out.println(gamblerSimulation.resignStake());
    }
}
