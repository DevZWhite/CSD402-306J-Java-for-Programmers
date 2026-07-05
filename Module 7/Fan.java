/*
 * Name:       Zachary D. White
 * Instructor: Darrell Payne
 * Class:      CSD-402
 * Date:       06/26/2026
 *
 * Program Description:
 *   This program defines a Fan class that models an electric fan.
 *   The Fan class stores the fan's speed, on/off state, blade radius,
 *   and color. It includes constants, private fields, getters, setters,
 *   two constructors, and a toString() method.
 *
 *   A separate test section at the bottom (main method) creates two Fan
 *   objects one with default values, one with custom values — and
 *   demonstrates all the class methods.
 *
 *   Updated for the UseFans assignment: the 'this' reference is now
 *   used consistently throughout the class wherever it is allowed,
 *   including in the getters and inside setSpeed()'s validation, not
 *   just in places where it is strictly required to resolve a naming
 *   conflict (like the argument constructor and the other setters).
 */

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
    // toString()
    //
    // Information on toSting invocation. https://www.geeksforgeeks.org/java/object-tostring-method-in-java/
    // Returns a readable description of the fan's current state.
    // Java calls this method automatically when we print a Fan object.
    // We use a helper to convert the speed number into a word label.
    // ----------------------------------------------------------------
    @Override
    public String toString() {

        // Convert the speed constant to a readable label
        String speedLabel;
        switch (this.speed) {
            case STOPPED: speedLabel = "Stopped"; break;
            case SLOW:    speedLabel = "Slow";    break;
            case MEDIUM:  speedLabel = "Medium";  break;
            case FAST:    speedLabel = "Fast";    break;
            default:      speedLabel = "Unknown"; break;
        }

        // Build the full description string and return it
        return "Fan State:"
             + "\n  Power  : " + (this.on ? "On" : "Off")
             + "\n  Speed  : " + speedLabel + " (" + this.speed + ")"
             + "\n  Radius : " + this.radius + " inches"
             + "\n  Color  : " + this.color;
    }

    // ----------------------------------------------------------------
    // main — Test Application
    //
    // Creates two Fan objects and demonstrates the class features:
    //   fan1 — built with the no-argument constructor (all defaults)
    //   fan2 — built with the argument constructor (custom values)
    // ----------------------------------------------------------------
    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("                    FAN TESTING                  ");
        System.out.println("=================================================");

        // --------------------------------------------------
        // Fan 1: Default Constructor
        // No arguments — all fields start at default values
        // --------------------------------------------------
        Fan fan1 = new Fan();

        System.out.println("\n--- Fan 1: Created with default constructor ---");
        System.out.println(fan1);   // calls toString() automatically

        // Now use setters to change fan1's state
        System.out.println("\n  Updating fan1 with setters...");
        fan1.setOn(true);           // turn the fan on
        fan1.setSpeed(Fan.MEDIUM);  // set speed to MEDIUM (2)
        fan1.setRadius(10);         // change blade radius to 10 inches
        fan1.setColor("blue");      // change color to blue

        System.out.println("\n--- Fan 1: After setter updates ---");
        System.out.println(fan1);

        // Demonstrate the individual getter methods
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

        System.out.println("\n-------------------------------------------------");

        // --------------------------------------------------
        // Fan 2: Argument Constructor
        // Pass in all four values directly at creation time
        // --------------------------------------------------
        Fan fan2 = new Fan(Fan.FAST, true, 12, "black");

        System.out.println("\n--- Fan 2: Created with argument constructor ---");
        System.out.println(fan2);

        // Turn fan2 off and slow it down to show setters still work
        System.out.println("\n  Turning fan2 off and reducing speed...");
        fan2.setOn(false);
        fan2.setSpeed(Fan.SLOW);

        System.out.println("\n--- Fan 2: After updates ---");
        System.out.println(fan2);

        System.out.println("\n=================================================");
        System.out.println("               END OF TEST PROGRAM               ");
        System.out.println("=================================================");
    }
}