/**
 *  Zero3.java        
 *  Demonstrates catching an exception in try-catch block with finally.
 */

public class Zero3
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main(String[] args)
   {
      int numerator = 4000;
      int denominator = 0;  // also set denominator to 1
      try
      {
         if (numerator > 500) {  // also make expression false
            System.out.println("Let's get out of here.");
            return;
         }
         if (numerator < 5) {  // also make expression false
            System.out.println("Let's get out of here.");
            System.exit(0);
         }
      
         System.out.println (numerator / denominator);
      }
      catch (ArithmeticException myProblem)
      {
         System.out.println (myProblem.getMessage());
            //myProblem.printStackTrace();
         System.out.println ("The exception has been handled!");
      }
      finally
      {
         System.out.println ("Wrapping up the try block.");	
      }
      
      System.out.println ("Wrapping up the program.");
   
      System.out.println("Program competing normally."); 
   }
}
