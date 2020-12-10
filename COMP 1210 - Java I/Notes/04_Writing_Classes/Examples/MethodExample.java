
//********************************************************************
//  MethodExample.java    Author: J. Cross
//********************************************************************
/**
 * Demonstrates the use of a method call with int and 
 * String argments. 
 */
public class MethodExample
{
   /**
    * Prints various examples of string concatenation.
    * @param args - not used
    */
   public static void main(String[] args)
   {
      MessageCalc obj = new MessageCalc();
      int count = 5;
      
      char ch = obj.calc(4, count, "War Eagle!");
      System.out.println("ch = " + ch);
         
      int i = obj.calc(4, count, "War Eagle!");
      System.out.println("i = " + i);
      
      /* Note that a char can be assigned to an int. */  
      int j = 'm';  
      System.out.println("j = " + j);  
      
      /* But an int cannot be assigned to a char
         without "loss of precision" so a cast is
         required.  */   
      char ch2 = (char) 112;
      System.out.println("ch2 = " + ch2);
   }
}