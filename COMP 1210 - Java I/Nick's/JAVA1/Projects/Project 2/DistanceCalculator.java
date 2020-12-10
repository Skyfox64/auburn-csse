   import java.util.Scanner;
   
	/**
	* This program.  
	*
	* @author Nick DiChiara
	* @version 08-27-2012
	*/
   
   public class DistanceCalculator {
   /**
   *
   *
   * @param args Command line arguments (not used).
   */
   
   
      public static void main(String[] args) {
      
         int x1;
         int y1;
         int x2;
         int y2;
         double slope;
      
         Scanner userInput = new Scanner(System.in);
      
         System.out.println("Please enter the x and y coordinates of "
             					+ "the first point:");
      
         System.out.print("\t" + "x1 = ");
         x1 = userInput.nextInt();
      
         System.out.print("\t" + "y1 = ");
         y1 = userInput.nextInt();
         
         System.out.println("Please enter the x and y coordinates of "
             					+ "the second point:");
      
         System.out.print("\t" + "x2 = ");
         x2 = userInput.nextInt();
      
         System.out.print("\t" + "y2 = ");
         y2 = userInput.nextInt();
      	
      	
         System.out.println("The midpoint is (" + (double) (x1 + x2) / 2 
            					+ ", " + (double) (y1 + y2) / 2 + ")");
      	
         if (x1 != x2) {
         
            slope = (y2 - y1) / (x2 - x1);
            System.out.println("The slope is " + slope);
         }
         
         else {
            System.out.println("The slope is undefined.");
         }	
      		
      }
      
   }

