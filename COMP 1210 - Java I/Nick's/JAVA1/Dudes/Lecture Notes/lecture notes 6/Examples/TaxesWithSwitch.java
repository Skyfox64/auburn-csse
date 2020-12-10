//********************************************************************
//  TaxesWithSwitch.java       Author: J. Cross
//********************************************************************
   import java.util.Scanner;
   import java.text.DecimalFormat;
/**
 * Demonstrates the use of a switch statement.
 */
   public class TaxesWithSwitch 
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
      
         switch (taxBracket)
         {
            case 0:
               System.out.println("Less than " + fmt.format(25000));
               break;
            case 1:
               System.out.println("At least " + fmt.format(25000)
                  	+ ", but less than " + fmt.format(50000));
               break;
            case 2:
               System.out.println("At least " + fmt.format(50000)
                  	+ ", but less than " + fmt.format(75000));
               break;
            case 3:
               System.out.println("At least " + fmt.format(75000)
                  	+ ", but less than " + fmt.format(100000));
               break;
            case 4:
               System.out.println("At least " + fmt.format(100000)
                  	+ ", but less than " + fmt.format(125000));
               break;
            default:
               System.out.println();
               System.out.println("Greater or equal to " + fmt.format(125000));
         }
      }
   }
