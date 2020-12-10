   import java.util.Scanner;
   
	/**
	* This program will allow a user to create a username 
	* and password. 
	*
	* @author Nick DiChiara
	* @version 9-5-2012
	*/


   public class UsernameGenerator {
   /**
   *
   * This class takes the user's input and creates a username 
   * and password. 
   *
   * @param args User-defined Command line arguments (not used).
   */
   
   
      public static void main(String[] args) {
      
         String firstName;
         String middleName;
         String lastName;
         String passWord;
         String passConf;
         String userName = "";
      
         Scanner userInput = new Scanner(System.in);
      
      
      	//Section to collect user's name. 
         System.out.println("Please enter your first name:");
         firstName = userInput.nextLine();
         if (firstName.trim().length() == 0) {
            firstName = "z"; }
       
         System.out.println("Please enter your middle name:");
         middleName = userInput.nextLine();
         if (middleName.trim().length() == 0) {
            middleName = "z"; }
      
         System.out.println("Please enter yout last name:");
         lastName = userInput.nextLine();
         if (lastName.trim().length() == 0) {
            lastName = "z"; } 					 
         else if (lastName.trim().length() == 1) {
            lastName = lastName + "z"; }
      	
      	
      	//Generates random number between 100 & 999
         int randNum = 100 + (int) (Math.random() * ((999 - 100) + 1));
         
      	//Uses generated number and user info to make username.
         userName = userName + Character.toLowerCase(firstName.charAt(0))
            	+ Character.toLowerCase(middleName.charAt(0)) 
            	+ Character.toLowerCase(lastName.charAt(0))
            	+ Character.toLowerCase(lastName.charAt(lastName.length() - 1))
            	+ randNum;
          
          
       	//Recives and checks passwords for consistency.
         System.out.println("Please enter your desired password:");
         passWord = userInput.nextLine();
      
         System.out.println("Please confirm your password:");
         passConf = userInput.nextLine();
         
      	//If they check out, the program continues on.
         if (passWord.equals(passConf)) {
         
            System.out.println("\nWelcome " + firstName + " " 
               			+ middleName + " " + lastName + "!");
         
            System.out.println("Your username is " + userName);
         
            System.out.println("Your password is " + passWord);
         }
         
         //If not, it fails and quits.
         else {
            System.out.println("\nFailed to set up new "
               				  + "user's login information.");
         }
      
      
      }
      
   }