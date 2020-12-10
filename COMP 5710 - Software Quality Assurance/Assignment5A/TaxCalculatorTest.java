import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaxCalculatorTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp(){
   }
   TaxCalculator tc = new TaxCalculator();
   
   //100: calculateTax
   //100_100: Happy Paths
   //Single Filing
   @Test public void test100_005_shouldCalculateTax_1_TIER1() {
      int testInput1_status = 1;
      int testInput2_income = 0;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }      
   
   @Test public void test100_010_shouldCalculateTax_1_TIER1() {
      int testInput1_status = 1;
      int testInput2_income = 10;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }    
   
   @Test public void test100_015_shouldCalculateTax_1_TIER1() {
      int testInput1_status = 1;
      int testInput2_income = 5990;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }  
   
   @Test public void test100_020_shouldCalculateTax_1_TIER1() {
      int testInput1_status = 1;
      int testInput2_income = 6000;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }  
   @Test public void test100_025_shouldCalculateTax_1_TIER2() {
      int testInput1_status = 1;
      int testInput2_income = 6010;
      
      int expectedReturn = 1;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_030_shouldCalculateTax_1_TIER2() {
      int testInput1_status = 1;
      int testInput2_income = 54990;
      
      int expectedReturn = 4899;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_035_shouldCalculateTax_1_TIER2() {
      int testInput1_status = 1;
      int testInput2_income = 55000;
      
      int expectedReturn = 4900;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_040_shouldCalculateTax_1_TIER3() {
      int testInput1_status = 1;
      int testInput2_income = 55010;
      
      int expectedReturn = 4902;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_045_shouldCalculateTax_1_TIER3() {
      int testInput1_status = 1;
      int testInput2_income = 104990;
      
      int expectedReturn = 14898;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_050_shouldCalculateTax_1_TIER3() {
      int testInput1_status = 1;
      int testInput2_income = 105000;
      
      int expectedReturn = 14900;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_055_shouldCalculateTax_1_TIER4() {
      int testInput1_status = 1;
      int testInput2_income = 105010;
      
      int expectedReturn = 14903;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_060_shouldCalculateTax_1_TIER4() {
      int testInput1_status = 1;
      int testInput2_income = 159990;
      
      int expectedReturn = 31397;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_065_shouldCalculateTax_1_TIER4() {
      int testInput1_status = 1;
      int testInput2_income = 160000;
      
      int expectedReturn = 31400;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 

   @Test public void test100_070_shouldCalculateTax_1_TIER5() {
      int testInput1_status = 1;
      int testInput2_income = 160010;
      
      int expectedReturn = 31404;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
      
   
   
   
   //Joint Filing
   @Test public void test100_105_shouldCalculateTax_2_TIER1() {      
      int testInput1_status = 2;
      int testInput2_income = 0;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      
      String errorMessage = "\n" 
                              + "\tStatus: " + testInput1_status
                              + "\tIncome: " + testInput2_income;
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }     
   
   @Test public void test100_110_shouldCalculateTax_2_TIER1() {
      int testInput1_status = 1;
      int testInput2_income = 10;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }    
   
   @Test public void test100_115_shouldCalculateTax_2_TIER1() {
      int testInput1_status = 2;
      int testInput2_income = 9990;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }  
   
   @Test public void test100_120_shouldCalculateTax_2_TIER1() {
      int testInput1_status = 2;
      int testInput2_income = 10000;
      
      int expectedReturn = 0;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   }  
   @Test public void test100_125_shouldCalculateTax_2_TIER2() {
      int testInput1_status = 2;
      int testInput2_income = 10010;
      
      int expectedReturn = 1;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_130_shouldCalculateTax_2_TIER2() {
      int testInput1_status = 2;
      int testInput2_income = 69990;
      
      int expectedReturn = 5999;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_135_shouldCalculateTax_2_TIER2() {
      int testInput1_status = 2;
      int testInput2_income = 70000;
      
      int expectedReturn = 6000;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_140_shouldCalculateTax_2_TIER3() {
      int testInput1_status = 2;
      int testInput2_income = 70010;
      
      int expectedReturn = 6002;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_145_shouldCalculateTax_2_TIER3() {
      int testInput1_status = 2;
      int testInput2_income = 119990;
      
      int expectedReturn = 15998;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_150_shouldCalculateTax_2_TIER3() {
      int testInput1_status = 2;
      int testInput2_income = 120000;
      
      int expectedReturn = 16000;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_155_shouldCalculateTax_2_TIER4() {
      int testInput1_status = 2;
      int testInput2_income = 120010;
      
      int expectedReturn = 16003;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_160_shouldCalculateTax_2_TIER4() {
      int testInput1_status = 2;
      int testInput2_income = 249990;
      
      int expectedReturn = 54997;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 
   
   @Test public void test100_165_shouldCalculateTax_2_TIER4() {
      int testInput1_status = 2;
      int testInput2_income = 250000;
      
      int expectedReturn = 55000;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 

   @Test public void test100_170_shouldCalculateTax_2_TIER5() {
      int testInput1_status = 2;
      int testInput2_income = 250010;
      
      int expectedReturn = 55004;
      int actualReturn = tc.calculateTax(testInput1_status, testInput2_income);
      String errorMessage = "\n" 
         + "\tStatus: " + testInput1_status
         + "\tIncome: " + testInput2_income
         + "\n";
      Assert.assertEquals(errorMessage, expectedReturn, actualReturn);
   } 

   //100_900: Sad Paths
   @Test(expected = IllegalArgumentException.class) 
    public void test100_905_shouldRaiseExceptionOnIllegalArgument_Status() { 
      int testInput1_status = 0;
      int testInput2_income = 6000;
      tc.calculateTax(testInput1_status, testInput2_income);
   }
   
   @Test(expected = IllegalArgumentException.class) 
    public void test100_910_shouldRaiseExceptionOnIllegalArgument_Status() { 
      int testInput1_status = -1;
      int testInput2_income = 6000;
      tc.calculateTax(testInput1_status, testInput2_income);
   }
   
   @Test(expected = IllegalArgumentException.class) 
    public void test100_915_shouldRaiseExceptionOnIllegalArgument_Status() { 
      int testInput1_status = 3;
      int testInput2_income = 6000;
      tc.calculateTax(testInput1_status, testInput2_income);
   }
   
   @Test(expected = IllegalArgumentException.class) 
    public void test100_920_shouldRaiseExceptionOnIllegalArgument_1_NegativeIncome() { 
      int testInput1_status = 1;
      int testInput2_income = -1;
      tc.calculateTax(testInput1_status, testInput2_income);
   }
   
   @Test(expected = IllegalArgumentException.class) 
    public void test100_925_shouldRaiseExceptionOnIllegalArgument_1_NegativeIncome() { 
      int testInput1_status = 1;
      int testInput2_income = -20;
      tc.calculateTax(testInput1_status, testInput2_income);
   }
   
   @Test(expected = IllegalArgumentException.class) 
    public void test100_930_shouldRaiseExceptionOnIllegalArgument_2_NegativeIncome() { 
      int testInput1_status = 2;
      int testInput2_income = -1;
      tc.calculateTax(testInput1_status, testInput2_income);
   }
   
   @Test(expected = IllegalArgumentException.class) 
    public void test100_935_shouldRaiseExceptionOnIllegalArgument_2_NegativeIncome() { 
      int testInput1_status = 2;
      int testInput2_income = -20;
      tc.calculateTax(testInput1_status, testInput2_income);
   }
}