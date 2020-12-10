   import java.text.DecimalFormat;  
	/**
	* This class characterizes Business-class tickets.
	*
	* @author Nick DiChiara
	* @version 11-6-2012
	*/
   
   public class Business extends AirTicket {
   /**
   * Variables: foodBev, ent, BAMILES.
   * Consructor
   * Methods
   * toString method (for String output)
   */
   
      public static final double BAMILES = 2.0;
      protected double foodBev;
      protected double ent;
   
   /**
   * Default constructor.
   * @param flightNumIn specifies the flight number.
   * @param tripDataIn specifies trip data based off of an Itinerary.
   * @param baseFareIn specifies the base fare.
   * @param fareFactorIn specifies the fare adjustment factor.
   * @param foodBevIn specifies the cost for food/bev.
   * @param entIn specifies the entertainment cost.
   */
      public Business(String flightNumIn, Itinerary tripDataIn,
      					double baseFareIn, double fareFactorIn, 
      					double foodBevIn, double entIn) {
         super(flightNumIn, tripDataIn, baseFareIn, fareFactorIn);
         foodBev = foodBevIn;
         ent = entIn;
      }
   
   /**
   * Method totalFare finds the total fare after calculation.
   * @return totalFare specifies the total fare.
   */    
      public double totalFare() {
         return (baseFare * fareFactor) + foodBev + ent;
      }
   
   /**
   * Method totalAwardMiles specifies the total award miles after calculation.
   * @return based on class specific calculations.
   */	
      public int totalAwardMiles() {
         return (int) (BAMILES * tripData.getMiles());
      }
   
   /**
   * Method toString ouputs the info of the flight.
   * @return output specifies the output data.
   */
      public String toString() {
         DecimalFormat dollarFmt = new DecimalFormat("$##,##0.00");
      
         String output = super.toString();
         output += "\tIncludes Food/Beverage: " + dollarFmt.format(foodBev) 
            	 + " Entertainment: " + dollarFmt.format(ent) + "\n";	
         return output;        
      }
   
   }