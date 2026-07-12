/**
 * Zachary White
 * Assignment 8.2: ArrayList Max Value 
 * July 09, 2026
 * CSD-402: Java for Programmers
 *
 * Description: 
 * This program demonstrates the use of an ArrayList to store integers 
 * and find the largest value in the list. It includes a method to count the 
 * number of odd integers in the list as well. 
 * The program first runs a series of automated tests to validate the max() method against edge cases
 * then it allows the user to input integers interactively until they enter 0 to stop.
 *
 * Features:
 *   - max() returns 0 for null or empty lists.
 *   - max() uses an enhanced for-loop and Integer.compare().
 *   - Before asking for user input, the program runs a few automated
 *     edge-case tests (empty list, single value, negative numbers) to
 *     prove the method behaves correctly in situations a normal run
 *     might not cover.
 *   - The interactive input loop is written as a do-while loop instead
 *     of a while(true)/break loop.
 *   - The program includes a helper method to read integers with input validation.
 *   - The program includes an additional method to count the number of odd integers in the list
 */
import java.util.ArrayList; // Lets us create and use ArrayList objects
import java.util.Scanner;   // Lets us read input typed by the user

public class ZacharyArrayListTest {

    // --- Returns the largest value in the ArrayList ---
    // Signature kept exactly as specified by the assignment:
    // public static Integer max(ArrayList list)
        // Guard clause: check for a null reference OR an empty list before
        // doing anything else. Without this check, calling list.get(0) on
        // an empty list would throw an IndexOutOfBoundsException, and
        // calling any method on a null reference would throw a
        // NullPointerException. Checking null first matters because Java
        // evaluates || left-to-right and stops as soon as one side is true
        // (this is called "short-circuit evaluation") -- so list.isEmpty()
        // never even runs if list is null, which avoids a crash.
        // More on this here https://www.geeksforgeeks.org/java/array-index-out-of-bounds-exception-in-java/
    public static Integer max(ArrayList list) {
        if (list == null || list.isEmpty()) {
            return 0; // Assignment requirement: empty list returns 0
        }

        // Start with no known largest value yet. Using null here 
        // (instead of assuming the first element is the largest) lets the loop
        Integer largest = null;

        // ("for-each" loop): walks through every element
        // in the list one at a time without needing a counter variable
        // like "int i". Object is used here because the ArrayList was
        // declared as a raw type (ArrayList list), so Java doesn't know
        // ahead of time that it only holds Integers.
            // Cast the generic Object back into an Integer so we can compare it numerically. 
            // If we haven't set a largest value yet (first loop pass),
            // OR the current value is bigger than what we've found so far,
            // update largest. Integer.compare(a, b) returns a positive
            // number if a > b, which is a safer way to compare boxed
            // Integer objects than using > directly (using > still works
            // here due to autoboxing, but Integer.compare is the more
            // "correct" object-oriented approach).
        for (Object obj : list) {
            Integer current = (Integer) obj;
            if (largest == null || Integer.compare(current, largest) > 0) {
                largest = current;
            }
        }
        return largest; // The biggest value found after checking every element
    }

    // --- Odd numbers ---
            // current % 2 gives the remainder after dividing by 2.
            // For odd numbers this remainder is 1 or -1 (negative numbers
            // in Java can produce a negative remainder, e.g. -3 % 2 == -1),
            // so Math.abs() makes sure both cases are caught correctly.
            // https://www.geeksforgeeks.org/java/java-math-abs-method-examples/
    public static int Oddnumbers(ArrayList list) {
        // Same defensive check as max(): don't try to loop over a null
        // or empty list.
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int count = 0; // Running total of how many odd numbers we've found
        for (Object obj : list) {
            Integer current = (Integer) obj; // Cast back to Integer
            if (Math.abs(current % 2) == 1) {
                count++; // Found an odd number, add one to the tally
            }
        }
        return count; // Total odd numbers found in the list
    }

