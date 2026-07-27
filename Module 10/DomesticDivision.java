/*
 * Name: Zachary White
 * Instructor: Darrell Payne
 * Assignment 10.2: Division Class Hierarchy Demonstration
 * July 24, 2026
 * CSD-402: Java for Programmers
 *
 * Description: Concrete subclass of Division representing a division
 * located within the home country. Adds a field for the state and
 * implements the display() method.
 */

public class DomesticDivision extends Division
{
    private String state;

    public DomesticDivision(String divisionName, int accountNumber, String state)
    {
        super(divisionName, accountNumber);
        this.state = state;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    @Override
    public void display()
    {
        System.out.println("Domestic Division");
        System.out.println("Division Name:   " + getDivisionName());
        System.out.println("Account Number:  " + getAccountNumber());
        System.out.println("State:           " + state);
        System.out.println();
    }
}
