

import java.util.Random;
/**
 * Demonstrates the use of the random() method in the Math class
 * to generate pseudo-random numbers.
 */
public class RandomNumbersExample2
{
/**
 * Generates random numbers in various ranges using Math.random(),
 * which generates values in the range [0,1).
 *
 * @param args Command-line arguments (unused). 
 */
   public static void main(String[] args)
   {
      int randomNum1;
      double randomNum2;
   
      randomNum2 = Math.random();
      System.out.println("A random double in the range [0,1): " 
         + randomNum2);
   
      randomNum1 = (int) (Math.random() * 4) + 1;
      System.out.println("From 0 to 4: " + randomNum1);
      
      randomNum1 = (int) (Math.random() * 20) + 5;
      System.out.println("From 5 to 24: " + randomNum1);
   
      randomNum1 = (int) (Math.random() * 11) + 90;
      System.out.println("From 90 to 100: " + randomNum1);
   
      randomNum1 = (int) (Math.random() * 10) - 10;
      System.out.println("From -10 to -1: " + randomNum1);
   
      randomNum2 = Math.random();
      System.out.println("A random double [0,1): " + randomNum2);
   
      randomNum2 = Math.random() * 10;  // 0.0 to 9.999999
      System.out.println("A random float (between 0-9.999999): "
         + randomNum2);
   
      randomNum1 = (int) randomNum2 + 1;
      System.out.println("From 1 to 10: " + randomNum1);
   } 
}
