import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test to test the getPlayerCount method. **/
   @Test public void min() {
      Selector s;
      int[] a = {12,2,8,4,2,10};
      Assert.assertEquals("Error", 2, s.min(a));
   }



  /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
}
