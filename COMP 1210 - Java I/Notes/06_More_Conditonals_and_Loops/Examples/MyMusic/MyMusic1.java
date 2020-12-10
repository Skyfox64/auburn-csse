
import java.awt.Desktop;
import java.io.File;

/**
 * Opens file in default browser.
 */
public class MyMusic1 { 
   /**
    * Launches default browser on the specified file.
    * @param args - not used.
    */
   public static void main(String[] args) {
   
      try {
      
         File f = new File("EltonJohn.mp3"); 
         //File f = new File("jeopardy.au");
         //File f = new File("westernBeat.wav");
         
         if (!f.exists()) {
            System.out.println("File does not exist.");
         }   
         else if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
         }
         else {
            Desktop d1 = Desktop.getDesktop();
            d1.open(f);
            System.out.println("Browser has been launched.");
         }         
      } 
      
      catch (Exception e) {
         System.out.println(e);
      }
   }
}