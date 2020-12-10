import java.io.IOException;

/**
* This class contains statements that create a provider via
* run argument. From there, it prints the information after
* calculating rates of expenditure, charges, and so on.
*
* @author John Carroll
* @version 11-21-2013
*/
public class CellPhonesPart2
{
   /**
   * @param args Command line arguments (not used).
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   public static void main(String[] args) throws IOException
   {
      Provider p = new Provider();
      p.readCellPhoneFile(args[0]);
      System.out.println(p.summary());
      System.out.println(p.rates());
      System.out.println(p.listByNumber());
      System.out.println(p.listByBill());
      System.out.println(p.excludedRecordsList());
   }
}