import java.util.Scanner;
public class NumericTest
{
   public static void main(String[] args)
   {
      String digits = "124";
      Scanner scan = new Scanner(digits);  
      if (scan.hasNextDouble()) {  
         double d = scan.nextDouble();  
         System.out.println(d);  
      } 
      else {
         System.out.println(digits + ": Not a double."); 
      } 
   }
}