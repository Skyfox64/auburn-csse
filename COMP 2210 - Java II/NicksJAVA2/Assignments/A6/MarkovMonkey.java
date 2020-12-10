import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

   /**
 * MarkovMonkey.java. Produces output text from an order K Markov model
 * of provided sample text.
 */
public class MarkovMonkey {
 
   public static void main(String[] args) {
      int k = 0;
      int length = 0;
      File source = null;
      File result = null;
   
      if (args.length == 4) {
         try {
            k = Integer.parseInt(args[0]);
            length = Integer.parseInt(args[1]);
            if(k <= 0 || length <= 0) throw new java.lang.NumberFormatException();
            source = new File(args[2]);
               
            Scanner kcheck = new Scanner(source);
            if(!kcheck.hasNext()) {
               System.err.println("Number of characters in " + args[2] + " is less than entered 'k' value: " + k);
               System.exit(1);
            }
            while(kcheck.hasNextLine())  {
               int chars = 0;
               String line = kcheck.nextLine();
               chars += line.length();
               if(chars > k) 
                  break;
               else{
                  System.err.println("Number of characters in " + args[2] + " is less than entered 'k' value: " + k);
                  System.exit(1);
               }
            }
            
            result = new File(args[3]);   
            if(!result.exists()) result.createNewFile();
            
            
            
            LanguageModeler lm = new LanguageModeler(k, source);
            String seed = lm.firstSeed();
            StringBuilder str = new StringBuilder(seed);
            FileWriter fw = new FileWriter(result);
            fw.write(str.toString());
         
            for(int i = 0; i < (length -k ); i++){
               char nextLet = lm.nextChar(seed);
               fw.write(nextLet);
               str.append(nextLet);
               seed = str.substring(i +1, seed.length() + i + 1);
            } 
            fw.close();
            
            
         } 
         catch (NumberFormatException e) {
            System.err.println("Arguments 'k' and 'length' must be positive integers.");
            System.exit(1);
         }
         catch (IOException e) {
            System.err.println("File was not found.");
            System.exit(1);
         }
      
      }
      else{
         System.err.println("Not enough command line arguments." +
            "\nNumber of arguments needed: 4" +
            "\nNumber of arguments found: " + args.length); 
         System.exit(1);   
      }
   
   }
}