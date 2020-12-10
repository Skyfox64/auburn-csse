import java.util.Comparator;

/**
* This class implements the Comparator interface fir CellPhone objects.
*
* @author John Carroll
* @version 11-21-2013
*/
public class CellPhoneBillComparator implements Comparator<CellPhone>
{
   /** Method used to compare two objects. 
   * @param c1 is the object of the comparator's basis.
   * @param c2 is being compared to object c1.
   * @return 1, -1, or 0.
   */
   public int compare(CellPhone c1, CellPhone c2) {
      if (c1.calculateBill() > c2.calculateBill()) {
         return 1;
      }
      else if (c1.calculateBill() < c2.calculateBill()) {
         return -1;
      }
      return 0;
   }
}