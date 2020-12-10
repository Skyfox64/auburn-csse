   import java.util.ArrayList;
   /**
	* This class will store an ArrayList of temperatures.
	* It will then use those to calculate high and low temps.	
	*
	* @author Nick DiChiara
	* @version 9-26-2012
	*/
   
   public class Temperatures {
   	/**
   	* Variables: list.
   	* Consructor
   	* Methods
   	* toString method (for String output)
   	*/
   	
      private ArrayList<Integer> temperatures = new ArrayList<Integer>();
   
   
      /**
   	* Default constructor. Sets temperaturesIn to temperatures.
   	* @param temperaturesIn specifies the temperatures array list.
   	*/
      public Temperatures(ArrayList temperaturesIn) {
         temperatures = temperaturesIn;
      }
   
   	/**
   	* Method to compute the lowest temp.
   	* @return low gives the lowest temp.
   	*/
      public int getLowTemp() {
         if (temperatures.isEmpty()) {
            return 0;
         }
         int low = temperatures.get(0); //Check
         for (int i = 0; i < (temperatures.size() - 1); i++) {
            if (temperatures.get(i) < low) {
               low = temperatures.get(i);
            }
         }
         return low;
      }
   	
   	/**
   	* Method to compute the highest temp.
   	* @return high gives the highest temp.
   	*/
      public int getHighTemp() {
         if (temperatures.isEmpty()) {
            return 0;
         }
         
         int high = temperatures.get(0);
         for (Integer currentTemp : temperatures) {
            if (currentTemp > high) {
               high = currentTemp;
            }
         }
         return high;
      }
   	
      /**
   	* Method to compare against the lowest temp.
   	* @param lowIn gives the temperature to compare.
   	* @return gives the lowest temp.
   	*/
      public int lowerMinimum(int lowIn) {
         return lowIn < getLowTemp() ? lowIn : getLowTemp();
      }
   	
   	/**
   	* Method to compare against the highest temp.
   	* @param highIn gives the temperature to compare.
   	* @return gives the highest temp.
   	*/
      public int higherMaximum(int highIn) {
         return highIn > getHighTemp() ? highIn : getHighTemp();
      }
   
      /**
   	* Method to output low and high temp.
   	* @return output specifies student's information.
   	*/		
      public String toString() {
         return "Low: " + getLowTemp() + "\r\nHigh: " + getHighTemp();
      }
   	
   }