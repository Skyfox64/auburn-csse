
/**
 *  LinearSearchExample.java
 *
 *  Provides several methods that attempt to implement
 *  the linear search algorithm on an array of ints.
 *
 *  Included in these examples are both the incorrect and
 *  corrected linear search implementations from lecture.
 *
 *  @author		Dean Hendrix (dh@auburn.edu)
 *  @version	2011-07-28
 */
   public class LinearSearchExample
   {
   
   /**
    * Incorrect implementaton of linear search from lecture.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int search1(int[] a, int target)
      {
         int i = 0;
         while ((a[i] != target) && (i < a.length)) 
         {
            i++;
         }
         
         if (a[i] == target)
         {
            return i;
         }
         else
         {
            return -1;
         }
      }
    
   /**
    * Possible implementation of linear search.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int search2(int[] a, int target)
      {
         int i = 0;
         while ((i < a.length) && (a[i] != target))
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
    * Possible implementation of linear search.
    *
    * @param a					the array to be searched
    * @param valueToFind	the int to be searched for
    * @return 					index of valueToFind in a or -1
    */ 
      public static int search3(int[] a, int valueToFind) {
         for (int i = 0; i < a.length; i++) 
         {
            if (valueToFind == a[i]) 
            {
               return i;
            }
         }
         return -1;
      }
   
    
   /**
    * Possible implementation of linear search.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int search4(int[] a, int target)
      {
         int i = 0;
         boolean found = false;
         while ((i < a.length) && (!found))
         { 
            if (a[i] == target)
            {
               found = true;
            }
            else
            {
               i++;
            }
         }
         
         if (found)
         {
            return i;
         }
         else
         {
            return -1;
         }
      }
   
   /**
    * Possible implementation of linear search.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int search5(int[] a, int target)
      {
         int i = 0;
         while ((i < a.length) && (a[i] != target)) 
         {
            i++;
         }
         
         if (a[i] == target)
         {
            return i;
         }
         else
         {
            return -1;
         }
      }
   
    
   
   /**
    * Exercises various implementations of the
    * linear search strategy.
    *
    * @param args		command line arguments not used
    */       
      public static void main(String[] args) 
      {
         
      // Initialze test fixtures
        
         int[] a = {2, 4, 6, 8, 10};
         
         search1(a, 4);
         search1(a, 5);
         search1(a, 10);
         search1(a, -1);
         search1(a, 6);
         
      }
    
    
    
   /**
    * Creates formatted string representation of an array of ints.
    *
    * @param a		array of ints
    * @return		"[x, x, ...]" representation of a
    */
      private static String arrayToString(int[] a)
      {
         StringBuffer sb = new StringBuffer("[");
         for (int i = 0; i < a.length; i++)
         {
            sb.append(a[i] + ", ");
         }
         sb.trimToSize();
         sb.deleteCharAt(sb.length() - 1);
         sb.deleteCharAt(sb.length() - 1);
         sb.append("]");
         return sb.toString();
      }
    
   }
   
