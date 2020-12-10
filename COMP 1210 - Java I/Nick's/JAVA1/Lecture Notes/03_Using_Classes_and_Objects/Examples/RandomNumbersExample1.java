

   import java.util.Random;
/**
 * Demonstrates the use of the Random class to generate 
 * pseudo-random numbers.
 */
   public class RandomNumbersExample1
   {
   /**
    * Generates random numbers in various ranges.
    *
    * @param args Command-line arguments (unused). 
    */
      public static void main(String[] args)
      {
         Random generator = new Random();
         int randomNum1;
         float randomNum2;
      
         randomNum1 = generator.nextInt();
         System.out.println("A full range random integer: " 
            + randomNum1);
      
         randomNum1 = generator.nextInt(5);
         System.out.println("From 0 to 4: " + randomNum1);
         
         randomNum1 = Math.abs(generator.nextInt()) % 5;
         System.out.println("From 0 to 4: " + randomNum1);
      
      
         randomNum1 = generator.nextInt(20) + 5;
         System.out.println("From 5 to 24: " + randomNum1);
      
         randomNum1 = generator.nextInt(11) + 90;
         System.out.println("From 90 to 100: " + randomNum1);
      
         randomNum1 = generator.nextInt(10) - 10;
         System.out.println("From -10 to -1: " + randomNum1);
      
         randomNum2 = generator.nextFloat();
         System.out.println("A random float (between 0-1): " + randomNum2);
      
         randomNum2 = generator.nextFloat() * 10;  // 0.0 to 9.999999
         System.out.println("A random float (between 0-9.999999): "
            + randomNum2);
      
         randomNum1 = (int) randomNum2 + 1;
         System.out.println("From 1 to 10: " + randomNum1);
      } 
   }
