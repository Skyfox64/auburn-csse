/**
 * SortingLabClient.java. Provides a simple example
 * client of SortingLab.java.
 *
 * NOTE: The generic type of SortingLab must be bound
 *       to a Comparable type. The sorting methods in
 *       SortingLab use the natural ordering of the
 *       elements in the parameter array.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2014-02-13
 *
 */
public final class SortingLabClient {

   public static void main(String[] args) {
      int key = 38;
      double elapsedTime = 0;   // elapsed time of current run
      double prevTime = 0;      // elapsed time of previous run
      double ratio = 1;         // currentTime / prevTime
      double lgratio = 0;       // log base 2 of ratio
      double averageLg = 0;
      double totalLg = 0;
      String[] as = {"D", "B", "E", "C", "A"};
      int[] best = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int[] worst = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      
      
      // run one sort on an array of Strings
      // SortingLab<String> sls = new SortingLab<>(key);
      // sls.sort1(as);
      
      // create sorting lab for ints and objects
      // also set min/max values for array size
      SortingLab<Integer> slint = new SortingLab<>(key);
      int M = 10000000; // max capacity for array
      int N = 100;  // initial size of array
      
      // Tester[] stabilityTestArray = createTester(10);
      // SortingLab<Tester> slobj = new SortingLab<>(key);
   //    
      // System.out.println("Array Randomized: ");
      // System.out.println(java.util.Arrays.toString(stabilityTestArray));
   //    
      // slobj.sort1(stabilityTestArray);
   //    
      // System.out.println("Array Sorted: ");
      // System.out.println(java.util.Arrays.toString(stabilityTestArray));
      // int something = 0;
      // if (something == 0) {
         // return;
      // }
      
      System.out.println("Sort 5 Running....\n");
      for (; N < M; N *= 2) {
         Integer[] random = getIntegerArray(N, Integer.MAX_VALUE);
         Integer[] sorted = sortedArray(N);
         Clock clock = new Clock();
         slint.sort5(sorted);
         elapsedTime = clock.elapsedTime();
         if (prevTime == 0) {
            prevTime = elapsedTime;
         }
         if (N >= 204800) {
            System.out.print(N + "\t");
            System.out.printf("%4.3f\n", elapsedTime);
            ratio = elapsedTime/prevTime;
         }
         prevTime = elapsedTime;
      }
      
      System.out.println("Sort 5 has ended!\n");
      
   }
   
   // method to create an array of random integers
   // useful for testing "average" case time complexities
   private static Integer[] getIntegerArray(int N, int max) {
      Integer[] a = new Integer[N];
      java.util.Random rng = new java.util.Random();
      for (int i = 0; i < N; i++) {
         a[i] = rng.nextInt(max);
      }
      return a;
   }
   
   // method to create an already sorted array
   // useful for testing "best" case time complexities
   private static Integer[] sortedArray(int N) {
      Integer[] a = new Integer[N];
      for (int i = 0; i < N; i++) {
         if (i != 0) {
            a[i] = i * 2;
         }
         else {
            a[i] = 1;
         }
      }
      return a;
   }
   
   
   private static Tester[] createTester(int length) {
   
      Tester[] createdArray = new Tester[length];
      
      java.util.Random rng = new java.util.Random();
      
      for (int i = 0; i < length; i++) {
         createdArray[i] = new Tester(rng.nextInt(6), rng.nextInt(6));
      }
      return createdArray;
   }
   
}