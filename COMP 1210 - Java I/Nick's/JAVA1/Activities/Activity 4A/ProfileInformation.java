	/**
	* This class will store profile information.
	*
	* @author Nick DiChiara
	* @version 9-10-2012
	*/

   public class ProfileInformation {
   /**
   * Variables: firstName, lastName, location, age, atatus.
   * consructor
   * methods
   * toString method (for String output)
   */
   
      private String firstName;
      private String lastName;
      private String location;
      private int age;
      private int status;
   
      private static final int OFFLINE = 0, ONLINE = 1;
      
   	/**
   	* Default constructor.
   	* @param first specifies first name.
   	* @param last specifies last name.
      */
      public ProfileInformation(String first, String last) {
      
         firstName = first;
         lastName = last;
         location = "Not specified";
         age = 0;
         status = OFFLINE;
      }
      
   	/**
   	* Method to allow user to pass in their location.
   	* @param locationName specifies users location.
   	*/
      public void setLocation(String locationName) {
         location = locationName;
      }
      
   	/**
   	* Method to change age. Will only set if age is over 0. 
   	* Returns boolean if age was set.
   	* @param ageInYears specifies user's age in years.
   	* @return isSet specifies whether the age was set.
   	*/
      public boolean setAge(int ageInYears) {
         boolean isSet = false;
         if (ageInYears > 0) {
            age = ageInYears;
            isSet = true;
         }
         return isSet;
      }
      
   	/**
      * Method to return age.
      * @return age specfies age entered.
      */
      public int getAge() {
         return age; 
      }
   
   	/**
   	* Method to return location.  ?????????????????
   	* @return location specifies user's location.
   	*/
      public String getLocation() {
         return location;
      }
      
   	/**
   	* Method to allow user to log off.
   	*/
      public void logOff() {
         status = OFFLINE;
      }
   
   	/**
   	* Method to allow user to log on.
   	*/
      public void logOn() {
         status = ONLINE;
      }
   	
   	/**
   	* Method to output user's information.
   	* @return output specifies user's information.
   	*/
      public String toString() {
         String output = "Name: " + firstName + " " + lastName + "\n";
         output += "Location: " + location + "\n";
         output += "Age: " + age + "\n";
         output += "Status: ";
         if (status == OFFLINE) {
            output += "Offline";
         }
         else {
            output += "Online";
         }
      	
         return output;
      }
   
   }
   
