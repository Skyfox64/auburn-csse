//********************************************************************
//  AddInts.java       
//********************************************************************
import java.util.Scanner;
/**
 * Demonstrates the use of for statements.
 */
public class AddMultiplyInts 
{
 /**
 * 1. Adds from 1 to n using a for loop.
 * 2. Multiplies from 1 to n using a for loop
 *    (a.k.a. "n factorial" or "n!").
 */
   public static void main (String[] args)
   {
      Scanner scan = new Scanner(System.in);
      System.out.print("Add and multiply integers from 1 to ");
      int n = scan.nextInt();
      
      int sum = 0;
      for (int i = 1; i <= n; i++) {
         sum += i;
      }
      System.out.println("Sum: " + sum);
      
      long product = 1;
      for (int i = 1; i <= n; i++) {
         product *= i;
      }
      System.out.println("Product: " + product);
   
   } 
}
