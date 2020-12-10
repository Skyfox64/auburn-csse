import java.text.DecimalFormat;
/**
 * Creates an abstract CellPhone class.
 *
 *@author Garrett Knecht
 *@version 11-6-2013
 */
public abstract class CellPhone
{
 /** Creates String number.*/
   protected String number;
 /** Creates in minutes.*/  
   protected int minutes;
 /** Creates int texts.*/
   protected int texts;
 /** Creates static int cellPhoneCount.*/
   private static int cellPhoneCount = 0;
   
   /**
    * Creates CellPhone constructor.
    *@param numberIn String phone number
    *@param textsIn int for text messages
    *@param minutesIn int for cell minutes
    */
   public CellPhone(String numberIn, int textsIn, int minutesIn)
   {
      number = numberIn;
      minutes = minutesIn;
      texts = textsIn;
      cellPhoneCount++;
   }
   
   /**
    * gets private number.
    *@return number returns new number
    */
   public String getNumber()
   {
      return number;
   }
   
   /**
    * sets number.
    *@param numberIn String phone number
    */
   public void setNumber(String numberIn)
   {
      number = numberIn;   
   }
   
   /**
    * gets private texts.
    *@return texts returns texts
    */
   public int getTexts()
   {
      return texts;
   }
   
   /**
    * sets texts.
    *@param textsIn sets texts
    */
   public void setTexts(int textsIn)
   {
      texts = textsIn;
   }
   
   /**
    * gets minutes.
    *@return minutes returns minutes
    */
   public int getMinutes()
   {
      return minutes;
   }
   
   /**
    * sets minutes.
    *@param minutesIn sets mintues
    */
   public void setMinutes(int minutesIn)
   {
      minutes = minutesIn;
   }
   
   /**
    * gets cell phone count.
    *@return cellPhoneCount returns cell count
    */
   public static int getCellPhoneCount()
   {
      return cellPhoneCount;
   }
   
   /**
    * resets cell Phone count.
    */
   public static void resetCellPhoneCount()
   {
      cellPhoneCount = 0;
   }
   
   /**
    * calculates bill.
    *@return bill. gets bill
    */
   public abstract double calculateBill();
   
   /**
    * resets bill.
    */
   public abstract void resetBill();
   
   /**
    * prints out desired output.
    *@return output desired output.
    */
   public String toString()
   {
      DecimalFormat bills = new DecimalFormat("#,##0.00");
      String output = "";
      
      output += "Number: " + number + " (" 
         + this.getClass().getName() + ")";
      output += "\nBill: $" + bills.format(calculateBill())
         + " for " + texts + " Texts, " + minutes + " Talk Minutes";
      
      return output;
   }
   
}