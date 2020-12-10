/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */

public class Zero1A 
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 1;
      try
      {
         System.out.println(numerator / denominator); // divide by zero
      }
      catch(ArithmeticException myProblem)
      {
         System.out.println("ArithmeticException caught and handled");
      }
      finally
      {
         System.out.println("Always done");
      }
      System.out.println("Program competing normally."); // won't get to here
   }
}
