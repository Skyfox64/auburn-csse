   import java.util.Scanner;
   import java.util.Random;
/**
* Contains the methods to create the 
* userId for the user.
*
*@author Tyler Rabren
*@version 9-18-2011 
*/
   public class UserID {
      private Scanner scan = new Scanner(System.in);
      private Random generator = new Random();
      private String firstName, lastName, userID, 
		 fName, lName, name, newPass;
      private String defPassword;
      private String idNumber, n1, n2, n3;
		private String websiteName;
		private String defWebsite;
   /**
	*
	*
	* @param first is set to firstName.
	* @param last is set to lastName.
	*/
      public UserID(String first, String last) {
         firstName = first;
         lastName = last;
         if (firstName.length() < 3) {
            fName = firstName.substring(0, firstName.length());
         }
         
         else {
         fName = firstName.substring(0, 3);
         }
      	if (lastName.length() < 3) {
      	lName = lastName.substring(0, lastName.length());
      	}
      	else {
         lName = lastName.substring(0, 3);
      }
          n1 = Integer.toString(generator.nextInt(2));
      
          n2 = Integer.toString(generator.nextInt((9 - 3) + 1) + 3);
      
          n3 = Integer.toString(generator.nextInt(10));
      
          idNumber = n1 + n2 + n3;
      
         userID = lName + fName + idNumber;
         defPassword = Integer.toString(generator.nextInt(899999 + 1) + 100000);
      }
   /**
	*
	*
	*
	*@return output.
	*/
      public String toString() {
         String output = "Name: " + firstName + " "
            + lastName + "\n";
         output += "UserID: " + userID + "\n";
         output += "Password: " + defPassword + "\n";
         return output;
      }
   
   
   /**
	*
	*
	*
   * @return userID.
   */
      public String getId() {
      
         return userID;
      }
		
		
   /**
	*
	*
	*
   *@return defPassword.
   */
      public String getPassword() {
         return defPassword;
      }
		/**
		*
		*
		*@return isSet.
		*@param userPass is set to defPassword.
		*/
      public boolean setPassword(String userPass) {
         boolean isSet = false;
         if (userPass.length() >= 6) {
            defPassword = userPass;
            isSet = true;
         }
         return isSet;
      }
   	
		public boolean setWebsite(String websiteName) {
		boolean website = false;
		if (websiteName.length() >= 1) {
		defWebsite = websiteName;
		website = true;
		}
		return website;
		}		
   
   /**
   *
	*
   */
      public void generateNewPassword() {
          generator = new Random();
         newPass = Integer.toString(generator.nextInt(999999));
      }
   
   }