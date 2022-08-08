package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //emoji
        final String attack = "\uD83D\uDD2A";
        final String runner = "\uD83C\uDFC3";
        final String healthy = "\uD83C\uDFE5";



        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;  // percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        // giving a label to this while

        GAME:
        while (running) {
            System.out.println("------------------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appreared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You Strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health portion, healing yourself for " + healthPotionHealAmount + "."
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numHealthPotions + " health portion(s) left.\n");
                    } else {
                        System.out.println("\t> You have noo health portions left! Defeat enemies for a chance to get one!\n");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t>You run away from the " + enemy + "!");
                    continue GAME;
                } else {
                    System.out.println("\tInvalid command!");
                }

            }

            //
            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle");
                break;
            }


            System.out.println("------------------------------------------------");
            System.out.println(" # " + enemy + "was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health portion! #");
                System.out.println(" # You now have " + numHealthPotions + " health portion(s). #");
            }
            System.out.println("------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command");
                input = in.nextLine();
            }

            if(input.equals("1")){
                System.out.println("You continue on your adventure!");
            }else if(input.equals("2")){
                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }
        }

        System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");

    }
}
