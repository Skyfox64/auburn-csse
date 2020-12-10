import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

/**
*
* @Author: John Carroll
* @Version: 9-11-2013
* Assignment Due Date: 9-16-2013
*
* The purpose of this program is to accept coded information
* as input that includes the number of adult meals, price of
* adult meal, number of child meals, price of child meal, and
* name of the customer. The program then prints the user's 
* order information including the total, as well as a 
* "lucky number" between 1 and 9999 inclusive. 
*/

public class TakeOutOrder
//TakeOutOrder.java
{
     /**
     * @param args Command line arguments (not used).
     */

   public static void main(String[] args)
   {
      //Scanner
      Scanner userInput = new Scanner(System.in);
      
      //Formatting
      DecimalFormat noDecimal = new DecimalFormat("#0");
      DecimalFormat currency = new DecimalFormat("$#,##0.00");
      DecimalFormat luckyNumStyle = new DecimalFormat("0000");
      
      
      //Prompt user for code   
      System.out.print("Enter your order code: ");
      String totalInput = userInput.nextLine();
      
      //Rid input of whitespace for non-string use
      String input = totalInput.trim();
         /* Options that were not used but
            may be used on another project later on: 
               String subInput = totalInput.substring(0, 13);
               String input = subInput.replaceAll(" ", "");*/
      
      
      //Determine if entered code is desirable
      if (totalInput.length() < 12)
      {
         System.out.print("\nInvalid Order Code."
            + "\nOrder code must have at least 12 characters.");
      }
      else
      {
         //Grab name and print
         System.out.println("\nName: " + input.substring(12));
         
         
         //Grab adult meals and price numbers
         String adultNumber = input.substring(0, 2);
         String adultPriceNumbers = input.substring(2, 4) + "." 
            + input.substring(4, 6);   
            
               //Turn String into a double
         double adult = Double.parseDouble(adultNumber);
         double adultPrice = Double.parseDouble(adultPriceNumbers);
         
               //Apply formatting and print
         System.out.println("Adult meals: " + noDecimal.format(adult) + " at "
            + currency.format(adultPrice));
         
         
         
         //Grab child meals and price and then format
         String childNumber = input.substring(6, 8);
         String childPriceNumbers = input.substring(8, 10) + "."
            + input.substring(10, 12);
            
               //Turn string into a double
         double child = Double.parseDouble(childNumber);
         double childPrice = Double.parseDouble(childPriceNumbers);
         
               //Apply formatting and print
         System.out.println("Child meals: " + noDecimal.format(child) + " at "
            + currency.format(childPrice));
         
         //Total cost
         double adultCost = adult * adultPrice;
         double childCost = child * childPrice;
         double totalCost = adultCost + childCost;
         System.out.println("Total: " + currency.format(totalCost));
         
         //Lucky number
         Random generator = new Random();
         double luckyNum = generator.nextDouble() * 10000;
            //Working alternative: double luckyNum = Math.random() * 10000;
         System.out.println("Lucky Number: " + luckyNumStyle.format(luckyNum));
           
      }
   }
}
