/**
 *  Demonstrates the remainder (%) operation.
 */
   public class RemainderCheck
   {
   /**
    * Shows examples of using the remainder operator (%) 
    * with both positive and negative operands.  Note that 
    * sign of the remainders always matches the sign of 
    * the numerator. I recommend that you verify each using 
    * long division to find the quotient and remainder.
    * 
    *   @param args - Standard commandline arguments
    */
      public static void main(String[] args)
      {
         System.out.println("11 % 2 = " + (11 % 2));
         System.out.println("-11 % 2 = " + (-11 % 2));
         System.out.println("11 % -2 = " + (11 % -2));
         System.out.println("-11 % -2 = " + (-11 % -2));
         System.out.println("5.5 % 1.5 = " + (5.5 % 1.5));
         System.out.println("6.5 % 1.5 = " + (6.5 % 1.5));
         System.out.println("6 % 1.5 = " + (6 % 1.5));
         System.out.println("-6 % 1.5 = " + (-6 % 1.5));
         System.out.println("-6.2 % 1.5 = " + (-6.2 % 1.5));
      }
   }
