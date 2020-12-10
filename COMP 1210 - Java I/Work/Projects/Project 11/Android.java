/**
* This class will derive the Android class from the SmartPhone class.
*
* @author John Carroll
* @version 12-5-2013
*/
public class Android extends SmartPhone
{
   /**
    * Fields.
    *===========================================================**/
   
   /** Represents the hotspot minutes used. */
   private int hotspotMin;
   /** Constant for the hotspot rate being charged. */
   public static final double HOTSPOT_RATE = 0.75;

   /** 
    * Consructor: Android.
    *============================================================*
    * @param numIn specifies the phone number.
    * @param txtIn specifies the texts made.
    * @param minIn specifies the minutes used.
    * @param dataIn specifies data used.
    * @param hSMinIn specifies the hotspot minutes used.
    * @throws NegativeValueException if value is negative.
    */	
   public Android(String numIn, int txtIn, int minIn, int dataIn, int hSMinIn)
      throws NegativeValueException
   {
      super(numIn, txtIn, minIn, dataIn);
      hotspotMin = hSMinIn;
      if (hSMinIn < 0)
      {
         CellPhone.cellPhoneCount--;
      
         throw new NegativeValueException("All values must be positive");
      }
   }
   
   /**
    * Methods.
    *============================================================**/
   
   /** Method used to get the number of hotspot minutes used.
    * @return hotspotMin specfies the amount of hotspot minutes used.
    */
   public int getHotspotMin()
   {
      return hotspotMin;
   }

   /** Method used to set the number of hotspot minutes used.
    * @param hotspotMinIn specfies the amount of hotspot minutes used. */
   public void setHotspotMin(int hotspotMinIn)
   {
      hotspotMin = hotspotMinIn;
   }

   /** Method used to calculate the bill.
    * @return bill specfies the calculated bill amount. */
   public double calculateBill()
   {
      double hotspotCharge = hotspotMin * HOTSPOT_RATE;
      double bill = super.calculateBill() + hotspotCharge;
      return bill;
   }

   /** Method used to reset the bill amount. */
   public void resetBill()
   {
      super.resetBill();
      hotspotMin = 0;
   }

   /** Method used to output the information. 
    * @return output specifies the stringed information. */
   public String toString()
   {
      String output = super.toString() + ", " + hotspotMin;
      output += " Hotspot Minutes";
      return output;
   }

}