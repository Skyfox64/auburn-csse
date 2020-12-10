   import java.util.Scanner;
   import java.util.ArrayList;
   /**
	* This class will store an ArrayList of temperatures.
	* It will then use those to calculate high and low temps.	
	*
	* @author Nick DiChiara
	* @version 9-26-2012
	*/  
   public class TemperatureInfo {
   /**
   * Method to retrieve temperatures from user. Send to 
   * Temperatures for processing, and print the results.
   * @param args the command line arguments.
   */
   
      public static void main(String[] args) {
         ArrayList<Integer> tempList = new ArrayList<Integer>();
         Scanner userInput = new Scanner(System.in);
      
         int tempInput = -1;
      
         do {
            System.out.print("Enter a positive temperature (-1 to stop): ");
            tempInput = userInput.nextInt();
            if (tempInput > -1) {
               tempList.add(tempInput);
            }
         } while (tempInput > -1);
      
      
         Temperatures temps = new Temperatures(tempList);
         System.out.println(temps.toString());
      }
   }