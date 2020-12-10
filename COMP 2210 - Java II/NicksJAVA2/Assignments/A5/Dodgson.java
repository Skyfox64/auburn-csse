import java.io.File;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Stack;

public class Dodgson {

   Lex l;
   TreeSet<String> w;
   TreeSet<String> e;
   TreeSet<String> x;
   Stack stack = new Stack();
   
       

/**
* Default constructor.
*/
   public Dodgson() {
      this("words.txt");
   }

/**
* Constructor for specified lexicon.
*/   
   public Dodgson(String lexicon) {
      l = new Lex(); 
      l.open(new File(lexicon));
   }

/**
This method returns a String that contains a 
minimum Dodgson sequence from start to end.
*/
   public String getSequence(String start, String end){
      
      
      stack = new Stack();
      String sequence = start + ", ";
      stack.push(new String(start + ", "));
         
      w = l.w[start.length()];
      
      TreeSet n = oneSimTreeGen(start);
      e = oneSimTreeGen(end);
      
      if(n.contains(end)){
         sequence += end;
         return sequence;}
      
      else{
         //return finder(n) + end; //from the bottom/original finder
         finder(n);
         stack.push(end);
         return sequence + stack;
      }     
         
   }   
   
   
   
   
   
   public TreeSet<String> oneSimTreeGen(String word){
   
      char[] chart = word.toCharArray();
      TreeSet<String> o = new TreeSet<String>();
      
      Iterator iter = w.iterator();
      while (iter.hasNext()){ 
         String nextWord = (String)iter.next();
         char[] chword = nextWord.toCharArray();
      
         int degSim = 0;
         for(int i=0; i < chart.length; i++)
            if (chart[i] == chword[i]) degSim++;
            
         if(degSim == word.length() - 1)
            o.add(nextWord);     
      }
   
      return o;
   
   }
   
  

   
   
   
   
   public String finder(TreeSet n){
   
      Iterator nextWord = n.iterator();
      while (nextWord.hasNext()){
         String word = (String)nextWord.next();
         TreeSet nn = oneSimTreeGen(word);
         
         
         Iterator eter = e.iterator();
         while (eter.hasNext()){
            if (nn.contains(eter.next())){
               return eter.next() + ", ";
            }
         }
         
      }
   
   
      return  ", "; 
   }
   
   
}