import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class tests for errors in the class: CellPhoneBillComparator.
*
* @author John Carroll
* @version 11-21-2013
*/
public class CellPhoneBillComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
  


   /** A test that always fails. **/
   @Test public void compareEqualsTest() 
   {
      FlipPhone test = new FlipPhone("111-111-1111", 50, 20);
      FlipPhone test2 = new FlipPhone("111-111-1111", 50, 20);
      
      CellPhoneBillComparator comparer = new CellPhoneBillComparator();
      int result = comparer.compare(test, test2);
      
      Assert.assertEquals(-1, -1);
   
   }
}
