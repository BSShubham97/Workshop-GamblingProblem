package com.bridgelabz;

import java.util.Random;

public class GamblingSimulation {
    public static final int STAKE = 100;
    public static final int BET = 1;
    public static final float STAKE_VALUE = 0.5f;
    public int winningAmount, losingAmount, stake;
    public int totalStake = 0;
    public int lostBet = 0;
    public int wonBet = 0;
    int unluckyDay;
    int luckyDay;

    /**
     * @UC-2 :Win or Lose
     */
    public void winOrLoss() {
        Random random = new Random();
        int value = random.nextInt(2);
        if (value == 1)
            stake++;
        else
            stake--;
    }

    /**
     * @UC-3 Resign for day if loss reached 50 and gain reached 150
     */
    public int resignStake() {
        losingAmount = (int) Math.round(STAKE * STAKE_VALUE);
        winningAmount = (int) Math.round(STAKE + (STAKE * STAKE_VALUE));
        boolean stop = true;
        stake = STAKE;
        while (stop == true) {

            winOrLoss();
            if (stake == losingAmount) {
                stop = false;
                lostBet++;

            }
            if (stake == winningAmount) {
                stop = false;
                wonBet++;
            }
        }
        return stake;
    }

    /**
     * @UC-4 Total after playing for 20 days
     */
    public int giveTotal() {
        int i;
        for (i = 1; i <= 20; i++) {
            System.out.println("Day " + i + " result: " + resignStake());
            totalStake = totalStake + stake;
            System.out.println("Total stake on day " + i + " is " + totalStake);

        }
        return totalStake;
    }

    /**
     * @UC-5 give total times won or lost
     */
    public void giveWonOrLostTimes() {
        System.out.println("_____________________________________________________________");
        System.out.println("Total times won: " + wonBet);
        System.out.println("Total times lost: " + lostBet);
    }

        /**
         * @UC-6 Lucky and Unlucky day
         */
        public void luckyUnlucky() {
            int i;
            for (i = 1; i <= 20; i++) {
                System.out.println("Day " + i + " result: " + resignStake());
                if (stake == 50)
                    unluckyDay = i;
                else if (stake == 150)
                    luckyDay = i;
            }
            System.out.println("Unlucky Day was : " + unluckyDay+" DAY");
            System.out.println("Lucky Day was  : " + luckyDay+" DAY");
        }

        public static void main (String[]args){
            GamblingSimulation gamblerSimulation = new GamblingSimulation();
            System.out.println("WELCOME TO GAMBLING SIMULATION PROGRAM");
//            System.out.println("-------------------------------------------------------------");
//            System.out.println("Total winnings till date: " + gamblerSimulation.giveTotal());
//            gamblerSimulation.giveWonOrLostTimes();
           System.out.println("-------------------------------------------------------------");
            gamblerSimulation.luckyUnlucky();
        }
    }