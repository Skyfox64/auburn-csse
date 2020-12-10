   import java.util.Scanner;
   
/**
* This program accepts input from user and calculates 
* age and heart rate statistics.
*
* @author Nick DiChiara
* @version 08-27-2012
*/

   public class AgeStatistics {
   	 /**
   	 * Accepts input from user and calculates age and 
   	 * heart rate statistics.
   	 *
   	 * @param args Command line arguments (not used).
   	 */
   
   
      public static void main(String[] args) {
      
         String name;
         int ageInYears;
         int gender = 0; //1 for femals
         double maxHeartRate = 0;
      
         Scanner userInput = new Scanner(System.in);
      
      	//Asks for user's name.
         System.out.print("Enter your name: ");
         name = userInput.nextLine();
      
      	//Asks for user's age in years.
         System.out.print("Enter your age in years: ");
         ageInYears = userInput.nextInt();
      
      	//Asks for user's gender.
         System.out.print("Enter your gender (1 for female, 0 for male):");
         gender = userInput.nextInt();
         
      	//Calculates and prints user's age in minutes.
         System.out.println("\t Your age in minutes is " 
            					+ ageInYears * 525600 + " minutes.");
         //Calculates and prints user's age in centuries.   					
         System.out.println("\t Your age in centuries is " 
            					+ (double) ageInYears / 100 + " centuries.");
            					
      	//Calculates and prints user's maximum heart rate depending on gender. 
         System.out.print("Your max heart rate is ");
      	
         if (gender == 1) { 
            maxHeartRate = 209 - (0.7 * ageInYears);
         }
         	
         else {
            maxHeartRate = 214 - (0.8 * ageInYears);
         }
      	
         System.out.println(maxHeartRate + " beats per minute.");
      }
   }