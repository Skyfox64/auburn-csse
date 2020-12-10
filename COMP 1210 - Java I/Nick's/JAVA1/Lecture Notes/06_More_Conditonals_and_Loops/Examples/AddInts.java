//********************************************************************
//  AddInts.java       
//********************************************************************
   import java.util.Scanner;
/**
 * Demonstrates the use of a for statement.
 */
   public class AddInts 
   {
    /**
    * 1. Adds int from 1 to limit using a for loop.
    * 2. Multiplies from 1 to limit using a for loop.
    */
      public static void main (String[] args)
      {
         Scanner scan = new Scanner(System.in);
         System.out.print("Add and multiply integers from 1 to ");
         int limit = scan.nextInt();
         int sum = 0;
         for (int i = 1; i <= limit; i++)
         {
            sum += i;
         }
         System.out.println("Sum: " + sum);
         
         long product = 1;
         for (int i = 1; i <= limit; i++)
         {
            product *= i;
         }
         System.out.println("Product: " + product);
      
      } 
   }
