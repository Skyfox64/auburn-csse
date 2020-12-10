import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class tests for errors in the class: Android.
*
* @author John Carroll
* @version 12-5-2013
*/
public class FlipPhoneTest {

   private FlipPhone flip1;
   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws NegativeValueException is value is negative.
    */
   @Before public void setUp() throws NegativeValueException
   {
      flip1 = new FlipPhone("123-456-7890", 100, 50);
   
   }
  
       
   /** A test that tests the calculateBillTest method. 
    */
   @Test public void calculateBillTest() {
      Assert.assertEquals(32.5, flip1.calculateBill(), .0001);
   }
   
   /** A test that tests the resetBill method. 
    */
   @Test public void resetBillTest() {  
      flip1.resetBill();
      Assert.assertEquals(0, flip1.getTexts());
      Assert.assertEquals(0, flip1.getMinutes());
   }
}