    // --- try/catch validation ---
    // This method exists so main() doesn't have to worry about bad input;
    // it will keep asking until it gets something it can actually use.
    // https://www.geeksforgeeks.org/java/java-try-catch-block/
                // scanner.nextLine() reads the entire line of text the user
                // typed. Integer.parseInt() then tries to convert that
                // text into a number. .trim() removes any accidental extra
                // spaces before or after the number.
                // If the text couldn't be converted to a number (for exmaple the
                // user typed "abc"), parseInt throws this exception. We
                // catch it here so the program doesn't crash, print a
                // friendly message, and the while(true) loop naturally
                // asks the user to try again.
    private static int readInt(Scanner scanner) {
        while (true) { // Loop forever until we successfully return a value
            System.out.print("Enter a number: ");
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid integer. Try again.");
            }
        }
    }

    // --- Runs a set of automated edge-case tests against max() and Oddnumbers() ---
    // "Edge cases" are unusual or extreme inputs (empty, null, negative,
    // all one type of number, etc.) that are easy to forget about but are
    // exactly where bugs like to hide. Testing them automatically means
    // I don't have to manually re-type these scenarios by hand every time
    // I want to check that max() and Oddnumbers() still work correctly.
    private static void runEdgeCaseTests() {
        System.out.println("==========================================");
        System.out.println("Edge-Case Tests for max() and Oddnumbers()");
        System.out.println("==========================================");

        // Test 1: an empty ArrayList. Expected result is 0, per the
        // assignment requirement that an empty list returns 0.
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        System.out.println("Empty list:            max = " + max(emptyList)
                + "  (expected 0)");

        // Test 2: a null reference instead of an actual ArrayList object.
        // This checks that the "list == null" part of the guard clause
        // in max() actually works, not just the "isEmpty()" part.
        ArrayList<Integer> nullList = null;
        System.out.println("Null list:             max = " + max(nullList)
                + "  (expected 0)");

        // Test 3: a list with exactly one value. Confirms the method
        // doesn't require at least two elements to work correctly.
        ArrayList<Integer> singleValue = new ArrayList<Integer>();
        singleValue.add(7);
        System.out.println("Single value [7]:      max = " + max(singleValue)
                + "  (expected 7)");

        // Test 4: all negative numbers. This checks that "largest" isn't
        // accidentally initialized to 0 somewhere (which would be wrong
        // here, since every value is below 0).
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        negatives.add(-5);
        negatives.add(-1);
        negatives.add(-20);
        System.out.println("Negatives [-5,-1,-20]: max = " + max(negatives)
                + "  (expected -1)");

        // Test 5: a mix of positive and negative numbers, also used to
        // test Oddnumbers() at the same time.
        ArrayList<Integer> mixed = new ArrayList<Integer>();
        mixed.add(3);
        mixed.add(-8);
        mixed.add(15);
        mixed.add(4);
        System.out.println("Mixed [3,-8,15,4]:     max = " + max(mixed)
                + "  (expected 15), odd count = " + Oddnumbers(mixed)
                + "  (expected 2)");

        // Test 6: a list where every number is even. Odd count should be 0.
        ArrayList<Integer> allEven = new ArrayList<Integer>();
        allEven.add(2);
        allEven.add(4);
        allEven.add(6);
        System.out.println("All even [2,4,6]:      max = " + max(allEven)
                + "  (expected 6), odd count = " + Oddnumbers(allEven)
                + "  (expected 0)");

        // Test 7: a list where every number is odd. Odd count should
        // equal the size of the list.
        ArrayList<Integer> allOdd = new ArrayList<Integer>();
        allOdd.add(1);
        allOdd.add(3);
        allOdd.add(5);
        System.out.println("All odd [1,3,5]:       max = " + max(allOdd)
                + "  (expected 5), odd count = " + Oddnumbers(allOdd)
                + "  (expected 3)");
        
        // Test 8: a general mix of odd and even numbers together.
        ArrayList<Integer> oddEvenMix = new ArrayList<Integer>();
        oddEvenMix.add(10);
        oddEvenMix.add(15);
        oddEvenMix.add(20);
        System.out.println("Odd/Even mix [10,15,20]: max = " + max(oddEvenMix)
                + "  (expected 20), odd count = " + Oddnumbers(oddEvenMix)
                + "  (expected 1)");

        System.out.println("==========================================\n");
    }

    // --- Test Program ---
    public static void main(String[] args) {
        // Run the automated tests first so the grader/reader can see proof
        // that max() and Oddnumbers() behave correctly on tricky inputs
        // before we ever get to the interactive part of the program.
        runEdgeCaseTests();

        Scanner scanner = new Scanner(System.in); // Set up input reader
        ArrayList<Integer> list = new ArrayList<Integer>(); // Stores user input

        System.out.println("========================================");
        System.out.println("   ArrayList Max Value Finder");
        System.out.println("========================================");
        System.out.println("Enter integers one at a time.");
        System.out.println("Enter 0 to stop.");
        System.out.println("----------------------------------------");

        // Collect user input until 0 is entered.
        // A do-while loop runs its body at least once BEFORE checking the
        // condition, which fits this situation well: we always need to
        // ask for at least one number before we can check whether it was
        // 0. Note that 0 itself still gets added to the list before the
        // loop stops, per the assignment requirements.
        int input;
        do {
            input = readInt(scanner); // Get a validated integer from the user
            list.add(input);          // Add it to the list (including 0)
        } while (input != 0);         // Keep looping as long as input isn't 0

        // Display the ArrayList contents and results
        System.out.println("----------------------------------------");
        System.out.println("Numbers entered: " + list);      // ArrayList's toString() prints it nicely
        System.out.println("Largest value:   " + max(list)); // Call our required method
        System.out.println("Odd numbers:     " + Oddnumbers(list)); // Call our additional method
        System.out.println("========================================");

        scanner.close(); // Always close the Scanner when done with it
    }
}