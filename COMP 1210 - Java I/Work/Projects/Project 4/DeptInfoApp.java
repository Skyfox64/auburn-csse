import java.util.Scanner;
/**
*
* @Author: John Carroll
* @Version: 9-21-2013
* Assignment Due Date: 9-23-2013
*
* The main method should prompt the user to enter the 
* department name, abbreviation, location, number of 
* faculty, number of graduate teaching assistants, number 
* of undergraduate students, number of graduate students, 
* and amount of research funding. After the values have 
* been read in, a DeptInfo object should be created and printed. 
*
*/

public class DeptInfoApp
//DeptInfoApp.java
{
   /**
   * @param args Command line arguments (not used).
   */
   public static void main(String[] args)
   {
      
      //Scanner
      Scanner userInput = new Scanner(System.in);
   
      //Prompt user for Dept:
      System.out.print("Dept: ");
      String deptName = userInput.nextLine();
      //Rid input of whitespace for non-string use
      String name = deptName.trim();
            
      //Prompt user for Abbreviation:
      System.out.print("Abbreviation: ");
      String abbreviation = userInput.nextLine();
      String abbrev = abbreviation.trim();   
      
      //Prompt user for Location:
      System.out.print("Location: ");
      String locationName = userInput.nextLine();
      String location = locationName.trim(); 
      
      //Prompt user for Number of Faculty:
      System.out.print("Number of Faculty: ");
      int numFaculty = Integer.parseInt(userInput.nextLine());
      
      //Prompt user for Number of GTA's:
      System.out.print("Number of GTA: ");
      int numGta = Integer.parseInt(userInput.nextLine());
      
      //Prompt user for Number of Undergraduate students:
      System.out.print("Number of Ugrad Students: ");
      int numUnderGrad = Integer.parseInt(userInput.nextLine());
      
      //Prompt user for Number of Graduate students:
      System.out.print("Number of Grad Students: ");
      int numGrad = Integer.parseInt(userInput.nextLine());
      
      //Prompt user for amount of Research Funding:
      System.out.print("Research Funding: ");
      double researchFund = Double.parseDouble(userInput.nextLine());
   
      
      //DeptInfo object: created and then printed
      DeptInfo dept = new DeptInfo(name, abbrev, location, numFaculty, 
         numGta, numUnderGrad, numGrad, researchFund);
      System.out.println("\n" + dept);
   }
}