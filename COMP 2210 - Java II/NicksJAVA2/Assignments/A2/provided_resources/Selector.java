import java.util.Collection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Defines a library of selection methods.
*
* @author  John Carroll (jcc0044@auburn.edu)
* @author  Dean Hendrix (dh@auburn.edu)
* @version 2013-01-29
*
*/
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


/**
 * Selects the minimum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException
 * if either c or comp is null, and it throws a NoSuchElementException 
 * if c is empty. The Collection c is not changed by this method.
 *
 * @param c     the Collection to be searched through
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      minimum value in c
 * @throws      IllegalArgumentException if either c or comp is null
 * @throws      NoSuchElementException if c is empty
 *
 */
   public static <T> T min(Collection<T> c, Comparator<T> comp) {
      if ((c.equals(null)) || (comp.equals(null))) {
         throw new IllegalArgumentException();
      }
      if (c.isEmpty()) {
         throw new NoSuchElementException();
      }
   
      Iterator<T> it = c.iterator();
      T min=it.next();
      while (it.hasNext()){
         T val=it.next();
         if(comp.compare(min,val ) > 0 ) 
            min=val;
      }
      return min;
   }


/**
 * Selects the maximum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException
 * if either c or comp is null, and it throws a NoSuchElementException 
 * if c is empty. The Collection c is not changed by this method.
 *
 * @param c     the Collection to be searched through
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      maximum value in c
 * @throws      IllegalArgumentException if either c or comp is null
 * @throws      NoSuchElementException if c is empty
 *
 */
   public static <T> T max(Collection<T> c, Comparator<T> comp) {
      if ((c.equals(null)) || (comp.equals(null))) {
         throw new IllegalArgumentException();
      }
      if (c.isEmpty()) {
         throw new NoSuchElementException();
      }
   
      Iterator<T> it = c.iterator();
      T max=it.next();
      while (it.hasNext()){
         T val=it.next();
         if(comp.compare(max,val ) < 0 ) 
            max=val;
      }
      return max;
   }


/**
 * Selects the kth minimum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException 
 * if either c or comp is null, and it throws a NoSuchElementException
 * if either c is empty or if there is no kth minimum value. Note that there 
 * is no kth minimum value if k < 1, k > c.size(), or if k is larger than
 * the number of distinct values in c. The Collection c is not changed by 
 * this method.
 *
 * @param c     the Collection to be searched through
 * @param k     the k-selection value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      kth minimum value in c
 * @throws      IllegalArgumentException as specified above
 * @throws      NoSuchElementException as specified above
 *
 */
   public static <T> T kmin(Collection<T> c, int k, Comparator<T> comp) {
      if ((c.equals(null)) || (comp.equals(null))) {
         throw new IllegalArgumentException();
      }
      if (c.isEmpty() || k < 1 || k > c.size()) {
         throw new NoSuchElementException();
      }
   
      ArrayList<T> sorted = new ArrayList<T>(c);
      java.util.Collections.sort(sorted, comp);
      ArrayList<T> unique = new ArrayList<T>();
      Iterator<T> it = sorted.iterator();
      while (it.hasNext())
      {
         T val=it.next();
         if(!unique.contains(val)) unique.add(val);
      }
      if (k > unique.size()) {
         throw new NoSuchElementException();
      }
      return unique.get(k-1);
   }


/**
 * Selects the kth minimum value from the Collection c, as defined by
 * the supplied Comparator comp. This method throws an IllegalArgumentException 
 * if either c or comp is null, and it throws a NoSuchElementException
 * if either c is empty or if there is no kth minimum value. Note that there 
 * is no kth minimum value if k < 1, k > c.size(), or if k is larger than
 * the number of distinct values in c. The Collection c is not changed by 
 * this method.
 *
 * @param c     the Collection to be searched through
 * @param k     the k-selection value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      kth minimum value in c
 * @throws      IllegalArgumentException as specified above
 * @throws      NoSuchElementException as specified above
 *
 */
   public static <T> T kmax(Collection<T> c, int k, Comparator<T> comp) {
      if ((c.equals(null)) || (comp.equals(null))) {
         throw new IllegalArgumentException();
      }
      if (c.isEmpty() || k < 1 || k > c.size()) {
         throw new NoSuchElementException();
      }
      
      ArrayList<T> sorted = new ArrayList<T>(c);
      java.util.Collections.sort(sorted, comp);
      ArrayList<T> unique = new ArrayList<T>();
      Iterator<T> it = sorted.iterator();
      while (it.hasNext())
      {
         T val=it.next();
         if(!unique.contains(val)) unique.add(val);
      }
      if (k > unique.size()) {
         throw new NoSuchElementException();
      }
      return unique.get(unique.size() - k);
   }


