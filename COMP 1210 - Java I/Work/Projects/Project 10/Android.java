/**
* This class will derive the Android class from the SmartPhone class.
* @author John Carroll
* @version 11-10-2013
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
   * @param num specifies the phone number.
   * @param txt specifies the texts made.
   * @param min specifies the minutes used.
   * @param dataIn specifies data used.
   * @param hSMin specifies the hotspot minutes used.
   */	
   public Android(String num, int txt, int min, int dataIn, int hSMin)
   {
      super(num, txt, min, dataIn);
      hotspotMin = hSMin;
   }
   
   /**
   * Methods.
   *============================================================*/
   
   /** Method used to get the number of hotspot minutes used.
   * @return hotspotMin specfies the amount of hotspot minutes used. */
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