   import java.util.Scanner;
 /**
  *  Demonstrates scanning input from System.in and the use of 
  *  the "if else" statement.
  */

   public class Difference {
   /**
    *  Reads in two ints from the System.in then prints the difference.
    *   @param args - Standard commandline arguments
    */
      public static void main(String[] args) {
         int number1, number2, difference;
         Scanner userInput = new Scanner(System.in);
         // get user input
         System.out.print("Enter the first number: ");
         number1 = userInput.nextInt();
         System.out.print("Enter the second number: ");
         number2 = userInput.nextInt();
         
         //get difference
         if (number1 >= number2) {
            difference = number1 - number2;
         }
         else {
            difference = number2 - number1;
         }
         //print difference
         System.out.println("The difference is " + difference);
      }  
   }
