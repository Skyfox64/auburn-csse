/**
 * Demonstrates the use of escape sequences.
 */
public class EscapeSeq
{
/**
 * Prints various examples of escape sequences.
 *   @param args - Standard commandline arguments
 */
   public static void main(String[] args)
   {
      System.out.println("How do I print a tab?");
      System.out.println("\tWith an escape sequence!");
   
      System.out.println("What about a quote?");
      System.out.println("\tWith another \"escape sequence\"!");
   	
      System.out.println("How do I move to a new line?");
      System.out.println("With yet another \n\nescape sequence...\n");
      
      System.out.println("What about a backslash?");
      System.out.println("\\ See above.\\\\");
   } 
}
