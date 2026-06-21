/*
 * Program: AverageCalculatorDemo
 * Description: Demonstrates overloaded methods for calculating the average
 *              of arrays of different primitive numeric types.
 * Author: Zachary White
 * Instructor: Darrell Payne
 * Date: 06/17/2026
 * Class: CSD402
 */
import java.util.Arrays;

public class AverageDemo {

    // This is my first time really using method OVERLOADING on purpose.
    // Overloading means I can have multiple methods with the same name (average)
    // as long as the parameter types are different. Java figures out which one
    // to call based on what type of array I pass in. So I don't have to come up
    // with four different method names like averageShort(), averageInt(), etc.

    // Overloaded method for short array
    public static short average(short[] array) {
        // I used "int sum" here instead of "short sum" because adding a bunch of
        // shorts together can actually overflow a short pretty easily (short only
        // goes up to 32,767). Using a bigger type to hold the running total while
        // still working with a small type is something I didn't think about until
        // I tested this with bigger numbers and got a weird negative result.
        int sum = 0;
        for (short value : array) {
            sum += value;
        }
        // Since the method has to return a short, I have to manually cast the
        // result back down with (short). Java won't do this automatically because
        // going from int -> short can lose data, so it forces me to be explicit
        // about it (this is called a "narrowing conversion").
        return (short) (sum / array.length);
    }

    // Overloaded method for int array
    public static int average(int[] array) {
        // Same idea as above but one level up - I'm summing ints into a long
        // just in case the total gets bigger than an int can hold. Better safe
        // than sorry since overflow bugs are hard to notice until it's too late.
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        // Casting the long sum back down to an int before returning, same
        // narrowing conversion concept as the short version above.
        return (int) (sum / array.length);
    }

    // Overloaded method for long array
    public static long average(long[] array) {
        // Here the array is already longs, and the sum is a long, so no casting
        // is needed on the way in. Long is basically as big as I need for this.
        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    // Overloaded method for double array
    public static double average(double[] array) {
        // With doubles I don't have to worry about the same overflow stuff,
        // but I do need to remember that dividing two doubles gives me a
        // decimal answer instead of just chopping off the remainder like
        // integer division does. That's actually the whole point of using
        // double here instead of int.
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    public static void main(String[] args) {
        // Made each array a different length on purpose so I could be sure
        // each overloaded method was actually being tested independently
        // and not just reusing the same data by accident.
        short[] shortArray = {4, 8, 15, 16, 23};                       // size 5
        int[] intArray = {100, 250, 375, 480};                         // size 4
        long[] longArray = {10000L, 25000L, 30500L, 47500L, 52000L, 61000L}; // size 6
        double[] doubleArray = {3.5, 7.25, 9.1};                       // size 3

        System.out.println("==================================================");
        System.out.println("           ARRAY AVERAGE CALCULATOR DEMO          ");
        System.out.println("==================================================");

        // ---- short[] test ----
        System.out.println("\n[1] short[] array (length " + shortArray.length + "):");
        System.out.println("    Elements: " + Arrays.toString(shortArray));
        // This is calling the overloaded version that takes a short[].
        // I don't have to tell Java which version to use - it just looks
        // at the type of shortArray and picks the matching method for me.
        short shortAvg = average(shortArray);
        System.out.println("    Average : " + shortAvg);

        // ---- int[] test ----
        System.out.println("\n[2] int[] array (length " + intArray.length + "):");
        System.out.println("    Elements: " + Arrays.toString(intArray));
        int intAvg = average(intArray);
        System.out.println("    Average : " + intAvg);

        // ---- long[] test ----
        System.out.println("\n[3] long[] array (length " + longArray.length + "):");
        System.out.println("    Elements: " + Arrays.toString(longArray));
        long longAvg = average(longArray);
        System.out.println("    Average : " + longAvg);

        // ---- double[] test ----
        System.out.println("\n[4] double[] array (length " + doubleArray.length + "):");
        System.out.println("    Elements: " + Arrays.toString(doubleArray));
        double doubleAvg = average(doubleArray);
        // Using printf with %.4f here so the average shows exactly 4 decimal
        // places instead of however many Java feels like printing by default.
        // %n is basically the same as \n but it's the "correct" platform-safe
        // way to do a newline in printf according to my reference text.
        System.out.printf("    Average : %.4f%n", doubleAvg);

        System.out.println("\n==================================================");
        System.out.println("                   END OF DEMO                    ");
        System.out.println("==================================================");
    }
}