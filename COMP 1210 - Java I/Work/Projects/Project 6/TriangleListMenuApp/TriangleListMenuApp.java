import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
/**  */
public class TriangleListMenuApp
{
/**
 * 
 * @param args - is not used.
 * @throws IOException from scanning input file.
 */
   public static void main(String[] args) throws IOException
   {
      String tListName = "none assigned";
      ArrayList<Triangle> myList = new ArrayList<Triangle>();
      TriangleList tL = new TriangleList(tListName, myList);
      String fileName = "none";
      
      double s1, s2, s3;   
      
      String code = "";
   
      Scanner scan = new Scanner(System.in);
      
      System.out.println("TriangleList System Menu\n"
                       + "R - Read in File and Create TriangleList\n"
                       + "P - Print TriangleList\n" 
                       + "S - Print Smallest Perimeter\n"
                       + "L - Print Largest Perimeter\n"   
                       + "T - Print Total of Perimeters\n"   
                       + "A - Add Triangle Object\n"
                       + "D - Delete Triangle Object\n"
                       + "Q - Quit");
   
      do {
         System.out.print("Enter Code [R, P, S, L, T, A, D, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
            
               tL = tL.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "TriangleList object created\n");
               break; 
                    
            case 'P':
               System.out.println(tL);
               break;
               
            case 'S':
               System.out.println("\n\tSmallest Perimeter: " 
                                    + tL.smallestPerimeter() + "\n");
               break;
               
            case 'L':
               System.out.println("\n\tLargest Perimeter: " 
                                    + tL.largestPerimeter() + "\n");
               break;
         
            case 'T':
               System.out.println("\n\tTotal of Perimeters: " 
                                    + tL.totalOfPerimeters() + "\n");
               break;
               
            case 'A':
               System.out.print("\tSide1: ");
               s1 = Integer.parseInt(scan.nextLine());
               System.out.print("\tSide2: ");
               s2 = Integer.parseInt(scan.nextLine());
               System.out.print("\tSide3: ");
               s3 = Integer.parseInt(scan.nextLine());
            
               tL.addTriangle(s1, s2, s3);
               System.out.println("\tTriangle added\n");
               break;   
               
            case 'D':
               System.out.print("\tSide1: ");
               s1 = Integer.parseInt(scan.nextLine());
               System.out.print("\tSide2: ");
               s2 = Integer.parseInt(scan.nextLine());
               System.out.print("\tSide3: ");
               s3 = Integer.parseInt(scan.nextLine());
            
               if (tL.deleteTriangle(s1, s2, s3)) {
                  System.out.println("\t\"" + s1 + ", " 
                                            + s2 + ", " 
                                            + s3 + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + s1 + ", " 
                                            + s2 + ", " 
                                            + s3 
                                            + "\" not found\n");
               }
               break;   
                  
            case 'Q': case 'q':
               break;
               
            default:
             // loop again
         }
      
      } while (!code.equalsIgnoreCase("Q"));   
      
      
   }
}