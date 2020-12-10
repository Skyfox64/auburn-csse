/**
 * This class will derive the FlipPhone class from the CellPhone class.
 *
 * @author John Carroll
 * @version 12-5-2013
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
    * @param numIn specifies the phone number.
    * @param txtIn specifies the texts made.
    * @param minIn specifies the minutes used.
    * @throws NegativeValueException if value is negative.*/	
   public FlipPhone(String numIn, int txtIn, int minIn) 
      throws NegativeValueException
   {
      super(numIn, txtIn, minIn);
   }
   
   
   /**
    * Methods.
    *============================================================**/

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