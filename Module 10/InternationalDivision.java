/*
 * Name: Zachary White
 * Instructor: Darrell Payne
 * Assignment 10.2: Division Class Hierarchy Demonstration
 * July 24, 2026
 * CSD-402: Java for Programmers
 *
 * Description: Concrete subclass of Division representing a division
 * located outside the home country. Adds fields for the country and
 * language spoken, and implements the display() method.
 */

public class InternationalDivision extends Division
{
    private String country;
    private String language;

    public InternationalDivision(String divisionName, int accountNumber,
                                  String country, String language)
    {
        super(divisionName, accountNumber);
        this.country = country;
        this.language = language;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    @Override
    public void display()
    {
        System.out.println("International Division");
        System.out.println("Division Name:   " + getDivisionName());
        System.out.println("Account Number:  " + getAccountNumber());
        System.out.println("Country:         " + country);
        System.out.println("Language:        " + language);
        System.out.println();
    }
}
