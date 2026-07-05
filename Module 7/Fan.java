/*
 * Name:       Zachary D. White
 * Instructor: Darrell Payne
 * Class:      CSD-402
 * Date:       07/04/2026
 *
 * Program Description:
 *   This program defines a Fan class that models an electric fan.
 *   The Fan class stores the fan's speed, on/off state, blade radius,
 *   and color. It includes constants, private fields, getters, setters,
 *   and two constructors.
 *
 *   Updated for the UseFans assignment. Additions in this version:
 *     - A displayFan(Fan) method that prints a single Fan's info using
 *       the getters directly.
 *     - A displayFans(List<Fan>) method that takes a whole collection
 *       of Fan objects and displays each one by calling displayFan().
 *     - Test code in main() that builds a collection (ArrayList<Fan>)
 *       of several Fan objects, exercises setters/getters on them,
 *       and then displays the whole collection using displayFans().
 *
 *   The 'this' reference is used consistently throughout the class
 *   wherever it is allowed, including in the getters and inside
 *   setSpeed()'s validation, not just in places where it is strictly
 *   required to resolve a naming conflict (like the argument
 *   constructor and the other setters).
 */

import java.util.ArrayList;
import java.util.List;

public class Fan {

    // ----------------------------------------------------------------
    // Constants — represent the four possible speed settings.
    // Using final int so the values can never be changed.
    // ----------------------------------------------------------------
    public static final int STOPPED = 0;
    public static final int SLOW    = 1;
    public static final int MEDIUM  = 2;
    public static final int FAST    = 3;

    // ----------------------------------------------------------------
    // Private Fields
    //
    // https://www.w3schools.com/Java/ref_keyword_private.asp - Private Keyword
    // Making these private means they can only be accessed through
    // the getter and setter methods below - this is conecept is encapsulation.
    // more on this concept here https://www.geeksforgeeks.org/java/encapsulation-in-java/
    // ----------------------------------------------------------------

    // Holds the current speed setting (default: STOPPED = 0)
    private int speed;

    // Tracks whether the fan is turned on or off (default: false = off)
    private boolean on;

    // The radius of the fan blades in inches (default: 6)
    private double radius;

    // The color of the fan (default: "white")
    private String color;

    // ----------------------------------------------------------------
    // No-Argument Constructor
    //
    // This constructor is called when no values are passed in.
    // It sets every field to its default value as specified
    // in the assignment. 'this' isn't required here since there is
    // no parameter shadowing, so the field names are used directly.
    //  More details on Constructors https://www.geeksforgeeks.org/java/constructors-in-java/
    // ----------------------------------------------------------------
    public Fan() {
        this.speed  = STOPPED;   // fan starts stopped
        this.on     = false;     // fan starts off
        this.radius = 6;         // default blade radius
        this.color  = "white";   // default color
    }

