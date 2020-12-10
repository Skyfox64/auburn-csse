   import java.util.Scanner;
//********************************************************************
// DinnerForGroup.java       Author: J. Cross
//********************************************************************
/**
 * Demonstrates the use of the Scanner class to 
 * read numeric data.
 */
    public class MealForGroup
   {
   /**
    * Calculates restaurant bill based on values 
    * entered by the user.
    */
       public static void main (String[] args)
      {
         int numOfPersons;
         double mealCost, total;
      
         Scanner scan = new Scanner(System.in);
      
         System.out.print ("Enter the number in group: ");
         numOfPersons = scan.nextInt();
      
         System.out.print ("Enter cost per person: ");
         mealCost = scan.nextDouble();
      
         total = numOfPersons * mealCost;
      
         System.out.println ("Total Cost: " + total);
      }
   }
