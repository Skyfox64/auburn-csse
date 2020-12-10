/**
 * Basic linear search example for ints.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2010-08-20
 *
 */
   public class ObjectSearchExample
   {
    
   /**
    * Performs linear search on an array of Objects.
    *
    * @param a 		array to be searched through
    * @param target	value to be searched for
    * @return 			index of target in a or -1 if target not found
    *
    */ 
      public static int search(Object[] a, Object target)
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
      
         String[] a = {"2", "4", "6", "8", "10"};
         String target = "8";
      
         System.out.println(search(a, target));
      
         Object[] b = {"2", 4, new Book("alskdfj", "laksdf", 123)};
         target = "8";
      
         System.out.println(search(b, target));
      }
   }
