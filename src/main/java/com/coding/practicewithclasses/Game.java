package com.coding.practicewithclasses;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int playerHP = 10;

            System.out.print("Enter your name: ");
            String playerName = scanner.nextLine();

            System.out.println("Welcome, " + playerName + "! Your character starts with 10 HP.");

            while (playerHP > 0) {
                System.out.println("Options:");
                System.out.println("1. Look for a fight");
                System.out.println("2. Check your stats");
                System.out.println("0. Leave the game");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Thanks for playing, " + playerName + "!");
                    break;
                } else if (choice == 1) {
                    // Generate an enemy with HP within the range of (playerHP - 5) to (playerHP + 5)
                    int enemyHP = random.nextInt(11) + (playerHP - 5);

                    System.out.println("You encountered an enemy!");

                    System.out.print("Do you want to fight (1 for yes, 0 for no)? ");
                    int fightChoice = scanner.nextInt();

                    if (fightChoice == 1) {
                        if (random.nextBoolean()) {
                            playerHP += 5;
                            System.out.println("You defeated the enemy and gained 5 HP. Your HP is now " + playerHP
                                                + "\n");
                        } else {
                            playerHP -= 5;
                            System.out.println("The enemy was too strong, and you lost 5 HP. Your HP is now " + playerHP
                                                + "\n");
                        }
                    } else {
                        System.out.println("You chose not to fight the enemy.");
                    }
                } else if (choice == 2) {
                    System.out.println("Your current HP is " + playerHP);
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }

                if (playerHP <= 0) {
                    System.out.println("Game over! Your character's HP reached 0.");
                }
            }
    }
}
