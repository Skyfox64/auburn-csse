   import java.util.Scanner;
   
	/**
    * Calculates the sum and average of three inputs via standard I/O.
    *
    * @author Tyler Rabren
    * @version 8-27-2010
    */
   public class AverageOfThree {
   
      /**
       * Calculates the sum and average of three inputs via standard I/O.
       *
       * @param args User-defined command line arguments (not used).
       */
		 
      public static void main(String[] args) {
      int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
      	// do not change variable types
         
         Scanner numberInput = new Scanner(System.in);  
      	
         System.out.println("This program calculates the sum and average "
            + "of three integers.");
            
         // get numerical input from user
         System.out.print("\tEnter the first number: ");
         sum1 = numberInput.nextInt();
         
			System.out.print("\tEnter the second number: ");
         sum2 = numberInput.nextInt();
         
			System.out.print("\tEnter the third number: ");
         sum3 = numberInput.nextInt();
         
      	// display sum
         System.out.println("\r\n The sum of your input is " + (sum1 + sum2 + sum3));
      	
      	//display average
         System.out.println("The average of your input is " 
			+ (double) (sum1 + sum2 + sum3) / 3);
      }
   }