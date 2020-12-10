/**
 * RunningTimeClient.java. Provides a simple example
 * client of RunningTime.java.
 *
 * Compilation:   %javac RunningTimeClient.java
 * Execution:     %java -ea RunningTimeClient
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2013-02-05
 *
 */
public class RunningTimeClient {

   public static void main(String[] args) {
   
   // some useful variables that you will need in
   // your own code
      Clock clock;              // measures elapsed time
      double elapsedTime = 0;   // elapsed time of current run
      double prevTime = 0;      // elapsed time of previous run
      double ratio = 1;         // currentTime / prevTime
      double lgratio = 0;       // log base 2 of ratio
      int N = 8192;               // problem size parameter
      int seed = 31;          // selects internal method of RunningTime
    
   // time method foo()
      clock = new Clock();
      foo();
      elapsedTime = clock.elapsedTime();
      System.out.print("This call to method foo() took ");
      System.out.printf("%4.3f", elapsedTime);
      System.out.println(" seconds.");
      
   // time RunningTime.timeTrial()
      clock = new Clock();
      RunningTime.timeTrial(N, seed);
      elapsedTime = clock.elapsedTime();
      System.out.print("This call to method RunningTime.timeTrial(" 
         + N + ", " + seed + ") took ");
      System.out.printf("%4.3f", elapsedTime);
      System.out.println(" seconds.");
   		
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