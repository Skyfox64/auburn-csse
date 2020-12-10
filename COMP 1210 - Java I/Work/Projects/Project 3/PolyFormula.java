import java.util.Scanner;
import java.text.DecimalFormat;

/**
*
* @Author: John Carroll
* @Version: 9-11-2013
* Assignment Due Date: 9-16-2013
*
* User enters value, program computes it into the
* poly formula, then it states how many digits are
* to the left and right of the decimal. Also, it 
* then reformats the result.
*
*/

public class PolyFormula
//PolyFormula.java
{
     /**
     * @param args Command line arguments (not used).
     */

   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      //___Variables___
      double x;
      //Left and right side of the equation:
      double leftEqu, rightEqu;
      //Entire formula:
      double polyFormula;
      
      
      //Prompt the user for a value x
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      //Computation for the PolyFormula
      leftEqu = Math.abs(2 * (Math.pow(x, 6)) - 4 * (Math.pow(x, 5)));
      rightEqu = Math.pow((3 * (Math.pow(x, 4)) - 5 * (Math.pow(x, 3))), 2);
      polyFormula = Math.sqrt(leftEqu + rightEqu);
      System.out.println("Result: " + polyFormula);
      
      //Convert double to string
      String decimal = Double.toString(polyFormula);
      
      //Find the digits to the left of the decimal
      int leftSide = decimal.indexOf(".");
      System.out.println("# digits to left of decimal point: " 
         + leftSide);
      
      //Find the digits to the right of the decimal
      int rightSide = decimal.length() - 1 - leftSide;
      System.out.println("# digits to right of decimal point: "
          + rightSide);
      
      //Format the result
      DecimalFormat newStyle = new DecimalFormat("#,##0.0##");
      System.out.print("Formatted Result: " + newStyle.format(polyFormula));
      
      
   }
   
   
}
