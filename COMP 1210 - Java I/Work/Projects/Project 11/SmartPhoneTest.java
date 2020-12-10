import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
* This class tests for errors in the class: SmartPhone.
*
* @author John Carroll
* @version 12-5-2013
*/
public class SmartPhoneTest {

   private SmartPhone smart1;
   private SmartPhone smart2;
   
   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws NegativeValueException is value is negative.
    */
   @Before public void setUp() throws NegativeValueException {     
      smart1 = new SmartPhone("123-456-7891", 40, 21, 10);
      try {
         smart2 = new SmartPhone("130-232-2323", 10, 10, -10);
      }
      catch (NegativeValueException e) {
      }
   }
   
   
   /** A test that tests the getData method. 
    */
   @Test public void getDataTest()
   {
      Assert.assertEquals(10, smart1.getData());
   }
   
   /** A test that tests the setData method. 
    */
   @Test public void setDataTest()
   {
      smart1.setData(15);
      Assert.assertEquals(15, smart1.getData());
   }
   
   /** A test that tests the calculateBill method. 
    */
   @Test public void calculateBillTest()
   {
      Assert.assertEquals(22.6, smart1.calculateBill(), .0001);
      
      smart1.setMinutes(612);
      Assert.assertEquals(104.5, smart1.calculateBill(), .0001);
   }
   
   /** A test that tests the resetBill method. 
    */
   @Test public void resetBillTest()
   {
      smart1.resetBill();
      Assert.assertEquals(0, smart1.getTexts());
      Assert.assertEquals(0, smart1.getMinutes());
      Assert.assertEquals(0, smart1.getData());
   }
   
   /** A test that tests the toString method. 
    */
   @Test public void toStringTest()
   {
      String smartPhone = "Number: 123-456-7891 (SmartPhone)"
         + "\nBill: $22.60 for 40 Texts, 21 Talk Minutes, 10 MB of Data";
         
      Assert.assertEquals("toStringTest", smartPhone, smart1.toString());
   }
   
}
