/**
* 	This program utilizes the open source music conversion 
* 	software "Sox" to convert music to different filetypes.
*
* @author Nick DiChiara
* @version 08-23-2012
*
*/
   import java.io.*;
   
   public class soxConvert 
   {
   /**
   * Converts files.
   *
   * @param args Command line arguments (not used).
   */
   
   
      public static void main(String args[]) {
        
         String file = args[0]; //"440.wav"
         String out = args[1]; //"440.ogg"
      
         try {
            String line;
            System.out.println("Converting...");
            Process p = Runtime.getRuntime().exec("./sox/sox ./sox/uploaded/" + file + " ./sox/converted/" + out);
            p.waitFor();
            System.out.println("ExitCode = " + p.exitValue());
            
            if (p.exitValue() == 0) 
               System.out.println("Conversion Successful!");
            else if (p.exitValue() == 1) 
               System.out.println("Conversion Successful!");  
         }
            catch (Exception err) {
               err.printStackTrace();
            }
      }
   }