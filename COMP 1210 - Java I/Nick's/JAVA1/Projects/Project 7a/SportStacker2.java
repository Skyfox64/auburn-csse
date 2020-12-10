import java.text.DecimalFormat;
import java.util.Arrays;
/**
* This class will store stacker name, number, times,
* and make calculations based off of that information.
*
* @author Nick DiChiara
* @version 10-25-2012
*/
   
public class SportStacker2 {
/**
* Variables: name, numTimes, times, playerCount.
* Consructor: SportStacker
* Methods: getName, getTimes, getNumTimesRecorded, addTime
* 			  increaseSize, removeSlowestTime, findFastestTime, 
*	   	  computeAvgTime, computeMedianTime.
* toString method (for String output)
*/

   private String name;
   private int numTimes;
   private double[] times;
   /**Static variable playerCount keeps track of the number of instances.*/
   private static int playerCount;
   
	
/**
* Default constructor.
* @param nameIn specifies stacker's name.
* @param numTimesIn specifies number of recorded times.
* @param timesIn specifies the times recorded.
*/	
   public SportStacker2(String nameIn, int numTimesIn, double ... timesIn) {
   
      name = nameIn;
      numTimes = numTimesIn;
      times = timesIn;
      playerCount++;
   }

 	 /**
	* Method to get name.
	* @return name specfies stacker's name.
	*/
   public String getName() {
      return name;
   }

	/**
	* Method to get times.
	* @return times specfies stacker's times.
	*/
   public double[] getTimes() {
      return times;
   }
   
	
	/**
	* Method to get player count.
	* @return playerCount specfies number of stackers.
	*/
   public static int getPlayerCount() {
      return playerCount;
   }
   
	/**
	* Method to reset the player count.
	*/
   public static void resetPlayerCount() {
      playerCount = 0;
   }
	
	/**
	* Method to get number of times recorded.
	* @return numTimes specfies the number of times.
	*/
   public int getNumTimesRecorded() {
      return numTimes;
   }
   
	/**
	* Method to add a time.
	* @param timeIn specifies time to be added.
	*/
   public void addTime(double timeIn) {
      if (numTimes == times.length) {
         increaseSize();
      }
      times[numTimes] = timeIn;
      numTimes++;
   }
	
	/**
	* Method to increase the size of the array 'times'.
	*/
   public void increaseSize() {
   
      double[] newTimes = new double[times.length + 1];
      for (int i = 0; i < times.length; i++) {
         newTimes[i] = times[i];
      }
      times = newTimes;
   }
   
	/**
	* Method to find the slowest time in the array 'times'.
	* @return slowest is the slowest time.
	*/
   public double findSlowestTime() {
      double slowest = times[0];
      for (int i = 0; i < times.length; i++) {
         if (times[i] > slowest) {
            slowest = times[i];
         }      
      }
      return slowest;
   }
	
	
   /**
	* Method to remove the slowest time in the array 'times'.
	* @return slowest is the slowest time.
	*/
   public double removeSlowestTime() {
      int i;
      int j = 0;
      double slowest = times[0];
      for (i = 0; i < times.length; i++) {
         if (times[i] > slowest) {
            slowest = times[i];
            j = i; 
         } 
            
      }
      
      for (int k = j; k < times.length - 1; k++) {
         times[k] = times[k + 1];
      }
      numTimes--;
      times[times.length - 1] = 0; 
      
      return slowest;
   }
	
	/**
	* Method to find the fastest time in array 'times'.
	* @return fastest is the fastest time.
	*/
   public double findFastestTime() {
      double fastest = times[0];
      for (int i = 0; i < times.length; i++) {
         if (times[i] < fastest && times[i] != 0) {
            fastest = times[i];
         }   
      }
      return fastest;
   }
	
	/**
	* Method to compute the average time in array 'times'.
	* @return sum / times.length is the average time.
	*/
   public double computeAvgTime() {
      if (times.length == 0) {
         return 0;
      }
      else {
         double sum = 0;
         for (int i = 0; i < times.length; i++) {
         	
            sum += times[i];
         }
         return sum / numTimes;
      }
   }
   
	/**
	* Method to compute the median time in array 'times'.
	* @return median is the median time.
	*/
   public double computeMedianTime() {
      double median = 0;
      if (times.length == 0) {
         return 0;
      }
      else {
         double[] temp = Arrays.copyOf(times, numTimes);
         Arrays.sort(temp);
         if (temp.length % 2 != 0) {
            median = temp[(temp.length - 1) / 2];
         }  
         else {
            median = (temp[(temp.length - 1) / 2] 
               + temp[((temp.length - 1) / 2) + 1]) / 2;
         }
         return median;
      }
   }
	
   
	/**
 	* Method to output stacker's information.
	* @return output specifies stacker's information.
	*/
   public String toString() {
      DecimalFormat df = new DecimalFormat("##0.00");
   
      String timesString = "";
      for (int i = 0; i < times.length; i++) {
         timesString += times[i] + " ";
      }
      
      String output = "";
      output += "Sport Stacker Name: " + name + "\n";
      output += "Times: " + timesString + "\n";
      output += "Average Time: " + df.format(computeAvgTime()) + "\n";
      output += "Median Time: " + df.format(computeMedianTime()) + "\n";
      output += "Fastest Time: " + df.format(findFastestTime()) + "\n";
      output += "Slowest Time: " + df.format(findSlowestTime()) + "\n";
      output += "Player Count: " + getPlayerCount() + "\n";
   
      return output;
   }

}
