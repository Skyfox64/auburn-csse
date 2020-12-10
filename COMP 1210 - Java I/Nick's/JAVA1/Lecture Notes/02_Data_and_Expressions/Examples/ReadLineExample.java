   import java.util.Scanner;
   
/**
 * Demonstrates the use of the nextLine method of 
 * the Scanner class to read a string from the user.
 */
   public class ReadLineExample
   {
   /**
    * Reads a line of text from the user and prints it.
    *   @param args - Standard commandline arguments
    */
      public static void main(String[] args)
      {
         Scanner scan = new Scanner(System.in);
      
         System.out.println("Enter a line of text:");
      
         String line = scan.nextLine();
      
         System.out.println("You entered: \n\"" 
            						+ line + "\"");
            						
      }
   }
