import java.util.Scanner;

public class AbsoluteValue2 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double num = 0;
   
      do {
         try {
            System.out.print("Enter a non-zero number: ");
            num = Double.parseDouble(input.nextLine());
         }
         catch (NumberFormatException issue) {
            System.out.println("That is not a valid number.");
         }
      } while (num == 0);
   
      System.out.print("The absolute value of " 
         + num + " is " + Math.abs(num));
   }
}