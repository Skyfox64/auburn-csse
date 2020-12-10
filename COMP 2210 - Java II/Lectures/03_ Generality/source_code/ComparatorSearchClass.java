   import java.util.Comparator;

/**
 * Basic linear search example for Objects
 * using a Comparator.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2010-08-20
 *
 */
   public class ComparatorSearchClass
   {
   
   /**
    * Performs linear search on an array of Objects
    * using a Comparator.
    *
    * @param a 		array to be searched through
    * @param target	value to be searched for
    * @param c			Comparator to use for comparison
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public static int search(Object[] a, Object target, Comparator c)
      {
         int i = 0;
         while ((i < a.length) && (c.compare(a[i], target) != 0)) 
         {
            i++;
         }
         if (i < a.length)
         {
            return i;
         }
         else
         {
            return -1;
         }
      }
        
   }
