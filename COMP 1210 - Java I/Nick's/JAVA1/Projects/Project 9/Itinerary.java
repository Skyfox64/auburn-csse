   /**
	* This class defines an Itinerary for a flight.
	*
	* @author Nick DiChiara
	* @version 11-5-2012
	*/
   
   public class Itinerary {
   /**
   * Variables: fromAirport, toAirport, departDate, arriveDate.
   * Consructor
   * Methods
   * toString method (for String output)
   */
   
   
      private String fromAirport;
      private String toAirport;
      private String departDate;
      private String arriveDate;
      private int miles;
   
   
   /**
   * Default constructor.
   * @param fromIn specifies from airport.
   * @param toIn specifies to airport.
   * @param departDateIn specifies the departure date.
   * @param arriveDateIn specifies the arrival date.
   * @param milesIn specifies the miles of the trip.
   */
      public Itinerary(String fromIn, String toIn, String departDateIn,
      		String arriveDateIn, int milesIn) {
         fromAirport = fromIn;
         toAirport = toIn;
         departDate = departDateIn;
         arriveDate = arriveDateIn;
         miles = milesIn;
      
      }
   
   /**
   * Method getFromAirport gets the airport the plane is from.
   * @return fromAirport specifies the from airport.
   */
      public String getFromAirport() {
         return fromAirport;
      }
   
   /**
   * Method getDepDateTime gets the departure date and time.
   * @return departDate specifies the departure date and time.
   */   
      public String getDepDateTime() {
         return departDate;
      }
   
   /**
   * Method getMiles gets the number of miles of the trip.
   * @return miles specifies the number of miles.
   */
      public int getMiles() {
         return miles;
      }
   
   /**
   * Method toString ouputs the Itinerary of the flight.
   * @return output specifies the output data.
   */
      public String toString() {
         String output = fromAirport + "-" + toAirport + " ("
            + departDate + " - " + arriveDate + ") " + miles + " miles";
         return output; 
      }
   
   }