   import java.util.Comparator;
   
	/**
	* This class ItineraryCompare sorts the AirTickets based on the Itinerary. 
	*
	* @author Nick DiChiara
	* @version 11-12-2012
	*/

   
   public class ItineraryCompare implements Comparator<AirTicket> {
   
   
   /**
   * Method compare compares and sorts based on alphabetical order 
   * of the Itineraries. 
   * @param t1 specifies one of the AirTickets.
   * @param t2 specifies another AirTicket for comparison. 
   * @return specicies the sorting result.
   */
      public int compare(AirTicket t1, AirTicket t2) {
      
         return t1.getItinerary().toString()
         .compareToIgnoreCase(t2.getItinerary().toString());
      
      }
   
   }