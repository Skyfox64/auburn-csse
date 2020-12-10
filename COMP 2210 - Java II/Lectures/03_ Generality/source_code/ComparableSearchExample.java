/**
 * Basic linear search example for Comparables.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2010-08-20
 *
 */
   public class ComparableSearchExample
   {
    
   /**
    * Performs linear search on an array of Comparables.
    *
    * @param a			array to be searched through
    * @param target	value to be searched for
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public static int search(Comparable[] a, Comparable target)
      {
         int i = 0;
         while ((i < a.length) && (a[i].compareTo(target) != 0)) 
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
      
         String[] a = {"2", "4", "6", "8", "10"};
         String target = "8";
      
         System.out.println(search(a, target));
      
         Integer[] b = {2, 4, 6, 8, 10};
         Integer t = 8;
      
         System.out.println(search(b, t));
      }
   }
   
