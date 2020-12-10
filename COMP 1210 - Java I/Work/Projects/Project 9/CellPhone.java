import java.text.DecimalFormat;

/**
* This class stores cell phone data and provides methods to access the data.
* @author John Carroll
* @version 11-10-2013
*/
public abstract class CellPhone
{
   /**
   * Fields.
   *===========================================================**/
   
   /** number represents the cellphone number. */
   protected String number;
   /** texts represents the number of texts. */
   protected int texts;
   /** minutes represents the number of minutes. */
   protected int minutes;
   /** cellPhoneCount represents the number of cell phones instantiated. */
   private static int cellPhoneCount;
      
   /** 
   * Consructor: CellPhone.
   *============================================================*
   * @param num specifies the phone number.
   * @param txt specifies the texts made.
   * @param min specifies the minutes used.
   */	
   public CellPhone(String num, int txt, int min)
   {
      number = num;
      texts = txt;
      minutes = min;
      cellPhoneCount++;
   }
   
   
   /**
   * Methods.
   *============================================================*/   
   
   /** Method used to get the number.
   * @return number specfies cellphone number. */
   public String getNumber()
   {
      return number;
   }
   
   /** Method used to set the number.
   * @param numberIn specfies number being set. */
   public void setNumber(String numberIn)
   {
      number = numberIn;
   }
   
   /** Method used to get the number of texts.
   * @return texts specfies number of texts. */
   public int getTexts()
   {
      return texts;
   }
   
   /** Method used to set the number of texts.
   * @param textsIn specfies number of texts being set. */
   public void setTexts(int textsIn)
   {
      texts = textsIn;
   }

   /** Method used to get the number of minutes.
   * @return minutes specfies number of minutes. */
   public int getMinutes()
   {
      return minutes;
   }

   /** Method used to set the number of minutes.
   * @param minutesIn specfies number of minutes being set. */
   public void setMinutes(int minutesIn)
   {
      minutes = minutesIn;
   }

   /** Method used to get the number of cellphones.
   * @return cellPhoneCount which specfies the number of cellphones. */
   public static int getCellPhoneCount()
   {
      return cellPhoneCount;
   }
   
   /** Method used to reset the number of cellphones. */
   public static void resetCellPhoneCount()
   {
      cellPhoneCount = 0;
   }
   
   /** Method used to calculate the bill. 
   * @return bill specfies the calculated bill amount. */
   public abstract double calculateBill();
   
   /** Method used to reset the bill. */
   public abstract void resetBill();
   
   /** Method used to output the information. 
   * @return output specifies the stringed information. */
   public String toString()
   {
      DecimalFormat currency = new DecimalFormat("$#,##0.00");
   
      String output = "";
      output += "Number: " + number + " (";
      output += this.getClass().getName();
      output += ")\nBill: " + currency.format(calculateBill());
      output += " for " + texts + " Texts, ";
      output += minutes + " Talk Minutes";
      return output;
   }


}