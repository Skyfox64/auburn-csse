   import java.util.List;
   import java.util.Iterator;

/**
 * Basic linear search example using an implementing class
 * of java.util.List.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2011-05-26
 *
 */
   public class ListSearchClass
   {
   
   /**
    * Performs linear search on a List of T's.
    *
    * @param <T>		Type of objects, specified by caller
    * @param a    	List to be searched through
    * @param target	value to be searched for
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public static <T> int searchA(List<T> a, T target)
      {
         int i = 0;
         while ((i < a.size()) && (!a.get(i).equals(target)))
         { 
            i++;
         }
         if (i < a.size())
         {
            return i;
         }
         else
         {
            return -1;
         }
      }
    
    
   /**
    * Performs linear search on a List of T's using an Iterator.
    *
    * @param <T>		Type of objects, specified by caller
    * @param a    	List to be searched through
    * @param target	value to be searched for
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public static <T> int searchB(List<T> a, T target)
      {
         Iterator<T> itr = a.iterator();
         int i = 0;
         while ((itr.hasNext()) && (!itr.next().equals(target)))
         { 
            i++;
         }
         if (i < a.size())
         {
            return i;
         }
         else
         {
            return -1;
         }
      }
    
   
    
   }
   
