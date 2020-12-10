   import java.util.Scanner;
	/**
	* This program will enter and interact with class StudentInvoice
	* to store student information.
	*
	* @author Nick DiChiara
	* @version 9-16-2012
	*/

   public class StudentInvoiceApp {
   
   /**
   *
   * This class takes the user's input and interfaces with the
   * StudentInvoice class.
   *
   * @param args User-defined Command line arguments (not used).
   */
   
      public static void main(String[] args) {
      	
         String studentName;
         String studentNumber;
         double tuitionFees;
         double scholarships;
      	
      	
         Scanner userInput = new Scanner(System.in);
      	
         System.out.print("Please enter first and last name: ");
         studentName = userInput.nextLine();
      	
         System.out.print("Please enter student ID number: ");
         studentNumber = userInput.nextLine();
         
      	
         System.out.print("Please enter tuition and fees: ");
         tuitionFees = Double.parseDouble(userInput.nextLine());
         
         System.out.print("Please enter scholarships: ");
         scholarships = Double.parseDouble(userInput.nextLine());
         
         StudentInvoice s = new StudentInvoice(studentName, studentNumber,
            							tuitionFees, scholarships);
      
      	
         System.out.print(s);
      
      }
   }