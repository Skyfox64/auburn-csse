import java.util.Scanner;
/**
 * Demonstrates the use of the Scanner class to 
 * read numeric data.
 */
public class DinnerForGroup
{
   /**
    * Calculates restaurant bill based on values 
    * entered by the user.
    *   @param args - Standard commandline arguments
    */
   public static void main(String[] args)
   {
      int numOfPersons; 
      double costOfMeal, total;
   
      Scanner scan = new Scanner(System.in);
   
      System.out.print("Enter the number in group: ");
      numOfPersons = scan.nextInt();
   
      System.out.print("Enter cost per person: ");
      costOfMeal = scan.nextDouble();
   
      total = numOfPersons * costOfMeal;
   
      System.out.println("Total Cost: $" + total);
   }
}
