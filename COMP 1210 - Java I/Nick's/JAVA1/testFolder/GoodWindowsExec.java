   import java.util.*;
   import java.io.*;
   class StreamGobbler extends Thread
   {
      InputStream is;
      String type;
    
      StreamGobbler(InputStream is, String type)
      {
         this.is = is;
         this.type = type;
      }
    
      public void run()
      {
         try
         {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null)
               System.out.println(type + ">" + line);    
         } 
            catch (IOException ioe)
            {
               ioe.printStackTrace();  
            }
      }
   }
   public class GoodWindowsExec
   {
      public static void main(String args[])
      {
         String file = "440.wav";
        
         try
         {            
            
                        
            Runtime rt = Runtime.getRuntime();
            System.out.println("Execing ");
            Process proc = rt.exec("./sox/sox ./sox/" + file + " ./sox/converted/440.ogg");
            // any error message?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");            
            
            // any output?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");
                
            // kick them off
            errorGobbler.start();
            outputGobbler.start();
                                    
            // any error???
            int exitVal = proc.waitFor();
            System.out.println("ExitValue: " + exitVal);        
         } 
            catch (Throwable t)
            {
               t.printStackTrace();
            }
      }
   }