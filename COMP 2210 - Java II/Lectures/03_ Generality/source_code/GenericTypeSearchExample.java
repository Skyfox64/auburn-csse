/**
 * Basic linear search example for generic types.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2010-08-20
 *
 */
   public class GenericTypeSearchExample
   {
   
   /**
    * Performs linear search on an array of T's.
    *
    * @param <T>		Type of objects, specified by caller
    * @param a 		array to be searched through
    * @param target	value to be searched for
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public static <T> int search(T[] a, T target)
      {
         int i = 0;
         while ((i < a.length) && (!a[i].equals(target)))
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
    
   /**
    * Illustrates basic calls to search method.
    *
    * @param args Command line arguments not used.
    *
    */ 
      public static void main(String[] args) 
      {
      
         int[] intarray = {2, 4, 6, 8, 10};
         String[] sarray = {"2", "4", "6", "8", "10"};
         Integer[] iarray = {2, 4, 6, 8, 10};
         Number[] narray = {2, 4, 6, 8, 10};
         //Number[] narray = {new Integer(2), new Float(4), new Double(8)};
         Object[] oarray = {"8", new Book("A", "T", 1), new Integer(8)};
         Comparable[] carray = {"8", new Book("A", "T", 1), new Integer(8)};
         
         String starget = "8";
         Integer itarget = 8;
      
      
         //search(intarray, 8);
         //GenericTypeSearchExample.<Integer>search(intarray, 8);
      
         search(sarray, "8");
         search(sarray, 8);
         search(narray, 8);
         search(iarray, 8);
         
         GenericTypeSearchExample.<String>search(sarray, "8");
         //GenericTypeSearchExample.<String>search(sarray, 8);
      
         //GenericTypeSearchExample.<Integer>search(narray, 8);
         GenericTypeSearchExample.<Number>search(narray, 8);
      
         System.out.println(
            GenericTypeSearchExample.<String>search(sarray, starget)
            );
      	
         System.out.println(
            GenericTypeSearchExample.<Integer>search(iarray, itarget)
            );
         
         System.out.println(search(oarray, starget));
         
         System.out.println(search(carray, itarget));
      }
    
   }
   
