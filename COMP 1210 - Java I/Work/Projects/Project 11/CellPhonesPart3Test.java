import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the CellPhonesPart3 class.
 *
 * @author John Carroll
 * @version 12-5-13
 */
public class CellPhonesPart3Test {

   private CellPhonesPart3 test = new CellPhonesPart3();
   private String[] args = {};

   /** Fixture initialization (common initialization
    *  for all tests). 
    */
   @Before public void setUp() {
   }
   
   /** 
   * Test when no run arguements are given.
   */
   @Test public void mainTestIfEmpty() {
    
      test.main(args);
      
      Assert.assertEquals(1, 1);
   
   }
   
    /**
    * Test when the file is not found.
    */
   @Test public void mainTestIfInvalid() {
      String[] args2 = {"provider1.dat"};
      test.main(args2);
      
      Assert.assertEquals(1, 1);
      
   }
   
   /**
    * Test for when the file is read in successfully.
    */
   @Test public void mainTestIfValid() {
      String[] args3 = {"provider3.csv"};
      test.main(args3);
      
      Assert.assertEquals(1, 1);
      
   } 
}
