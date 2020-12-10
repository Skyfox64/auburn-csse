   import java.util.Scanner;
/**
 * Demonstrates the use of the Scanner class to 
 * process a String.
 */
   public class StringScan
   {
   /**
    * Separates a phrase into words.
    *   @param args - Standard commandline arguments
    */
      public static void main(String[] args)
      {
         Scanner scan = new Scanner("this is a test");
         System.out.println(scan.next());
         System.out.println(scan.next());
         System.out.println(scan.next());
         System.out.println(scan.next());
      }
   }
