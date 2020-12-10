import java.text.DecimalFormat;

public class IPhone extends SmartPhone
{
   protected int iMessages;
   public static final double IMESSAGE_RATE = .35;
   
   public IPhone (String numberIn, int textsIn, int minutesIn,
      int dataIn, int iMessagesIn)
   {
      super(numberIn, textsIn, minutesIn, dataIn);
      iMessages = iMessagesIn;
   }
   
   public int getIMessages()
   {
      return iMessages;
   }
   
   public void setIMessages(int iMessagesIn)
   {
      iMessages = iMessagesIn;
   }
   
   public double calculateBill()
   {
      double bill = 0.0;
      bill = super.calculateBill();
      
      bill += (iMessages * IMESSAGE_RATE);
      return bill;
   }
   
   public void resetBill()
   {
      super.resetBill();
      iMessages = 0;
   }
   
   public String toString()
   {
      String output = "";
      output += super.toString() + ", " + iMessages + " iMessages";
    
      return output;
   }
}