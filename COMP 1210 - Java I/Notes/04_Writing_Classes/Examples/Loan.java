public class Loan {
   
   private double balance = 0, interestRate, 
         maxLoanAmount;
   
   private static final double DEFAULT_INTEREST = 0.05;
   private static final double CUSTOMER_MAX = 10000;
   private static final double EMPLOYEE_MAX = 100000;   
   public static final int EMPLOYEE_ACCOUNT = 0;
   public static final int CUSTOMER_ACCOUNT = 1;
   
   public Loan(int accountType) {
      interestRate = DEFAULT_INTEREST;
         
      if (accountType == EMPLOYEE_ACCOUNT) {
         maxLoanAmount = EMPLOYEE_MAX;
      }
      else {
         maxLoanAmount = CUSTOMER_MAX;
      }
   }
   
   public double getBalance() {
      return balance;
   }
      
   public boolean setInterest(double newInterest) {
      
      if (newInterest >= 0 && newInterest <= 1) {
         interestRate = newInterest;
         return true;
      }
      else {
         return false;
      }
   }
   
   public boolean borrow(double amount) {
            
      if (balance + amount <= maxLoanAmount) {
         balance += amount;
         return true;
      }
      else {
         return false;
      }
   }
      
   public double calculateTotalBalance() {
      return balance * (1 + interestRate);
   }
   
   public String toString() {
      String output = "Loan amount: " 
            + balance + "\n" 
            + "Total balance with interest: $" 
            + calculateTotalBalance() 
            + "\n";
      return output;
   }
   
}
