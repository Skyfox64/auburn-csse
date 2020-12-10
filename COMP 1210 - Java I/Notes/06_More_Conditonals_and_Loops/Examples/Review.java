import java.util.ArrayList;

 /**
  * Represents the review of an employee based on their performance.
  * Scores representing poor, decent, average, great, and superb can
  * be added. The average of all scores can be calculated and the 
  * employee can be compared to another employee to determine who has
  * the better score.
  *
  * @author ______________
  * @version _____________
  */   
public class Review {

   private String name;
   private ArrayList<Integer> scores;
   
	/** Represents the worst score possible. */
   public static final int POOR = 0; 
   /** Represents a below-average score. */
   public static final int DECENT = 1; 
   /** Represents an average score. */
   public static final int AVERAGE = 2; 
   /** Represents an above-average score. */
   public static final int GREAT = 3; 
   /** Represents the best score possible score. */
   public static final int SUPERB = 4;
   
	 /** Initializes a new employee review given a first and last name.
	  *  Their score will be 0 until scores are added.
	  *
	  * @param lastName The last name of the employee.
	  * @param firstName The first name of the employee.
	  */
   public Review(String lastName, String firstName) {
      name = lastName + ", " + firstName;
      scores = new ArrayList<Integer>();
   }
   
	 /** Adds a score to the employee's record if the score is
	  *  one of the valid scoring options.
	  *
	  * @param scoreIn The last name of the employee.
	  * @return returns true if the score is one of the valid options.
	  */
   public boolean addScore(int scoreIn) {
      if (scoreIn == POOR || scoreIn == DECENT || scoreIn == AVERAGE 
      || scoreIn == GREAT || scoreIn == SUPERB) {
         scores.add(scoreIn);
         return true;
      }
      return false;
   }
   
	 /** Calculates the average of the employee's score.
	  *
	  * @return the average of the employee's score.
	  */
   public double calculateAverage() {
      return (double) sumScores() / scores.size();
   }
   
   private int sumScores() {
      int sum = 0;
      for (Integer numScore : scores) {
         sum += numScore;
      }
      return sum;
   }
   
	 /** Returns true if this employee is better than the average
	  *  rating based on the average of all of their scores.
	  *
	  * @return true if the employee's average score is 
	  *     based on the average rating.
	  */
   public boolean isAboveAverage() {
      return calculateAverage() >= AVERAGE;
   }
   
	 /** Returns true if this employee is better than another
	  *  based on average score. 
	  *
	  * @param otherPerson the other employee with which this 
	  *    employee will be compared.
	  * @return true if this employee is better than another.
	  */  
   public boolean isBetterThan(Review otherPerson) {
      return this.calculateAverage() > otherPerson.calculateAverage();
   }
   
	
	 /** Returns a string representation of the employee's performance.
	  *
	  * @return employee's overall performance.
	  */  
   public String overallPerformance() {
   
      switch ((int) Math.round(calculateAverage())) {
         case POOR:
            return "Poor";
         case DECENT:
            return "Decent";
         case AVERAGE:
            return "Average";
         case GREAT:
            return "Great";
         case SUPERB:
            return "Superb";
         default:
            return "Unknown";
      }
   }
   
	 /** Returns a string representation of the employee including their 
	  *  name and their overall performance.
	  *
	  * @return representation of the employee's performance.
	  */  
   public String toString() {
      return name + ": " + overallPerformance();
   }
}