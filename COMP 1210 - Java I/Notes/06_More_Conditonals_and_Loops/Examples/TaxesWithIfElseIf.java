//********************************************************************
//  TaxesWithIfElseIf.java       Author: J. Cross
//********************************************************************
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Demonstrates the use nested if-else-if statements.
 */
public class TaxesWithIfElseIf 
{
/**
 * Reads the user's income and prints tax bracket
 * accordingly.
 * @param args Standard command line arguments.
 */
   public static void main(String[] args)
   {
      DecimalFormat fmt = new DecimalFormat("$#,##0.00");
      Scanner scan = new Scanner(System.in);
   
      System.out.print("Enter your income: ");
      int income = scan.nextInt(); scan.nextLine();
      System.out.println("Income: " + fmt.format(income));
      int taxBracket = income / 25000;
      System.out.println("Tax Bracket: " + taxBracket);
   
      if (taxBracket == 0) {
         System.out.println("Less than " + fmt.format(25000));	
      }
      else if (taxBracket == 1) { 
         System.out.println("At least " + fmt.format(25000)
               	+ ", but less than " + fmt.format(50000));
      }
      else if (taxBracket == 2) {
         System.out.println("At least " + fmt.format(50000)
                  + ", but less than " + fmt.format(75000));
      }
      else if (taxBracket == 3) {
         System.out.println("At least " + fmt.format(75000)
                     + ", but less than " + fmt.format(100000));
      }
      else if (taxBracket == 4) {
         System.out.println("At least " + fmt.format(100000)
                        + ", but less than " + fmt.format(125000));
      }
      else {
         System.out.println();
         System.out.println("Greater or equal to " + fmt.format(125000));
      }
   }
}
