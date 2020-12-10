   import org.junit.Assert;
   import org.junit.Before;
   import org.junit.Test;


   public class BankLoanTest {

	@Test public void addBalanceTest()
	{
		BankLoan loan = new BankLoan("Joan", 0.08);
		loan.borrowFromBank(100);
		
	Assert.assertEquals("The getBalance method returned an incorrect "
		+ "value after $100 was added.", 100, loan.getBalance(), 0.01);
	}
	
	
	@Test public void amountValidTest()
	{
		Assert.assertEquals("isAmountValid failed for value -1.",
		false, BankLoan.isAmountValid(-1));
		
		Assert.assertEquals("isAmountValid failed for value 1.",
		true, BankLoan.isAmountValid(1));
	}
	
   }
