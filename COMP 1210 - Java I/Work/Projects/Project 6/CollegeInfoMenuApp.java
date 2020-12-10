import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
/**
*
* @Author: John Carroll
* @Version: 10-13-2013
* Assignment Due Date: 10-14-2013
*
* This class will store an ArrayList of DeptInfo objects.
* It will then pass those to CollegeInfo to compute and gather
* a Summary for the college and its departments.
* This main method prints a list of options with the action code and a short
* description followed by a line with just the action codes prompting the user
* to select an action. After the user enters an action code, the action is 
* performed, including output if any. Then the line with just the action codes 
* prompting the user to select an action is printed again to accept the next
* code. The first action a user should normally perform is 'R' to read in the
* file and create a CollegeInfo object. The other actions can then be used to 
* process the CollegeInfo object. This continues until the user enters 'Q' to
* quit. Note that your program should accept both uppercase and lowercase 
* action codes. 
*
*/
public class CollegeInfoMenuApp
{
   /**
   * @param args Command line arguments (not used).
   * @throws IOException  If an input or output 
   *                      exception occurred      
   */
   public static void main(String[] args) throws IOException
   {
      String collegeName = "";
      
      ArrayList<DeptInfo> collegeList = new ArrayList<DeptInfo>();
      CollegeInfo ci = new CollegeInfo(collegeName, collegeList);
      Scanner userInput = new Scanner(System.in);
      System.out.println("CollegeInfo System Menu");
      System.out.println("R - Read in File and Create CollegeInfo");
      System.out.println("P - Print CollegeInfo");
      System.out.println("S - Print Summary");
      System.out.println("A - Add DeptInfo Object");
      System.out.println("D - Delete DeptInfo Object");
      System.out.println("F - Find DeptInfo Object");
      System.out.println("Q - Quit");   
      String input = "";
      
      do 
      {
         System.out.print("Enter Code [R, P, S, A, D, F, or Q]:");
         input = userInput.nextLine();
         if (input.length() == 0) {
            continue;
         }
         input = input.toUpperCase();
         char choice = input.charAt(0);
         switch(choice) {
            case 'R':
               System.out.print("\tFile name: ");
               String fileName = userInput.nextLine();
                  
               ci = ci.readFile(fileName);
            
               System.out.println("\tFile read in " 
                  + "and CollegeInfo object created\n");
               
               break; 
                    
            case 'P':
               System.out.print(ci);
               break;
               
            case 'S':
               System.out.println(ci.summary() + "\n");
               break;
               
            case 'A':
               System.out.print("\tDept Name: ");
               String nameIn = userInput.nextLine();
               System.out.print("\tAbbrev: ");
               String abbrevIn = userInput.nextLine();
               System.out.print("\tLocation: ");
               String locationIn = userInput.nextLine();
               System.out.print("\tNumber of Faculty: ");
               int numFacultyIn = Integer.parseInt(userInput.nextLine());
               System.out.print("\tNumber of TAs: ");
               int numGtaIn = Integer.parseInt(userInput.nextLine());
               System.out.print("\tNumber of UGrads: ");
               int numUnderGradIn = Integer.parseInt(userInput.nextLine());
               System.out.print("\tNumber of Grads: ");
               int numGradIn = Integer.parseInt(userInput.nextLine());
               System.out.print("\tResearch Funding: ");
               double researchFundIn = Double.parseDouble(userInput.nextLine());
            
               
               ci.addDeptInfo(nameIn, abbrevIn, locationIn, 
                  numFacultyIn, numGtaIn, numUnderGradIn, numGradIn, 
                  researchFundIn); 
               System.out.println("\tDeptInfo added\n");
            
               break;
         
            case 'D':
               System.out.print("\tDept Abbrev: ");
               String abbrev = userInput.nextLine();
               
               if (ci.deleteDeptInfo(abbrev)) {
                  System.out.println("\t\"" + abbrev + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + abbrev + "\" not found\n");
               }
                  
               
               break;
               
            case 'F':
               System.out.print("\tDept Abbrev: ");
               String abbrev1 = userInput.nextLine();
               
               if (ci.findDeptInfo(abbrev1) != "") {
                  System.out.println(ci.findDeptInfo(abbrev1));
               }
              
               break;      
                  
            case 'Q': case 'q':
               break;
               
            default:
         }
      
      } while (!input.equalsIgnoreCase("Q"));   
   }
}