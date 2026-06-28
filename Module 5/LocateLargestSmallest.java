/*
Name: Zachary D. White
Instructor: Darrell Payne
Class: CSD-402
Date: 06/26/2026

Description:
 * This program finds the location (row and column) of the largest
 * and smallest elements inside a 2D array. It uses overloaded methods
 * so it works with both double[][] and int[][] arrays.
 *
 * The four required methods are:
 *   locateLargest(double[][])
 *   locateLargest(int[][])
 *   locateSmallest(double[][])
 *   locateSmallest(int[][])
 *
 * Each method returns a small int[] with two values: {row, col}
 */


public class LocateLargestSmallest {

    // ----------------------------------------------------------------
    // locateLargest — double[][]
    //
    // Searches a 2D double array for its largest value.
    // Returns a 1D int array where [0] = row index, [1] = col index.
    // ----------------------------------------------------------------
    public static int[] locateLargest(double[][] arrayParam) {

        // Start by assuming the very first element is the largest
        int[] location = {0, 0};
        double largest = arrayParam[0][0];

        // Loop through every row in the 2D array
        for (int row = 0; row < arrayParam.length; row++) {

            // Loop through every column in the current row
            for (int col = 0; col < arrayParam[row].length; col++) {

                // If we find something bigger, update our largest value
                // and save where we found it
                if (arrayParam[row][col] > largest) {
                    largest      = arrayParam[row][col];
                    location[0]  = row;
                    location[1]  = col;
                }
            }
        }

        // Return the {row, col} location of the largest element
        return location;
    }

    // ----------------------------------------------------------------
    // locateLargest — int[][]
    //
    // Same logic as above, but works with an int[][] instead.
    // Java picks this version automatically when we pass an int[][].
    // ----------------------------------------------------------------
    public static int[] locateLargest(int[][] arrayParam) {

        // Assume the first element is the largest until we find otherwise
        int[] location = {0, 0};
        int largest = arrayParam[0][0];

        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++) {

                // New largest found — update value and save its position
                if (arrayParam[row][col] > largest) {
                    largest     = arrayParam[row][col];
                    location[0] = row;
                    location[1] = col;
                }
            }
        }

        return location;
    }

    // ----------------------------------------------------------------
    // locateSmallest — double[][]
    //
    // Searches a 2D double array for its smallest value.
    // Returns a 1D int array where [0] = row index, [1] = col index.
    // ----------------------------------------------------------------
    public static int[] locateSmallest(double[][] arrayParam) {

        // Assume the first element is the smallest to start
        int[] location = {0, 0};
        double smallest = arrayParam[0][0];

        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++) {

                // If we find something smaller, update and save the location
                if (arrayParam[row][col] < smallest) {
                    smallest    = arrayParam[row][col];
                    location[0] = row;
                    location[1] = col;
                }
            }
        }

        return location;
    }

    // ----------------------------------------------------------------
    // locateSmallest — int[][]
    //
    // Same logic as above, but for an int[][] array.
    // ----------------------------------------------------------------
    public static int[] locateSmallest(int[][] arrayParam) {

        // Start with the first element as our current smallest
        int[] location = {0, 0};
        int smallest = arrayParam[0][0];

        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++) {

                // Found a new smallest — update value and record its position
                if (arrayParam[row][col] < smallest) {
                    smallest    = arrayParam[row][col];
                    location[0] = row;
                    location[1] = col;
                }
            }
        }

        return location;
    }

    // ----------------------------------------------------------------
    // printArray — double[][]
    //
    // A helper method that prints a double[][] with row and column
    // labels so we can visually verify the results are correct.
    // ----------------------------------------------------------------
    private static void printArray(double[][] arr) {

        // Print column header labels across the top
        System.out.print("       ");
        for (int c = 0; c < arr[0].length; c++)
            System.out.printf("Col%-5d", c);
        System.out.println();

        // Print each row with its row label on the left
        for (int r = 0; r < arr.length; r++) {
            System.out.printf("  Row %d ", r);
            for (double v : arr[r])
                System.out.printf("%-8.1f", v);  // one decimal place
            System.out.println();
        }
    }

    // ----------------------------------------------------------------
    // printArray — int[][]
    //
    // Overloaded version of the helper above, but for int[][] arrays.
    // ----------------------------------------------------------------
    private static void printArray(int[][] arr) {

        // Print column header labels
        System.out.print("       ");
        for (int c = 0; c < arr[0].length; c++)
            System.out.printf("Col%-5d", c);
        System.out.println();

        // Print each row with its label
        for (int r = 0; r < arr.length; r++) {
            System.out.printf("  Row %d ", r);
            for (int v : arr[r])
                System.out.printf("%-8d", v);
            System.out.println();
        }
    }

    // ----------------------------------------------------------------
    // main — Test Driver
    //
    // Creates one double[][] and one int[][] test array, then calls
    // all four methods and prints the results.
    // ----------------------------------------------------------------
    public static void main(String[] args) {

        // Test array 1: a 3x3 double grid
        double[][] doubleGrid = {
            { 3.5,  9.1,  2.7 },
            { 8.4,  1.2, 14.6 },
            { 6.0,  0.3,  7.7 }
        };

        // Test array 2: a 3x4 int grid (different size to be thorough)
        int[][] intGrid = {
            { 45,  12,  78,   3 },
            {  7,  99,  23,  56 },
            { 34,  61,   8,  82 }
        };

        System.out.println("==========================================================");
        System.out.println("       LOCATE LARGEST & SMALLEST TESTING PROGRAM          ");
        System.out.println("==========================================================");

        // --- Test 1: double[][] ---
        System.out.println("\n[ Test 1 ] double[][] array:");
        printArray(doubleGrid);

        // Call locateLargest and use the returned {row, col} to print the value
        int[] dLarge = locateLargest(doubleGrid);
        System.out.printf("%n  Largest  value: %.1f  --> found at [row %d][col %d]%n",
                doubleGrid[dLarge[0]][dLarge[1]], dLarge[0], dLarge[1]);

        // Call locateSmallest and print its location the same way
        int[] dSmall = locateSmallest(doubleGrid);
        System.out.printf("  Smallest value: %.1f  --> found at [row %d][col %d]%n",
                doubleGrid[dSmall[0]][dSmall[1]], dSmall[0], dSmall[1]);

        // --- Test 2: int[][] ---
        System.out.println("\n----------------------------------------------------------");
        System.out.println("\n[ Test 2 ] int[][] array:");
        printArray(intGrid);

        // Locate and display the largest int
        int[] iLarge = locateLargest(intGrid);
        System.out.printf("%n  Largest  value: %d  --> found at [row %d][col %d]%n",
                intGrid[iLarge[0]][iLarge[1]], iLarge[0], iLarge[1]);

        // Locate and display the smallest int
        int[] iSmall = locateSmallest(intGrid);
        System.out.printf("  Smallest value: %d   --> found at [row %d][col %d]%n",
                intGrid[iSmall[0]][iSmall[1]], iSmall[0], iSmall[1]);

        System.out.println("\n==========================================================");
    }
}