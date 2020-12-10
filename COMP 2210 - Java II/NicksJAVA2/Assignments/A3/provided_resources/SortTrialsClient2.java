import java.lang.reflect.*;
import java.lang.Class;
import java.text.DecimalFormat;

/**
 * SortTrialsClient.java. Provides a simple example
 * client of SortTrials.java.
 *
 * NOTE: The generic type of SortTrials must be bound
 *       to a Comparable type. The sorting methods in
 *       SortTrials use the natural ordering of the
 *       elements in the parameter array.
 *
 * Compilation:   %javac SortTrialsClient.java
 * Execution:     %java -ea SortTrialsClient
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2013-02-05
 *
 */
public final class SortTrialsClient2 {

   public static void main(String[] args) {
   
      Clock clock;              // measures elapsed time
      double elapsedTime = 0;   // elapsed time of current run
      double prevTime = 0;      // elapsed time of previous run
      double ratio = 1;         // currentTime / prevTime
      double lgratio = 0;       // log base 2 of ratio
      int N = 2000;             // problem size parameter
      int trials = 10;           // # of trials
      int k = 1;                //counter used for output
      DecimalFormat d3 = new DecimalFormat("##0.000"); //Format for output 
   
      try{
             
         SortTrials<Integer> st = new SortTrials<Integer>();
         Method[] test_methods = st.getClass().getDeclaredMethods();
         
         for (Method m : test_methods) {
            String name = m.getName();
            if (name.startsWith("sort")) {
               System.out.println("\nMethod: sort" + k);
               System.out.println("Run---N---------Time------Ratio----lgRatio");
               for (int j = 0; j < trials; j++){
                  
               
                  Integer[] a = new Integer[N];
                  for(int i = 0; i < N; i++){
                     a[i] = (int)(Math.random() * 1000);
                  }
               
                  System.out.print(j + "     ");
                  System.out.format("%07d", N);
                  System.out.print("   ");
                  assert st.isSorted(a) == false;
                  clock = new Clock();
                  m.invoke(st, new Object[]{a});
                  elapsedTime = clock.elapsedTime();
                  if (prevTime == 0){ ratio = 0; lgratio = 0;}
                  else{ratio = (elapsedTime / prevTime);
                     lgratio = Math.log(ratio)/Math.log(2);}
                  
                  System.out.print(d3.format(elapsedTime) + "s    " + d3.format(ratio) + "    " + d3.format(lgratio) + "\n");;
                  prevTime = elapsedTime;
                  assert st.isSorted(a) == true;
                  st.shuffle(a);
                  N=N*2;
               }
               N = 2000;
               k++;
               prevTime = 0;
            }
         }      
                  
            
            
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
         
      
      
       
   }
}