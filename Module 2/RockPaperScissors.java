/*/ 
Author:     Zachary D. White
Instructor: Professor; Darrell Payne
Date:       June 10,2026
Assignment: Module 2 - Rock-Paper-Scissors Game

Description:
Rock-Paper-Scissors Game in Java
This is a simple console-based implementation of the classic Rock-Paper-Scissors game in Java. 
The user can play against the computer, which randomly selects its choice. 
The game keeps track of wins, losses, and ties, 
and displays the final results when the user decides to quit.

Instructions:
1. Compile and run the RockPaperScissors.java
2. Follow the on-screen prompts to enter your choice:
   - Enter 1 for Rock
   - Enter 2 for Paper
   - Enter 3 for Scissors
   - Enter 0 to Quit the game
3. After each round, the game will display the choices made by both the user and the computer,
   the result of the round (win, lose, or tie), and the current record of wins, losses, and ties.
4. When you choose to quit, the game will display the final results of your gaming session, including total games played, wins, losses, ties, and win rate.
/*/ 

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
// Method to convert numeric choice to string representation
    public static String getSelection(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "Unknown";
        }
    }
// Determine the result of the game based on user and computer choices
    public static String getResult(int userChoice, int opponentChoice) {
        if (userChoice == opponentChoice) return "TIE";
        if ((userChoice == 1 && opponentChoice == 3) ||
            (userChoice == 2 && opponentChoice == 1) ||
            (userChoice == 3 && opponentChoice == 2)) {
            return "WIN";
        }
        return "LOSE";
    }
// Main method to run the Rock-Paper-Scissors game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random   = new Random();

        int wins   = 0;
        int losses = 0;
        int ties   = 0;
//  Display the game title and instructions
        System.out.println("========================================");
        System.out.println("        ROCK - PAPER - SCISSORS         ");
        System.out.println("========================================");
// Game loop to continuously play until the user decides to quit
        while (true) {
            System.out.println("\n  1 = Rock  |  2 = Paper  |  3 = Scissors  |  0 = Quit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");
            int userChoice = -1;
//  Input validation to ensure the user enters a valid choice
            while (userChoice < 0 || userChoice > 3) {
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                    if (userChoice < 0 || userChoice > 3) {
                        System.out.print("Invalid input. Enter 0 to quit or 1, 2, 3 to play: ");
                    }
                } else {
                    scanner.next();
                    System.out.print("Invalid input. Enter 0 to quit or 1, 2, 3 to play: ");
                }
            }
            if (userChoice == 0) {
                break;
            }
//  Computer randomly selects its choice
            int opponentChoice = random.nextInt(3) + 1;
            String result = getResult(userChoice, opponentChoice);
//  Display the choices and result of the round
            System.out.println("\n----------------------------------------");
            System.out.printf("  You chose     : %s%n", getSelection(userChoice));
            System.out.printf("  Opponent chose: %s%n", getSelection(opponentChoice));
            System.out.println("----------------------------------------");

            switch (result) {
                case "WIN":
                    wins++;
                    System.out.printf("  %s beats %s - You WIN!%n",
                            getSelection(userChoice), getSelection(opponentChoice));
                    break;
                case "LOSE":
                    losses++;
                    System.out.printf("  %s beats %s - You LOSE!%n",
                            getSelection(opponentChoice), getSelection(userChoice));
                    break;
                case "TIE":
                    ties++;
                    System.out.printf("  Both chose %s - It's a TIE!%n",
                            getSelection(userChoice));
                    break;
            }
//  Display the current record of wins, losses, and ties after each round
            System.out.println("----------------------------------------");
            System.out.printf("  Record -> Wins: %d  |  Losses: %d  |  Ties: %d%n",
                    wins, losses, ties);
            System.out.println("========================================");
        }

//  Display final results of the game session
        int totalGames = wins + losses + ties;
        System.out.println("\n========================================");
        System.out.println("             FINAL RESULTS              ");
        System.out.println("========================================");
        System.out.printf("  Total Games : %d%n", totalGames);
        System.out.printf("  Wins        : %d%n", wins);
        System.out.printf("  Losses      : %d%n", losses);
        System.out.printf("  Ties        : %d%n", ties);
        if (totalGames > 0) {
            double winPct = (wins * 100.0) / totalGames;
            System.out.printf("  Win Rate    : %.1f%%%n", winPct);
        }
        System.out.println("========================================");
        System.out.println("       Thanks for playing. Goodbye!     ");
        System.out.println("========================================");

        scanner.close();
    }
}