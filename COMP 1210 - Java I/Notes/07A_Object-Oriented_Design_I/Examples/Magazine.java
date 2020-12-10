
/**
 * Represents a magazine with a title & # of pages. A count 
 * of the number of magazine objects created is maintained.
 */
public class Magazine
{
   public String title = new String("none");
   private int pages = 0;
   private static int count = 0; 
/**
 * Constructor sets title and pages; increments count.
 */
   public Magazine(String theTitle, int thePages) 
   {
      title = theTitle;
      pages = thePages;
      count++;  
   }
   
   public static int getCount()
   {
      return count; 
   }
   
   public static void resetCount() {
      count = 0;
   }

   public String toString ()
   {
      return ("\r\nTitle: " + title + "\r\nPages: " 
         + pages + " \r\nCount: " + count);
   }
}
