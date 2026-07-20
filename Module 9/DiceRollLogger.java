/*
 * Name: Zachary White
 * Instructor: Darrell Payne
 * Assignment 9.2: Random Number File I/O
 * July 15, 2026
 * CSD-402: Java for Programmers
 *
 * Description: Creates a file named rolls.log if it doesn't already
 * exist. Rolls a simulated 100-sided die 10 times, appending the
 * results to the file separated by spaces. The file is then closed,
 * reopened, and its full contents are read back and printed.
 */

import java.io.*;
import java.nio.file.*;
import java.util.Random;

public class DiceRollLogger {

    private static final String FILE_NAME = "rolls.log";
    private static final int ROLLS_PER_SESSION = 10;
    private static final int DIE_SIDES = 100; // rolls 1-100

    public static void main(String[] args) {
        Path logPath = Paths.get(FILE_NAME);

        try {
            prepareFile(logPath);
            String newRolls = rollDice();
            appendRollsToFile(logPath, newRolls);

            System.out.println("----------------------------------------");
            System.out.println("Reading back " + FILE_NAME + ":");
            displayFileContents(logPath);

        } catch (IOException ex) {
            System.out.println("Something went wrong reading or writing " + FILE_NAME + ".");
            ex.printStackTrace();
        }
    }

    // Creates the log file only if it isn't already sitting on disk
    private static void prepareFile(Path logPath) throws IOException {
        if (Files.notExists(logPath)) {
            Files.createFile(logPath);
            System.out.println(FILE_NAME + " did not exist, so it was created.");
        } else {
            System.out.println(FILE_NAME + " already exists, new rolls will be appended.");
        }
    }

    // Generates 10 random "dice roll" values as a single space-separated line
    private static String rollDice() {
        Random dice = new Random();
        StringBuilder session = new StringBuilder();

        for (int roll = 0; roll < ROLLS_PER_SESSION; roll++) {
            int result = dice.nextInt(DIE_SIDES) + 1; // 1 to DIE_SIDES
            session.append(result);
            if (roll < ROLLS_PER_SESSION - 1) {
                session.append(" ");
            }
        }
        session.append(System.lineSeparator());
        return session.toString();
    }

    // Opens the file in append mode, writes the roll line, then closes it
    private static void appendRollsToFile(Path logPath, String rollLine) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(logPath.toFile(), true));
        writer.write(rollLine);
        writer.close();
        System.out.println(ROLLS_PER_SESSION + " new rolls appended to " + FILE_NAME + ".");
    }

    // Reopens the file for reading and prints every line it contains
    private static void displayFileContents(Path logPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(logPath.toFile()));
        String line;
        int sessionNumber = 1;
        while ((line = reader.readLine()) != null) {
            System.out.println("Session " + sessionNumber + ": " + line);
            sessionNumber++;
        }
        reader.close();
    }
}
