/*
 * Name: Zachary White
 * Instructor: Darrell Payne
 * Assignment 10.2: Division Class Hierarchy Demonstration
 * July 24, 2026
 * CSD-402: Java for Programmers
 *
 * Description: Abstract superclass representing a company division.
 * Holds the division name and account number common to all divisions,
 * and declares an abstract display() method to be implemented by
 * concrete subclasses.
 */

public abstract class Division
{
    private String divisionName;
    private int accountNumber;

    public Division(String divisionName, int accountNumber) {
        this.divisionName = divisionName;
        this.accountNumber = accountNumber;
    }

    public String getDivisionName()
    {
        return divisionName;
    }

    public void setDivisionName(String divisionName)
    {
        this.divisionName = divisionName;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public abstract void display();
}
