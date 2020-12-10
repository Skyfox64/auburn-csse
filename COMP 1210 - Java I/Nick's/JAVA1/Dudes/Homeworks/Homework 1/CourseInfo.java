   /** 
    * Prints the course name, semester, and instructor of COMP 
	 * 1210 followed by a description of the course. 
	 *
	 * @author Lauren Goff
	 * @version 8-22-2011
    */
   public class CourseInfo{
   
      /*
       * Prints course information to std output.
       *
       * @param args Command line arguments (not used).
       */
      public static void main (String[] args) {
        
         // print name, semester, & instructor
         System.out.println
            ("Course Name: comp 1210") ;
         System.out.println
            ( "Semester: Fall 2011" );
         System.out.println("Instructor: Dr. Cross");
      
         // print description
         System.out.println("Descriptoin:comp 1210 uses the Java programming language to cover the basics of software development.");
      }
   }