import java.text.DecimalFormat;  
/**
* This class characterizes Elite-class tickets.
*
* @author Nick DiChiara
* @version 11-6-2012
*/

public class Elite extends Business {
/**
* Variables: comm.
* Consructor
* Methods
* toString method (for String output)
*/


   private double comm;
   
/**
* Default constructor.
* @param flightNumIn specifies the flight number.
* @param tripDataIn specifies trip data based off of an Itinerary.
* @param baseFareIn specifies the base fare.
* @param fareFactorIn specifies the fare adjustment factor.
* @param foodBevIn specifies the cost for food/bev.
* @param entIn specifies the entertainment cost.
* @param commIn specifies the communication cost.
*/
   public Elite(String flightNumIn, Itinerary tripDataIn,
   					double baseFareIn, double fareFactorIn, 
   					double foodBevIn, double entIn, double commIn) {
      super(flightNumIn, tripDataIn, baseFareIn, fareFactorIn,
         	 foodBevIn, entIn);
      comm = commIn;
   }

/**
* Method totalFare finds the total fare after calculation.
* @return totalFare specifies the total fare.
*/     
   public double totalFare() {
      return super.totalFare() + comm;
   }


/**
* Method totalAwardMiles specifies the total award miles after calculation.
* @return based on class specific calculations from Business.
*/
   public int totalAwardMiles() {
      return super.totalAwardMiles();
   }

/**
* Method toString ouputs the info of the flight.
* @return output specifies the output data.
*/
   public String toString() {
      DecimalFormat dollarFmt = new DecimalFormat("$##,##0.00");
   
      String output = super.toString();
      output += "\tIncludes: Comm Services: " + dollarFmt.format(comm);  	 
      return output;        
   }

}