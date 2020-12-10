import java.text.DecimalFormat;

/**
* This class will store the student's name, number, times,
* and make calculations based off of that information.
*
* @author John Carroll
* @version 10-31-2013
*/
public class WeightedGrades2
{   
   /**
   * Fields.
   *============================================================*
   * Variables: studentName represents the student's name
   *            numGrades represents the number of grades
   *            grades represents the actual grades in a String array
   */
   private String studentName = "";
   private int numGrades = 0;
   private String[] grades;
   
   /**Static variable wgCount keeps track of the number of instances.**/
   private static int wgCount = 0;
   
   /**CONSTANTS: ACTV_WT, QUIZ_WT, PROJ_WT, EXAM_WT, FINAL_EXAM_WT**/
   /**Constant for Activities' weight.*/
   private static final double ACTV_WT = 0.05;
   /**Constant for Quizzes' weight.*/
   private static final double QUIZ_WT = 0.10;
   /**Constant for Projects' weight.*/
   private static final double PROJ_WT = 0.25;
   /**Constant for Exams' weight.*/
   private static final double EXAM_WT = 0.30;
   /**Constant for the Final's weight.*/
   private static final double FINAL_EXAM_WT = 0.30;

   
   /** 
   * Consructor: WeightedGrades2.
   *============================================================*
   * @param studentNameIn specifies student's name.
   * @param numGradesIn specifies number of grades.
   * @param gradesIn specifies the grades recorded.
   */	
   public WeightedGrades2(String studentNameIn, int numGradesIn, 
      String ... gradesIn) {
      
      studentName = studentNameIn;
      numGrades = numGradesIn;
      grades = gradesIn;
      
      wgCount++;
   }
   
   /**
   * Methods.
   *============================================================*
   *          getName, getNumGrades, getGrades, getWeightedGradesCount,
   *          resetWeightedGradesCount, gradesByCategory, addGrade, 
   *          deleteGrade, deleteLowestGrade, increaseGradeCapacity,
   * 			  average, courseAvg, computeMedianGrade
   *
   * toString method (for String output)
   *   
   */
   
   /**
      * Method used to get name.
   * @return studentName specfies student's name.
   */
   public String getName()
   {
      return studentName;
   }

   /**
   * Method used to get number of grades.
   * @return numGrades specifies the number of grades.
   */
   public int getNumGrades()
   {
      return numGrades;
   }

   /**
   * Method used to get the actual grades.
   * @return grades specifies the actual grades.
   */
   public String[] getGrades()
   {
      return grades;
   }
   
   /**
   * Method used to get the count of wgCount.
   *@return wgCount specifies the count for wgCount.
   */
   public static int getWeightedGradesCount()
   {
      return wgCount;
   }
   
   /**
   * Method used to reset the count for wgCount.
   * Method resets the wgCount to 0.
   */
   public static void resetWeightedGradesCount()
   {
      wgCount = 0;
   }
   
   /**
   * Method used to get the grades by category.
   * @param categoryIn specifies a user-defined category.
   * @return categoryGrades gives the grades in that category.
   */
   public double[] gradesByCategory(char categoryIn)
   {
      int numOfGrades = 0;
      for (int i = 0; i < grades.length; i++) {
         if (grades[i].charAt(0) == categoryIn) {
            numOfGrades++;
         }
      }
      double[] categoryGrades = new double[numOfGrades];
      int count = 0;
      for (int i = 0; i < grades.length; i++) {
         if (grades[i].charAt(0) == categoryIn) {
            categoryGrades[count] = Double.parseDouble(grades[i].substring(1));
            count++;
         }      
      }      
      return categoryGrades; 
   }

   /**
   * Method used to output the student's information.
	* @return output specifies student's information.
	*/
   public String toString()
   {
   
      DecimalFormat twoDecimal = new DecimalFormat("#,##0.00");
   
      String output = "";
      output += "\tStudent Name: " + studentName; 
      
      output += "\n\tActivities: ";
      double[] aGrades = gradesByCategory('a');
      for (int i = 0; i < aGrades.length; i++) {
         output += aGrades[i] + " ";
      }
     
      output += "\n\tQuizzes: ";
      double[] qGrades = gradesByCategory('q');
      for (int i = 0; i < qGrades.length; i++) {
         output += qGrades[i] + " ";
      }
      
      output += "\n\tProjects: ";
      double[] pGrades = gradesByCategory('p');
      for (int i = 0; i < pGrades.length; i++) {
         output += pGrades[i] + " ";
      }
         
      output += "\n\tExams: ";
      double[] eGrades = gradesByCategory('e');
      for (int i = 0; i < eGrades.length; i++) {
         output += eGrades[i] + " ";
      }
         
      output += "\n\tFinal Exam: ";
      double[] fGrades = gradesByCategory('f');
      for (int i = 0; i < fGrades.length; i++) {
         output += fGrades[i] + " ";
      }
       
      output += "\n\tCourse Average: " + twoDecimal.format(courseAvg()) + "\n";
      
      return output;
   }
   
