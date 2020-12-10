import java.io.*;
import java.util.*;

/**
 * Creates an order K Markov model for a text sample.
 *
 */
public class LanguageModeler {
   private int k = 0;
   private char[] source;
   private Hashtable<String, char[]> ht = new Hashtable();

   public LanguageModeler(int K, File text) {
      try{
         k = K;
         String filecontent = new Scanner(text).useDelimiter("\\Z").next();
         source = filecontent.toCharArray();
         gen();
      }
      catch (IOException e) {
         System.err.println("File not found. Please Try Again.");
         System.exit(1);
      }
   
   }
   
   
   public LanguageModeler(int K, String text) {
      k = K;   
      source = text.toCharArray();
      gen();
   }
   
   
   private void gen(){
      for(int i = 0; i < source.length - (k + 1); i++){
         String key = "";
         for(int j = 0; j < k; j++){
            key += source[i + j];
         }
         if(!ht.containsKey(key)){
            String nextletters = "";
            char[] keychar = key.toCharArray();
                              
            for(int l = 0; l <= (source.length - (k + 1)); l++){
               for(int m = 0; m < keychar.length; m++){
                  if(keychar[m] != source[l + m]){
                     break;
                  }
                  if(m == keychar.length - 1){
                     nextletters += source[l + keychar.length];
                  }
               }  
            }
         
            char[] nexts = nextletters.toCharArray();
            ht.put(key, nexts); 
         }
      }
   }
   
    
   public String firstSeed() {
      String fseed = "";
      for(int i = 0; i < k; i++){
         fseed += source[i];
      }
      return fseed;
      
   }
   
   
   public String randomSeed() {
      String randoseed = "";
      Random rand = new Random();
      int  r = rand.nextInt(source.length - k);
      for(int i = 0; i < k; i++){
         randoseed += source[r + i];
      }
      return randoseed;       
   }
   
   
   public char nextChar(String seed) {
      char[] nexts = ht.get(seed);
      Random rand = new Random();
      try{
         int  n = rand.nextInt(nexts.length);
         return nexts[n];
      }
      catch(NullPointerException e){
         nextChar(randomSeed());
      }
   
      return '#';
   }
 
}