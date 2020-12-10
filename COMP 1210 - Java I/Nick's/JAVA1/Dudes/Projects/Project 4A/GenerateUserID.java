   import java.util.Scanner;
/**
* Takes the user's information, then
* creates a userid and a default password. 
* Then asks the user if they would like 
* to change their password, and if they
* say yes then they are prompted to 
* enter their own password. Then the user's
* Id formation is once again outputed, but 
* with the password set to the user's choice. 
* Project 4A
*
*@ author Slade Meriwether.
*@ version 9-18-2011
*
*/
   public class GenerateUserID {
   /**
   * Prompts the user to enter their first
	* and last name. Then outputs the user's 
	* userid and a default password. The user
	* is then asked if they would like to change
	* their password. If they enter N then the
	* program ends. But if the user enters Y, then
	* the user is prompted to enter their own password.
	* if the password is less than six digits then the 
	* program returns an Invalid password message. But
	* if the user enters an acceptable password, then
	* the program once again outputs the user's Id. The
	* only difference id that the pssword is now replaced
	* with the user's chosen password.
	*
   *@param args Command line arguments (not used).
   */
      public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         String first, last, choice, password, s, t, passW, frName, lsName;
         s = "y";
         t = "n";
         passW = "0";
         password = "not set";
      
      
         System.out.print("Enter yor first name: ");
         first = scan.nextLine();
         System.out.print("Enter yor last name: ");
         last = scan.nextLine();
			
			frName = first.toLowerCase();
			lsName = last.toLowerCase();
      
         UserID user1 = new UserID(frName, lsName);
         System.out.println("\n" + user1);
         
         System.out.print("\nWould you like to change your password "
            + "(y - Yes, n - No) ");
         choice = scan.nextLine();
      
         if (choice.compareToIgnoreCase(s) == 0) {
            System.out.print("\nPlease enter new password: ");
         
         password = scan.nextLine();
         
			if (user1.setPassword(password)) {
         
            
         
            System.out.println("\n" + user1);
         }
         
         else {
            System.out.print("\nError: Invalid password. Password "
               + "must	be 6 or more digits.");
         }
			
			}
          

         
                 
         
      }
   
   
   }
