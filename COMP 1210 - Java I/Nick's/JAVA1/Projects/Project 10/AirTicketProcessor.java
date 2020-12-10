import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
* This class AirTicketProcessor reads in flight data from a file
* and generates reports. 
*
* @author Nick DiChiara
* @version 11-12-2012
*/


public class AirTicketProcessor {
   /**
* Variables: list, invalid.
* Consructor
* Methods
* toString method (for String output)
*/

   private ArrayList<AirTicket> list;
   private ArrayList<String> invalid;

/**
* Default constructor.
*/
   public AirTicketProcessor() {
      list = new ArrayList<AirTicket>(); 
      invalid = new ArrayList<String>();
   }
   
/**
* Method readAirTicketFile reads in data from the file.
* @param fileName specifies the file to be read.
* @throws IOException 
*/
   public void readAirTicketFile(String fileName) throws IOException {
   
      Scanner fileScan = new Scanner(new File(fileName));
      while (fileScan.hasNext()) {
         String line = fileScan.nextLine();
         Scanner lScan = new Scanner(line);
         lScan.useDelimiter(",");
         char type = lScan.next().charAt(0);
         String flight = lScan.next();
         Itinerary trip = new Itinerary(lScan.next(), 
                  lScan.next(), lScan.next(), 
                  lScan.next(), lScan.nextInt());
            		
         switch (type) {
            case 'B':
            //B - Business Class   
               list.add(new Business(flight, trip, 
                  lScan.nextDouble(), lScan.nextDouble(), 
                  lScan.nextDouble(), lScan.nextDouble()));
               break;
               
            case 'E':
            //E - Economy Class
               list.add(new Economy(flight, trip, 
                  lScan.nextDouble(), lScan.nextDouble()));
               break;
            	
            case 'F':
            //F - First (Elite) Class
               list.add(new Elite(flight, trip, 
                  lScan.nextDouble(), lScan.nextDouble(), 
                  lScan.nextDouble(), lScan.nextDouble(),
                  lScan.nextDouble()));
               break;
            
            case 'N':
            //N - NonRefundable
               list.add(new NonRefundable(flight, trip, 
                  lScan.nextDouble(), lScan.nextDouble(), 
                  lScan.nextDouble()));
               break;
            	
            default:
               System.out.println("Error");			
         }
      
      }
   
      fileScan.close();
   
   }

/**
* Method generateReport generates and prints a report of the tickets.
*/
   public void generateReport() {
      System.out.println("\n----------------------------\n"
         + "Air Ticket Report\n"
         + "----------------------------\n");
   
      for (AirTicket tix : list) {
         System.out.println(tix + "\n");
      }  
   
   }

 /**
* Method generateReportByFlightNum generates and prints a report 
* of the tickets in order of the respective flight numbers.
*/
   public void generateReportByFlightNum() {
      Collections.sort(list);
      System.out.println("----------------------------\n"
         + "Air Ticket Report (by Flight Number)\n"
         + "----------------------------\n");
   	
      for (AirTicket tix : list) {
         System.out.println(tix + "\n");
      }
      
   }

	/**
* Method generateReportByItinerary generates and prints a report 
* of the tickets in order of the respective Itineraries.
*/
   public void generateReportByItinerary() {
      Collections.sort(list, new ItineraryCompare());
      System.out.println("----------------------------\n"
         + "Air Ticket Report (by Itinerary)\n"
         + "----------------------------\n");
         	
      for (AirTicket tix : list) {
         System.out.println(tix + "\n");
      }
   
   }

}