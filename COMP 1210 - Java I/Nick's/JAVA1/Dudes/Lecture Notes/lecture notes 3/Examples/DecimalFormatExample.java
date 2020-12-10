   import java.text.DecimalFormat;

/**
 * Demonstrates the use of the DecimalFormat 
 * class.
 */
   public class DecimalFormatExample
   {
   /**
   * Declares and intializes some doubles then
   * prints them using instances of DecimalFormat.
   *
   * @param args Command-line arguments (unused). 
   */
      public static void main(String[] args)
      {
         double b, c;  
         c = 123456789.87654321;
         b = 0;
         double a = 12345.6789;
         DecimalFormat fmt1 = new DecimalFormat("0.###E0");     
         System.out.println(fmt1.format(a));
         DecimalFormat fmt2 = new DecimalFormat("0.###E0");     
         System.out.println(fmt2.format(c));
         
         DecimalFormat df = new DecimalFormat("0.##");
         double val = 4.123567;
         System.out.println(df.format(val));
         
         DecimalFormat df2 = new DecimalFormat("$#,###.##");
         double val2 = -112345678.123567;
         System.out.println(df2.format(val2));
      	
      
      	
         // Scanner scan = new Scanner (System.in);
      // 
         // System.out.print ("Enter the coefficient of x squared: ");
         // a = scan.nextInt();
      // 
         // System.out.print ("Enter the coefficient of x: ");
         // b = scan.nextInt();
      // 
         // System.out.print ("Enter the constant: ");
         // c = scan.nextInt();
      // 
      // // Use the quadratic formula to compute the roots.
      // // Handles a positive or negative discriminant.
      // 
         // discriminant = Math.pow(b, 2) - (4 * a * c);
         // if (discriminant >= 0)
         // {
            // System.out.println("\nRoots are rational.");
            // root1 = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
            // root2 = ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);
         // 
            // System.out.println ("Root #1: " + root1);
            // System.out.println ("Root #2: " + root2);
         // }
         // else
         // {
            // System.out.println("\nRoots are irrational.");
            // System.out.println("Root #1: " + (-1 * b) + " + " 
               // + Math.sqrt(-1 * discriminant)+"i");
            // System.out.println("Root #2: " + (-1 * b) + " - " 
               // + Math.sqrt(-1 * discriminant)+"i");
         // }
      }
   }
