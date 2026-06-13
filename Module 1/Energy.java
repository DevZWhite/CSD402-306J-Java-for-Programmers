/*
   Program Name: Energy.java
   Author: Zachary White
   Date: June 4, 2026
   Course: CSD402 - Module 1 Darrell Payne

   Requirements:
   JDK Version: 26.0.1

 * Description:
    This is a simple console application that calculates the energy required to heat a given amount of water 
    from an initial temperature to a final temperature. The user is prompted to enter the mass of water in kilograms, 
    the initial temperature in Celsius, and the final temperature in Celsius. The program then uses the formula Q = m * c * ΔT, 
    where c is the specific heat capacity of water (4184 J/kg°C), to calculate and display the energy needed in Joules.
*/

import java.util.Scanner;

public class Energy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // This will prompt the user to enter the amount of water, initial temperature, and final temperature
        System.out.print("Enter the amount of water in kilograms: ");
        double waterMass = input.nextDouble();

        System.out.print("Enter the initial temperature (Celsius): ");
        double initialTemperature = input.nextDouble();

        System.out.print("Enter the final temperature (Celsius): ");
        double finalTemperature = input.nextDouble();

        // calculate the energy needed using the formula Q = m * c * ΔT
        double Q = waterMass * (finalTemperature - initialTemperature) * 4184;

        // Displays the energy needed in Joules to the user
        System.out.printf("The energy needed is %.2f Joules.%n", Q);

        input.close();
    }
}