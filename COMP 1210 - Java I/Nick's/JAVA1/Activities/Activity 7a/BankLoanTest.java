   import org.junit.Assert;
   import org.junit.Before;
   import org.junit.Test;


   public class BankLoanTest {
   
   
      /** Fixture initialization (common initialization
       *  for all tests). **/
      @Before public void setUp() {
      }
   
   
     /** A test that doesn't fail. **/
      @Test public void chargeInterestTest() {
         BankLoan loan1 = new BankLoan("Jane", .10);
         loan1.borrowFromBank(1000.00);
         loan1.chargeInterest();
         Assert.assertEquals("Error", 1100, loan1.getBalance(), .0001);
      }
   }
