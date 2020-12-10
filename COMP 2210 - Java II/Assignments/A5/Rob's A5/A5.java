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
 
public final class A5 {

   public static void main(String[] args) {
   
      ArrayList<WordPair> pairList = new ArrayList<WordPair>();
      pairList.add(new WordPair("cat", "hat")); //
      pairList.add(new WordPair("cat", "dog")); //
      pairList.add(new WordPair("cat", "red"));
      pairList.add(new WordPair("hot", "dog"));
      pairList.add(new WordPair("cog", "war"));
      pairList.add(new WordPair("bird", "fish"));
      pairList.add(new WordPair("head", "tail")); //
      pairList.add(new WordPair("door", "lock"));
      pairList.add(new WordPair("bank", "loan"));
      pairList.add(new WordPair("lewis", "alice"));
      pairList.add(new WordPair("aloof", "break"));
      pairList.add(new WordPair("earth", "first")); //
      pairList.add(new WordPair("earth", "peace")); //
      pairList.add(new WordPair("sword", "peace")); //
      pairList.add(new WordPair("sword", "plows")); //
      pairList.add(new WordPair("clash", "clown"));
      pairList.add(new WordPair("chair", "board"));
      pairList.add(new WordPair("board", "hotel"));
      pairList.add(new WordPair("chair", "hotel"));
      pairList.add(new WordPair("gimlets", "theeing"));
      pairList.add(new WordPair("cat", "fish"));
      pairList.add(new WordPair("xyz", "dog"));
      pairList.add(new WordPair("dog", "xyz"));
      pairList.add(new WordPair("hair", "bald"));
      pairList.add(new WordPair("tight", "loose"));
      pairList.add(new WordPair("twerk", "miley"));
      pairList.add(new WordPair("tiger", "eagle"));
      pairList.add(new WordPair("love", "hate"));
      pairList.add(new WordPair("lass", "male"));
      pairList.add(new WordPair("live", "dead"));
      pairList.add(new WordPair("warm", "cold"));
   
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
   
      System.out.println("\n*********************************************************");
      // WordLists.jar must be on the CLASSPATH
      InputStream names = A5.class.getResourceAsStream("names.txt");
      lewis = new Dodgson(names);
      System.out.println("Number of words in the lexicon: " + lewis.wordCount() + "\n");
      pairList = new ArrayList<WordPair>();
      pairList.add(new WordPair("lewis", "alice"));
      pairList.add(new WordPair("santa", "claus"));
      pairList.add(new WordPair("john", "fred"));
      pairList.add(new WordPair("betty", "sally"));
      for (WordPair wp : pairList) {
         List<String> ladder = lewis.getMinSequence(wp.start, wp.end);
         System.out.println(wp.start + " --> " + wp.end + " : ");
         System.out.println("\t" + ladder);
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

