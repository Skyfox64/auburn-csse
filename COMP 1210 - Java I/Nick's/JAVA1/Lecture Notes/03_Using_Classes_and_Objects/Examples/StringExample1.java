/**
 * Illustrates declaration and intialization of 
 * String variables and invoking of String methods.
 */
   public class StringExample1
   {
   /**
   * Declares and intializes String variables then
   * invokes several common methods.  Set breakpoint 
   * open viewers on variables to examine.
   *
   * @param args Command-line arguments (unused). 
   */
      public static void main(String[] args)
      {	
         String courseNo;
         courseNo = "COMP1210";
         String courseName = "Intro to Computing I";
         System.out.println(courseNo + " " + courseName);
      
         String course = courseNo + " " + courseName;
         int count = course.length();
      
         String courseChg1 = course.toUpperCase();
         String courseChg2 = course.toLowerCase();
         String courseChg3 = course.replace('o', 'x');
         String courseChg4 = courseChg2.replace('o', 'O');
         String courseChg5 = course.substring(2, 10);
         System.out.println("course: \"" + course + "\"");
         System.out.println("Length of string: " + count);
       
        // Print each change
         System.out.println("courseChg1: " + courseChg1);
         System.out.println("courseChg2: " + courseChg2);
         System.out.println("courseChg3: " + courseChg3);
         System.out.println("courseChg4: " + courseChg4);
         System.out.println("courseChg5: " + courseChg5);
      }
   }
