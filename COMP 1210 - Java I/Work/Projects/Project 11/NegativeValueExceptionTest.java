import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *tests the NegativeValueException class.
 *
 *
 * @author John Carroll
 * @version 12-5-2013
 */

public class NegativeValueExceptionTest {


   /** Fixture initialization (common initialization
    *  for all tests). 
    */
   @Before public void setUp() {
   }

   /** tests if NegativeValueException has been thrown.
    *   
    */
   @Test public void negativeValueExceptionThrowTest() { 
      boolean thrown = false; 
      try { 
         FlipPhone fp = new FlipPhone("123-456-7890", -100, 200); 
      }
      catch (NegativeValueException e) { 
         thrown = true; 
      }
      Assert.assertTrue(thrown); 
   }
   /** tests if NegativeValueException has been thrown.
    *   
    */
   @Test public void negativeValueExceptionThrowTest2() { 
      boolean thrown = false; 
      try { 
         FlipPhone fp2 = new FlipPhone("123-456-7890", 100, 200); 
      }
      catch (NegativeValueException e) { 
         thrown = true; 
      }
      Assert.assertFalse(thrown); 
   }
}
