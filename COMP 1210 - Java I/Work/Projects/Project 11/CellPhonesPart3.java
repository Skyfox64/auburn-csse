import java.io.IOException;
/**
 * This class reads in the file name from the command line
 * and then prints the summary, rates, cellphone list by
 * number, cellphone list by billing amount, and the list 
 * of excluded records.
 *
 * @author John Carroll
 * @version 12-5-2013
 */
public class CellPhonesPart3   {
   /** Main method creates objects of FlipPhone,
    *  SmartPhone, IPhone, and Android, and prints them.
    *  @param args Command line arguments (not used).
    */
   public static void main(String[] args)
   {
      Provider p = new Provider();
   
      while (1 == 1)
      {
         if (args.length == 0)
         {
            String output;
            output = "*** File name not provided by command line arguement.";
            output += "\nProgram ending.";
            System.out.println(output);
            return;
         }
         else
         {
            try
            {
               p.readCellPhoneFile(args[0]);
               System.out.println(p.summary());
               System.out.println(p.rates());
               System.out.println(p.listByNumber());
               System.out.println(p.listByBill());
               System.out.println(p.excludedRecordsList());
               return;
            }
            catch (IOException e)
            {
               String catchOut = "*** File not found.";
               catchOut += "\nProgram ending.";
               System.out.println(catchOut);
               return;
            }
          
         }
      } 
   
   }
}