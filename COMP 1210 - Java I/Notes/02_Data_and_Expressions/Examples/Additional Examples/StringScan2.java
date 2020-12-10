//********************************************************************
//  StringScan.java       Author: J. Cross
//
//  Demonstrates the use of the Scanner class to process a String.
//********************************************************************

   import java.util.Scanner;

    public class StringScan2
   {
   //-----------------------------------------------------------------
   //  Separates a phrase into words.
   //-----------------------------------------------------------------
       public static void main (String[] args)
      {
         Scanner scan = new Scanner("this, is a test.");
         scan.useDelimiter("\\W+");  // skip all non-word characters
         System.out.println (scan.next());
         System.out.println (scan.next());
         System.out.println (scan.next());
         System.out.println (scan.next());
      }
   }
