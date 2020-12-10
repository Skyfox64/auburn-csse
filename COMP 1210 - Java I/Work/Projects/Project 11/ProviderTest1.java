import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;

/**
* This class tests for errors in the class: Provider.
*
* @author James Bass
* @version 11-21-2013
*/
public class ProviderTest1 {
   private Provider p = new Provider();
   /** Fixture initialization (common initialization
    *  for all tests). 
    */
    
   @Before public void setUp() throws NegativeValueException
   {
      CellPhone.resetCellPhoneCount();
      FlipPhone flip1 = new FlipPhone("111-243-5948", 100, 50);
      FlipPhone flip2 = new FlipPhone("111-243-6924", 30, 77);
      Android android1 = new Android("111-934-9939", 500, 400, 1000, 30);
      IPhone iphone1 = new IPhone("111-123-4567", 20, 548, 220, 55);
      SmartPhone smartPhone1 = new SmartPhone("111-131-3131", 40, 21, 10);
      String brickPhone = "BrickPhone,111-534-5948,100,50";
      p.addPhone(flip1);
      p.addPhone(flip2);
      p.addPhone(android1);
      p.addPhone(iphone1);
      p.addPhone(smartPhone1);
      p.setName("AU Cellular Service");
      p.addExcludedRecord(brickPhone);
   }
   
   /**
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void readCellPhoneFileTest() throws IOException
   {
      Provider read = new Provider();
      read.readCellPhoneFile("provider3.csv");
    
      Assert.assertEquals("Test for Name", "AU Cellular Service", 
         read.getName());
      Assert.assertEquals("Test for count", 5, read.getPhones().length);
   }
   
   /** A test that tests the setName method. 
    */
   @Test public void setNameTest()
   {
      p.setName("Name");
      Assert.assertEquals("Test for set name", "Name", p.getName());
   }
   
   /** A test that tests the getPhones method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void getPhonesTest() throws IOException, NegativeValueException
   {  
      
      FlipPhone flip1 = new FlipPhone("111-243-5948", 100, 50);
      FlipPhone flip2 = new FlipPhone("111-243-6924", 30, 77);
      Android android1 = new Android("111-934-9939", 500, 400, 1000, 30);
      IPhone iphone1 = new IPhone("111-123-4567", 20, 548, 220, 55);
      SmartPhone smartPhone1 = new SmartPhone("111-131-3131", 40, 21, 10);
      
      CellPhone[] expected = {flip1, flip2, android1, iphone1, smartPhone1};
      
      Assert.assertEquals("Test for getPhones", 
                           Arrays.toString(expected),
                           Arrays.toString(p.getPhones()));
   } 

   /** A test that tests the getExcludedRecords method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void getExcludedRecordsTest() throws IOException
   {
      Provider test = new Provider();
      test.readCellPhoneFile("provider3.csv");
      String[] expected = {"BrickPhone,111-534-5948,100,50"};
      
      Assert.assertArrayEquals("excludedRecords test", expected, 
         test.getExcludedRecords());
   }
   
   /** A test that tests the addPhone method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void addPhoneTest() throws IOException, NegativeValueException
   {
      
     
      FlipPhone flip1 = new FlipPhone("111-243-5948", 100, 50);
      FlipPhone flip2 = new FlipPhone("111-243-6924", 30, 77);
      Android android1 = new Android("111-934-9939", 500, 400, 1000, 30);
      IPhone iphone1 = new IPhone("111-123-4567", 20, 548, 220, 55);
      SmartPhone smartPhone1 = new SmartPhone("111-131-3131", 40, 21, 10);
      SmartPhone smartPhone2 = new SmartPhone("123-456-7890", 20, 20, 10);
      CellPhone[] expected = {flip1, flip2, android1, iphone1, smartPhone1, smartPhone2};
      
      
      
      p.addPhone(smartPhone2);
      Assert.assertEquals("Test for addPhones", 
                           Arrays.toString(expected),
                           Arrays.toString(p.getPhones()));
   }
   
   /** A test that tests the deletePhone method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void deletePhoneTest() throws IOException, NegativeValueException 
   {
      FlipPhone flip1 = new FlipPhone("111-243-5948", 100, 50);
      Android android1 = new Android("111-934-9939", 500, 400, 1000, 30);
      IPhone iphone1 = new IPhone("111-123-4567", 20, 548, 220, 55);
      SmartPhone smartPhone1 = new SmartPhone("111-131-3131", 40, 21, 10);
      CellPhone[] expected = {flip1, android1, iphone1, smartPhone1};
   
      p.deletePhone("111-243-6924");  
      Assert.assertEquals("Test for addPhones", 
                           Arrays.toString(expected),
                           Arrays.toString(p.getPhones())); 
   }
   
            
    
   /** A test that tests the addExcludedRecords method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void addExcludedRecordsTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider3.csv");
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
      double testBills = 531.70;
      
      Assert.assertEquals("test calculateTotalBill", testBills,
         p.calculateTotalBill(), .001);   
   }
      
   /** A test that tests the calculateTotalTexts method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void calculateTotalTextsTest() throws IOException 
   {
      Provider test1 = new Provider();
      test1.readCellPhoneFile("provider3.csv");
      int testTexts = 694;
      
      Assert.assertEquals("Tests calculateTotalTexts", testTexts,
         p.calculateTotalTexts());
   }
        
   /** A test that tests the calculateTotalMinutes method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void calculateTotalMinutesTest() throws IOException 
   {
      int testMins = 1096;
      
      Assert.assertEquals("test calculateTotalMinutes", testMins,
         p.calculateTotalMinutes());
   }
   
   /** A test that tests the calculateTotalData method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void calculateTotalDataTest() throws IOException 
   {
      int testData = 1230;
     
      Assert.assertEquals("tests calculateTotalData", testData,
         p.calculateTotalData());
   }
            
   /** A test that tests the calculateTotalHotspotMin method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void calculateTotalHotspotMinTest() throws IOException 
   {
      int testHotspot = 30;
       
      Assert.assertEquals("tests calculateTotalHotspotMin", testHotspot,
         p.calculateTotalHotspotMin());
   }
      
   /** A test that tests the calculateTotalIMessage method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void calculateTotalIMessagesTest() throws IOException 
   {
      int testIMessage = 55;
      
      Assert.assertEquals("tests calculateTotalIMessages", testIMessage,
         p.calculateTotalIMessages());
   }
   
   /** A test that tests the summary method.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   @Test public void summaryTest() throws IOException {
      
      
      
      String summTest = "------------------------------\n"
         + "Summary for AU Cellular Service\n"
         + "------------------------------\n"
         + "Number of cell phones: 5\n"
         + "Texts: 690\n"
         + "Talk Minutes: 1096\n"
         + "Data: 1230\n"
         + "Hotspot Minutes: 30\n"
         + "iMessages: 55\n"
         + "Bill Total: $531.70\n";
      
      Assert.assertEquals("Test for the summary.", summTest,
         p.summary());
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
      
      
      String excludedRecordsTest = "------------------------------"
         + "\nExcluded Records"
         + "\n------------------------------\n"
         + "\nBrickPhone,111-534-5948,100,50\n";
         
      Assert.assertEquals("tests excludedRecordsList", excludedRecordsTest,
         p.excludedRecordsList());
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
