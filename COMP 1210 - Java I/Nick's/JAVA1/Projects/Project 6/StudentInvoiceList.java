   import java.util.ArrayList;
   
	
  /**
	* This class will store an ArrayList of StudentInvoice objects.
	* It will then use those to calculate averages based off of
	* tuition fees, and scholarships.
	*
	* @author Nick DiChiara
	* @version 10-2-2012
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
   	* Method to add a new student invoice.
   	* @param name specifies student's name.
   	* @param number specifies student ID number.
   	* @param fees specifies student's tuition fees.
   	* @param ships specifies student's scholarships.
   	*/
      public void addStudentInvoice(String name, String number, 
      										double fees, double ships) {
         list.add(new StudentInvoice(name, number, fees, ships));
      
      }
      
   	
   	/**
   	* Method to delete a student invoice.
   	* @param number specifies student ID number.
   	* @return specifies whether the value was changed.
   	*/
      public boolean deleteStudentInvoice(String number) {
         for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentNumber().equals(number)) {
               list.remove(i);
               return true;
            }
         }	
         return false;
      }
      
   	
   	/**
   	* Method to set a student's tuition fees.
   	* @param number specifies student ID number.
   	* @param fees specifies student's new fees.
   	* @return specifies whether the value was changed.
   	*/
      public boolean setStudentInvoiceTuitionFees(String number, double fees) {
         for (StudentInvoice i : list) {
            if (i.getStudentNumber().equals(number)) {
               i.setTuitionFees(fees);
               return true;
            }
         }
      
         return false;
      }
      
   	
   	/**
   	* Method to get a student's tuition fees.
   	* @param number specifies student ID number.
   	* @return specifies the value and whether it was changed.
   	*/
      public double getStudentInvoiceTuitionFees(String number) {
         for (StudentInvoice i : list) {
            if (i.getStudentNumber().equals(number)) {
               return i.getTuitionFees();
            }
         }
      
         return -1;
      }
      
   	
   	
   	/**
   	* Method to set a student's scholarships.
   	* @param number specifies student ID number.
   	* @param ships specifies student's new scholarships.
   	* @return specifies whether the value was changed.
   	*/
      public boolean setStudentInvoiceScholarships(String number, 
      															 double ships) {
         for (StudentInvoice i : list) {
            if (i.getStudentNumber().equals(number)) {
               i.setScholarships(ships);
               return true;
            }
         }
      
         return false;
      }
   
   
      /**
   	* Method to get a student's scholarships.
   	* @param number specifies student ID number.
   	* @return specifies the value and whether it was changed.
   	*/
      public double getStudentInvoiceScholarships(String number) {
         for (StudentInvoice i : list) {
            if (i.getStudentNumber().equals(number)) {
               return i.getScholarships();
            }
         }
      
         return -1;
      }
      
   	
   	/**
   	* Method to find a student's invoice.
   	* @param number specifies student ID number.
   	* @return specifies the value and whether it was found.
   	*/
      public String findStudentInvoice(String number) {
         for (StudentInvoice i : list) {
            if (i.getStudentNumber().equals(number)) {
               return i.toString() + "\n";
            }
         }
      
         return number + " not found";
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