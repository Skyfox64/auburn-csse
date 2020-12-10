import java.util.ArrayList;
  /**
* This class will store an ArrayList of StudentInvoice objects.
* It will then use those to calculate averages based off of
* tuition fees, and scholarships.
*
* @author Nick DiChiara
* @version 9-26-2012
*/

public class StudentInvoiceList {
/**
* Variables: list.
* Consructor
* Methods
* toString method (for String output)
*/


   private ArrayList<StudentInvoice> list = new ArrayList<StudentInvoice>();

	/**
	* Default constructor. Sets listIn to list.
	* @param listIn specifies the StudentInvoice array list.
	*/
   public StudentInvoiceList(ArrayList<StudentInvoice> listIn) {
      list = listIn;
   }
 
	/**
	* Method to compute the average tuition fees.
	* @return average gives the average tuition fees.
	*/
   public double avgTuitionFees() {
      if (list.isEmpty()) {
         return 0;
      }
      else {
         int i = list.size();
         int j = i - 1;
         double total = 0;
         while (j >= 0) {
            total += list.get(j).getTuitionFees();
            j--;
         }
         double average = total / i; 
         return average;
      }
   }

	/**
	* Method calculate percentage of students with scholarships.
	* @return percent specifies the scholarship percentage.
	*/
   public double percentScholarships() {
      if (list.isEmpty()) {
         return 0;
      }
      else {
         int i = list.size();
         int j = i - 1;
         double total = 0;
         while (j >= 0) {
            if (list.get(j).getScholarships() > 0.00) {
               total++;
            }
            j--;
         }
         double percent = (total / i); 
         return percent;
      
      }
   }

   /**
	* Method to calculate the average scholarships.
	* @return average specifies the average scholarship.
	*/
   public double avgScholarships() {
      if (list.isEmpty()) {
         return 0;
      }
      else {
         int i = list.size();
         int j = i - 1;
         double total = 0;
         while (j >= 0) {
            if (list.get(j).getScholarships() == 0.00) {
               i--;
            }
            
            total += list.get(j).getScholarships();
            j--;
         }
         double average = total / i; 
         return average;
      }
   }

	/**
	* Method to output student information.
	* @return output specifies student's information.
	*/										
							
   public String toString() {
      String output = "";
      
      int i = list.size() - 1;
      int j = 0;
      while (j <= i) {
         output += list.get(j).toString() + "\n";
         j++;
      }
     
      return output + "\n";
   }
}