//********************************************************************
//  CountOff.java       Author: J. Cross
//
//  Demonstrates the difference between print and println.
//********************************************************************

    public class FloatDoubleTest
   {
   //-----------------------------------------------------------------
   //  Prints down the page then across.
   //-----------------------------------------------------------------
       public static void main (String[] args)
      {
         double x1 = .2;
         float y1 = (float) .2;
         double x2 = 1.123456789012345;
         float y2 = (float) x2;
      
         
         System.out.println ("Down");
         System.out.println ("One... ");
         System.out.println ("Two... ");
         System.out.println ("Three... ");
         System.out.print ("Across... ");
         System.out.print ("four... ");
         System.out.print ("five... ");
         System.out.println ("and end");
      }
   }
