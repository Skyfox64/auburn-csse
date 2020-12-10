import java.util.Scanner;

/**
*
* @author: John Carroll
* @version: 9-4-2013
* Assignment Due Date: 9-4-2013
*/

 
public class AgeStatistics
//AgeStatistics.java
{
     /**
     * @param args Command line arguments (not used).
     */
   public static void main(String[] args)
   {
   // Prints the output for the JLetter program.
      //System.out.println("JAVAJAVAJAVA");
      
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int ageInYears = 0;
      int gender = 0;
      double maxHeartRate = 0;
      
      
      //Prompt the user for their name:
      System.out.print("Enter your name: ");
      name = userInput.nextLine();
      
      //Prompt the user for their age:
      System.out.print("Enter your age in years: ");
      ageInYears = userInput.nextInt();
      
      //Prompt the user for their gender:
      System.out.print("Enter your gender (1 for female, 0 for male): ");
      gender = userInput.nextInt();
      
      //convert age:
      System.out.println("\tYour age in minutes is "
         + ageInYears * 525600 + " minutes.");
         
      System.out.println("\tYour age in centuries is "
         + (double) ageInYears / 100 + " centuries.");
         
      // display max heart rate
      System.out.print("Your max heart rate is: ");
      if (gender == 1)
      {
         // calculate female MHR
         maxHeartRate = (209 - (0.7 * ageInYears));
      }
      else
      {
         // calculate male MHR
         maxHeartRate = (214 - (0.8 * ageInYears));
      }
      System.out.println(maxHeartRate + " beats per minute.");
      
   }
   
}