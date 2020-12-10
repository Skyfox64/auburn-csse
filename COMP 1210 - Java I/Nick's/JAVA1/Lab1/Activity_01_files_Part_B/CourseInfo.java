   /**
    * Prints the course name, semester, and instructor of COMP 
	 * 1210 followed by a description of the course. 
	 *
	 * @author Nick DiChiara
	 * @version 08-21-2012
    */
   public class CourseInfo
   {
      /**
       * Prints course information to std output.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) 
      {
       
         // print name, semester, & instructor
         System.out.println("Course Name: COMP 1210");
         System.out.println("Semester: Fall 2012");
         System.out.println("Instructor: Dr. Cross\n");
      
         // print description
         System.out.println("Description:"); 
         System.out.println("COMP 1210 uses the Java programming language " 
            				  + "to cover the basics of software development.");
      }
   }