   import java.util.Scanner;
   
   public class YesOrNoInput {
   
      public static void main(String[] args) {
         
         String userIn;
         boolean isValid;
         Scanner stdIn = new Scanner(System.in);
         
         do {
            System.out.print("Enter the user's selection (y or n): ");
            userIn = stdIn.nextLine().trim();
            isValid = userIn.equals("y") || userIn.equals("n");
            if (!isValid) {
               System.out.println("Error. Input must be y or n");
            }
         } while (!isValid);
         
         System.out.println("\r\nThe selection was " 
            + (userIn.equals("y") ? "y for Yes" : "n for No") + ".");
      }
   
   }