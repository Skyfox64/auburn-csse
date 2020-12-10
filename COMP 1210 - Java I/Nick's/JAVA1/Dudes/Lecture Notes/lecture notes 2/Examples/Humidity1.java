  /**
  *  Demonstrates the use of the "if" statement.
  */
   public class Humidity1 {
   /**
    *  Checks humidity and prints temperature.
    *   @param args - Standard commandline arguments
    */
      public static void main(String[] args) {
         int temp = 85;
         double humidity = .60;
         if (humidity >= .60) {
            temp = temp + 5;
         }
         System.out.println("Feels like " + temp + 
            " degrees."); 
      }
   }
