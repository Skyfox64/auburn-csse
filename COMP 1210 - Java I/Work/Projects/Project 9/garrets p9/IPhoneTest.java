import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class IPhoneTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   IPhone iPhone1 = new IPhone("123-456-7890", 20, 548, 220, 55);

   @Test public void getImessagesTest()
   {
      Assert.assertEquals("iMessage Test", 55, iPhone1.getIMessages());
   }
   
   @Test public void setIMessagesTest()
   {
      iPhone1.setIMessages(34);
      Assert.assertEquals("Set iMessages", 34, iPhone1.iMessages);
   }
   
   @Test public void calculateBillTest()
   {
      Assert.assertEquals(95.05, iPhone1.calculateBill(), 0001);
   }
   
   @Test public void resetBill()
   {
      iPhone1.resetBill();
      Assert.assertEquals(0, iPhone1.getIMessages());
   }
   
   @Test public void toStringTest()
   {
      boolean isTrue = iPhone1.toString().contains("55");
      Assert.assertTrue(isTrue);
   }
   
}
