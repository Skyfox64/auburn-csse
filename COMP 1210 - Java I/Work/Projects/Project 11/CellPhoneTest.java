import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
* This class tests for errors in the class: CellPhone.
*
* @author John Carroll
* @version 12-5-2013
*/
public class CellPhoneTest {
   


   /** Fixture initialization (common initialization
    *  for all tests). 
    */
   @Before public void setUp() 
   {
   }
  


   /** A test that tests the getNumber method.
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void getNumberTest() throws NegativeValueException
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);            
   
      Assert.assertEquals("123-456-7890", flip1.getNumber());
   }
   
   /** A test that tests the setNumber method. 
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void setNumberTest() throws NegativeValueException
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);            
   
      flip1.setNumber("098-765-4321");
   
      Assert.assertEquals("098-765-4321", flip1.getNumber());
   }
   
   /** A test that tests the getTexts method. 
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void getTextsTest() throws NegativeValueException
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);            
   
      Assert.assertEquals(100, flip1.getTexts());
   }
   
   /** A test that tests the setTexts method. 
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void setTextsTest() throws NegativeValueException
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);            
   
      flip1.setTexts(700);
      Assert.assertEquals(700, flip1.getTexts());
   }
   
   /** A test that tests the getMinutes method. 
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void getMinutesTest() throws NegativeValueException {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);            
   
      Assert.assertEquals(100, flip1.getTexts());
   }
   
   /** A test that tests the setMinutes method. 
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void setMinutesTest() throws NegativeValueException
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);            
   
      flip1.setMinutes(999);
      Assert.assertEquals(999, flip1.getMinutes());
   }
   
   /** A test that tests the toString method. 
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void toStringTest() throws NegativeValueException
   {
      String cellPhone = "Number: 123-456-7890 (FlipPhone)"
         + "\nBill: $32.50 for 100 Texts, 50 Talk Minutes";
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);            
   
      Assert.assertEquals(cellPhone, flip1.toString());
   }
   
   /** compareToTest.
    *@throws NegativeValueException if the number is negative.
    */
   @Test public void compareToTest() throws NegativeValueException
   {
      FlipPhone flip2 = new FlipPhone("111-243-5948", 100, 50);
      FlipPhone flip3 = new FlipPhone("111-342-7544", 34, 955);
      
      Assert.assertEquals("Test for compareTo", -1, 
         flip2.compareTo(flip3));
   }
}
