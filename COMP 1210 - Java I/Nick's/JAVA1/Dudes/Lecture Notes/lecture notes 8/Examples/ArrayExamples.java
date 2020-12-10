
/**
 * Demonstrates the declaration of various arrays 
 * and the assigment of their values.
 */
   public class ArrayExamples
   {
   /**
    * Creates array of various types then assigns 
    * some values as appropriate, then prints out 
    * the values.
    */
      public static void main (String[] args)
      {
      // Create arrays and print values.
         int[] myInts = new int[5];
         char[] myChar = new char[5];
         boolean[] myBooleans = new boolean[5];
         double[] myDoubles = new double[4];
         String[] myStrings = new String[6];
         for(int i : myInts)
            System.out.println(i);
         for(char c : myChar)
            System.out.println(c);
         for(boolean b : myBooleans)
            System.out.println(b);
      
         for(double d : myDoubles)
            System.out.println(d);
         for(String s : myStrings)
            System.out.println(s);
         System.out.println("\n***** After some assignments *****");
      // Make array assignments.
         myInts[0] = 999;
         myBooleans[1] = true;
         myDoubles[2] = 98.6; 
         myStrings[3] = "I'm not null!";
         int len = myStrings[3].length();
         //int len2 = myStrings[2].length(); // Carefull here!
      	
         System.out.println(myStrings[3]);
         System.out.println(myStrings[3].toUpperCase());
         
         for(int i : myInts)
            System.out.println(i);
         for(boolean b : myBooleans)
            System.out.println(b);
         for(double d : myDoubles)
            System.out.println(d);
         for(String s : myStrings)
            System.out.println(s);
      }
   }
