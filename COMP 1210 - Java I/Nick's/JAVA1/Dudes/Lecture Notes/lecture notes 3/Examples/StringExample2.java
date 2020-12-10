   import java.util.Scanner;

  /**
   * Demonstrates various methods in the String class.
   */
   public class StringExample2 {
      /**
       * Demonstrates various methods in the String class.
       *
       * @param args Command-line arguments (unused). 
       */
      public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         String input, replaced;
      
         System.out.print("Enter a string of your choice: ");
         input = scan.nextLine();
      
         System.out.println("\r\nThe string that you entered was \"" 
            + input + "\".");
      	
         System.out.println("\r\nThe first character is a(n) '"
            + input.charAt(0) + "'.");
      	
         System.out.println("The last character is a(n) '"
            + input.charAt(input.length() - 1) + "'.");
      	
         if (input.contains(" ")) {
            System.out.println("The string you entered contains at "
               + "least one space.");
         }
         else {
            System.out.println("The string you entered does not a space.");
         }
      	
         replaced = input;
         replaced = replaced.replace("a", "*");
         replaced = replaced.replace("e", "*");
         replaced = replaced.replace("i", "*");
         replaced = replaced.replace("o", "*");
         replaced = replaced.replace("u", "*");
         System.out.println("If I replaced all of the vowels with astericks, "
            + "your string would look as follows: ");
         System.out.println("\t" + replaced);
      
      }
   }
