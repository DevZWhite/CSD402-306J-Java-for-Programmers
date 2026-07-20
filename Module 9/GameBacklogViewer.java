/*
 * Name: Zachary White
 * Instructor: Darrell Payne
 * Assignment 9.2: ArrayList / Exception Handling
 * July 15, 2026
 * CSD-402: Java for Programmers
 *
 * Description: Builds an ArrayList of at least 10 Strings representing
 * a video game backlog, prints it out with a for-each loop, then lets
 * the user re-view one entry by index. The lookup is wrapped in a
 * try/catch block so an invalid index prints "Out of Bounds" instead
 * of crashing. The user's typed input is boxed into an Integer object
 * and later auto-unboxed back to a primitive int when it's handed to
 * the ArrayList's get() method.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GameBacklogViewer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Minimum 10 Strings in the ArrayList
        ArrayList<String> backlog = new ArrayList<>();
        backlog.add("The Legend of Zelda: Tears of the Kingdom");
        backlog.add("Elden Ring");
        backlog.add("Hades II");
        backlog.add("Baldur's Gate 3");
        backlog.add("Metroid Prime Remastered");
        backlog.add("Final Fantasy VII Rebirth");
        backlog.add("Hollow Knight: Silksong");
        backlog.add("Persona 5 Royal");
        backlog.add("Chrono Trigger");
        backlog.add("Stardew Valley");
        backlog.add("Celeste");

        printBacklog(backlog);

        System.out.print("\nEnter the index (starting at 0) of the title you want to view again: ");
        String rawInput = input.nextLine();

        // Autoboxing: the primitive-like text is parsed and boxed into an Integer object
        Integer chosenIndex = Integer.valueOf(rawInput);

        try {
            // Auto-unboxing: Integer -> int happens automatically when passed to get()
            String chosenGame = backlog.get(chosenIndex);
            System.out.println("\nYou picked #" + chosenIndex + ": " + chosenGame);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("\nException thrown: Out of Bounds");
        }

        System.out.println("\nThanks for checking the backlog!");
        input.close();
    }

    // Prints the backlog using a for-each loop, numbered starting at 1
    private static void printBacklog(ArrayList<String> games) {
        System.out.println("=== My Current Game Backlog ===");
        int index = 0;
        for (String title : games) {
            System.out.println("[" + index + "] " + title);
            index++;
        }
    }
}
