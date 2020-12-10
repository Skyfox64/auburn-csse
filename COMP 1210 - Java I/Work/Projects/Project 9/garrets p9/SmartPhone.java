   /**
 * creates SmartPhone class.
 *
 *@author Garrett Knecht
 *@version 11-06-2013
 */
public class SmartPhone extends CellPhone
{
   /** cretes data int. */
   protected int data;
   /** creates constant talk rate. */
   public static final double TALK_RATE = 0.10;
   /** creates constant text rate.*/
   public static final double TEXT_RATE = 0.50;
   /** creates constant max talk time. */
   public static final double MAX_TALK_TIME = 600.0;
   /** creates constant overtime talk rate. */
   public static final double OVERTIME_TALK_RATE = 2.0;
   /** creates constant data rate. */
   public static final double DATA_RATE = 0.05;
   
   /**
    * constructor.
    *@param numberIn gets phone number.
    *@param textsIn gets texts
    *@param minutesIn gets minutes
    *@param dataIn gets data
    */
   public SmartPhone(String numberIn, int textsIn, int minutesIn, int dataIn)
   {
      super(numberIn, textsIn, minutesIn);
      data = dataIn;
   }
   
   /**
    * gets data.
    *@return data returns data
    */
   public int getData()
   {
      return data;
   }
   
   /**
    * sets data.
    *@param dataIn gets data
    */
   public void setData(int dataIn)
   {
      data = dataIn;
   }
   
   /**
    * calculates bill.
    *@return bill returns bill
    */
   public double calculateBill()
   {
      double bill = 0.0;
      bill = (texts * TEXT_RATE) + (DATA_RATE * data);
      
      if (minutes > MAX_TALK_TIME)
      {
         bill += (MAX_TALK_TIME * TALK_RATE + (minutes - MAX_TALK_TIME)
            *  OVERTIME_TALK_RATE);
      }
      
      else 
      {
         bill += minutes * TALK_RATE;
      }
      return bill;
   }
   
   /**
    * resets bill.
    */
   public void resetBill()
   {
      texts = 0;
      minutes = 0;
      data = 0;
   }
   
   /**
    * prints desired output.
    *@return output returns string
    */
   public String toString()
   {
      String output = "";
      output += super.toString() + ", " + data + " MB of Data";
    
      return output;  
   }
}