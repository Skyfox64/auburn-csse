/**
* This class will derive the IPhone class from the SmartPhone class.
*
* @author John Carroll
* @version 12-5-2013
*/
public class IPhone extends SmartPhone
{
   /**
    * Fields.
    *===========================================================**/
   
   /** Represents the number of iMessages used. */
   protected int iMessages;
   /** Constant for the iMessage rate being charged. */
   public static final double IMESSAGE_RATE = .35;

   /** 
    * Consructor: IPhone.
    *============================================================*
    * @param numIn specifies the phone number.
    * @param txtIn specifies the texts made.
    * @param minIn specifies the minutes used.
    * @param dataIn specifies data used.
    * @param iMessagesIn specifies the iMessages used.
    * @throws NegativeValueException is value is negative.
    */	
   public IPhone(String numIn, int txtIn, int minIn, int dataIn, 
      int iMessagesIn)throws NegativeValueException
   {
      super(numIn, txtIn, minIn, dataIn);
      iMessages = iMessagesIn;
      if (iMessagesIn < 0)
      {
         CellPhone.cellPhoneCount--;
      
         throw new NegativeValueException("All values must be positive");
      }
   }
   
   /**
       * Methods.
       *============================================================**/
   
   /** Method used to get the number of iMessages used.
    * @return iMessages specfies the amount of iMessages used. */
   public int getIMessages()
   {
      return iMessages;
   }
   
   /** Method used to set the number of iMessages used.
    * @param iMessagesIn specfies the amount of iMessages used. */
   public void setIMessages(int iMessagesIn)
   {
      iMessages = iMessagesIn;
   }

   /** Method used to calculate the bill. 
    * @return bill specfies the calculated bill amount. */
   public double calculateBill()
   {
      double iCharge = iMessages * IMESSAGE_RATE;
      double bill = super.calculateBill() + iCharge;
      return bill;
   }
   
   /** Method used to reset the bill. */
   public void resetBill()
   {
      super.resetBill();
      iMessages = 0;
   }
   
   /** Method used to output the information. 
    * @return output specifies the stringed information. */
   public String toString()
   {
      String output = super.toString() + ", " + iMessages + " iMessages";
      return output;
   }
}