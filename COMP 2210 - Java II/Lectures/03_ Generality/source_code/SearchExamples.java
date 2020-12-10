   import java.util.Comparator;
    
   public class SearchExamples
   {
   
      public static int searchObject(Object[] a, Object target)
      {
         int i = 0;
         while ((i < a.length) && (!a[i].equals(target))) 
            i++;
         if (i < a.length)
            return i;
         else
            return -1;
      }
   
      public static int searchComparable(Comparable[] a, Comparable target)
      {
         int i = 0;
         while ((i < a.length) && (a[i].compareTo(target) != 0)) 
            i++;
         if (i < a.length)
            return i;
         else
            return -1;
      }
   
      public static int searchComparator(Object[] a, Object target, Comparator c)
      {
         int i = 0;
         while ((i < a.length) && (c.compare(a[i], target) != 0)) 
            i++;
         if (i < a.length)
            return i;
         else
            return -1;
      }
   
      public static <T> int searchGeneric(T[] a, T target) {
         int i = 0;
         while ((i < a.length) && (!a[i].equals(target))) 
            i++;
         if (i < a.length)
            return i;
         else
            return -1;
      }
   
   
   }
