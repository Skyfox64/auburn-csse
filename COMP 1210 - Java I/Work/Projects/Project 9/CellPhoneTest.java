import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* This class tests for errors in the class: CellPhone.
* @author John Carroll
* @version 11-10-2013
*/
public class CellPhoneTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Creates instance of FlipPhone. **/
   private FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);


   /** A test that tests the getNumber method. **/
   @Test public void getNumberTest() {
      Assert.assertEquals("123-456-7890", flip1.getNumber());
   }
   
   /** A test that tests the setNumber method. **/
   @Test public void setNumberTest() {
   
      flip1.setNumber("098-765-4321");
   
      Assert.assertEquals("098-765-4321", flip1.getNumber());
   }
   
   /** A test that tests the getTexts method. **/
   @Test public void getTextsTest() {
      Assert.assertEquals(100, flip1.getTexts());
   }
   
   /** A test that tests the setTexts method. **/
   @Test public void setTextsTest() {
   
      flip1.setTexts(700);
      Assert.assertEquals(700, flip1.getTexts());
   }
   
   /** A test that tests the getMinutes method. **/
   @Test public void getMinutesTest() {
      Assert.assertEquals(100, flip1.getTexts());
   }
   
   /** A test that tests the setMinutes method. **/
   @Test public void setMinutesTest() {
   
      flip1.setMinutes(999);
      Assert.assertEquals(999, flip1.getMinutes());
   }
   
   /** A test that tests the toString method. **/
   @Test public void toStringTest()
   {
      String cellPhone = "Number: 123-456-7890 (FlipPhone)"
         + "\nBill: $32.50 for 100 Texts, 50 Talk Minutes";
         
      Assert.assertEquals(cellPhone, flip1.toString());
   }
   
}
