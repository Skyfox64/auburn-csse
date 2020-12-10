/** SQA examples using assertions and exceptions. */  
public class SQA_AssertionExamples {

   public static void main(String[] args) {
      setOddEven(10);
      setOddEven2(35);
      setOddEven(-10);
      intSqRoot(23);
   }
 
   /**
    * Determines if an integer is odd or even.
    *
    * @param x the interger to be tested.
    *
    * @return 1 if x is odd, 0 if x is even.
    */  
   public static int setOddEven(int x) {
      assert x >= 0 : "x is not >= 0; x = " + x;
      
      System.out.println("IN x: " + x);
      
      while (x > 1)
      {
         x = x - 2;
      }
      
      System.out.println("OUT x: " + x);
      
      assert x == 0 || x == 1 : "x = " + x +"; should have been 0 or 1";
   
      return x;
   }
  
   /**
    * Determines if an integer is odd or even.
    *
    * @param x the interger to be tested.
    *
    * @return 1 if x is odd, 0 if x is even.
    *
    * @throws IllegalArgumentException when x < 0.
    */
   public static int setOddEven2(int x) {
      //assert x >= 0 : "x is not >= 0; x = " + x;
      if (!(x >= 0))
         throw new IllegalArgumentException
            ("x = " + x + ": x must be >= 0: ");
      
      System.out.println("IN x: " + x);
      
      while (x > 1)
      {
         x = x - 2;
      }
      
      System.out.println("OUT x: " + x);
      assert x == 0 || x == 1 : "x = " + x +"; should have been 0 or 1";
      return x;
   }
  

   /**
    * Computes the integer part of a square root.
    *
    * @param x the integer to be tested. This must be >= 0.
    *
    * @throws IllegalArgumentException if x < 0.
    */
   public static int intSqRoot(double x) {
      if (!(x >= 0))
         throw new IllegalArgumentException
            ("x = " + x + ": x must be >= 0: ");
   
      int y = 0;
      while (Math.pow((y + 1), 2) <= x) {
         y = y + 1;
      }
      System.out.println("x = " + x + ", y = " + y);
         
      return y;
   }
   

}
