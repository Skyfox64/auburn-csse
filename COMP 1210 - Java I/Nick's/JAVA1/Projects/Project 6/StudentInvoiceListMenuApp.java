import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
/**
* This class will store an ArrayList of StudentInvoice objects.
* It will then pass those to StudentInvoiceList to calculate averages based 
* off of tuition fees, and scholarships.
*
* @author Nick DiChiara
* @version 10-2-2012
*/
public class StudentInvoiceListMenuApp {

/**
* Method to retrieve file name. Gather information from file. Send to 
* StudentInvoiceList for processing, and print the results.
* @param args the command line arguments.
* @throws IOException FileNotFoundException.
*/
   public static void main(String[] args) throws IOException {
   
      StudentInvoiceList sil = null;
      Scanner userInput = new Scanner(System.in);
      boolean quit = false;
      DecimalFormat dollar = new DecimalFormat("$##,##0.00");
      DecimalFormat percent = new DecimalFormat("##0.00%");
      
      String menu = "StudentInvoice System Menu\n";
      menu += "R - Read in File\n";
      menu += "P - Print Report\n";
      menu += "A - Add An Invoice\n";
      menu += "D - Delete an Invoice\n";
      menu += "T - Set Tuition and Fees\n";
      menu += "S - Set Scholarships\n";
      menu += "F - Find an Invoice\n";
      menu += "Q - Quit\n";
      System.out.print(menu);
   	
      do {
         System.out.print("Enter Code [R, P, A, D, T, S, F, or Q]: ");
      
         char input = Character.toLowerCase(userInput.nextLine().charAt(0));
      
         switch (input) {
            case 'r':
            	//R - Read in File
               ArrayList<StudentInvoice> l = new ArrayList<StudentInvoice>();
               String fileName;
            
               System.out.print("Enter file name: ");
               fileName = userInput.nextLine();
            
               boolean getInvoices = true;
               while (getInvoices) {
               
                  if (fileName.trim().length() == 0) {
                     break; 
                  } 
               
                  Scanner parser = new Scanner(new File(fileName));
                  while (parser.hasNext()) {
                     l.add(new StudentInvoice(parser.nextLine(), 
                        parser.nextLine(), 
                        Double.parseDouble(parser.nextLine()),
                        Double.parseDouble(parser.nextLine())));
                  }
                  parser.close();
                  StudentInvoiceList newsil = new StudentInvoiceList(l);
                  sil = newsil;
                  System.out.println("file read in and student "
                     + "invoice list created");
                  break;
               }
            
               break;
            case 'p':
            	//P - Print Report
               String output = "";
               output += sil.toString();
               output += "Average Tuition and Fees: " 
                  + dollar.format(sil.avgTuitionFees()) + "\n";
               output += "Percentage of Student with Scholarships: " 
                  + percent.format(sil.percentScholarships()) + "\n";
               output += "Average Scholarship: " 
                  + dollar.format(sil.avgScholarships()) + "\n";  
            
               System.out.print(output + "\n");
               break;
            case 'a':
            	//A - Add An Invoice
               System.out.print("Name: ");
               String name = userInput.nextLine();
               System.out.print("ID Number: ");
               String number = userInput.nextLine();
               System.out.print("Tuition & Fees: ");
               double fees = Double.parseDouble(userInput.nextLine());
               System.out.print("Scholarships: ");
               double ships = Double.parseDouble(userInput.nextLine());
               sil.addStudentInvoice(name, number, fees, ships);
               System.out.print("student added\n");
               break;
            case 'd':
            	//D - Delete an Invoice
               System.out.print("Delete Student with ID Number: ");
               number = userInput.nextLine();
               System.out.print(number);
               System.out.print(sil.deleteStudentInvoice(number) 
                  ? " deleted\n" : " not found\n");
            
               break;
            case 't':
            	//T - Set Tuition and Fees
               System.out.print("Set TuitionFees for Student with " 
                  + "ID Number: ");
               number = userInput.nextLine();
               System.out.print("Enter Tuition: ");
               fees = Double.parseDouble(userInput.nextLine());
               System.out.print(number);
               System.out.print(sil.setStudentInvoiceTuitionFees(number, 
                  																fees) 
                  	? " Tuition and Fees: " + dollar.format(fees)
                  	+ "\n" : " not found\n");
               break;
            case 's':
            	//S - Set Scholarships
               System.out.print("Set Scholarships for Student with " 
                  + "ID Number: ");
               number = userInput.nextLine();
               System.out.print("Enter Scholarships: ");
               ships = Double.parseDouble(userInput.nextLine());
               System.out.print(number);
               System.out.print(
                  	sil.setStudentInvoiceScholarships(number, ships) 
                  	? " Scholarships: " + dollar.format(ships)
                  	+ "\n" : " not found\n");
            
               break;
            case 'f':
            	//F - Find an Invoice
               System.out.print("Find Student with ID Number: ");
               number = userInput.nextLine();
               System.out.print(
                  	sil.findStudentInvoice(number) + "\n");
               break;
            case 'q':
            	//Q - Quit
               quit = true;
               break;
            default:
               System.out.println("Invalid choice.");			
         }
      } while (!quit);	
      
   }
}