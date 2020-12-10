import java.text.DecimalFormat;
/**
* This class will store student name, number, tuition fees, 
* and scholarships.
*
* @author Nick DiChiara
* @version 9-16-2012
*/

public class StudentInvoice {
/**
* Variables: studentName, studentNumber, tuitionFees, scholarShips.
* Consructor
* Methods
* toString method (for String output)
*/
   private String studentName;
   private String studentNumber;
   private double tuitionFees;
   private double scholarShips;
   
										
/**
* Default constructor.
* @param name specifies student's name.
* @param number specifies student's number.
* @param fees specifies student's tuition fees.
* @param ships specifies student's scholarships.
*/	
   public StudentInvoice(String name, String number, double fees, 
   								double ships) {
   						
      studentName = name;
      studentNumber = number;
      tuitionFees = fees;
      scholarShips = ships;
    
   
   }
	
	
	

/**
* Method to get name.
* @return studentName specfies students name.
*/
   public String getName() {
      return studentName; 
   }									
		
/**
* Method to set name.
* @param name specifies student's name.
* @return isSet specifies whether the boolean is set.
*/
   public boolean setName(String name) {
      boolean isSet = false;
      if (name != null && name.trim().length() != 0) {
         studentName = name.trim();
         isSet = true; }
      return isSet;
   }	
							
/**
* Method to get the stored student number.
* @return studentNumber gives the current student number.
*/
   public String getStudentNumber() {
      return studentNumber;
   }
   
/**
* Method to check to see if the entered student number is valid and 
* then set it.
* @param number specifies student's number.
* @return isSet specifies whether the boolean is set.
*/
   public boolean setStudentNumber(String number) {
      boolean isSet = false;
      if (number != null && number.trim().length() != 0) {
         studentNumber = number.trim();
         isSet = true; }
      return isSet;
   }
   
/**
* Method to get the stored tuition fees.
* @return tuitionFees gives the current tuition fees.
*/
   public double getTuitionFees() {
      return tuitionFees;
   }
   
/**
* Method to set tuition fees to entered value.
* @param fees specifies student's tuition fees.
*/		
   public void setTuitionFees(double fees) {
      tuitionFees = fees;
   }
   
/**
* Method to get stored scholarship values.
* @return scholarShips gives the current scholarships.
*/
   public double getScholarships() {
      return scholarShips;
   }
   
/**
* Method to set tuition to entered value.
* @param ships specifies student's scholarships.
*/
   public void setScholarships(double ships) {
      scholarShips = ships;
   }
   
/**
* Method to adjust stored tuition fees by adding the other entered fees.
* @param fees specifies student's tuition fees.
* @return tuitionFees gives the current fees.
*/
   public double adjustTuitionFees(double fees) {
   //Check and see if void is correct.
      tuitionFees += fees;
      return tuitionFees;
   }
		
/**
* Method to adjust stored scholarships by adding the other 
* entered scholarships.
* @param ships specifies student's scholarships.
* @return scholarShips gives the current scholarships.
*/
   public double adjustScholarships(double ships) {
   //CHEck and see if void is correct.
      scholarShips += ships;
      return scholarShips;
   }


							
/**
* Method to output student's information.
* @return output specifies student's information.
*/										
							
   public String toString() {
   
      DecimalFormat dollarFmt = new DecimalFormat("$##,###.00");
   
      String output = "\nName: " + studentName + "\n";
      output += "ID Number: " + studentNumber + "\n";
      output += "Tuition & Fees: " + dollarFmt.format(tuitionFees) + "\n";
      output += "Scholarships: " + dollarFmt.format(scholarShips) + "\n";
      if (tuitionFees > scholarShips) {
         output += "\nYou owe: " 
            + dollarFmt.format(tuitionFees - scholarShips);
      }
      else {
         output += "\nPlease pick up your check for: " 
            + dollarFmt.format(scholarShips - tuitionFees);
      }
   	
      return output;
   }									

}