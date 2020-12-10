/**
 * creates class for flip phone object.
 *
 *@author Garrett Knecht
 *@version 11-6-2013
 */
public class FlipPhone extends CellPhone
{
   /** public constant.*/
   public static final double TALK_RATE = 0.15;
   /** public constant for texts. */
   public static final double TEXT_RATE = 0.25;
   
   /**
    * Constructor for flip phone.
    *@param numberIn gets number
    *@param textsIn gets texts
    *@param minutesIn gets minutes
    */
   public FlipPhone(String numberIn, int textsIn, int minutesIn)
   {
      super(numberIn, textsIn, minutesIn);
   }
   
   /**
    * calculates bill.
    *@return bill returns bill
    */
   public double calculateBill()
   {
      double bill = (texts * TEXT_RATE) + (minutes * TALK_RATE);
      return bill;
   }
   
   /**
    * resets bill.
    */
   public void resetBill()
   {
      texts = 0;
      minutes = 0;
   }
   
   
}