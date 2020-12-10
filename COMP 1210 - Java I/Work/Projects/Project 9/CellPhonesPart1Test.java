import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
* This class tests the class: CellPhonePart1.
* @author John Carroll
* @version 11-10-2013
*/
public class CellPhonesPart1Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** A test that tests the getCellPhoneCount method. **/
   @Test public void getCellPhoneCountTest()
   {
      CellPhonesPart1 cp = new CellPhonesPart1();
      
      CellPhone.resetCellPhoneCount();
   
      CellPhonesPart1.main(null); 
      
      Assert.assertEquals("CellPhone.cellPhoneCount should be 4. ", 4,
          CellPhone.getCellPhoneCount());
   }      
}
