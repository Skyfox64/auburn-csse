import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class tests for errors in the class: Android.
*
* @author John Carroll
* @version 12-5-2013
*/
public class AndroidTest {

   private Android android1;
   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws NegativeValueException if value is negative.
    */
   @Before public void setUp() throws NegativeValueException {
      android1 = new Android("123-456-7890", 500, 400, 1000, 30);
   }

   /** A test that tests the getHotspotMinTest method. 
    */
   @Test public void getHotspotMinTest()
   {
      Assert.assertEquals("Hot Spot Test", 30, android1.getHotspotMin());
   }
   
   /** A test that tests the setHotspotMinTest method. 
    */
   @Test public void setHotspotMin()
   {
      android1.setHotspotMin(47);
      Assert.assertEquals("Set hot spot test", 47, android1.getHotspotMin());
   }
   
   /** A test that tests the calculateBillTest method. 
    */
   @Test public void calculateBillTest()
   {
      Assert.assertEquals(362.5, android1.calculateBill(), .0001);
   }
   
   /** A test that tests the resetBill method. 
    */
   @Test public void resetBillTest()
   {
      android1.resetBill();
      Assert.assertEquals("reset bll test", 0, android1.getHotspotMin());
   }
   
   /** A test that tests the toString method. 
    */
   @Test public void toStringTest()
   {
      boolean isTrue = android1.toString().contains("30");
      Assert.assertTrue(isTrue);
   }
}
