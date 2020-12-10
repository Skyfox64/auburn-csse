	/**
	* This class will store student name, number, tuition fees, 
	* and scholarships.
	*
	* @author Nick DiChiara
	* @version 10-2-2012
	*/

   public class Scores {
      	/**
   	* Default constructor. Sets listIn to list.
   	* @param listIn specifies the StudentInvoice array list.
   	*/
   
      private int[] numbers;
   
      	   /**
   * Method to get name.
   * @param numberIn specifies num in.
   */
      public Scores(int[] numberIn) {
         numbers = numberIn;
      }
   
   
   	   /**
   * Method to get name.
   * @return studentName specfies students name.
   */
      public int[] findEvens() {
         int numberEvens = 0;
      	
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
               numberEvens++;
            }
         }
       	
         /**
      * Method to get name.
      * @return studentName specfies students name.
      */
         int[] evens = new int[numberEvens];
         int count = 0;
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
               evens[count] = numbers[i];
               count++;
            }
         }  
      	
         return evens;
      }
   
   	   /**
   * Method to get name.
   * @return studentName specfies students name.
   */
      public int[] findOdds() {
         int numberOdds = 0;
      	
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
               numberOdds++;
            }
         }
         
         int[] odds = new int[numberOdds];
         int count = 0;
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
               odds[count] = numbers[i];
               count++;
            }
         }  
      
         return odds;
      }
   	
   	   /**
   * Method to get name.
   * @return studentName specfies students name.
   */
      public double calculateAverage() {
         int sum = 0;
      	
         for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
         }
         return (double) sum / (double) numbers.length;
      }
   	
   	   /**
   * Method to display information in reverse order.
   * @return output specifies array info in reverse order.
   */
      public String toReverseString() {
         String output = "";
      	
         for (int i = numbers.length - 1; i >= 0; i--) {
            output += numbers[i] + " ";
         }
         return output;
      }
   	
   	
   	   /**
   * Method to display information.
   * @return output specfies array info.
   */
      public String toString() {
         String output = "";
         
         for (int i = 0; i < numbers.length; i++) {
            output += numbers[i] + "\t";
         }
         return output;
      }
   }