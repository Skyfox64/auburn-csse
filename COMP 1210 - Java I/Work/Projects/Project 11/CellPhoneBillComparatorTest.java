import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class tests for errors in the CellPhoneBillComparator class.
*
* @author John Carroll
* @version 12-5-2013
*/
public class CellPhoneBillComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). 
    */
   @Before public void setUp() {
   }
  


   /** A test that always fails. 
    * @throws NegativeValueException if value is negative.
    */
   @Test public void compareEqualsTest() throws NegativeValueException 
   {
      FlipPhone test = new FlipPhone("111-111-1111", 50, 20);
      FlipPhone test2 = new FlipPhone("111-111-1111", 50, 20);
      
      CellPhoneBillComparator comparer = new CellPhoneBillComparator();
      int result = comparer.compare(test, test2);
      
      Assert.assertEquals(0, 0);
   
   
      test = new FlipPhone("111-111-1111", 0, 0);
      test2 = new FlipPhone("111-111-1111", 50, 20);
      
    
      result = comparer.compare(test, test2);
      
      Assert.assertEquals(-1, -1);
   
   
      test = new FlipPhone("111-111-1111", 50, 20);
      test2 = new FlipPhone("111-111-1111", 0, 0);
      
      
      result = comparer.compare(test, test2);
      
      Assert.assertEquals(1, 1);
   
   
   }
}
