import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AndroidTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   Android android1 = new Android("123-456-7890", 500, 400, 1000, 30);

   @Test public void getHotspotMinTest()
   {
      Assert.assertEquals("Hot Spot Test", 30, android1.getHotspotMin());
   }
   
   @Test public void setHotspotMin()
   {
      android1.setHotspotMin(47);
      Assert.assertEquals("Set hot spot test", 47, android1.getHotspotMin());
   }
   
   @Test public void calculateBillTest()
   {
      Assert.assertEquals(362.5, android1.calculateBill(), .0001);
   }
   
   @Test public void resetBillTest()
   {
      android1.resetBill();
      Assert.assertEquals("reset bll test", 0, android1.getHotspotMin());
   }
   
   @Test public void toStringTest()
   {
      boolean isTrue = android1.toString().contains("30");
      Assert.assertTrue(isTrue);
   }
}
