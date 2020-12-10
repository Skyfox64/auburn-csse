   import java.util.Scanner;
   import java.io.IOException;
   
	/**
	* This class AirTicketApp recieves the file to be processed,
	* then sorts and generates flight reports. 
	*
	* @author Nick DiChiara
	* @version 11-12-2012
	*/
   
   public class AirTicketApp {
   
   
      
   /**
   * Method main prompts user for filename and then generates reports.
   * @param args specifies the command args.
   * @throws IOException 
   */
      public static void main(String[] args) throws IOException {
         boolean fileOpened = false;
         AirTicketProcessor atp =  new AirTicketProcessor();
         
         while (!fileOpened) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter File Name: ");
            String fileName = userInput.nextLine();
            
            
            try {
               atp.readAirTicketFile(fileName);
               fileOpened = true;
            }
            
               catch (IOException issue) { 
                  System.out.print("Please try again");
               }
                  
         }
         atp.generateReport();
         atp.generateReportByFlightNum();      
         atp.generateReportByItinerary();    
         atp.generateReportForInvalidInput();  
      }
   
   }