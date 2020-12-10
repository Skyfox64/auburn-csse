import java.util.Scanner;

public class YesOrNoInput5 {

   public static void main(String[] args) {
      
      String userIn;
      boolean isValid;
      Scanner stdIn = new Scanner(System.in);
      int tries = 0;
      
      do {
         System.out.print("Continue? (enter y or n): ");
         userIn = stdIn.nextLine().trim();
         tries++;
         isValid = userIn.equals("y") || userIn.equals("n");
         if (!isValid) {
            if (tries > 5) {
               System.out.println("Too many attempts; aborting");
               break;
            }   
            System.out.println("Error. Input must be y or n");
         }
      } while (!isValid);
      
      System.out.println("\r\nThe selection was " + userIn + ".");
   }
}