/**
 * Returns a Collection containing all the values in the supplied
 * Collection c that are in the range [low..high]; that is, all the 
 * values that are greater than or equal to low and less than or 
 * equal to high, including duplicate values, as determined by the
 * supplied Comparator comp. The returned Collection contains only
 * values in the range [low..high], and no others. Note that low and
 * high do not have to be actual values in c. If there are no 
 * qualifying values, including the case where c is empty, this method 
 * throws a NoSuchElementException. This method throws an 
 * IllegalArgumentException if either c or comp is null. The Collection c
 * is not changed by this method.
 *
 * @param c     the Collection to be searched through
 * @param low   the lower bound value of the range
 * @param high  the upper bound value of the range
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      a Collection of elements in the range [low..high]
 * @throws      IllegalArgumentException as specified above
 * @throws      NoSuchElementException as specified above
 *
 */
   public static <T> Collection<T> range(Collection<T> c, T low, T high, 
                                         Comparator<T> comp) {
      if ((c.equals(null)) || (comp.equals(null))) {
         throw new IllegalArgumentException();
      }
      if (c.isEmpty()) {
         throw new NoSuchElementException();
      }
                                          
      Iterator<T> it = c.iterator();
      Collection<T> range = new ArrayList<T>();
      while (it.hasNext()){
         T val=it.next();
         if((comp.compare(low,val ) <= 0) && (comp.compare(high,val ) >= 0)) 
            range.add(val);
      }
      if (range.size() == 0) {
         throw new NoSuchElementException();
      }
      return range;
   
   }


/**
 * Returns the smallest value in the Collection c that is greater than
 * or equal to the given key, as defined by the supplied Comparator
 * comp. This method throws an IllegalArgumentException if either c
 * or comp is null, and throws a NoSuchElementException if c is empty
 * or if there is no qualifying value. Note that key does not have to 
 * be an actual value in c.
 *
 * @param c     the Collection to be searched through
 * @param key   the reference value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      the next greater value in c
 * @throws      IllegalArgumentException as specified above
 * @throws      NoSuchElementException as specified above
 *
 */
   public static <T> T ceiling(Collection<T> c, T key, Comparator<T> comp) {
      if ((c.equals(null)) || (comp.equals(null))) {
         throw new IllegalArgumentException();
      }
      if (c.isEmpty()) {
         throw new NoSuchElementException();
      }
   
      Iterator<T> it = c.iterator();
      Collection<T> greater = new ArrayList<T>();
      while (it.hasNext()){
         T val=it.next();
         if(comp.compare(key,val ) < 0 ) 
            greater.add(val);
      }
      if (greater.size() == 0) {
         throw new NoSuchElementException();
      }
      return Selector.min(greater, comp);
   }


/**
 * Returns the largest value in the Collection c that is less than
 * or equal to the given key, as defined by the supplied Comparator
 * comp. This method throws an IllegalArgumentException if either c
 * or comp is null, and throws a NoSuchElementException if c is empty
 * or if there is no qualifying value. Note that key does not have to 
 * be an actual value in c.
 *
 * @param c     the Collection to be searched through
 * @param key   the reference value
 * @param comp  the Comparator that defines the ordering of the elements in c
 * @return      the next smaller value in c
 * @throws      IllegalArgumentException as specified above
 * @throws      NoSuchElementException as specified above
 *
 */
   public static <T> T floor(Collection<T> c, T key, Comparator<T> comp) {
      if ((c.equals(null)) || (comp.equals(null))) {
         throw new IllegalArgumentException();
      }
      if (c.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      Iterator<T> it = c.iterator();
      Collection<T> less = new ArrayList<T>();
      while (it.hasNext()){
         T val=it.next();
         if(comp.compare(key,val ) > 0 ) 
            less.add(val);
      }
      if (less.size() == 0) {
         throw new NoSuchElementException();
      }
      return Selector.max(less, comp);
   }


/**
 * Embedded sample tests. Run with assertions enabled:
 *    % java -ea Selector
 *
 */
   public static void main(String[] args) {
      Comparator<Integer> comp = new CompareIntegers();
   
      Collection<Integer> c = new ArrayList<>();
      c.add(12); c.add(2); c.add(8);
      c.add(4);  c.add(2); c.add(10);
   
      assert Selector.min(c, comp) == 2;
      assert Selector.max(c, comp) == 12;
      assert Selector.kmin(c, 3, comp) == 8;
      assert Selector.kmax(c, 4, comp) == 4;
      assert Selector.ceiling(c, 5, comp) == 8;
      assert Selector.floor(c, 5, comp) == 4;
      
      Collection<Integer> expected = new ArrayList<>();
      expected.add(4); expected.add(8); expected.add(10);
      Collection<Integer> r = Selector.range(c, 3, 10, comp);
      assert r.size() == 3;
      assert r.containsAll(expected);
   }
   
   
   static class CompareIntegers implements Comparator<Integer> {
      public int compare(Integer i, Integer j) {
         return i.compareTo(j);
      }
   }
}