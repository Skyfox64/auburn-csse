import java.util.Scanner;
import java.io.IOException;
import java.io.File;

/**
* This class will store the student's name, number of grades and perform  
* operations such as printing, adding, deleting and finding grades by category.
*
* @author John Carroll
* @version 10-21-2013
*/
public class WeightedGradesApp
{

   /**
	* Method to retrieve file name. Gather information from file. Send to 
	* WeightedGrades for processing, and print the results.
	* @param args the command line arguments.
	* @throws IOException FileNotFoundException.
	*/
   public static void main(String[] args) throws IOException
   {  
      WeightedGrades student = null;
      
      boolean getInfo = true;
      while (getInfo) {
         if (args.length == 0) {
            System.out.println("File name was expected as a run argument.\n"
               + "Program ending.");
            return; 
         } 
               
         Scanner reader = new Scanner(new File(args[0]));
         String name = reader.nextLine();
        
         int numGrades = 0;
         while (reader.hasNextLine()) {
            reader.next();
            numGrades++;
         }
         reader.close();
         String[] grades = new String[numGrades];
         
         reader = new Scanner(new File(args[0]));
         reader.nextLine();
         
         
         for (int i = 0; i < numGrades; i++) {
            grades[i] = reader.nextLine();
         }
          
         WeightedGrades newStudent = new WeightedGrades(
            name, numGrades, grades);
         student = newStudent;
         System.out.println(
            "File read in and WeightedGrades object created.\n");
         break;
      }
      
      System.out.println("Weighted Grades App Menu");
      System.out.println("P - Print Report");
      System.out.println("C - Print Category");
      System.out.println("A - Add Grade");
      System.out.println("D - Delete Grade");
      System.out.println("Q - Quit");   
      String input = "";
      
      Scanner userInput = new Scanner(System.in);
      
      do 
      {
         System.out.print("\nEnter Code [P, C, A, D, or Q]:");
         input = userInput.nextLine();
         if (input.length() == 0) {
            continue;
         }
         input = input.toUpperCase();
         char choice = input.charAt(0);
         switch(choice) {
            case 'P':
               System.out.print(student);
               break;
               
            case 'C':
               System.out.print("\tCategory: ");
               char category = userInput.nextLine().charAt(0);
               System.out.print("\t");
               double[] catGrades = student.gradesByCategory(category); 
               for (int i = 0; i < catGrades.length; i++) {
                  System.out.print(catGrades[i] + " ");
               }
               System.out.print("\n");
               break;
                     
            case 'A':
            
               System.out.print("\tGrade to add: ");
               student.addGrade(userInput.nextLine());
               break;
         
            case 'D':
               System.out.print("\tGrade to delete: ");
               String gradeInput = userInput.nextLine();
               
               if (student.deleteGrade(gradeInput)) {
                  System.out.print("\tGrade removed.\n");
               }
               else {
                  System.out.print("\tGrade not found.\n");
               }         
               break;
                    
            case 'Q': case 'q':
               break;
               
            default:
         }
      
      } while (!input.equalsIgnoreCase("Q"));   
   }
}