   /**
   * Method used to add a grade.
	* @param newGradeIn specifies grade to be added.
	*/
   public void addGrade(String newGradeIn)
   {
      if (numGrades == grades.length) {
         increaseGradesCapacity();
      }
      grades[numGrades] = newGradeIn;
      numGrades++;
   }
   
   /**
   * Method used to delete a grade.
	* @param deleteGradeIn specifies the grade to be deleted.
   * @return result specifies true or false
	*/
   public boolean deleteGrade(String deleteGradeIn) {
      boolean result = false;
      for (int i = 0; i < numGrades; i++) {
      
         if (grades[i].equals(deleteGradeIn)) {
            result = true;
            grades[i] = " ";
            
            for (int j = i; j < numGrades - 1; j++) {
               grades[j] = grades[j + 1];
            }
            grades[numGrades - 1] = " ";
            break;
         }
      }
      numGrades--;
   
      return result;
   }
   
         
   /**
   * Method used to delete the lowest grade in a category.
   * @param categoryIn is the user-defined category.
   * @return true if the category has a grade to delete.
   * returns false if the category does not have a grade to delete.
   */
   public boolean deleteLowestGrade(char categoryIn) {
      boolean result = false;
      
      int num;
      double min = Double.parseDouble(grades[0].substring(1));
      int j = 0;
      
      for (num = 0; num < numGrades; num++) {
         double gradesIn = Double.parseDouble(grades[num].substring(1));
         
         if (gradesIn < min) {
         
            min = gradesIn;
            j = num;
         }
      }
      
      result = deleteGrade(grades[j]);
      
      return result;
   }
   
   
   
   /**
   * Method used to increase the size of the array 'grades'.
	*/
   public void increaseGradesCapacity()
   {
      String[] newGrades = new String[numGrades + 1];
      for (int i = 0; i < numGrades; i++)
      {
         newGrades[i] = grades[i];
      }
      grades = newGrades;
   }
   
   /**
   * Method used to compute the average grade in array 'grades'.
   * @param gradesIn specifies the grade in question.
	* @return avg specifies the average.
	*/
   public double average(double[] gradesIn)
   {
      int i = 0;
      double total = 0;
      double avg = 0.0;
      if (gradesIn.length != 0) {
         while (i < gradesIn.length)
         {
            total += gradesIn[i];
            i++;
         }
         avg = total / gradesIn.length;
      }
      return avg;
   }
   
   /**
   * Method used to compute the average grade in category of the array 'grades'.
	* @return avg specifies the course average.
	*/
   public double courseAvg()
   {
      double result = 0.0;
      if (numGrades != 0)
      {
         double actvAvg = average(gradesByCategory('a'));
         double quizAvg = average(gradesByCategory('q'));
         double projAvg = average(gradesByCategory('p'));
         double examAvg = average(gradesByCategory('e'));
         double finalAvg = average(gradesByCategory('f'));
         result = ((actvAvg * ACTV_WT) + (quizAvg * QUIZ_WT) 
            + (projAvg * PROJ_WT) + (examAvg * EXAM_WT) 
            + (finalAvg * FINAL_EXAM_WT));
      }
      return result;
   }
   
   /**
   *Method used to compute the median grade of a category.
   *@param categoryIn is the category.
   *@return median specifies the median of the category.
   */
   public double computeMedianGrade(char categoryIn)
   {
   
      double[] categoryGrades = gradesByCategory(categoryIn);
      double median = 0.0;
      if (categoryGrades.length != 0)
      {
         java.util.Arrays.sort(categoryGrades);
         if (categoryGrades.length % 2 == 0)
         {
            int i = categoryGrades.length / 2;
            int j = i - 1;
            median = (categoryGrades[i] + categoryGrades[j]) / 2;
         }
         else
         {
            median = categoryGrades[categoryGrades.length / 2];
         }
      }
      return median;
   }
}