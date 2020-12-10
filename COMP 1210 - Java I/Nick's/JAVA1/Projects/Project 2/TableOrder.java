   import java.util.Scanner;

	/**
	* This program records data involving names of events and
	* number of people attending. The program then calculates 
	* the number of tables needed based on attendance. 
	*
	* @author Nick DiChiara
	* @version 08-27-2012
	*/   
	
   public class TableOrder {
    /**
    * Records data involving names of events and
    * number of people attending. The program then calculates 
    * the number of tables needed based on attendance. 
    *
    * @param args Command line arguments (not used).
    */
   
   
      public static void main(String[] args) {
      
         String eventName;
         int numGuests;
      
      
         Scanner userInput = new Scanner(System.in);
         
      	//Asks for event name.
         System.out.print("Please enter the name of the event: ");
         eventName = userInput.nextLine();
      
      	//Asks for attendance.
         System.out.print("Please enter the number of people attending: ");
         numGuests = userInput.nextInt();
      
      
         int numTables = numGuests / 10;
         int remainder = numGuests % 10;
         if (remainder >= 1) {
            numTables++;
         }
      			      
         System.out.println("\n" + "Tables for " + "\"" + eventName + "\":");
         
      
         System.out.println("\t" + "Tables needed: " + numTables);
         
         if (numGuests == 0) {
         
            System.out.println("\t" + "Plates needed: " + 0);
         }
         
         else {
         
            System.out.println("\t" + "Plates needed: " + (numGuests + 15));
         }
      }
   
   }