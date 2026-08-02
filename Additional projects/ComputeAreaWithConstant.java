// Module 2.4 computing an area using constants
import java.util.Scanner;

public class ComputeAreaWithConstant {
    public static void main(String[] args) {
        final double PI = 3.14159;
    
    // create a scanner object
    Scanner input = new Scanner(System.in);
    // prompt the user to enter a radius
    System.out.println("Please enter a number for radius");
    double radius = input.nextDouble();
    // compute area
    double area = radius * radius * PI;
    // show results
    System.out.println("The area for circle of radius " + radius + " is " + area);

    input.close();
    }
}