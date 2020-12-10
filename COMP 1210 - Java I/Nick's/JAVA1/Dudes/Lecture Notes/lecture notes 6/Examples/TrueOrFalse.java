   import java.util.Scanner;
   
   public class TrueOrFalse {
   
      public static void main(String[] args) {
      
         char input = 't';
         String answer = ""; 
         Scanner stdIn = new Scanner(System.in);
      
         System.out.print("Enter your selection (t or f): ");
         input = stdIn.nextLine().charAt(0);
      
         switch (input) {
            case 't':
               answer = "true";
               break;
            case 'f':
               answer = "false";
               break;
            default:
               answer = "invalid";
         }
         System.out.println("Your answer was " + answer + ".");
      
      // This is the equivalent if statement.
      /*
         if (input == 't') {
            answer = "true";
         }
         else if (input == 'f') {
            answer = "false";
         }
         else {
            answer = "invalid";
         }
      	System.out.println("Your answer was " + answer + ".");
      */
      }
   
   }