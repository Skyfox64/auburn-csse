  /**
  *  Demonstrates the use of the "if" statement.
  */
   public class Humidity2 {
   /**
    *  Checks humidity and prints temperature.
    *   @param args - Standard commandline arguments
    */
      public static void main(String[] args) {
         int temp = 85;
         double humidity = .60;
         boolean isHotter = humidity >= .60;
         if (isHotter) {
            temp = temp + 5;
         }
         System.out.println("Feels like " + temp + 
            " degrees."); 
      }
   }