    // ----------------------------------------------------------------
    // Argument Constructor
    //
    // This constructor lets us create a Fan with specific values
    // right away instead of using setters after creation.
    // ----------------------------------------------------------------
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed  = speed;    // "this.speed" refers to the field;
        this.on     = on;       // "speed" alone would refer to the parameter
        this.radius = radius;
        this.color  = color;
    }

    // ----------------------------------------------------------------
    // Getters — return the current value of each private field
    // https://www.geeksforgeeks.org/java/getter-and-setter-in-java/
    //
    // 'this' is used here to explicitly point to the current object's
    // fields. It isn't strictly necessary (there's no parameter with
    // the same name in these methods), but it's allowed and makes it
    // unambiguous that we're returning this object's own state.
    // ----------------------------------------------------------------

    // Returns the current speed setting (0–3)
    public int getSpeed() {
        return this.speed;
    }

    // Returns true if the fan is on, false if it is off
    public boolean isOn() {
        return this.on;
    }

    // Returns the blade radius
    public double getRadius() {
        return this.radius;
    }

    // Returns the color of the fan
    public String getColor() {
        return this.color;
    }

    // ----------------------------------------------------------------
    // Setters — allow outside code to update each private field
    // ----------------------------------------------------------------

    // Sets the speed — we validate that only 0–3 are accepted
    public void setSpeed(int speed) {
        if (speed == STOPPED || speed == SLOW ||
            speed == MEDIUM  || speed == FAST) {
            this.speed = speed;
        } else {
            // If an invalid speed is passed, default to STOPPED
            System.out.println("  [Warning] Invalid speed. Fan set to STOPPED.");
            this.speed = STOPPED;
        }
    }

    // Turns the fan on (true) or off (false)
    public void setOn(boolean on) {
        this.on = on;
    }

    // Updates the blade radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Updates the fan color
    public void setColor(String color) {
        this.color = color;
    }

    // ----------------------------------------------------------------
    // displayFan(Fan)
    //
    // Displays a SINGLE Fan's information WITHOUT calling toString().
    // Instead, this method calls the getter methods directly and
    // prints each piece of information itself. This is intentionally
    // separate from toString() so the two display paths never overlap.
    // ----------------------------------------------------------------
    public static void displayFan(Fan fan) {

        // Convert the speed number into a readable label, the same
        // way toString() does, but done independently here so this
        // method never has to call toString() to get its output.
        String speedLabel;
        switch (fan.getSpeed()) {
            case STOPPED: speedLabel = "Stopped"; break;
            case SLOW:    speedLabel = "Slow";    break;
            case MEDIUM:  speedLabel = "Medium";  break;
            case FAST:    speedLabel = "Fast";    break;
            default:      speedLabel = "Unknown"; break;
        }

        System.out.println("  Power  : " + (fan.isOn() ? "On" : "Off"));
        System.out.println("  Speed  : " + speedLabel + " (" + fan.getSpeed() + ")");
        System.out.println("  Radius : " + fan.getRadius() + " inches");
        System.out.println("  Color  : " + fan.getColor());
    }

    // ----------------------------------------------------------------
    // displayFans(List<Fan>)
    //
    // Takes a COLLECTION of Fan instances and displays every Fan in
    // it. This method also avoids toString() — it simply loops over
    // the collection and hands each Fan off to displayFan() above.
    // ----------------------------------------------------------------
    public static void displayFans(List<Fan> fans) {
        int index = 1;
        for (Fan fan : fans) {
            System.out.println("\n--- Fan #" + index + " ---");
            displayFan(fan);
            index++;
        }
    }

    // ----------------------------------------------------------------
    // main — Test Application
    //
    // Builds a collection (ArrayList<Fan>) of several Fan objects,
    // exercises constructors/setters/getters on them, and then
    // displays the whole collection using displayFans().
    // ----------------------------------------------------------------
    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("                    FAN TESTING                  ");
        System.out.println("=================================================");

        // --------------------------------------------------
        // Create a collection of Fan instances.
        // --------------------------------------------------
        List<Fan> fans = new ArrayList<Fan>();

        // Fan 1: built with the no-argument constructor (all defaults)
        Fan fan1 = new Fan();
        fans.add(fan1);

        // Fan 2: built with the argument constructor (custom values)
        Fan fan2 = new Fan(Fan.FAST, true, 12, "black");
        fans.add(fan2);

        // Fan 3: another no-argument fan we will customize with setters
        Fan fan3 = new Fan();
        fans.add(fan3);

        // Fan 4: another argument-constructor fan
        Fan fan4 = new Fan(Fan.SLOW, false, 8, "red");
        fans.add(fan4);

        // fan5: another argument-constructor fan
        Fan fan5 = new Fan(Fan.MEDIUM, true, 10, "white");
        fans.add(fan5);

        // Display the collection right after creation, before any updates

        System.out.println("\n--- Collection right after creation ---");
        displayFans(fans);

        // --------------------------------------------------
        // Update fan1 with setters
        // --------------------------------------------------
        System.out.println("\n  Updating fan1 with setters...");
        fan1.setOn(true);           // turn the fan on
        fan1.setSpeed(Fan.MEDIUM);  // set speed to MEDIUM (2)
        fan1.setRadius(10);         // change blade radius to 10 inches
        fan1.setColor("blue");      // change color to blue

        // Demonstrate the individual getter methods on fan1
        System.out.println("\n  Demonstrating getters on fan1:");
        System.out.println("  getSpeed()  --> " + fan1.getSpeed());
        System.out.println("  isOn()      --> " + fan1.isOn());
        System.out.println("  getRadius() --> " + fan1.getRadius());
        System.out.println("  getColor()  --> " + fan1.getColor());

        // Test the invalid speed guard in setSpeed()
        System.out.println("\n  Testing invalid speed input on fan1:");
        fan1.setSpeed(99);   // 99 is not a valid speed constant
        System.out.println("  Speed after bad input: " + fan1.getSpeed()
                         + " (should be 0 / STOPPED)");

        // --------------------------------------------------
        // Turn fan2 off and slow it down
        // --------------------------------------------------
        System.out.println("\n  Turning fan2 off and reducing speed...");
        fan2.setOn(false);
        fan2.setSpeed(Fan.SLOW);

        // --------------------------------------------------
        // Customize fan3 with setters
        // --------------------------------------------------
        System.out.println("\n  Updating fan3 with setters...");
        fan3.setOn(true);
        fan3.setSpeed(Fan.FAST);
        fan3.setRadius(14);
        fan3.setColor("green");

        // --------------------------------------------------
        // Customize fan4 with setters
        // --------------------------------------------------
        System.out.println("\n  Turning fan4 on...");
        fan4.setOn(true);

        // --------------------------------------------------
        // Customize fan5 with setters
        // --------------------------------------------------
        System.out.println("\n  Changing fan5 color to yellow..."); 
        fan5.setColor("yellow");

        // --------------------------------------------------
        // Display the single-Fan method on just fan2, to show
        // displayFan() working independently of the collection.
        // --------------------------------------------------
        System.out.println("\n--- Displaying a single Fan (fan2) with displayFan() ---");
        displayFan(fan2);

        // --------------------------------------------------
        // Display the whole collection after all updates,
        // showing displayFans() working across every Fan.
        // --------------------------------------------------
        System.out.println("\n--- Collection after all updates ---");
        displayFans(fans);

        System.out.println("\n=================================================");
        System.out.println("               END OF TEST PROGRAM               ");
        System.out.println("=================================================");
    }
}