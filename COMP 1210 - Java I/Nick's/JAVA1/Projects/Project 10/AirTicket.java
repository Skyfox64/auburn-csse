   import java.text.DecimalFormat;
  /**
	* This class AirTicket defines data involved and categorization
	* of tickets.
	*
	* @author Nick DiChiara
	* @version 11-5-2012
	*/

  
   public abstract class AirTicket implements Comparable<AirTicket> {
   /**
   * Variables: flightNum, tripData, baseFare, fareFactor.
   * Consructor
   * Methods
   * toString method (for String output)
   */
   
   
      protected String flightNum;
      protected Itinerary tripData;
      protected double baseFare;
      protected double fareFactor;
   
   
   /**
   * Default constructor.
   * @param flightNumIn specifies the flight number.
   * @param tripDataIn specifies trip data based off of an Itinerary.
   * @param baseFareIn specifies the base fare.
   * @param fareFactorIn specifies the fare adjustment factor.
   */
      public AirTicket(String flightNumIn, Itinerary tripDataIn,
      					double baseFareIn, double fareFactorIn) {
         flightNum = flightNumIn;
         tripData = tripDataIn;
         baseFare = baseFareIn;
         fareFactor = fareFactorIn;
      }
   
   /**
   * Method getFlightNum gets the number of the flight.
   * @return flightNum specifies the number.
   */
      public String getFlightNum() {
         return flightNum;
      }
   
   /**
   * Method getBaseFare gets the base fare of the flight.
   * @return baseFare specifies the fare.
   */
      public double getBaseFare() { 
         return baseFare;
      }
   
   /**
   * Method getItenerary gets the itenerary of the flight.
   * @return tripData specifies the info of the trip.
   */   
      public Itinerary getItinerary() {
         return tripData;
      }
      
   /**
   * Method to compare AirTicket objects.
   * @param obj is the AirTicket object being compared.
   * @return gives the compare results.
   */
      public int compareTo(AirTicket obj) {
      
         return getFlightNum().compareTo(obj.getFlightNum());
      }	
   
   /**
   * Method getFareAdjustmentFactor gets the adjustment factor.
   * @return fareFactor specifies the adjustment factor.
   */   
      public double getFareAdjustmentFactor() {
         return fareFactor;
      }
   
   /**
   * Method totalFare specifies the total fare after being calculated.
   * @return totalFare based on calculations.
   */   
      public abstract double totalFare();
   
   /**
   * Method totalAwardMiles specifies the total award miles after calculation.
   * @return totalAwardMiles based on calculations.
   */	
      public abstract int totalAwardMiles();
   
   /**
   * Method toString ouputs the info of the flight.
   * @return output specifies the output data.
   */
      public String toString() {
         DecimalFormat dollarFmt = new DecimalFormat("$##,##0.00");
      
         String output = "Flight: " + flightNum + "\n";
         output += tripData + " (" + this.totalAwardMiles() + " award miles)\n";
         output += "Base Fare: " + dollarFmt.format(baseFare) 
            		+ " Fare Adjustment Factor: "	+ fareFactor + "\n";
         output += "Total Fare: " + dollarFmt.format(totalFare()) 
            		+ " (" + this.getClass() + ")\n";	
         return output;
      }
      
   }