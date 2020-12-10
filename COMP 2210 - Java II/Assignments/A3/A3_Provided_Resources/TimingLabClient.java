/**
 * TimingLabClient.java. Provides a simple example
 * client of TimingLab.java.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2014-02-13
 *
 */
public class TimingLabClient {

   public static void main(String[] args) {
   
   // some useful variables that you will need in
   // your own code
      Clock clock;              // measures elapsed time
      double elapsedTime = 0;   // elapsed time of current run
      double prevTime = 0;      // elapsed time of previous run
      double ratio = 1;         // currentTime / prevTime
      double lgratio = 0;       // log base 2 of ratio
      int N = 64;                // problem size parameter
      int key = 44;             // selects internal method of RunningTime
    
   // time a single method in this class
      clock = new Clock();
      foo();
      elapsedTime = clock.elapsedTime();
      System.out.print("This call to method foo() took ");
      System.out.printf("%4.3f", elapsedTime);
      System.out.println(" seconds.");
      
   // measure elapsed time for a single call to timeTrial
      clock = new Clock();
      TimingLab tl = new TimingLab(key);
      tl.timeTrial(N);
      elapsedTime = clock.elapsedTime();
      System.out.print("This call to method TimingLab.timeTrial(" 
         + N + " took ");
      System.out.printf("%4.3f", elapsedTime);
      System.out.println(" seconds.)");
   
   // measure elapsed time for multiple calls to timeTrial
   // with increasing N values
      N = 2;
      System.out.println("   Run       N       Time      Ratio    lg Ratio");
   
      for (int i = 0; i < 13; i++) {
         clock = new Clock();
         tl.timeTrial(N);
         prevTime = elapsedTime;
      
         elapsedTime = clock.elapsedTime();
         ratio = elapsedTime/prevTime;
         lgratio = (Math.log(ratio) / Math.log(2));
         
         System.out.printf("%7d %7d", i+1, N);
         System.out.printf("%10.3fs %10.3f %10.3f\n", elapsedTime, ratio, lgratio);
         
         N *= 2;
      }
   		
   }

// Something that will hopefully take time >= 0.001 seconds
// so that the program output looks better.
   private static void foo() {
      for (int i = 0; i < 100000; i++) {
         String s1 = "War";
         String s2 = "Eagle";
         String s3 = s1 + s2;
      }
   }

}