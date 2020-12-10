/**
* This class will derive the SmartPhone class from the CellPhone class.
* @author John Carroll
* @version 11-10-2013
*/
public class SmartPhone extends CellPhone
{

   /**
   * Fields.
   *===========================================================**/
   
   /** data represents the data usage. */
   protected int data;
   /** Constant for the talk rate being charged. */
   public static final double TALK_RATE = 0.10;
   /** Constant for the text rate being charged. */
   public static final double TEXT_RATE = 0.50;
   /** Constant for the talk rate when going overtime being charged. */
   public static final double OVERTIME_TALK_RATE = 2.0;
   /** Constant representing the Maximum talk rate. */
   public static final double MAX_TALK_TIME = 600.0;
   /** Constant representing the data rate being charged. */
   public static final double DATA_RATE = 0.05;
 
   /** 
   * Consructor: SmartPhone.
   *============================================================*
   * @param num specifies the phone number.
   * @param txt specifies the texts made.
   * @param min specifies the minutes used.
   * @param dataIn specifies data used.
   */	
   public SmartPhone(String num, int txt, int min, int dataIn)
   {
      super(num, txt, min);
      data = dataIn;
   }
   
   /**
   * Methods.
   *============================================================*/   
   
   /** Method used to get the data.
   * @return data specfies data used. */
   public int getData()
   {
      return data;
   }
   
   /** Method used to set the data.
   * @param dataIn specfies data used. */
   public void setData(int dataIn)
   {
      data = dataIn;
   }
   
   /** Method used to calculate the bill.
   * @return bill specfies the calculated bill amount. */
   public double calculateBill()
   {
      double minCharge;
      if (minutes < MAX_TALK_TIME)
      {
         minCharge = minutes * TALK_RATE;
      }
      else
      {
         minCharge = (MAX_TALK_TIME * TALK_RATE);
         minCharge += (minutes - MAX_TALK_TIME) * OVERTIME_TALK_RATE;
      }
      double bill = texts * TEXT_RATE + DATA_RATE * data; 
      bill += minCharge;
      return bill;
   }
   
   /** Method used to reset the bill amount. */
   public void resetBill()
   {
      texts = 0;
      minutes = 0;
      data = 0;
   }
   
   
   /** Method used to output the information. 
   * @return output specifies the stringed information. */
   public String toString()
   {
      String output = super.toString() + ", " + data + " MB of Data";
      return output;  
   }
}