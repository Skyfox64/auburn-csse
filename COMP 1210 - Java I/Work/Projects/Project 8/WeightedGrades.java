import java.text.DecimalFormat;
/**
* This class will store the student's name, number, times,
* and make calculations based off of that information.
*
* @author John Carroll
* @version 10-21-2013
*/
public class WeightedGrades
{
   /**
   * Variables: studentName, numGrades, grades.
   * CONSTANTS: ACTV_WT, QUIZ_WT, PROJ_WT, EXAM_WT, FINAL_EXAM_WT
   * Consructor: WeightedGrades
   * Methods: getName, getNumGrades, getGrades, gradesByCategory,
   *          addGrade, deleteGrade, increaseGradeCapacity,
   * 			  average, courseAvg
   * toString method (for String output)
   */
   private String studentName = "";
   private int numGrades = 0;
   private String[] grades;
   
   
   private static final double ACTV_WT = 0.05;
   private static final double QUIZ_WT = 0.10;
   private static final double PROJ_WT = 0.25;
   private static final double EXAM_WT = 0.30;
   private static final double FINAL_EXAM_WT = 0.30;

   /**
   * Default constructor.
   * @param studentNameIn specifies student's name.
   * @param numGradesIn specifies number of grades.
   * @param gradesIn specifies the grades recorded.
   */	
   public WeightedGrades(String studentNameIn, int numGradesIn, 
      String[] gradesIn) {
      studentName = studentNameIn;
      numGrades = numGradesIn;
      grades = gradesIn;
   }
   
   /**
   * getName.
   * @return studentName
   */
   public String getName()
   {
      return studentName;
   }

   /**
   * getNumGrades.
   * @return numGrades;
   */
   public int getNumGrades()
   {
      return numGrades;
   }

   /**
   * getGrades.
   * @return grades
   */
   public String[] getGrades()
   {
      return grades;
   }

   /**
   * gradesByCategory.
   * @param categoryIn specifies user-inquiry
   * @return categoryGrades gives the grades in that cat.
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
   * toString.
 	* Method to output the student's information.
	* @return output specifies student's information.
	*/
   public String toString()
   {
   
      DecimalFormat twoDecimal = new DecimalFormat("#,##0.0#");
   
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
   * addGrade.
	* Method to add a grade.
	* @param newGradeIn specifies grade to be added.
	*/
   public void addGrade(String newGradeIn)
   {
      if (numGrades == grades.length)
      {
         increaseGradesCapacity();
      }
      grades[numGrades] = newGradeIn;
      numGrades++;
   }
   
   /**
   * deleteGrade.
	* Method to delete a grade.
	* @param deleteGradeIn specifies the grade to be deleted.
   * @return result specifies true or false
	*/
   public boolean deleteGrade(String deleteGradeIn)
   {
   
      boolean result = false;
      for (int i = 0; i < grades.length; i++) {
      
         if (grades[i].equals(deleteGradeIn)) {
            result = true;
            grades[i] = " ";
            
            numGrades--;
            for (int j = i; j < numGrades; j++) {
               grades[i] = grades[i + 1];
               grades[i + 1] = " ";
               i++;
            }
         }
         else {
            continue;
         }
      }
      return result;
   }
   
   /**
   * increaseGradeCapacity.
	* Method to increase the size of the array 'grades'.
	*/
   public void increaseGradesCapacity()
   {
      String[] newGrades = new String[grades.length + 1];
      for (int i = 0; i < grades.length; i++)
      {
         newGrades[i] = grades[i];
      }
      grades = newGrades;
   }
   
   /**
   * average.
	* Method to compute the average grade in array 'grades'.
   * @param gradesIn specifies the grade in question.
	* @return avg is the average grade.
	*/
   public double average(double[] gradesIn)
   {
      int i = 0;
      double total = 0;
      double avg = 0;
      while (i < gradesIn.length)
      {
         total += gradesIn[i];
         i++;
      }
      avg = total / gradesIn.length;
      return avg;
   }
   
   /**
   * courseAvg.
	* Method to compute the average grade in category of the
   * array 'grades'.
	* @return avg is the average grade.
	*/
   public double courseAvg()
   {
      double result = 0.0;
      
      double actvAvg = average(gradesByCategory('a'));
      double quizAvg = average(gradesByCategory('q'));
      double projAvg = average(gradesByCategory('p'));
      double examAvg = average(gradesByCategory('e'));
      double finalAvg = average(gradesByCategory('f'));
      
         
      if (numGrades == 0) {
         result = 0.0;
      }
      else {
         result = actvAvg * ACTV_WT + quizAvg * QUIZ_WT;
         result += projAvg * PROJ_WT + examAvg * EXAM_WT;
         result += finalAvg * FINAL_EXAM_WT;
      }
      return result;
   }
}