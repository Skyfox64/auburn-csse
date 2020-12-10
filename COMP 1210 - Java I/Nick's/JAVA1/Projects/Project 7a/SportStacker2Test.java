import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
* This class will test the SportStacker2 class for errors.
*
* @author Nick DiChiara
* @version 10-25-2012
*/

public class SportStacker2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


  /** A test to test the getName method. **/
   @Test public void getName() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
         										4, 6.5, 7.3, 5.8, 7.0);
      Assert.assertEquals("Error", "Borat Sagdiyev", s.getName());
   }
   
	 /** A test to test the getTimes method. **/
   @Test public void getTimes() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      double[] times = s.getTimes();
   	
      String timesString = "";
      for (int i = 0; i < times.length; i++) {
         timesString += times[i];
      }   										
   												
      String test = "6.57.35.87.0";
      Assert.assertEquals("Error", test, timesString);
   }
	
	 /** A test to test the getPlayerCount method. **/
   @Test public void getPlayerCount() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      s.resetPlayerCount();
      Assert.assertEquals("Error", 0, s.getPlayerCount());
   }
	
	 /** A test to test the resetPlayerCount method. **/
   @Test public void resetPlayerCount() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      s.resetPlayerCount();
      Assert.assertEquals("Error", 0, s.getPlayerCount());
   }

 /** A test to test the getNumTimesRecorded method. **/
   @Test public void getNumTimesRecorded() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      Assert.assertEquals("Error", 4, s.getNumTimesRecorded());
   }

 /** A test to test the addTime method. **/
   @Test public void addTime() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      s.addTime(4.3);
      double[] times = s.getTimes();
      Assert.assertEquals("Error", 4.3, times[4], .001);
   }
   
	/** A test to test the addTime method without increasing time. **/
   @Test public void addTimeIf() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       2, 6.5, 7.3, 5.8, 7.0);
      s.addTime(4.3);
      double[] times = s.getTimes();
      Assert.assertEquals("Error", 4.3, times[2], .001);
   }


 /** A test to test the increaseSize method. **/
   @Test public void increaseSize() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      s.increaseSize();
      double[] times = s.getTimes();
      Assert.assertEquals("Error", 5, times.length);
   }
	
 /** A test to test the findSlowestTime method. **/
   @Test public void findSlowestTime() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      Assert.assertEquals("Error", 7.3, s.findSlowestTime(), .001);
   }

 /** A test to test the removeSlowestTime method. **/
   @Test public void removeSlowestTime() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      Assert.assertEquals("Error", 7.3, s.removeSlowestTime(), .001);
   }

 /** A test to test the findFastestTime method. **/
   @Test public void findFastestTime() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      Assert.assertEquals("Error", 5.8, s.findFastestTime(), .001);
   }

 /** A test to test the computeAvgTime method. **/
   @Test public void computeAvgTime() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      Assert.assertEquals("Error", 6.65, s.computeAvgTime(), .001);
   }
   
	/** A test to test the computeAvgTime method when times is empty. **/
   @Test public void computeAvgTimeIf() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       0);
      Assert.assertEquals("Error", 0.0, s.computeAvgTime(), .001);
   }

 /** A test to test the computeMedianTime method. **/
   @Test public void computeMedianTime() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      Assert.assertEquals("Error", 6.75, s.computeMedianTime(), .001);
   }
   
	/** A test to test the computeMedianTime method when times is empty. **/
   @Test public void computeMedianTimeIf() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       0);
      Assert.assertEquals("Error", 0.0, s.computeMedianTime(), .001);
   }
   
	/** A test to test the computeMedianTime method if length is odd. **/
   @Test public void computeMedianTimeIfOdd() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       3, 6.5, 7.3, 5.8);
      Assert.assertEquals("Error", 6.5, s.computeMedianTime(), .001);
   }



 /** A test to test the toString method. **/
   @Test public void tostring() {
      SportStacker2 s = new SportStacker2("Borat Sagdiyev",
                                       4, 6.5, 7.3, 5.8, 7.0);
      boolean isCorrect = s.toString().contains("Sagdiyev");
      Assert.assertTrue(isCorrect);         
   }
}
