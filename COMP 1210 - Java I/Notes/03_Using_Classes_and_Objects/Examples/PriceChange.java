import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

  /**
* Calculates the percent change between 2 prices.
*/
public class PriceChange {
   /**
    * Calculates the percent change between 2 prices.
    *
    * @param args Command-line arguments (unused). 
    */
   public static void main(String[] args) {
      double initialPrice, finalPrice;
   
      Scanner input = new Scanner(System.in);
    
      NumberFormat percentFmt = NumberFormat.getPercentInstance();
      NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();  
   	
      System.out.print("Enter the initial price: ");
      initialPrice = input.nextDouble();
   
      System.out.print("Enter the final price: ");
      finalPrice = input.nextDouble();
      
      System.out.println("\r\nThe initial price that you entered was "
          + currencyFmt.format(initialPrice) + ".");
   	
      System.out.println("The final price that you entered was "
          + currencyFmt.format(finalPrice) + ".");
   	
      System.out.print("\r\nThere was an approximate " 
         + percentFmt.format((finalPrice - initialPrice) / initialPrice)
         + " change in price.");
         
    // DecimalFormat could be used here instead of CurrencyFormat 
    // using 0 will ensure that 2 decimal places are always included
      DecimalFormat dollarFmt = new DecimalFormat("$0.00");
      System.out.print("\r\nThere was " 
         + dollarFmt.format(finalPrice - initialPrice) 
         + " change in price.");
   
   
   }
}
