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
* @version 9-26-2012
*/
public class StudentInvoiceListApp {

/**
* Method to retrieve file name. Gather information from file. Send to 
* StudentInvoiceList for processing, and print the results.
* @param args the command line arguments.
* @throws IOException FileNotFoundException.
*/
   public static void main(String[] args) throws IOException {
   
      ArrayList<StudentInvoice> list = new ArrayList<StudentInvoice>();
      Scanner userInput = new Scanner(System.in);
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
            list.add(new StudentInvoice(parser.nextLine(), 
               		parser.nextLine(), 
               		Double.parseDouble(parser.nextLine()),
               		Double.parseDouble(parser.nextLine())));
         }
         parser.close();
         break;
      }
      
      StudentInvoiceList sil = new StudentInvoiceList(list);
      DecimalFormat dollar = new DecimalFormat("$##,##0.00");
      DecimalFormat percent = new DecimalFormat("##0.00%");
      
      String output = "";
      output += sil.toString();
      output += "Average Tuition and Fees: " 
         		 + dollar.format(sil.avgTuitionFees()) + "\n";
      output += "Percentage of Student with Scholarships: " 
         		 + percent.format(sil.percentScholarships()) + "\n";
      output += "Average Scholarship: " 
         		 + dollar.format(sil.avgScholarships()) + "\n";
      
      System.out.print(output);
   }
}