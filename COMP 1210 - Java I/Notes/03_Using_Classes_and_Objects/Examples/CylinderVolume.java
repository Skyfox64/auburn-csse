import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Calculates the volume of a cylinder.
 */
public class CylinderVolume {
   /**
    * Calculates the volume of a cylinder.
    *
    * @param args Command-line arguments (unused). 
    */
   public static void main(String[] args) {
      double radius, height, volume;
   
      Scanner scan = new Scanner(System.in);
   
      System.out.print("Enter the radius: ");
      radius = scan.nextDouble();
   
      System.out.print("Enter the height: ");
      height = scan.nextDouble();
      
      volume = Math.PI * Math.pow(radius, 2) * height;
   
      System.out.println("The volume of the cylinder is " 
         + volume + " cubic units.");
         
   // Now, format the value of volume using an 
   // instance of the DecimalFormat class. 
      DecimalFormat dFmt = new DecimalFormat("#0.0##");
      System.out.println("The volume of the cylinder is " 
         + dFmt.format(volume) + " cubic units.");
   }
}
