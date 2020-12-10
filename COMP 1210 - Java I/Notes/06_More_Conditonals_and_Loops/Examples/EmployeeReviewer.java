import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

 /**
  * Generates a review of several employees from a file listing
  * employee's performances. The file must include each employee's
  * followed by 5 performance ratings.
  *
  * @author ______________
  * @version _____________
  */ 
public class EmployeeReviewer {

   /**
    * Generates a review of several employees from a file listing
    * employee's performances. The file must include each employee's
    * name followed by 5 performance ratings.
    * 
	 * @param args command line arguments (not used).
	 * @throws IOException if the file cannot be read.
    */       
   public static void main(String[] args) throws IOException {
   
      String fileName;
      Scanner fileScan;
      Scanner stdInScan = new Scanner(System.in);
      ArrayList<Review> allReviews = new ArrayList<Review>();
      
      do {
         System.out.print("Enter the file name to be processed: ");
         fileName = stdInScan.nextLine().trim();
      } while (fileName.equals(""));
   	
      fileScan = new Scanner(new File(fileName));
      
      while (fileScan.hasNext()) {
         // get first line (should be employee's name
         String line = fileScan.nextLine();
         Scanner lineScan = new Scanner(line);
         // read first and last name from line
         String first = lineScan.next();
         String last = lineScan.next();
      	
      	// create new employee
         Review emplReview = new Review(last, first);
         // add all 5 scores to review
         for (int i = 0; i < 5; i++) {
            emplReview.addScore(Integer.parseInt(fileScan.nextLine()));
         }
         
         allReviews.add(emplReview);
      }
      
      System.out.println("");
   	// print all reviews
      for (Review review : allReviews) {
         System.out.println(review);
      }
   }
}