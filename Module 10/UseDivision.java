/*
 * Name: Zachary White
 * Instructor: Darrell Payne
 * Assignment 10.2: Division Class Hierarchy Demonstration
 * July 24, 2026
 * CSD-402: Java for Programmers
 *
 * Description: Application that demonstrates the Division class
 * hierarchy by creating two InternationalDivision objects and two
 * DomesticDivision objects and displaying their information.
 */

public class UseDivision
{
    public static void main(String[] args)
    {
        InternationalDivision intlDiv1 = new InternationalDivision(
                "European Sales", 10234, "France", "French");
        InternationalDivision intlDiv2 = new InternationalDivision(
                "South American Sales", 10567, "Paraguay", "Guaraní");

        DomesticDivision domDiv1 = new DomesticDivision(
                "Midwest Operations", 20345, "Ohio");
        DomesticDivision domDiv2 = new DomesticDivision(
                "West Coast Operations", 20678, "Arizona");

        Division[] divisions = { intlDiv1, intlDiv2, domDiv1, domDiv2 };

        for (Division div : divisions)
        {
            div.display();
        }
    }
}
