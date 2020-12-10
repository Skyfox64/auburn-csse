import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for WeightedGrades2 class.
 *
 *@author Garrett Knecht
 *@version 10-30-2013
 */
public class WeightedGrades2Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
    * Test for getName.
    */
   @Test public void getNameTest()
   {
      String[] myGrades = {"a90", "a100", "q90", "q80",
            "p100", "e87.5", "f90"};
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
   
      Assert.assertEquals("Test for getName.", "Garrett Knecht", wg.getName());
   }
   
   /**
    * Tests getNumGrades.
    */
   @Test public void getNumGradesTest()
   {
      String[] myGrades = {"a90", "a100", "q90", "q80",
            "p100", "e87.5", "f90"};
            
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
      
      Assert.assertEquals("Test for getNumGrades.", 7, wg.getNumGrades());
   }
   
   /**
    * Tests getGrades.
    */
   @Test public void getGrades()
   {
      String[] myGrades = {"a90", "a100", "q90", "q80",
            "p100", "e87.5", "f90"};
      
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
      Assert.assertEquals("test for getGrades.", myGrades, wg.getGrades());
   }
   
   /**
    *Tests resetWeghtedGradesCount.
    */
   @Test public void resetWeightedGradesCount()
   {
      WeightedGrades2.resetWeightedGradesCount();
      Assert.assertEquals(0, WeightedGrades2.getWeightedGradesCount());
   }

/**
 * Tests gradesByCategory.
 */
   @Test public void gradesByCategory()
   {
      String[] myGrades = {"a90", "a100", "q90", "q80",
            "p100", "e87.5", "f90"};
            
      double[] testGrades = {90, 100};
     
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
      
      Assert.assertArrayEquals("test for gradesByCategory", testGrades,
            wg.gradesByCategory('a'), 0.0001);
   }
   
   /**
    * Tests addGrade.
    */
   @Test public void addGrade() 
   {
      String[] myGrades = {"a90", "a100", "q90",
            "q80", "p100", "e87.5", "f90"};
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
      
      wg.addGrade("a76");
      String[] grades = wg.getGrades();
      Assert.assertEquals("Add grade test", "a76", grades[7]);
   }
   
   /**
    * Tests addGrade without increasing.
    */
   @Test public void addGradeNoIncrease() 
   {
   
      String[] myGrades = {"a90", "a100", "q90",
            "q80", "p100", "e87.5", "f90"};
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 3, myGrades);
      
      wg.addGrade("a80");
      String[] grades = wg.getGrades();
      Assert.assertEquals("Add grade test", "a80", grades[3]);
   }
   
   /**
    * Tests deleteGradeTest.
    */ 
   @Test public void deleteGradeTest()
   {
      String[] myGrades1 = {"a90", "a100", "q90", "q80",
            "p100", "e87.5", "f90", null, null};
      
      String[] myGrades2 = {"a90", "q90", "q80",
            "p100", "e87.5", "f90", " ", null, null};
            
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades1);
      
      boolean result = wg.deleteGrade("a100");
      
      Assert.assertArrayEquals("Test for deleteGrade.", 
         myGrades2, wg.getGrades());
         
      Assert.assertEquals("Test for deleteGrade return value.",
         true, result);
   }
   
   /**
    * Tests deleteGrade if no grades.
    */
   @Test public void deleteGradeEmpty() 
   {
      String[] myGrades1 = {"a90", "a100", "q90", "q80",
            "p100", "e87.5", "f90", null, null};
            
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 0, myGrades1);
      
      Assert.assertFalse(wg.deleteGrade("p20"));
   }

   /**
    * Tests delete lowest grade.
    */   
   @Test public void deleteLowestGrade() 
   {
      String[] myGrades1 = {"a90", "a100", "q90",
            "q80", "p100", "e87.5", "f90"};
      String[] myGrades2 = {"a100", "q90", "q80", 
            "p100", "e87.5", "f90"};
      String[] expectedGrades = {"a100", "q90", "q80", 
            "p100", "e87.5", "f90"};
      
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades1);
      
      wg.deleteLowestGrade('a');
      WeightedGrades2 wg2 = new WeightedGrades2("Garrett Knecht", 6, myGrades2);
   
      String[] newGrades = wg2.getGrades();
      Assert.assertArrayEquals(expectedGrades, newGrades);
   }
   
   /**
    * tests deleteLowestGrade if empty.
    */
   @Test public void deleteLowestGradeEmpty() 
   {
   
      String[] myGrades = {};
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 0, myGrades);
      
      String[] grades = wg.getGrades();
      Assert.assertEquals(0, grades.length, .0001);
   }
   
  /**
   *Tests increaseGradesCapacity.
   */ 
   @Test public void increaseGradesCapacity() 
   {
      String[] myGrades = {"a90", "a100", "q90", 
            "q80", "p100", "e87.5", "f90"};
      
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
      
      wg.increaseGradesCapacity();
      String[] grades = wg.getGrades();
      Assert.assertEquals(8, grades.length, .0001);
   }
   
   /**
    * Tests average.
    */
   @Test public void average() 
   {
      String[] myGrades = {"a90", "a100", "q90", 
            "q80", "p100", "e87.5", "f90"};
   
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
         
      double[] testGrades = wg.gradesByCategory('a');
      Assert.assertEquals("average test", 95.0, wg.average(testGrades), .0001);
   }
   
   /**
    * Tests average if null.
  
   @Test public void averageEmpty() 
   {
      String[] myGrades = {};
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 0, myGrades);
      double[] testGrades = wg.gradesByCategory('a');
      Assert.assertEquals(0.0, wg.average(testGrades), .0001);
   }
   */
   
   /**
    * Tests courseAvg.
    */   
   @Test public void courseAvg() 
   {
      String[] myGrades = {"a90", "a100", "q90", 
            "q80", "p100", "e87.5", "f90"};
      
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
      Assert.assertEquals(91.5, wg.courseAvg(), .0001);
   }
   
   /**
    * Tests courseAvg if empty.
    */
   @Test public void courseAvgEmpty() 
   {
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 0);
      
      Assert.assertEquals(0.0, wg.courseAvg(), .0001);
   }
   
   /** 
    * Tests computeMedianGrade.    
    */
   @Test public void computeMedianGrade() 
   {
      String[] myGrades = {"a90", "a100", "q90", "q80",
            "p100", "e87.5", "f90"};                             
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 7, myGrades);
      
      Assert.assertEquals("median test", 95, wg.computeMedianGrade('a'), .0001);
   }
   
   /**
    * Tests computeMedianGrade if empty.
    */
   @Test public void computeMedianGradeEmpty() 
   {
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 0);
      
      Assert.assertEquals(0.0, wg.computeMedianGrade('a'), .0001);
   }
   
   /**
    * Tests odd computeMedianGrade.
    */
   @Test public void computeMedianGradeIfOdd() 
   {
   
      String[] myGrades2 = {"a80", "a90", "a100", "q90", 
            "q80", "p100", "e87.5", "f90"};
         
      WeightedGrades2 wg = new WeightedGrades2("Garrett Knecht", 8, myGrades2);
         
      Assert.assertEquals(90, wg.computeMedianGrade('a'), .0001);
   }
   
   /**
    * Tests toString method
    */
   @Test public void tostring() 
   {
    
      String[] myGrades = {"a90", "a100", "q90", 
            "q80", "p100", "e87.5", "f90"};
        
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, myGrades);
      
      boolean isCorrect = wg.toString().contains("your name");
      
      Assert.assertTrue(isCorrect);         
   }
}
