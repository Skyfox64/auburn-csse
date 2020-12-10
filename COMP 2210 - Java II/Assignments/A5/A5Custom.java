import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Driver for the Dodgson sequence.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2014-04-08
 *
 */
public final class A5Custom {

   public static void main(String[] args) {
      ArrayList<WordPair> pairList = new ArrayList<WordPair>();
      pairList.add(new WordPair("cat", "hat")); //
      pairList.add(new WordPair("cat", "dog")); //
      pairList.add(new WordPair("cat", "red"));
      pairList.add(new WordPair("hot", "dog"));
      pairList.add(new WordPair("cog", "war"));
      pairList.add(new WordPair("bird", "fish")); 
      
      System.out.println("\n*********************************************************");
      // WordLists.jar must be on the CLASSPATH
      InputStream wordlist = A5.class.getResourceAsStream("sowpods.txt");
      Dodgson lewis = new Dodgson(wordlist);
      System.out.println("Number of words in the lexicon: " + lewis.wordCount() + "\n");
      for (WordPair wp : pairList) {
         List<String> ladder = lewis.getMinSequence(wp.start, wp.end);
         System.out.println(wp.start + " --> " + wp.end + " : ");
         System.out.println("\t" + "Min sequence: " + ladder);
         System.out.println("\t" + "Hamming distance: " + lewis.hammingDistance(wp.start, wp.end));
         System.out.println("\t" + "Ladder length: " + (ladder.size() - 1));
         System.out.println("\t" + "Valid sequence: " + lewis.isValidSequence(ladder));
      }
   
      
   }
   
   
/**  
 * models a pair of words.
 *
 */
   static final class WordPair {
      private String start;
      private String end;
   
      private WordPair(String word1, String word2) {
         start = word1;
         end = word2;
      }
   }

}


