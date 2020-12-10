//********************************************************************
//  Zero.java       Author: Lewis/Loftus
//
//  Demonstrates an uncaught exception.
//********************************************************************
   import java.math.*;
    public class ZeroDoubleEtc
   {
   //-----------------------------------------------------------------
   //  Deliberately divides by zero to produce an exception.
   //-----------------------------------------------------------------
       public static void main (String[] args)
      {
         double numerator = 10.0;
         double denominator = 0.0;
         try
         {
            double x = numerator/denominator;
            double y1 = x/10;
            double y2 = x/x;
            double y2b = x*x;
            double y3 = 10.0/x;
            double y4 = 1000/x;
            double y5 = 10 * x;
            double y6 = 10/-0.0;
            double y7 = x + y6;
            
            
            int i1 = Integer.MAX_VALUE;
            int i2 = (int)x; 
            int i3 = (int)x/(int)x;
            int i4 = (int)x + (int)x;
            int i5 = (int)x * (int)x;
            int i6 = Integer.MAX_VALUE + Integer.MAX_VALUE;
            int i7 = 1 + Integer.MAX_VALUE;
            int i8 = 2147483647 - 10 + 1000;
            
            BigInteger j1 = new BigInteger("2147483647");
            System.out.println(j1);
            BigInteger j2 = j1.multiply(j1);
            System.out.println(j2);
            BigInteger j3 = j2.multiply(j2);
            System.out.println(j3);
            BigInteger j4 = j3.multiply(j3);
            System.out.println(j4);
            System.out.println (numerator/denominator);
         }
         
             catch(ArithmeticException problem)
            {
               System.out.println (problem.getMessage());
               System.out.println ("This text will be printed.");
            }
         finally
         {
            System.out.println ("This text will be printed from finally.");
         }
         
         System.out.println ("This text will be printed too.");
      }
   }
