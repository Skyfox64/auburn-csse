import java.util.Scanner;

public class YesOrNoInput2 {
   final static int MAX = 10;
   public static void main(String[] args) {
      
      String userIn;
      boolean isValid;
      Scanner stdIn = new Scanner(System.in);
      int tries = 0;
      
      do {
         System.out.print("Continue? (enter y or n): ");
         userIn = stdIn.nextLine().trim();
         isValid = userIn.equals("y") || userIn.equals("n");
         if (!isValid) {
            if (++tries > MAX) {
               System.out.println("Too many attempts - aborting");
               break;
            }   
            System.out.println("Error. Input must be y or n");
         }
      } while (!isValid);
      
      if (tries <= MAX) {
         System.out.println("\r\nThe selection was " 
            + (userIn.equals("y") ? "y for Yes" : "n for No") + ".");
      }
   }
}