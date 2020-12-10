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
      	
         System.out.println("What if I wanted to move a line down?");
         System.out.println("With yet another \r\nescape sequence...\r\n");
         
         System.out.println("What about printing backslashs?");
         System.out.println("Directory: D:\\Courses\\comp1210\\");
      } 
   }
