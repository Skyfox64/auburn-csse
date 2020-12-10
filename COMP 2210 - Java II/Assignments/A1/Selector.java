import java.util.Arrays;

/**
* Defines a library of selection methods.
*
* @author  John Carroll (jcc0044@auburn.edu)
* @author  Dean Hendrix (dh@auburn.edu)
* @version 2014-01-14
*
*/
public class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


/**
 * Selects the minimum value from the array a. This method
 * throws IllegalArgumentException if a is null or has zero
 * length. The array a is not changed by this method.
 *
 * @param a     the array to be searched through
 * @return      minimum value in a
 * @throw       IllegalArgumentException if a is null or zero-length
 *
 */
   public static int min(int[] a) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int min = a[0];
         for (int i = 0; i < a.length; i++) {
            if (a[i] < min && a[i] != 0) {
               min = a[i];
            }   
         }
         return min;
      }
   }


/**
 * Selects the maximum value from the array a. This method
 * throws IllegalArgumentException if a is null or has zero
 * length. The array a is not changed by this method.
 *
 * @param a     the array to be searched through
 * @return      maximum value in a
 * @throw       IllegalArgumentException if a is null or zero-length
 *
 */
   public static int max(int[] a) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int max = a[0];
         for (int i = 0; i < a.length; i++) {
            if (a[i] > max && a[i] != 0) {
               max = a[i];
            }   
         }
         return max;
      }
   }


/**
 * Selects the kth minimum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth minimum value. Note that there is no kth
 * minimum value if k < 1, k > a.length, or if k is larger than
 * the number of distinctk values in the array. The array a is not
 * changed by this method.
 *
 * @param a     the array to be searched through
 * @param k     the k-selection value
 * @return      kth minimum value in a
 * @throw       IllegalArgumentException as specified above
 *
 */
   public static int kmin(int[] a, int k) {
      
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      else {
         int kmin = 0;
         int[] temp = (int[]) a.clone();
         Arrays.sort(temp);
         int [] ranked = new int[temp.length];
         int uniqueCount = 0;
         for (int i = 0; i < temp.length; i++) {
            boolean unique = true;
            for (int j = 0; j < uniqueCount && unique; j++) {
               if (temp[i] == ranked[j]) {
                  unique = false;
               }
            }
            if (unique) {
               ranked[uniqueCount++] = temp[i];
            }  
         }
         int[] rankedUnique = Arrays.copyOf(ranked, uniqueCount);
         if (k > rankedUnique.length) {
            throw new IllegalArgumentException();
         }
         return rankedUnique[-1 + k];
      }
   
   }


/**
 * Selects the kth maximum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth maximum value. Note that there is no kth
 * maximum value if k < 1, k > a.length, or if k is larger than
 * the number of distinctk values in the array. The array a is not
 * changed by this method.
 *
 * @param a     the array to be searched through
 * @param k     the k-selection value
 * @return      kth maximum value in a
 * @throw       IllegalArgumentException as specified above
 *
 */
   public static int kmax(int[] a, int k) {
     
      int kmax = 0;
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      else {
         int[] temp = (int[]) a.clone();
         Arrays.sort(temp);
         int [] ranked = new int[temp.length];
         int uniqueCount = 0;
         for (int i = 0; i < temp.length; i++) {
            boolean unique = true;
            for (int j = 0; j < uniqueCount && unique; j++) {
               if (temp[i] == ranked[j]) {
                  unique = false;
               }
            }
            if (unique) {
               ranked[uniqueCount++] = temp[i];
            }
         }
         int[] rankedUnique = Arrays.copyOf(ranked, uniqueCount);
         if (k > rankedUnique.length) {
            throw new IllegalArgumentException();
         }
         return rankedUnique[rankedUnique.length - k];
      }
   
   }


/**
 * Returns an array containing all the values in a in the
 * range [low..high]; that is, all the values that are greater
 * than or equal to low and less than or equal to high,
 * including duplicate values. The length of the returned array
 * is the same as the number of values in the range [low..high].
 * If there are no qualifying values, this method returns a
 * zero-length array. Note that low and high do not have
 * to be actual values in a. This method thows an
 * IllegalArgumentException if a is null or has zero length.
 * The array a is not changed by this method.
 *
 * @param a     the array to be searched through
 * @param low   the lower bound value of the range
 * @param high  the upper bound value of the range
 * @return      an array of elements i
 * @throw       IllegalArgumentException as specified above
 *
 */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int rangeLength = 0;
         for (int i = 0; i < a.length; i++) {
            if (a[i] >= low && a[i] <= high) {
               rangeLength++;
            }
         }
         if (rangeLength == 0) {
            int [] emptyArray = new int[0];
            return emptyArray; 
         }
         int[] range = new int[rangeLength];  
         int k = 0;
         for (int j = 0; j < a.length; j++) {
            if (a[j] >= low && a[j] <= high) {
               range[k] = a[j];
               k++;
            }
         }
         return range;
      }
   }


/**
 * Returns the smallest value in a that is greater than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 *
 * @param a     the array to be searched through
 * @param key   the reference value
 * @return      the next greater value in a
 * @throw       IllegalArgumentException as specified above
 *
 */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int i;
         int ceil = max(a);
         for (i = 0; i < a.length; i++) {
            if (a[i] < ceil && a[i] >= key) {
               ceil = a[i];
            }
         } 
         if (ceil < key) {
            throw new IllegalArgumentException();
         }
         return ceil;
      }
   }


/**
 * Returns the largest value in a that is less than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 *
 * @param a     the array to be searched through
 * @param key   the reference value
 * @return      the next smaller value in a
 * @throw       IllegalArgumentException as specified above
 *
 */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int i;
         int floor = min(a);
         for (i = 0; i < a.length; i++) {
            if (a[i] > floor && a[i] <= key) {
               floor = a[i];
            }
         } 
         if (floor > key) {
            throw new IllegalArgumentException();
         }
      
         return floor;
      }
   }


/**
 * Embedded sample tests. Run with assertions enabled:
 *    % java -ea Selector
 *
 */
   public static void main(String[] args) {
      int[] a = {12, 2, 8, 4, 2, 10};
   
      assert Selector.min(a) == 2;
      assert Selector.max(a) == 12;
      assert Selector.kmin(a, 3) == 8;
      assert Selector.kmax(a, 4) == 4;
      assert Selector.ceiling(a, 5) == 8;
      assert Selector.floor(a, 5) == 4;
   
      int[] range = {4, 8, 10};
      int[] r = Selector.range(a, 3, 10);
      assert r.length == 3;
      Arrays.sort(r);
      assert Arrays.equals(range, r);
   
   }
}