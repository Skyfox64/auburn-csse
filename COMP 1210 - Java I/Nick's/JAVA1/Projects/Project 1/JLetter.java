   /**
    * This program prints a large "J" made up of the word "JAVA".
	 *
	 * @author Nick DiChiara
	 * @version 08-21-2012
    */
   public class JLetter
   {
      /**
       * Prints a large "J" made up of the word "JAVA" to std output.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) 
      {
         // Prints a large "J".
         System.out.println("JAVAJAVAJAVA\r" 
            				  + "JAVAJAVAJAVA\r"
            				  + "      JAVA\r"
            				  + "      JAVA\r"
            				  + "      JAVA\r"
            				  + "      JAVA\r"						  
            				  + "J     JAVA\r"      						  
            				  + "JA    JAVA\r"      						  
            				  + " JAVAJAVA\r"
            				  + "  JAVAJA\r");
      }
   }