package com.coding.turnbasedgame;

import java.util.Random;
import java.util.Scanner;

public class TurnBasedGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int playerHP = 10;  // Initialize playerHP to 10
        int enemyHP = 0;  // Initialize enemyHP to 0
        boolean inBattle = false;

        // Intro to game
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("Welcome, " + playerName + "! Your character starts with 10 HP.");

        // In-game loop
        while (playerHP > 0) {
            System.out.println("Options:");
            if (!inBattle) {
                System.out.println("1. Look for a fight");
            } else {
                System.out.println("1. Attack");
            }
            System.out.println("2. Check your stats");
            if (!inBattle) {
                System.out.println("0. Leave the game");
            } else {
                System.out.println("3. Leave battle (Lose 5 HP)");
            }
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("\nThanks for playing, " + playerName + "!");
                break;
            } else if (choice == 1) {
                if (!inBattle) {
                    // Generate an enemy with random HP
                    enemyHP = random.nextInt(10 + 1) + (playerHP - 5);
                    System.out.println("\nYou encountered an enemy with " + enemyHP + " HP!");
                    inBattle = true;
                }

                // Attack phase
                int damage = random.nextInt(playerHP) + 1;
                System.out.println("\nYou attack for " + damage + " damage!");

                enemyHP -= damage;

                // Check if the enemy is defeated
                if (enemyHP <= 0) {
                    System.out.println("\nYou defeated the enemy!");
                    playerHP += 5;
                    System.out.println("\nYou gained 5 HP. Your HP is now " + playerHP);
                    inBattle = false;
                } else {
                    // Enemy attacks back
                    damage = random.nextInt(enemyHP) + 1;
                    System.out.println("\nThe enemy attacks for " + damage + " damage!");

                    playerHP -= damage;

                    if (playerHP <= 0) {
                        System.out.println("\nYou were defeated. Game over!");
                    } else {
                        System.out.println("\nYour HP is now " + playerHP);
                        System.out.println("The enemy's HP is now " + enemyHP + "\n");
                    }
                }
            } else if (choice == 2) {
                System.out.println("\nYour current HP is " + playerHP);
            } else if (choice == 3) {
                System.out.println("You left the battle. -5 HP");
                playerHP -= 5;
            } else {
                System.out.println("\nInvalid choice. Please select a valid option.");
            }
        }
    }
}