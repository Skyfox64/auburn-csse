import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CellPhonesPart1Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void cellPhoneCountTest()
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100,50);
      SmartPhone smart1 = new SmartPhone("123-456-7890", 40, 21, 10);
      IPhone iPhone1 = new IPhone("123-456-7890", 20, 548, 220, 55);
      Android android1 = new Android("123-456-7890", 500, 400, 1000, 30);
      
      Assert.assertEquals("cell phone count test", 4, CellPhone.getCellPhoneCount());
   }
   
   @Test public void resetCellPhoneCountTest()
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100,50);
      SmartPhone smart1 = new SmartPhone("123-456-7890", 40, 21, 10);
      IPhone iPhone1 = new IPhone("123-456-7890", 20, 548, 220, 55);
      Android android1 = new Android("123-456-7890", 500, 400, 1000, 30);
      
      CellPhone.resetCellPhoneCount();
      Assert.assertEquals("reset cell phone count test", 0, CellPhone.getCellPhoneCount());
   }
}
