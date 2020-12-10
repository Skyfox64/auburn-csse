import java.text.DecimalFormat;
/**
 * This class creates weighted grades names and grades
 * array for WeightedGradesApp.
 *
 *@author Garrett Knecht
 *@version 10-21-2013
 */
public class WeightedGrades2
{

/**
 * Creates string name.
 */
   private String name = "";
   
 /**
  * Creates int numGrades.
  */
   private int numGrades = 0;
   
 /**
  * Creates string array grades.
  */
   private String[] grades;
   /**
    * Creates int count.
    */
   private static int count = 0;
   
 /**
  * Creates static double activity average.
  */
   private static final double ACTV_WT = 0.05;
 
 /**
  * Creates static doyble quiz average.
  */
   private static final double QUIZ_WT = 0.10;
 
 /**
  * Creates static double project weight.
  */
   private static final double PROJ_WT = 0.25;
   
 /**
  * Creates static double exam weight.
  */
   private static final double EXAM_WT = 0.30;
   
 /**
  * Creates static double final exam weight.
  */
   private static final double FINAL_EXAM_WT = 0.30;

/**
 * Creates WeightedGrades class with string name
 * int numGrades and array grades.
 *@param nameIn pulls name
 *@param numGradesIn pulls numGrades
 *@param gradesIn pulls array grades.
 */
   public WeightedGrades2(String nameIn, int numGradesIn, 
      String...gradesIn) 
   {
      name = nameIn;
      numGrades = numGradesIn;
      grades = gradesIn;
      
      count++;
   }

/**
 * Creates string getName.
 *@return name returns name.
 */
   public String getName()
   {
   
      return name;
   }

/**
 * Creates getNumGradesIn.
 *@return returns numGrades
 */
   public int getNumGrades()
   {
   
      return numGrades;
   }

/**
 * Creates string array getGrades.
 *@return grades returns array grades.
 */
   public String[] getGrades()
   {
   
      return grades;
   }
   
   /**
    * Creates weightedGradesCount.
    *@return returns count
    */
   public static int getWeightedGradesCount()
   {
      return count;
   }
   
   /**
    * Creates resetWeightedGradesCount.
    */
   public static void resetWeightedGradesCount()
   {
      count = 0;
   }

/**
 * Creates double array gradesByCategory.
 *@param categoryIn char categoryIn
 *@return category returns category.
 */
   public double[] gradesByCategory(char categoryIn)
   {
   
      int j = 0;
      
      for (int i = 0; i < grades.length; i++) 
      {
         if (grades[i].charAt(0) == categoryIn) 
         {
            j++;
         }
      }
      
      double[] category = new double[j];
      j = 0;
      
      for (int i = 0; i < grades.length; i++) 
      {
         if (grades[i].charAt(0) == categoryIn) 
         {
            category[j] = Double.parseDouble(grades[i].substring(1));
            j++;
         }      
      } 
           
      return category; 
   }


/**
 * creates void addGrade class.
 *@param gradeIn string for new grades
 */
   public void addGrade(String gradeIn) 
   {
      
      if (numGrades == grades.length)
      {
         increaseGradesCapacity();
      }
      grades[numGrades] = gradeIn;
      numGrades++;
   }
     
/**
 * creates boolean deleteGrade.
 *@param deleteGradeIn deletes selected grade.
 *@return deleted returns deleted from deleted grades.
 */
   public boolean deleteGrade(String deleteGradeIn)
   {
      boolean deleted = false;
      
      for (int i = 0; i < numGrades; i++) 
      {   
      
         if (grades[i].equals(deleteGradeIn)) 
         {
            deleted = true;
           
            
            for (int j = i; j < numGrades - 1; j++) 
            {
               grades[j] = grades[j + 1];
            }
            grades[numGrades - 1] = " ";
            break;
         }
         
        
      }
      
      
      numGrades--;
      return deleted;
   }
   
   /**
    *Creates deleteLowestGrade boolean.
    *@param deleteLowestGradeIn char
    *@return returnsDeleteLowest
    */
   public boolean deleteLowestGrade(char deleteLowestGradeIn)
   {
      boolean deleteLowest = false;
      
      int num;
      double min = Double.parseDouble(grades[0].substring(1));
      int j = 0;
      
      for (num = 0; num < grades.length; num++)
      {
         double gradesIn = Double.parseDouble(grades[num].substring(1));
         
         if (gradesIn < min)
         {
            min = gradesIn;
            j = num;
         }
      }
      
      deleteLowest = deleteGrade(grades[j]);
      
      return deleteLowest;
   }

/**
 * creates void increaseGradesCapacity.
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
 * creates double array average.
 *@param gradesIn takes gradesIn.
 *@return average returns average of all grades.
 */  
   public double average(double[] gradesIn)
   {
      int i = 0;
      double total = 0;
      double average = 0;
      
      while (i < gradesIn.length)
      {
         total += gradesIn[i];
         i++;
      }
      
      average = total / gradesIn.length;
      
      return average;
   }

/**
 * creates double courseAvg.
 *@return deleted returns course average.
 */  
   public double courseAvg()
   {
      double courseAvg = 0.0;
      double activityAvg = average(gradesByCategory('a'));
      double quizAvg = average(gradesByCategory('q'));
      double projectAvg = average(gradesByCategory('p'));
      double examAvg = average(gradesByCategory('e'));
      double finalAvg = average(gradesByCategory('f'));
      
      if (grades.length > 0)
      {
         courseAvg = ((activityAvg * ACTV_WT) + (quizAvg * QUIZ_WT) 
            + (projectAvg * PROJ_WT) + (examAvg * EXAM_WT) 
            + (finalAvg * FINAL_EXAM_WT));
         return courseAvg;
      }
      else
      {
         return  courseAvg;
      }
   }
   
   /**
    * Creates double computeMedianGrade.
    *@param categoryIn char
    *@return median
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
   
   
   
/**
 * creates string toString of name and grades.
 *@return list returns list of all string information
 */
   public String toString()
   {
      double[] catA = gradesByCategory('a');
      double[] catQ = gradesByCategory('q');
      double[] catP = gradesByCategory('p');
      double[] catE = gradesByCategory('e');
      double[] catF = gradesByCategory('f');
      String list = "";
      list += "\tStudent Name: " + name + "\n\tActivities: ";
      
      for (int i = 0; i < catA.length; i++) 
      {
         list += catA[i] + " ";
      }
     
      list += "\n\tQuizzes: ";
      for (int i = 0; i < catQ.length; i++) 
      {
         list += catQ[i] + " ";
      }
      
      list += "\n\tProjects: ";
      for (int i = 0; i < catP.length; i++) 
      {
         list += catP[i] + " ";
      }
         
      list += "\n\tExams: ";
      for (int i = 0; i < catE.length; i++) 
      {
         list += catE[i] + " ";
      }
        
      list += "\n\tFinal Exam: ";
      for (int i = 0; i < catF.length; i++) 
      {
         list += catF[i] + " ";
      }
       
      DecimalFormat averageFormat = new DecimalFormat("#,##0.00");
      
      list += "\n\tCourse Average: " + averageFormat.format(courseAvg()) + "\n";
      
      return list;
   }
}