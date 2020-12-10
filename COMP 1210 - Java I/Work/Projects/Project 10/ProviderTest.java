import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
* This class tests for errors in the class: Provider.
*
* @author John Carroll
* @version 11-21-2013
*/
public class ProviderTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
    
   @Before public void setUp() {
   }
   
   /**
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void readCellPhoneFileTest() throws IOException
   {
      Provider test = new Provider();
      test.readCellPhoneFile("provider1.dat");
    
      Assert.assertEquals("Test for Name", "AU Cellular Service", 
         test.getName());
      Assert.assertEquals("Test for count", 5, test.getPhones().length);
   }
   
   /** A test that tests the setName method. **/
   @Test public void setNameTest()
   {
      Provider test = new Provider();
      test.setName("Name");
      Assert.assertEquals("Test for set name", "Name", test.getName());
   }
   
   /** A test that tests the getPhones method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void getPhonesTest() throws IOException
   {  
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      CellPhone[] test1Array = test1.getPhones();
      
      FlipPhone flip1 = new FlipPhone("111-243-5948", 100, 50);
      FlipPhone flip2 = new FlipPhone("111-342-7544", 34, 955);
      Android android = new Android("111-934-9939", 500, 400, 1000, 30);
      IPhone iPhone = new IPhone("111-123-4567", 20, 548, 220, 55);
      SmartPhone smartPhone = new SmartPhone("111-131-3131", 40, 21, 10);
      
      CellPhone[] testArray = {flip1, flip2, android, iPhone, smartPhone};
      
      boolean[] test = new boolean[test1Array.length];
      for (int i = 0; i < test.length; i++) {
         String stringTest1 = test1Array[i].toString();
         String stringTest2 = testArray[i].toString();
         test[i] = stringTest1.equals(stringTest2);
      }
      
      boolean[] expected = {true, true, true, true, true};
      
      for (int i = 0; i < expected.length; i++) {
         Assert.assertEquals("Phones not set correctly.", test[i],
            expected[i]); 
      }
   } 

   /** A test that tests the getExcludedRecords method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void getExcludedRecordsTest() throws IOException
   {
      Provider test = new Provider();
      test.readCellPhoneFile("provider1.dat");
      String[] expected = {"BrickPhone,111-534-5948,100,50"};
      
      Assert.assertArrayEquals("excludedRecords test", expected, 
         test.getExcludedRecords());
   }
   
   /** A test that tests the addPhone method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void addPhoneTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      
     
      FlipPhone flip1 = new FlipPhone("111-243-5948", 100, 50);
      FlipPhone flip2 = new FlipPhone("111-342-7544", 34, 955);
      Android android = new Android("111-934-9939", 500, 400, 1000, 30);
      IPhone iPhone = new IPhone("111-123-4567", 20, 548, 220, 55);
      SmartPhone smartPhone = new SmartPhone("111-131-3131", 40, 21, 10);
      SmartPhone smartPhone2 = new SmartPhone("123-456-7890", 20, 20, 10);
      test1.addPhone(smartPhone2);
      CellPhone[] testArray = test1.getPhones();
      
      CellPhone[] actualArray = {flip1, flip2, android, iPhone,
         smartPhone, smartPhone2};
      boolean[] booleanTestArray = new boolean[testArray.length];
      boolean[] booleanActualArray = {true, true, true, true, true, true};
         
      for (int i = 0; i < booleanTestArray.length; i++) 
      {
         String string1 = testArray[i].toString();
         String string2 = actualArray[i].toString();
         booleanTestArray[i] = string1.equals(string2);
         
      }
      
      for (int i = 0; i < booleanTestArray.length; i++) 
      {
         Assert.assertEquals("addPhones test", booleanActualArray[i],
            booleanTestArray[i]); 
      }
   }
   
   /** A test that tests the deletePhone method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void deletePhoneTest() throws IOException 
   {
      //Generate provider
      Provider test1 = new Provider();
      //Read in a test array, filled with cellphones
      test1.readCellPhoneFile("provider1.dat");
      
      Assert.assertEquals("Test for boolean value of deletePhone",
                         true, test1.deletePhone("111-934-9939"));
      Assert.assertEquals("Test for boolean value of deletePhone",
                         false, test1.deletePhone("111-123-9999"));
                         
      //test1.deletePhone("111-934-9939");
      CellPhone[] testArray = test1.getPhones();
     
     
      //Create cellphones for an expected result
      FlipPhone flip1 = new FlipPhone("111-243-5948", 100, 50);
      FlipPhone flip2 = new FlipPhone("111-342-7544", 34, 955);
      IPhone iPhone = new IPhone("111-123-4567", 20, 548, 220, 55);
      SmartPhone smartPhone = new SmartPhone("111-131-3131", 40, 21, 10);
      //Deleted entry:
      //Android android = new Android("111-934-9939", 500, 400, 1000, 30);
      
      //Create an expected result
      CellPhone[] expectedArray = {flip1, flip2, iPhone, smartPhone};
      
      //Create boolean arrays: Test and Expected
      boolean[] booleanExpectedArray = {true, true, true, true};
      boolean[] booleanTestArray = new boolean[testArray.length];
      
         
      for (int i = 0; i < booleanTestArray.length; i++) 
      {
         String string1 = testArray[i].toString();
         String string2 = expectedArray[i].toString();
         booleanTestArray[i] = string1.equals(string2); 
      }
      
      for (int i = 0; i < booleanTestArray.length; i++) 
      {
         Assert.assertEquals("deletePhones test", booleanExpectedArray[i],
            booleanTestArray[i]); 
      }      
   }
   
            
    
   /** A test that tests the addExcludedRecords method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void addExcludedRecordsTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      test1.addExcludedRecord("NotAPhone,123-456-7890,14,70");
      String[] string1 = {"BrickPhone,111-534-5948,100,50",
         "NotAPhone,123-456-7890,14,70"};
      
      Assert.assertArrayEquals("tests addExcludedRecords", string1,
         test1.getExcludedRecords());      
   }
      
   /** A test that tests the calculateTotalBill method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void calculateTotalBillTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      double testBills = 664.40;
      
      Assert.assertEquals("test calculateTotalBill", testBills,
         test1.calculateTotalBill(), .001);   
   }
      
   /** A test that tests the calculateTotalTexts method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void calculateTotalTextsTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      int testTexts = 694;
      
      Assert.assertEquals("Tests calculateTotalTexts", testTexts,
         test1.calculateTotalTexts());
   }
        
   /** A test that tests the calculateTotalMinutes method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void calculateTotalMinutesTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      int testMins = 1974;
      
      Assert.assertEquals("test calculateTotalMinutes", testMins,
         test1.calculateTotalMinutes());
   }
   
   /** A test that tests the calculateTotalData method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void calculateTotalDataTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      int testData = 1230;
     
      Assert.assertEquals("tests calculateTotalData", testData,
         test1.calculateTotalData());
   }
            
   /** A test that tests the calculateTotalHotspotMin method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void calculateTotalHotspotMinTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      int testHotspot = 30;
       
      Assert.assertEquals("tests calculateTotalHotspotMin", testHotspot,
         test1.calculateTotalHotspotMin());
   }
      
   /** A test that tests the calculateTotalIMessage method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void calculateTotalIMessagesTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      int testIMessage = 55;
      
      Assert.assertEquals("tests calculateTotalIMessages", testIMessage,
         test1.calculateTotalIMessages());
   }
   
   /** A test that tests the summary method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void summaryTest() throws IOException {
      
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      
      CellPhone.resetCellPhoneCount();
   
      
      String summTest = "------------------------------\n"
         + "Summary for AU Cellular Service\n"
         + "------------------------------\n"
         + "Number of cell phones: 0\n"
         + "Texts: 694\n"
         + "Talk Minutes: 1974\n"
         + "Data: 1230\n"
         + "Hotspot Minutes: 30\n"
         + "iMessages: 55\n"
         + "Bill Total: $664.40\n";
      
      Assert.assertEquals("Test for the summary.", summTest,
         test1.summary());
   }
         
   /** A test that tests the rates method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void ratesTest() throws IOException
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      String ratesTest = "------------------------------\n"
         + "Rates for AU Cellular Service\n"
         + "------------------------------\n"
         + "FlipPhone Talk Rate: $0.15"
         + "   Text Rate: $0.25\n"
         + "SmartPhone Talk Rate: $0.10"
         + "   Text Rate: $0.50"
         + "   Max Talk Time: 600.0\n"
         + "   iPhone iMessage Rate: $0.35\n"
         + "   Android Hotspot Rate: $0.75\n";         
         
      Assert.assertEquals("tests rates", ratesTest,
         test1.rates());      
   
   }
     
   /** A test that tests the listByNumber method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void listByNumberTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      test1.deletePhone("111-243-5948");
      test1.deletePhone("111-342-7544");
      test1.deletePhone("111-934-9939");
                  
      String listByNumberTest = "------------------------------"
         + "\nCell Phones by Number"
         + "\n------------------------------\n\n"
         + "Number: 111-123-4567 (IPhone)"
         + "\nBill: $95.05 for 20 Texts, 548 Talk Minutes," 
         + " 220 MB of Data, 55 iMessages\n"
         + "\nNumber: 111-131-3131 (SmartPhone)"
         + "\nBill: $22.60 for 40 Texts, 21 Talk Minutes, 10 MB of Data\n\n";
         
      Assert.assertEquals("tests listByNumber", listByNumberTest,
         test1.listByNumber());
   }
   
   /** A test that tests the listByBill method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void listByBillTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      test1.deletePhone("111-243-5948");
      test1.deletePhone("111-342-7544");
      test1.deletePhone("111-934-9939");
                  
      String listByBillTest = "------------------------------"
         + "\nCell Phones by Billing Amount"
         + "\n------------------------------\n"
         + "\nNumber: 111-131-3131 (SmartPhone)"
         + "\nBill: $22.60 for 40 Texts, 21 Talk Minutes, 10 MB of Data\n"
         + "\nNumber: 111-123-4567 (IPhone)"
         + "\nBill: $95.05 for 20 Texts, 548 Talk Minutes,"
         + " 220 MB of Data, 55 iMessages\n\n";
         
      Assert.assertEquals("tests listByNumber", listByBillTest,
         test1.listByBill());
   }
     
   /** A test that tests the excludedRecordsList method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void excludedRecordsListTest() throws IOException {
      
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      
      String excludedRecordsTest = "------------------------------"
         + "\nExcluded Records"
         + "\n------------------------------\n"
         + "\nBrickPhone,111-534-5948,100,50\n";
         
      Assert.assertEquals("tests excludedRecordsList", excludedRecordsTest,
         test1.excludedRecordsList());
   }  
   

   /** A test that tests the toString method.
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   @Test public void toStringTest() throws IOException
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider1.dat");
      test1.deletePhone("111-243-5948");
      test1.deletePhone("111-342-7544");
      test1.deletePhone("111-934-9939");
                  
      String toStringTest = "\nNumber: 111-123-4567 (IPhone)"
         + "\nBill: $95.05 for 20 Texts, 548 Talk Minutes,"
         + " 220 MB of Data, 55 iMessages\n"
         + "\nNumber: 111-131-3131 (SmartPhone)"
         + "\nBill: $22.60 for 40 Texts, 21 Talk Minutes, 10 MB of Data\n";
         
      Assert.assertEquals("Test for the toString.", toStringTest,
         test1.toString());     
   }
   
}
