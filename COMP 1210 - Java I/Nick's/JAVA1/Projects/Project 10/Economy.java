   /**
	* This class characterizes Economy tickets.
	*
	* @author Nick DiChiara
	* @version 11-6-2012
	*/
   
   public class Economy extends AirTicket {
   /**
   * Variables: EAMiles.
   * Consructor
   * Methods
   * toString method (for String output)
   */
   
   
      public static final double EAMILES = 1.5;
   
   /**
   * Default constructor.
   * @param flightNumIn specifies the flight number.
   * @param tripDataIn specifies trip data based off of an Itinerary.
   * @param baseFareIn specifies the base fare.
   * @param fareFactorIn specifies the fare adjustment factor.
   */
      public Economy(String flightNumIn, Itinerary tripDataIn,
      					double baseFareIn, double fareFactorIn) {
         super(flightNumIn, tripDataIn, baseFareIn, fareFactorIn);
      }
   
   /**
   * Method totalFare finds the total fare after calculation.
   * @return totalFare specifies the total fare.
   */   
      public double totalFare() {
         return baseFare * fareFactor;
      }
   
   /**
   * Method totalAwardMiles specifies the total award miles after calculation.
   * @return based on class specific calculations.
   */	
      public int totalAwardMiles() {
         return (int) (EAMILES * tripData.getMiles());
      }
   
   /**
   * Method toString ouputs the info of the flight.
   * @return output specifies the output data.
   */
      public String toString() {
         String output = super.toString();
         output += "\tIncludes Award Miles Factor: " + EAMILES;	
         return output;        
      }
   
   }