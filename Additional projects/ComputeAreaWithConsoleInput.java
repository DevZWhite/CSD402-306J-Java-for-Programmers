/*
This program showcases basic user input performs calculation then prints a result
*/

import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number for the radius value:");
        double radius = input.nextDouble();
        double area = radius * radius * 3.14159;
        System.out.println("The calculated area of the circle with the given 10" + radius + " radius" + " " + "is" + " " + area);
    }
    
}
