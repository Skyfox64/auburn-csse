   /**
   */
   public class Division {
   
   /**
   * Method intDivide.
   * @param numerator specifies the numerator.
   * @param denominator specifies the numerator.
   * @return specifies the division of the two.
   */
      public static int intDivide(int num, int denom) {
         try {
            return num / denom;
         }
            catch(ArithmeticException error) {
               return 0;
            }
         
      }
   
   /**
   * Method decimalDivide.
   * @param numerator specifies the numerator.
   * @param denominator specifies the numerator.
   * @return specifies the division of the two.
   */
      public static float decimalDivide(int num, int denom) {
         if (denom == 0) {
            throw new IllegalArgumentException("The denominator "
               + "cannot be zero.");
         }
         return (float) num / denom;
      }
   
   }