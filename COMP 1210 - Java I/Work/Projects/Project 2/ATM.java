import java.util.Scanner;

/**
*
* @Author: John Carroll
* @Version: 9-6-2013
* Assignment Due Date: 9-9-2013
*
* This project is written to help an ATM manufacturer.
* They would like it to allow a user to enter the amount
* of cash in whole dollars. If the limit being dispensed
* does not exceed $300, then the program then displays 
* the number of bills by denomination.
*
*/

public class ATM
//ATM.java
{
     /**
     * @param args Command line arguments (not used).
     */

   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int amount;
      int twenties;
      int tens;
      int fives;
      int ones;
      int calculations;
      
       
      //Prompt the user for the amount:
      System.out.print("Enter the amount: ");
      amount = userInput.nextInt();
         
         //Determine if is of the limit of $300:
         //If it is it prints that is has exceeded the limit
      if (amount > 300)
      {
         System.out.print("Limit of $300 exceeded!");
      }
         //If it has NOT then the number of each bill
         //will be calculated and shown
      else
      {
         System.out.println("Bills by denomination: ");
         
         //Print the number of bills by denomination
         //Twenty dollar bills
         twenties = amount / 20;
         System.out.println("\t$20: " + twenties);
         
         //Ten dollar bills
         tens = ((amount - (twenties * 20)) / 10);
         System.out.println("\t$10: " + tens);
         
         //Five dollar bills
         fives = ((amount - ((twenties * 20) + (tens * 10))) / 5);
         System.out.println("\t$5: " + fives);
         
         //One dollar bills
         ones = (amount - ((twenties * 20) + (tens * 10) + (fives * 5)));
         System.out.println("\t$1: " + ones);
         
         //Print Calculations for the total amount
         System.out.print("$" + amount + " = ("
            + twenties + " * $20) + ("
            + tens + " * $10) + ("
            + fives + " * $5) + ("
            + ones + " * $1)");
      }
   }
}