import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * tests smart phone class.
 *
 *@author Garrett Knecht
 *@version 11-06-2013
 */
public class SmartPhoneTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Creates instance of SmartPhone. */
   private SmartPhone smart1 = new SmartPhone("123-456-7890", 40, 21, 10);

   /**
    * tests getData().
    */
   @Test public void getDataTest()
   {
      Assert.assertEquals(10, smart1.getData());
   }
   
   /** Tests setData().*/
   @Test public void setDataTest()
   {
      smart1.setData(15);
      Assert.assertEquals(15, smart1.getData());
   }
   
   /** Tests calculateBillTest().*/
   @Test public void calculateBillTest()
   {
      Assert.assertEquals(22.6, smart1.calculateBill(), .0001);
      
      smart1.setMinutes(612);
      Assert.assertEquals(104.5, smart1.calculateBill(), .0001);
   }
   
   /** Tests resetBill().*/
   @Test public void resetBillTest()
   {
      smart1.resetBill();
      Assert.assertEquals(0, smart1.getTexts());
      Assert.assertEquals(0, smart1.getMinutes());
      Assert.assertEquals(0, smart1.getData());
   }
   
   /** Tests toString().*/
   @Test public void toStringTest()
   {
      String smartPhone = "Number: 123-456-7890 (SmartPhone)"
         + "\nBill: $22.60 for 40 Texts, 21 Talk Minutes, 10 MB of Data";
         
      Assert.assertEquals("toStringTest", smartPhone, smart1.toString());
   }
   
}