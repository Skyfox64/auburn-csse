import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class tests for errors in the class: IPhone.
*
* @author John Carroll
* @version 12-5-2013
*/
public class IPhoneTest {

   private IPhone iPhone1;

   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws NegativeValueException is value is negative.
    */
   @Before public void setUp() throws NegativeValueException {
      iPhone1 = new IPhone("123-456-7890", 20, 548, 220, 55);
   }
   

   /** A test that tests the getImessages method. 
    */
   @Test public void getImessagesTest()
   {
      Assert.assertEquals("iMessage Test", 55, iPhone1.getIMessages());
   }
   
   /** A test that tests the setImessages method. 
    */
   @Test public void setIMessagesTest()
   {
      iPhone1.setIMessages(34);
      Assert.assertEquals("Set iMessages", 34, iPhone1.iMessages);
   }
   
   /** A test that tests the calculateBillTest method. 
    */
   @Test public void calculateBillTest()
   {
      Assert.assertEquals(95.05, iPhone1.calculateBill(), 0001);
   }
   
   /** A test that tests the resetBill method. 
    */
   @Test public void resetBill()
   {
      iPhone1.resetBill();
      Assert.assertEquals(0, iPhone1.getIMessages());
   }
   
   /** A test that tests the toString method. 
    */
   @Test public void toStringTest()
   {
      boolean isTrue = iPhone1.toString().contains("55");
      Assert.assertTrue(isTrue);
   }
   
}
