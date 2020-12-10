import java.util.Scanner;
 
public class Difference {

   public static void main(String[] args) {
      int number1, number2, difference;
      Scanner userInput = new Scanner(System.in);
      // get user input
      System.out.print("Enter the first number: ");
      number1 = userInput.nextInt();
      System.out.print("Enter the second number: ");
      number2 = userInput.nextInt();
      
      //get difference
      if (number1 >= number2) {
         difference = number1 - number2;
      }
      else {
         difference = number2 - number1;
      }
      //print difference
      System.out.println("The difference is " + difference);
   }  
}
