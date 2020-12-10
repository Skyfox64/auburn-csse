/*
 * Output:
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class MyMusic2 {
   public static void main(String[] args) {
      try {
         //URL url = new URL("file:EltonJohn.mp3" );
         URL url = new URL("file", "localhost", "jeopardy.au");
         //URL url = new URL("file", "localhost", "EltonJohn.mpg");
         AudioClip ac = Applet.newAudioClip(url);
         ac.play();
      
         System.out.println("Press ENTER key to exit.");
         System.in.read();
         ac.stop();
      } 
      catch (Exception e) {
         System.out.println(e);
      }
   }
}