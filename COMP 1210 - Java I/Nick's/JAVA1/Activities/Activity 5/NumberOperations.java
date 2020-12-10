/**
* This class will store student name, grades, 
* and calculate final grade.
*
* @author Nick DiChiara
* @version 9-17-2012
*/
   public class NumberOperations {
   /**
   * Variables: exam1, exam2, finalExam, activityAvg,
   *					quizAvg, projectAvg, studentName.
   * Consructor
   * Methods
   * toString method (for String output)
   */
      private int number;
   
   	/**
   	* Default constructor.
   	* @param numberIn specifies number entered.
   	*/
      public NumberOperations(int numberIn) {
         number = numberIn;
      }
   
   	/**
   	* Method to calculate grade based on averages.
   	* @return grade specifies student's grade.
   	*/	
      public int getValue() {
         return number; //placeholder return
      }
      
      /**
   	* Method to calculate odd numbers.
   	* @return output specifies the odd numbers.
   	*/	
      public String oddsUnder() {
         String output = "";
         int i = 0;
         while (i < number) {
            if (i % 2 != 0) {
               output += i + "\t";
            }
            i++;
         }  
      	
         return output;
      }
      
      /**
   	* Method to find powers of two under "number".
   	* @return output specifies found values.
   	*/	
      public String powersTwoUnder() {
         String output = "";
         int powers = 1;
         while (powers < number) {
            output += powers + "\t";
            powers = powers * 2;
         }
         return output;
      }
      
   	/**
   	* Method to compare an entered number to "number".
   	* @param compareNumber specifies number for comparison.
   	* @return # is based off of the if statements.
   	*/	
      public int isGreater(int compareNumber) {
         if (number > compareNumber) {
            return 1;
         }
         else if (number < compareNumber) {
            return -1;
         }
         else {
            return 0; 
         }
      }
   	
   	/**
   	* Method to calculate grade based on averages.
   	* @return grade specifies student's grade.
   	*/	
      public String toString() {
         return number + "";
      }
   
   }