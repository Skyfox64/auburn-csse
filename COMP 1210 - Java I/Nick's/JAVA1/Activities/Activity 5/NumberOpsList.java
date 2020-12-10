   import java.util.Scanner;
   import java.util.ArrayList;
   
   /**
    * Demonstrates the NumberOperations class.
	 */
   public class NumberOpsList {
   
      /**
       * Reads a set of positive numbers from the user until the user enters 0.
   	 * Prints odds under and powers of 2 under for each number.
   	 *
       * @param args - Standard commandline arguments
       */
      public static void main(String[] args) {
      	
         int input;
         Scanner in = new Scanner(System.in);
         
         ArrayList<NumberOperations> numOps = new ArrayList<NumberOperations>();
         
         System.out.println("Enter a list of positive integers: ");
         input = Integer.parseInt(in.nextLine());
         numOps.add(new NumberOperations(input));
         while (input != 0) {
            numOps.add(new NumberOperations(input));
            input = Integer.parseInt(in.nextLine());
         }
      
         // add a while loop as described below: 
      	// while the input is not "0"
            // add NumberOperations object to array based on user input
            // get the next user input
      		
      		   
         int i = 0;
         while (i < numOps.size()) {
            NumberOperations num = numOps.get(i);
            System.out.println("For: " + num);
         	// add print statement for odds under num
         	// add print statement for powers of 2 under num
            System.out.println("  Odds under:\t" + num.oddsUnder());
            System.out.println("  Powers of 2 under:\t" + num.powersTwoUnder());
            i++;
         }
      }
   }