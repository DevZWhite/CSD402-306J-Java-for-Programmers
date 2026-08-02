import java.util.Scanner;

public class DisplayTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //prompt the user for input
        System.out.println("Enter an integer for number of seconds:");
        int seconds = input.nextInt();

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60; //seconds remaining
        System.out.println(seconds + " seconds is " + minutes + " minutes and "
            + remainingSeconds + " seconds");
        
    }
}
