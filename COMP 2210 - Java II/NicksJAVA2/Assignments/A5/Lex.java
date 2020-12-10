import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.TreeSet;

public class Lex implements Lexicon {

   Scanner fileScan = null;
   public TreeSet[] w = new TreeSet[25];
   public TreeSet ww = new TreeSet();
   
   
   public Lex(){
   
   
   
   }
   
   

/**
 * Associates the lexicon with the words contained
 * in fileName.
 *
 * @param filename	the file containing strings
 * 						to be included in the lexicon
 */
   public void open(File filename){
      try{
         
         for(int i = 0; i < w.length; i++)
            w[i] = new TreeSet<String>();
         
         Scanner fileScan = new Scanner(filename);
         
         
         
         //This just needs to be modified to hasNextLine and 
         //a word is defined by the letters before the first " " which is the regex
         
         while (fileScan.hasNextLine()) {
            String word = fileScan.nextLine();
            ww.add(word.toLowerCase());
            w[word.length()].add(word.toLowerCase());
         }
         
         
         
         
         
                                            
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
   }


/**
 * Closes the currently open lexicon. 
 *
 */
   public void close() {
      fileScan.close();
   }


/**
 * Determines if str is a word.
 *
 * @param str	the string to be validated as a word
 * @return		true is str is in the lexicon, false
 *					otherwise
 */   
   public boolean isWord(String str){
   
      for (int i=0; i<w.length; i++){
         if (w[i].contains(str.toLowerCase())) 
            return true;  
      }
      return false;
   }
   
/**
 * Determines if str begins any word.
 *
 * @param str	the string to be validated as a word
 *					prefix
 * @return		true is str begins any word in the
 *					lexicon, false otherwise
 */   
   public boolean isPrefix(String str){
   
      boolean prefix = false;
      do{
         for (int i=0; i<w.length; i++){
            Iterator iter = w[i].iterator();
            while (iter.hasNext()){
               String word = (String)iter.next();
               prefix = word.startsWith(str);
            }
         }
      
      }while(!prefix);
      return prefix;
   }
   
   /**
 * Instantiates and returns an iterator on this
 * lexicon.
 *
 * @return 	an iterator object for this lexicon
 */	
   public Iterator iterator(){
      return ww.iterator();
   }






}