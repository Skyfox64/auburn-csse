public class Android extends SmartPhone
{
   private int hotSpot = 0;
   public static final double HOTSPOT_RATE = 0.75;
   
   public Android(String numberIn, int textsIn, int minutesIn,
      int dataIn, int hotSpotIn)
   {
      super(numberIn, textsIn, minutesIn, dataIn);
      hotSpot = hotSpotIn;
   }
   
   public int getHotspotMin()
   {
      return hotSpot;
   }
   
   public void setHotspotMin(int hotSpotIn)
   {
      hotSpot = hotSpotIn;
   }
   
   public double calculateBill()
   {
      double bill = 0;
      bill = super.calculateBill();
      
      bill += (hotSpot * HOTSPOT_RATE);
      return bill;
   }
   
   public void resetBill()
   {
      super.resetBill();
      hotSpot = 0;
   }
   
   public String toString()
   {
      String output = "";
      output = super.toString() + ", " + hotSpot + " Hotspot Minutes";
      return output;
   }
}