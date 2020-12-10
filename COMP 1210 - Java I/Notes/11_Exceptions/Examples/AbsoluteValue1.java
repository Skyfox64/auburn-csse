import java.util.Scanner;

public class AbsoluteValue1 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double num = 0;
   
      do {
         System.out.print("Enter a non-zero number: ");
         num = Double.parseDouble(input.nextLine());
      } while (num == 0);
   
      System.out.print("The absolute value of " 
         + num + " is " + Math.abs(num));
   }
}