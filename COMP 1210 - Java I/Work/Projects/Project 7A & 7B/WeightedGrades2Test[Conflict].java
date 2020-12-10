import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class will test the WeightedGrades2 class for errors.
*
* @author John Carroll
* @version 10-31-2013
*/
public class WeightedGrades2Test {
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**=============getNameTest================**/
   /** A test to test the getNameTest method. **/
   @Test public void getNameTest() {
   
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
   
      Assert.assertEquals("your name" , wg.getName());
   }
   
   /**=============getNumGradesTest================**/
   /** A test to test the getNumGradesTest method. **/
   @Test public void getNumGradesTest() {
   
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
   
      Assert.assertEquals(7 , wg.getNumGrades());
   }
   
   
   /**=============getGradesTest================**/
   /** A test to test the getGradesTest method. **/
   @Test public void getGradesTest() {
   
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
         
      String[] test = {"a90", "a100", "q90", "q80", "p100", "e87.5", "f90"};
   
      Assert.assertArrayEquals(test, wg.getGrades());
   }
   
   
   /**=============getWeightedGradesCountTest================**/
   /** A test to test the getWeightedGradesCountTest method. **/
   @Test public void getWeightedGradesCountTest() {
   
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
   
      Assert.assertEquals(1, wg.getWeightedGradesCount());
   }
   
   /**=============resetWeightedGradesCountTest================**/
   /** A test to test the resetWeightedGradesCountTest method. **/
   @Test public void resetWeightedGradesCountTest() {
   
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
   
      wg.resetWeightedGradesCount();
      Assert.assertEquals(0, wg.getWeightedGradesCount());
   }
   
   
   /**=================gradesByCategory===================**/
   /** A test to test the gradesByCategory method. **/
   @Test public void gradesByCategory() {
   
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
   
      double[] testGrades = {90, 100};
   
      Assert.assertArrayEquals(testGrades, wg.gradesByCategory('a'), 0.0001);
   }
   
   /**=================toString=======================**/
   /** A test to test the toString method. **/
   @Test public void tostring() {
      
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
      
      boolean isCorrect = wg.toString().contains("your name");
      
      Assert.assertTrue(isCorrect);         
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   /**===============addGrade==================**/
   /** A test to test the addGrade method. **/
   @Test public void addGrade() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
      
      wg.addGrade("a80");
      String[] grades = wg.getGrades();
      Assert.assertEquals("a80", grades[7]);
   }
   
	/** A test to test the addGrade method without increasing grades. **/
   @Test public void addGradeIf() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 2, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
      
      wg.addGrade("a80");
      String[] grades = wg.getGrades();
      Assert.assertEquals("a80", grades[2]);
   }
   
   
   
   /**===============deleteGrade==================**/
   /** A test to test the deleteGrade method if true(length>0. **/
   @Test public void deleteGrade() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
         
      // wg.deleteGrade("a90");
      // WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         //"q90", "q80", "p100", "e87.5", "f90");
      // String[] expectedGrades = {"a100", "q90", "q80", "p100", "e87.5", 
         //"f90"};
   // 
      //String[] newGrades = wg2.getGrades();
      Assert.assertTrue(wg.deleteGrade("a90"));
   }
   
   /** A test to test the deleteGrade method if empty(false(0=length)). **/
   @Test public void deleteGradeIf() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 0);
      
      // String[] grades = wg.getGrades();
      Assert.assertFalse(wg.deleteGrade("z01"));
   }
   
   
   
   /**===============deleteLowestGrade==================**/
   /** A test to test the deleteLowestGrade method if true. **/
   @Test public void deleteLowestGrade() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
         
      wg.deleteLowestGrade('a');
      WeightedGrades2 wg2 = new WeightedGrades2("your name", 6, "a100", "q90", 
         "q80", "p100", "e87.5", "f90");
      String[] expectedGrades = {"a100", "q90", "q80", "p100", "e87.5", "f90"};
   
      String[] newGrades = wg2.getGrades();
      Assert.assertArrayEquals(expectedGrades, newGrades);
   }
   
   /** A test to test the deleteLowestGrade method if empty. **/
   @Test public void deleteLowestGradeIf() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 0);
      
      String[] grades = wg.getGrades();
      Assert.assertEquals(0, grades.length, .0001);
   }
   
   // /** A test to test the deleteLowestGrade method if empty. **/
   // @Test public void deleteLowestGradeIf() {
      // WeightedGrades2 wg = new WeightedGrades2("your name", 0);
   //        
      // String[] grades = wg.getGrades();
   //        
      // wg.deleteLowestGrade('a');
      // WeightedGrades2 wg2 = new WeightedGrades2("your name", 0);
      // String[] expectedGrades = {};
   // 
      // String[] newGrades = wg2.getGrades();
      // Assert.assertArrayEquals(expectedGrades, newGrades);
   // }

      
   
   
   /**============increaseGradesCapacity================**/
   /** A test to test the increaseGradesCapacity method. **/
   @Test public void increaseGradesCapacity() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
      wg.increaseGradesCapacity();
      String[] grades = wg.getGrades();
      Assert.assertEquals(8, grades.length, .0001);
   }
   
   
   
   /**==================average======================**/
   /** A test to test the average method. **/
   @Test public void average() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
         
      double[] testGrades = wg.gradesByCategory('a');
      Assert.assertEquals(95.0, wg.average(testGrades), .0001);
   }
   
   /** A test to test the average method when grades is empty. **/
   @Test public void averageIf() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 0);
      double[] testGrades = wg.gradesByCategory('a');
      Assert.assertEquals(0.0, wg.average(testGrades), .0001);
   }


   
   
   /**===============courseAvg=======================**/
   /** A test to test the courseAvg method. **/
   @Test public void courseAvg() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
      Assert.assertEquals(91.5, wg.courseAvg(), .0001);
   }
   
   /** A test to test the computeAvg method when grades is empty. **/
   @Test public void courseAvgIf() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 0);
      
      Assert.assertEquals(0.0, wg.courseAvg(), .0001);
   }


   
   /**===============computeMedianGrade======================**/
   /** A test to test the computeMedianGrade method. **/
   @Test public void computeMedianGrade() {
                                    
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a90", "a100",
         "q90", "q80", "p100", "e87.5", "f90");
      
      Assert.assertEquals(95, wg.computeMedianGrade('a'), .0001);
   }
   
   /** A test to test the computeMedianGrade method when times is empty. **/
   @Test public void computeMedianGradeIf() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 0);
      
      Assert.assertEquals(0.0, wg.computeMedianGrade('a'), .0001);
   }
   
   /** A test to test the computeMedianGrade method if length is odd. **/
   @Test public void computeMedianGradeIfOdd() {
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, "a80", "a90", 
         "a100", "q90", "q80", "p100", "e87.5", "f90");
         
      Assert.assertEquals(90, wg.computeMedianGrade('a'), .0001);
   }
 
}
