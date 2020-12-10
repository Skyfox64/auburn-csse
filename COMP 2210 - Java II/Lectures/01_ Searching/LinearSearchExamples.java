
/**
 *  LinearSearchExamples.java
 *
 *  Provides several examples of linear search implementations.
 *  Linear search is a searching <b>strategy</b> that could be
 *  implemented in many different ways.
 *
 *  Included in these examples are both the incorrect and
 *  corrected linear search implementations from lecture.
 *
 *  @author		Dean Hendrix (dh@auburn.edu)
 *  @version	2011-04-26
 */
   public class LinearSearchExamples
   {
   
   /**
    * Incorrect implementaton of linear search from lecture.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int searchBuggyFromLecture(int[] a, int target)
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
    * Corrected implementaton of linear search from lecture.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int searchRepairedFromLecture(int[] a, int target)
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
    * Implementation from Wikipedia.
    * http://en.wikipedia.org/wiki/Linear_search
    *
    * @param a					the array to be searched
    * @param valueToFind	the int to be searched for
    * @return 					index of valueToFind in a or -1
    */ 
      public static int wikiLinearSearch(int[] a, int valueToFind) {
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
    * Another variation on linear search.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int linearSearchA(int[] a, int target)
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
    * Yet another variation on linear search.
    *
    * @param a			the array to be searched
    * @param target	the int to be searched for
    * @return			index of target in a if present, -1 if not
    */ 
      public static int linearSearchB(int[] a, int target)
      {
         int i = 0;
         while ((a[i] != target) && (i < a.length - 1)) 
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
    * Yet another variation on linear search. Really?
    * Like we haven't seen enough already.
    *
    * @param a				the array to be searched
    * @param target		the int to be searched for
    * @return 				true if target is in a, false otherwise
    */ 
      public static boolean linearSearchC(int[] a, int target) {
         boolean found = false;
         for (int i = 0; i < a.length; i++) 
         {
            if (target == a[i]) 
            {
               found = true;
            }
         }
         return found;
      }
   
   
   
   /**
    * One last implementation of linear search.
    *
    * Please stop. 
    * But I can't help myself. 
    * No, seriously, stop.
    *
    * @param a					the array to be searched
    * @param valueToFind	the int to be searched for
    * @return 					index of valueToFind in a or -1
    */ 
      public static int linearSearchD(int[] a, int valueToFind) {
         for (int i = a.length - 1; i >= 0; i--) 
         {
            if (valueToFind == a[i]) 
            {
               return i;
            }
         }
         return -1;
      }
   
   
   /**
    * Exercises various implementations of the
    * linear search strategy.
    *
    * A method should never, ever be this long. However, for what
    * I'm trying to illustrate, and without talking about things
    * beyond the scope of today's lecture, copy-and-paste with a ton of
    * redundancy is the easiest way to do it.
    *
    * @param args		command line arguments not used
    */       
      public static void main(String[] args) 
      {
         
      // Initialze test fixtures
        
         int[] a = {2, 4, 6, 8, 10};
         
         final int NOT_FOUND = -1;
         final int UNDEFINED = -2;
      	
         int lowHit = a[0];
         int highHit = a[a.length - 1];
         int midHit = a[a.length / 2];
         int lowMiss = lowHit - 1;
         int highMiss = highHit + 1;
         int midMiss = midHit - 1;
      
         int[] target = {lowHit, highHit, midHit, 
                         lowMiss, highMiss, midMiss};
      
         int[] expected = {0, a.length - 1, a.length / 2,
                          NOT_FOUND, NOT_FOUND, NOT_FOUND};
      
         int actual = UNDEFINED;
      
      
      // Test the search methods
      
         System.out.println("searchBuggyFromLecture");
         System.out.println("----------------------");
         
         System.out.println("a = " + arrayToString(a));
         for (int i = 0; i < target.length; i++)
         {
            System.out.print("Target = " + target[i] + " ");
            System.out.print("Expected = " + expected[i] + " ");
            try
            {
               actual = searchBuggyFromLecture(a, target[i]);
               System.out.print("Actual = " + actual);
               if (expected[i] != actual)
               {
                  System.out.print(" << FAILURE >>");
               }
               System.out.println();
            }
               catch (Exception e)
               {
                  System.out.println(" !! Exception thrown !! << FAILURE >>");
               }
         }
         System.out.println("\n");
      	
      
         System.out.println("searchRepairedFromLecture");
         System.out.println("----------------------");
         
         System.out.println("a = " + arrayToString(a));
         for (int i = 0; i < target.length; i++)
         {
            System.out.print("Target = " + target[i] + " ");
            System.out.print("Expected = " + expected[i] + " ");
            try
            {
               actual = searchRepairedFromLecture(a, target[i]);
               System.out.print("Actual = " + actual);
               if (expected[i] != actual)
               {
                  System.out.print(" << FAILURE >>");
               }
               System.out.println();
            }
               catch (Exception e)
               {
                  System.out.println(" !! Exception thrown !! << FAILURE >>");
               }
         }
         System.out.println("\n");
      
      
         System.out.println("wikiLinearSearch");
         System.out.println("----------------------");
         
         System.out.println("a = " + arrayToString(a));
         for (int i = 0; i < target.length; i++)
         {
            System.out.print("Target = " + target[i] + " ");
            System.out.print("Expected = " + expected[i] + " ");
            try
            {
               actual = wikiLinearSearch(a, target[i]);
               System.out.print("Actual = " + actual);
               if (expected[i] != actual)
               {
                  System.out.print(" << FAILURE >>");
               }
               System.out.println();
            }
               catch (Exception e)
               {
                  System.out.println(" !! Exception thrown !! << FAILURE >>");
               }
         }
         System.out.println("\n");
      
      	
      	
         System.out.println("linearSearchA");
         System.out.println("----------------------");
         
         System.out.println("a = " + arrayToString(a));
         for (int i = 0; i < target.length; i++)
         {
            System.out.print("Target = " + target[i] + " ");
            System.out.print("Expected = " + expected[i] + " ");
            try
            {
               actual = linearSearchA(a, target[i]);
               System.out.print("Actual = " + actual);
               if (expected[i] != actual)
               {
                  System.out.print(" << FAILURE >>");
               }
               System.out.println();
            }
               catch (Exception e)
               {
                  System.out.println(" !! Exception thrown !! << FAILURE >>");
               }
         }
         System.out.println("\n");
      
      
         System.out.println("linearSearchB");
         System.out.println("----------------------");
         
         System.out.println("a = " + arrayToString(a));
         for (int i = 0; i < target.length; i++)
         {
            System.out.print("Target = " + target[i] + " ");
            System.out.print("Expected = " + expected[i] + " ");
            try
            {
               actual = linearSearchB(a, target[i]);
               System.out.print("Actual = " + actual);
               if (expected[i] != actual)
               {
                  System.out.print(" << FAILURE >>");
               }
               System.out.println();
            }
               catch (Exception e)
               {
                  System.out.println(" !! Exception thrown !! << FAILURE >>");
               }
         }
         System.out.println("\n");
      
      
         System.out.println("linearSearchC");
         System.out.println("----------------------");
         
         System.out.println("a = " + arrayToString(a));
         for (int i = 0; i < target.length; i++)
         {
            System.out.print("Target = " + target[i] + " ");
            System.out.print("Expected = " + expected[i] + " ");
            try
            {
               boolean actualC = linearSearchC(a, target[i]);
               System.out.print("Actual = " + actual);
               if (((expected[i] == NOT_FOUND) && (actualC == true))
               || ((expected[i] != NOT_FOUND) && (actualC == false)))
               {
                  System.out.print(" << FAILURE >>");
               }
               System.out.println();
            }
               catch (Exception e)
               {
                  System.out.println(" !! Exception thrown !! << FAILURE >>");
               }
         }
         System.out.println("\n");
      
      
         System.out.println("linearSearchD");
         System.out.println("----------------------");
         
         System.out.println("a = " + arrayToString(a));
         for (int i = 0; i < target.length; i++)
         {
            System.out.print("Target = " + target[i] + " ");
            System.out.print("Expected = " + expected[i] + " ");
            try
            {
               actual = linearSearchD(a, target[i]);
               System.out.print("Actual = " + actual);
               if (expected[i] != actual)
               {
                  System.out.print(" << FAILURE >>");
               }
               System.out.println();
            }
               catch (Exception e)
               {
                  System.out.println(" !! Exception thrown !! << FAILURE >>");
               }
         }
         System.out.println("\n");
      
      
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
   
