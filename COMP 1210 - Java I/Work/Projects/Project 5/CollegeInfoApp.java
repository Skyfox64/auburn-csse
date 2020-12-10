import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
/**
*
* @Author: John Carroll
* @Version: 10-5-2013
* Assignment Due Date: 10-7-2013
*
* This class will store an ArrayList of DeptInfo objects.
* It will then pass those to CollegeInfo to compute and gather
* a Summary for the college and its departments. 
*
*/

public class CollegeInfoApp
//CollegeInfoApp.java
{
   /**
   * @param args Command line arguments (not used).
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   public static void main(String[] args) throws IOException
   {
      //Read a file
      ArrayList<DeptInfo> dept = new ArrayList<DeptInfo>();
      Scanner userInput = new Scanner(System.in);
      String fileName;
   
      System.out.print("Enter file name: ");
      fileName = userInput.nextLine();
      //System.out.print("\n");
      
      String collegeName = "";
      
      boolean getCollege = true;
      while (getCollege) {
      
         if (fileName.trim().length() == 0) {
            break; 
         } 
         else {
            //Scan in file
            Scanner inFile = new Scanner(new File(fileName));
         
            //Print College name
            collegeName = inFile.nextLine();
            
            
            //Print DeptInfo Objects    
            while (inFile.hasNext()) {
               dept.add(new DeptInfo(inFile.nextLine(), 
                     inFile.nextLine(), inFile.nextLine(),
                     Integer.parseInt(inFile.nextLine()),
                     Integer.parseInt(inFile.nextLine()),
                     Integer.parseInt(inFile.nextLine()),
                     Integer.parseInt(inFile.nextLine()),
                     Double.parseDouble(inFile.nextLine())));
            }
            inFile.close();
            break;
         }
      }
      
      //CollegeInfo object: created and then printed
      CollegeInfo ci = new CollegeInfo(collegeName, dept);
      System.out.print(ci);
   }
}