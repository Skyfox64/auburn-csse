
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
    */
      public static void main (String[] args)
      {
         MessageCalc obj = new MessageCalc();
         int count = 5;
         char ch = obj.calc(4, count, "War Eagle!");
         System.out.println ("ch = " + ch);
         
         int i = obj.calc(4, count, "War Eagle!");
         System.out.println ("i = " +i);
         
         i = ch;  				// note: a char can be assigned to an int
       	//c = i;				// but an int cannot be assigned to a char
       							// without "loss of precision"
      
      }
   }