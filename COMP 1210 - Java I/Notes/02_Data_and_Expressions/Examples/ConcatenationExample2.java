/**
* Demonstrates the use of the string concatenation 
* operator and the automatic conversion of an 
* integer to a string.
*/
public class ConcatenationExample2
{
/**
 * Examples of string concatenation, including addition of 
 * numeric values.
 *   @param args - Standard commandline arguments (not used)
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
      // Concatenating numbers treated as strings.
      System.out.println("Alabama Polytechnic Institute: " + 1872 + 27);
      // then 61 years later ...
      System.out.println("Auburn University: " + (1899 + 61));
   } 
}
