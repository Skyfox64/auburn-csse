   /**
	* This class characterizes NonRefundable tickets.
	*
	* @author Nick DiChiara
	* @version 11-6-2012
	*/

   public class NonRefundable extends AirTicket {
   /**
   * Variables: discountFactor.
   * Consructor
   * Methods
   * toString method (for String output)
   */
   
      private double discountFactor;
      
   /**
   * Default constructor.
   * @param flightNumIn specifies the flight number.
   * @param tripDataIn specifies trip data based off of an Itinerary.
   * @param baseFareIn specifies the base fare.
   * @param fareFactorIn specifies the fare adjustment factor.
   * @param discountFactorIn specifies the fare discount factor.
   */
      public NonRefundable(String flightNumIn, Itinerary tripDataIn,
      				double baseFareIn, double fareFactorIn, 
      				double discountFactorIn) {
         super(flightNumIn, tripDataIn, baseFareIn, fareFactorIn);
         discountFactor = discountFactorIn;
      }
   /**
   * Method getDiscountFactor gets the discount factor.
   * @return discountFactor specifies the discount factor.
   */	
      public double getDiscountFactor() {
         return discountFactor;
      }
   /**
   * Method totalFare finds the total fare after calculation.
   * @return totalFare specifies the total fare.
   */	
      public double totalFare() {
         return baseFare * fareFactor * discountFactor;
      }
   
   /**
   * Method totalAwardMiles specifies the total award miles after calculation.
   * @return tripData.getMiles() based on class specific calculations.
   */	
      public int totalAwardMiles() {
         return tripData.getMiles();
      }	
   	
   /**
   * Method toString ouputs the info of the flight.
   * @return output specifies the output data.
   */	
      public String toString() {
      
         String output = super.toString();
         output += "\tIncludes DiscountFactor: " + discountFactor;	
         return output;
      }
      
   }