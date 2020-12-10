import java.util.Scanner;

/**
*
* @Author: John Carroll
* @Version: 9-6-2013
* Assignment Due Date: 9-9-2013
*
* This program takes the x and y coordinates of two points
* as doubles and calculates the slope (if defined) of the
* line defined by the two points. The slope is only defined
* if the two x coordinates are not equal. If the slope is
* defined, the program calculates and prints the Y-intercept
* and then further, if the slope is not 0, it calculates and
* prints the X-intercept.
*
*/

public class SlopeIntercept
{
     /**
     * @param args Command line arguments (not used).
     */

   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String name = "";
         //Variables
      double x1;
      double y1;
      double x2;
      double y2;
      double slope;
      double yIntercept;
      double xIntercept;
      
      /**
      * Prompt the user for two sets of coordinates:
      * one set for the start and one for the end
      *
      * (Instructions specified to replace everything in Italics 
      * (example 1)with your own words)
      *
      */
      System.out.print("Please enter the desired starting coordinates (x,y): "
         + "\n\tx1 = ");
      x1 = userInput.nextDouble();
      System.out.print("\ty1 = ");
      y1 = userInput.nextDouble();
      
      System.out.print("Please enter the desired ending coordinates (x,y): "
         + "\n\tx2 = ");
      x2 = userInput.nextDouble();
      System.out.print("\ty2 = ");
      y2 = userInput.nextDouble();
         
         //Determine if slope is defined or not
      if (x1 == x2)
      {
         System.out.print("Slope: \"undefined\"");  
      }
      else
      {
         //Calculate and print the slope
         slope = (y2 - y1) / (x2 - x1);
         System.out.println("Slope: " + slope);
         
         //Calculate and print Y-Intercept
         yIntercept = y1 - (slope * x1);
         System.out.println("Y intercept: " + yIntercept);
         
         //Determine if X-intercept is defined
         if (y1 == y2)
         {
            //If undefined print such
            System.out.print("X intercept: \"undefined\"");
         }
         else
         {
            //If defined, then calculate and print X-Intercept
            xIntercept = -1 * (yIntercept / slope);
            System.out.print("X intercept: " + xIntercept);
         }
      }
   }
}