
import java.util.Scanner;
public class SecondProgramJan2013
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      scan.useDelimiter(",");
      System.out.print("Enter item info: ");
      String name = scan.next();
      double price = scan.nextDouble();
      int quantity = scan.nextInt();
      double total = price * quantity;   
      System.out.println("Total: " + total);
      System.out.println("War Eagle!!!"); 
   } 
}