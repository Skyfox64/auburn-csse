   /**
   *This exception will arise when an invalid category is scanned in.
	*
	* @author Nicholas DiChiara
	* @version 11/28/2012
   */
   
   
   public class InvalidCategoryException extends Exception {
   
   
   /**
   * Method InvalidCategoryException shows the category that is incorrect.
   * @param category specifies the category that is incorrect.
   */
      public InvalidCategoryException(String category) {
      
         super("For category: " + "\"" + category + "\"");
      
      }
   
   }