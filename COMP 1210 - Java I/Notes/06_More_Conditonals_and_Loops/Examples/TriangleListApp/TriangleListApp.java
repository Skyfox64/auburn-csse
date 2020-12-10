import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class TriangleListApp {

/**
 * 
 * @param args - is not used.
 * @throws IOException from scanning input file.
 */
   public static void main(String[] args) throws IOException
   {
      ArrayList<Triangle> myList = new ArrayList<Triangle>();
      String triangleListName = "";
      double side1 = 0;
      double side2 = 0;
      double side3 = 0;      
   
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      
      Scanner scanFile = new Scanner(new File(fileName));
   
      triangleListName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         side1 = Integer.parseInt(scanFile.nextLine());
         side2 = Integer.parseInt(scanFile.nextLine());
         side3 = Integer.parseInt(scanFile.nextLine());
         
         Triangle t = new Triangle(side1, side2, side3);
         myList.add(t);           
      }
      
      TriangleList myTriangleList = new TriangleList(triangleListName, myList);
   
      System.out.println(myTriangleList);
      
      DecimalFormat df = new DecimalFormat("#,##0.##");
      System.out.println("----- Summary for " + myTriangleList.getListName() 
                        + " -----"); 
      System.out.println("Number of Triangles: " 
                           + myTriangleList.numTriangles());
      System.out.println("Smallest Perimeter: " 
                           + myTriangleList.smallestPerimeter()); 
      System.out.println("Largest Perimeter: " 
                           + myTriangleList.largestPerimeterWithSides());   
   
      //java.text.DecimalFormat df = new java.text.DecimalFormat("#,##0");
                             
   }

}
