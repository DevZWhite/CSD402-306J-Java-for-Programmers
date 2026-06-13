package CSD402;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


/* 
   Program Name: Helloworld.java 
   this program requests the user to enter their name and date of birth then prints "Hi my name is [name] and I was born on [date of birth]"
   this program features input validation to ensure the user enters a valid date of birth in the format MM/DD/YYYY. If the user enters an invalid date, the program will prompt them to enter it again until a valid date is provided. After displaying the initial message,
   the console then tells the user how old they are in years, months, and days based on the current date and the date of birth entered by the user.
*/


public class Helloworld {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        while (name.trim().isEmpty()) {
            System.out.print("Name cannot be empty. Please enter your name: ");
            name = input.nextLine();
        }
        System.out.print("Please enter your date of birth (MM/DD/YYYY): ");
        String dobInput = null;
        while (true) {
            String line = input.nextLine();
            if (!line.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.print("Invalid date format. Please enter your date of birth (MM/DD/YYYY): ");
                continue;
            }
            String[] tryParts = line.split("/");
            int month = Integer.parseInt(tryParts[0]);
            int day = Integer.parseInt(tryParts[1]);
            int year = Integer.parseInt(tryParts[2]);
            try {
                LocalDate birth = LocalDate.of(year, month, day);
                if (birth.isAfter(LocalDate.now()) || year <= 1900) {
                    System.out.print("Invalid date. Please enter your date of birth (MM/DD/YYYY): ");
                    continue;
                }
                dobInput = line;
                break;
            } catch (Exception e) {
                System.out.print("Invalid date. Please enter your date of birth (MM/DD/YYYY): ");
            }
        }

        System.out.println("Hi my name is " + name + " and I was born on " + dobInput + ".");
        String[] parts = dobInput.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
        input.close();
    }
}

