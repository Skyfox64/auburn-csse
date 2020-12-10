   import java.util.Scanner;
   
	/**
    * Converts tablespoons to cups or teaspoons to cups 
	 * based on user input. 
    *
    * @author Tyler Rabren
    * @version 8-27-2010
    */
   public class CookingCalculations {
   
      /**
       * Converts tablespoons to cups or teaspoons to cups 
       * based on user input. If the user enters 1 then the program 
       * converts tablespoons -> cups. Otherwise it converts 
       * teaspoons -> cups. It also caluclates the remainder. 
   	 * For example, converting 40 tablespoons to cups
   	 * would result in 2 cups and 8 tablespoons.
       *
       * @param args User-defined command line arguments (not used).
       */
      public static void main(String[] args) {
      
         int choice, conversionAmount = 0, cups = 0, remaining = 0;
         Scanner userIn = new Scanner(System.in);
         
			System.out.print("Enter 1 to convert tablespoons "
            + "to cups or 2 to convert teapsoon to cups.\r\n> ");
         choice = userIn.nextInt();
         
         System.out.print("Enter the amount you want to convert.\r\n> ");
         conversionAmount = userIn.nextInt();
      
         
         if (choice == 1) {
		   cups = conversionAmount / 16;
			remaining = conversionAmount % 16;
            System.out.print("The amount you entered is equal to " 
            + cups + " cups and " + remaining + " tablespoons");
         }
         else {
			cups = conversionAmount / 48;
			remaining =  conversionAmount % 48;
         System.out.print("The amount you entered is equal to " 
            + cups + " cups and " + remaining + " teaspoons");
			}	
			
         
      }
   }