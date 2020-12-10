/**
* This class will derive the FlipPhone class from the CellPhone class.
* @author John Carroll
* @version 11-10-2013
*/
public class FlipPhone extends CellPhone
{
   /**
   * Fields.
   *===========================================================**/
   
   /** Constant for the talk rate being charged. */
   public static final double TALK_RATE = 0.15;
   /** Constant for the text rate being charged. */
   public static final double TEXT_RATE = 0.25;
   
   /** 
   * Consructor: FlipPhone.
   *============================================================*
   * @param num specifies the phone number.
   * @param txt specifies the texts made.
   * @param min specifies the minutes used.
   */	
   public FlipPhone(String num, int txt, int min)
   {
      super(num, txt, min);
   }
   
   
   /**
   * Methods.
   *============================================================*/   

   /** Method used to calculate the bill.
   * @return bill specfies the calculated bill amount. */
   public double calculateBill()
   {
      double bill = texts * TEXT_RATE + minutes * TALK_RATE;
      return bill;
   }

   /** Method used to reset the bill amount. */
   public void resetBill()
   {
      texts = 0;
      minutes = 0;
   }
}