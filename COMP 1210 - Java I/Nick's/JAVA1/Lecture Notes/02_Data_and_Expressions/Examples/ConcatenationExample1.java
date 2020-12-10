/**
 * Demonstrates the use of the string concatenation 
 * operator and the automatic conversion of an 
 * integer to a string.
 */
   public class ConcatenationExample1
   {
   /**
    * Prints various examples of string concatenation.
    *   @param args - Standard commandline arguments
    */
      public static void main(String[] args)
      {
      // Strings can be concatenated using "plus" (+) operator.
         System.out.println("AUBURN UNIVERSITY "
            + "HISTORY OF NAME CHANGES");
      // A string can contain numeric digits
         System.out.println("East Alabama Male College (founded): "
            + "1856");
      // A numeric value can be concatenated to a string.
         System.out.println("Agricultural and Mechanical "
            + "College of Alabama: " + 1872);
      // then 27 years later ...
         System.out.println("Alabama Polytechnic Institute: " + (1899));
      // then 61 years later ...
         System.out.println("Auburn University: " + (1960));
      } 
   }
