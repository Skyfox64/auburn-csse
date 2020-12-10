  /**
  *  Demonstrates the use of the "if else" statement.
  */
   public class IfElseExample {
   /**
    *  Compares two numbers and prints "less than" relationship.
    *   @param args - Standard commandline arguments 
    */
      public static void main(String[] args) {
         int num1 = 9, num2 = 7;
         if (num1 < num2) {
            System.out.println(num1 + " is < " + num2);
         }
         else {
            System.out.println(num2 + " is < " + num1);
         }
         System.out.println("Done!");
      }
   }
