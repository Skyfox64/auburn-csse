import java.io.File;
import java.util.TreeSet;
import java.util.Iterator;

public class Dodgson2 {

  
   String lexicon;

/**
* Default constructor.
*/
   public Dodgson2() {
      lexicon = "words.txt"; 
   }

/**
* Constructor for specified lexicon.
*/   
   public Dodgson2(String fileIn) {
      lexicon = fileIn;
   }

/**
This method returns a String that contains a 
minimum Dodgson sequence from start to end.
*/
   public String getSequence(String start, String end){
      String sequence = "";
      Lex l = new Lex(); 
      l.open(new File(lexicon));
         
      TreeSet<String> t = l.w[start.length()];
      
      char[] chart = start.toCharArray();
      char[] chend = end.toCharArray();
      
                  
         
         
      TreeSet<String> o = new TreeSet<String>();
      
      Iterator iter = t.iterator();
      while (iter.hasNext()){ 
         String word = (String)iter.next();
         char[] chword = word.toCharArray();
      
         int degSim = 0;
         for(int i=0; i < chart.length; i++)
            if (chart[i] == chword[i]) degSim++;
            
         if(degSim == start.length() - 1)
            o.add(word);     
      }
   
   
   
   
   
   
   
        //new tree as in before generating the amount by how many deg-1 words there are. 
      TreeSet[] p = new TreeSet[o.size()];
      
      
      //CANT USE TREE BECAUSE IT IS BINARY
      
      //if it is degsim-1 and increasing sim to end by one continue. 
      //then find shortest tree and iterate through from root to leaf and print
      
      //for(int j = 0; j < w.length; j++)
         //w[j] = new TreeSet<String>();     maybe use this to add, but most likely drop the top and use below oter
      
      //consider adding a method that checks for degsim
      
        
       
      Iterator oter = o.iterator();
      while (oter.hasNext())
         sequence += ( oter.next() + ", " );
         
         
         
         
         //fix this o below with whatever the smallest tree has
      Iterator ster = o.iterator();
      while (ster.hasNext())
         sequence += ( ster.next() + ", " );    
      
      return sequence;
   }   
}