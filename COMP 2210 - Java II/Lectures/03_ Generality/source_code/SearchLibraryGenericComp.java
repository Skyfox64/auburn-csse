   import java.util.Comparator;

/**
 * Search library class with reusable methods
 * implementing linear search.
 *
 * @param	<T> type of objects for searches
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2010-08-24
 *
 */
   public class SearchLibraryGenericComp<T>
   {
   
   /**
    * Performs linear search on an array of T's.
    *
    * @param a 		array to be searched through
    * @param target	value to be searched for
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public int search(T[] a, T target)
      {
         for (int i = 0; i < a.length; i++)
         {
            if (a[i].equals(target))
            {
               return i;
            }
         }
         return -1;
      }
      
   /**
    * Performs linear search on an array of T's
    * using a client-supplied comparator.
    *
    * Note the need to bind the generic type of the
    * Comparator class to T.
    *
    * @param a 		array to be searched through
    * @param target	value to be searched for
    * @param c			Comparator to use for comparison
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public int search(T[] a, T target, Comparator<T> c)
      {
         for (int i = 0; i < a.length; i++)
         {
            if (c.compare(a[i], target) == 0)
            {
               return i;
            }
         }
         return -1;
      }
      	
   }