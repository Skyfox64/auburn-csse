  /**
   * This class will store student name, grades, 
   * and calculate final grade.
   *
   * @author Nick DiChiara
   * @version 9-17-2012
   */
   
   public class Grade {
   /**
   * Variables: exam1, exam2, finalExam, activityAvg,
   *					quizAvg, projectAvg, studentName.
   * Consructor
   * Methods
   * toString method (for String output)
   */
      private double exam1;
      private double exam2;
      private double finalExam;
      private double activityAvg;
      private double quizAvg;
      private double projectAvg;
      private String studentName;
      
   /**
   * Sets variables to determine exam type.
   */
      public static final int EXAM_1 = 0, EXAM_2 = 1, FINAL = 3; 
   /**
   * Sets variables to determine exam weight.
   */
      public static final double EXAM_WEIGHT = 0.15,
      								FINAL_WEIGHT = 0.30,
      								ACT_WEIGHT = 0.05,
      								QUIZ_WEIGHT = 0.10,
      								PROJ_WEIGHT = 0.25;
   
   
   /**
   * Default constructor.
   * @param nameIn specifies student's name.
   */
      public Grade(String nameIn) {
      
         studentName = nameIn;
            
      }
      
   /**
   * Method to set lab averages.
   * @param activityAvgIn specifies student's activity average.
   * @param quizAverageIn specifies student's quiz average.
   */
      public void setLabAverages(double activityAvgIn, double quizAverageIn) {
         
         activityAvg = activityAvgIn; 
         quizAvg = quizAverageIn;
      
      }
   
   
   /**
   * Method to set lab exam score.
   * @param examType specifies the exam type.
   * @param examScore specifies student's exam score.
   */
      public void setExamScore(int examType, double examScore) {
         if (examType == EXAM_1) {
            exam1 = examScore;
         }
         else if (examType == EXAM_2) {
            exam2 = examScore;
         }
         else if (examType == FINAL) {
            finalExam = examScore;
         }
      }
      
   /**
   * Method to set project averages.
   * @param average specifies student's project average.
   */	
      public void setProjectAverage(double average) {
      
         projectAvg = average;
      }
   	
   /**
   * Method to calculate grade based on averages.
   * @return grade specifies student's grade.
   */	
      public double calculateGrade() {
         double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
            				+ finalExam * FINAL_WEIGHT + activityAvg * ACT_WEIGHT
            				+ quizAvg * QUIZ_WEIGHT + projectAvg * PROJ_WEIGHT; 
         return grade;
      }
   	
   
   /**
   * Method to output student's grade.
   * @return specifies student's information.
   */			
      public String toString() {
         return "Name: " + studentName + "\r\n"
            	+ "Final Grade: " + calculateGrade();
      }
   }