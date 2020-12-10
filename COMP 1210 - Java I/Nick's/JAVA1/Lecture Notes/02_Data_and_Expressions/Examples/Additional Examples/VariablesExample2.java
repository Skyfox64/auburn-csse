//********************************************************************
//  VariablesExample2.java    Author: J. Cross
//********************************************************************
/**
 * Demonstrates the delcaration, initialization, and
 * assignment of variables. 
 */
   public class VariablesExample2
   {
   /**  */
      static final int MAX = 100;
   /**
    * Examples of variable declaration, initialization, and
    * assignment.
    *	 @param args - Standard commandline arguments
    */
      public static void main(String[] args)
      {
      // Declaring integer ("int") variables.
         int i;
         int j, k;
         final int MAX_MORE = 100;
         //MAX = 500;
      // Declaring and initializing integer ("int") variables.
      // In general, you should always intialize 
      // a variable when you declare it.
         int m = 0;
         int n = 10, p = 20;
      
      // Assigning values to variables.
         i = 10;
         System.out.println("i = " + i);
         i = 99;
         System.out.println("i = " + i); 
         k = i + 100;
         System.out.println("k = " + k);
      }
   }
