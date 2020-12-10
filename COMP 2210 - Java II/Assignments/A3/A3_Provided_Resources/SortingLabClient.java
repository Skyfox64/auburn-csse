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
      int key = 44;
      // run one sort on an array of Strings
      String[] as = {"D", "B", "E", "C", "A"};
   
      SortingLab<String> sls = new SortingLab<>(key);
      sls.sort1(as);
   
      // run a sort on multiple Integer arrays of increasing length
      SortingLab<Integer> sli = new SortingLab<>(key);
     //=======================================================
     // Stability checker
     //=======================================================
     
      Tester[] stabilityTestArray = createTester(10);
      SortingLab<Tester> slobj = new SortingLab<>(key);
      
      System.out.println("Array Randomized: ");
      System.out.println(java.util.Arrays.toString(stabilityTestArray));
      
      slobj.sort3(stabilityTestArray);
      
      System.out.println("Array Sorted: ");
      System.out.println(java.util.Arrays.toString(stabilityTestArray));
      int something = 0;
      if (something == 0) {
         return;
      }
      
      //======================================================
      //======================================================
      
      //======================================================
      // Initializers
      //======================================================
      int M = 400000; // max capacity for array
      int N = 100;  // initial size of array
      double elapsedTime = 0;
      double prevTime = 0;
   
      //======================================================
      //=======================================================
         // Random Case/Average case Checker
      //=======================================================
        // N = 100;
      // System.out.println("Method: sort1"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
      //    //Integer[] ai = getWorstArray(N);
         // Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort1(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort2"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
      //    //Integer[] ai = getWorstArray(N);
         // Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort2(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort3"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
      //    //Integer[] ai = getWorstArray(N);
         // Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort3(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort4"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort4(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort5"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
      // 
         // Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
      //    
         // Clock clock = new Clock();
      //    
         // sli.sort5(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
      
      
         //=======================================================
         //=======================================================
   
         //=======================================================
         // Best/Worst Case checker
         //=======================================================
   
      // N = 100;
      // System.out.println("Method: sort1"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getBestArray(N);
      //    //Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort1(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort2"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getBestArray(N);
      //    //Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort2(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort3"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getBestArray(N);
      //    //Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort3(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort4"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getBestArray(N);
      //    //Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort4(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort5"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getBestArray(N);
      //    //Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort5(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
      
      //========================================================
      // Check between the two quicksorts
         
      // N = 100;
      // System.out.println("Method: sort2"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getBestArray(N);
      // //Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort5(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      // }
   //    
      // N = 100;
      // System.out.println("Method: sort5"); //***Added
      // System.out.println("-----Run-----N------Time------Ratio----lgRatio"); //***Added
      // for (int i = 0; N < M; N *= 2, i++) {
         // Integer[] ai = getBestArray(N);
      //    //Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         // Clock clock = new Clock();
      //    
         // sli.sort5(ai);//Sort NUMBER ************
      //    
         // prevTime = elapsedTime;
      //    
         // elapsedTime = clock.elapsedTime();
      //    
         // double ratio = elapsedTime/prevTime;
         // double lgratio = (Math.log(ratio) / Math.log(2));
      //    
         // System.out.printf("%7d %7d", i+1, N);
         // System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
      //    
      //    
      // }
   }
   
   
   //Used for Average case checker
   private static Integer[] getIntegerArray(int N, int max) {
      Integer[] a = new Integer[N];
      java.util.Random rng = new java.util.Random();
      for (int i = 0; i < N; i++) {
         a[i] = rng.nextInt(max);
      }
      return a;
   }
   
   //Used for Best/Worst case Checker
   private static Integer[] getBestArray(int N) {
      Integer[] a = new Integer[N];
      for(int i = 0; i < N; i++)
      {
         a[i] = i + 1;
      }
      return a;
   }
   
   private static Integer[] getWorstArray(int N) {
      Integer[] a = new Integer[N];
      for(int i = N; i > 0; i--)
      {
         a[i - 1] = N - i + 1;
      }
      return a;
   }
   
   //Used for Stability Checker
   private static Tester[] createTester(int length) {
   
      Tester[] createdArray = new Tester[length];
      
      java.util.Random rng = new java.util.Random();
      
      for (int i = 0; i < length; i++) {
         createdArray[i] = new Tester(rng.nextInt(10), rng.nextInt(10));
      }
      return createdArray;
   }
}