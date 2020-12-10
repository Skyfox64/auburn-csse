import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;


/**
* This class tests for errors in the class: CellPhonesPart2.
*
* @author John Carroll
* @version 11-21-2013
*/
public class CellPhonesPart2Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
    /** A test for the CellPhonesPart2.
    *@throws IOException throws IOException*/
   @Test public void compareTest() throws IOException 
   {  
      CellPhone.resetCellPhoneCount();
      
      CellPhonesPart2 test = new CellPhonesPart2();
      String[] args = {"provider1.dat"};
      test.main(args);
      
      Assert.assertEquals("Number of CellPhone objects created incorrect.", 5,
         CellPhone.getCellPhoneCount());
   }
}
