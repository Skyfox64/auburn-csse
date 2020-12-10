import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Supports playing Dodgson's Word Ladder game.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2014-03-24
 *
 */
public class Dodgson {

   public class Node implements Comparable<Node> {
      public String element;
      public Node prev;
      public boolean visited;
   
      public Node() {
         element = null;
         prev = null;
         visited = false;
      }
   
      public Node(String e) {
         element = e;
         prev = null;
         visited = false;
      }
      
      public int compareTo(Node input) {
         return element.compareToIgnoreCase(input.element);
      }
   
   }

/**
 * Instantiate with words available in the specified
 * InputStream used as the game's lexicon.
 *
 * @param in   InputStream with words for lexicon
 *
 */
 
   TreeSet<Node> fullWordList = new TreeSet<Node>();
   int size = 0;

   public Dodgson(InputStream in) {
      Scanner s = 
            new Scanner(new BufferedReader(new InputStreamReader(in)));
      while (s.hasNext()) {
         String str = s.next();
         if (fullWordList.add(new Node(str))) {
            size++;
         }
         s.nextLine();
      }
   }
     
   

/**
 * Constructs a shortest length Dodgson sequence from
 * start to finish. If multiple sequences exist with
 * minimum length, no guarantee is made about which is
 * returned. If no sequence exists, an empty List is 
 * returned.
 *
 * @param start the starting word for the sequence
 * @param finish the ending word for the sequence
 * @return the minimum sequence from start to finish
 *
 */
   public List<String> getMinSequence(String start, String finish) {
      if (start.length() != finish.length()) {
         return new LinkedList<String>();
      }
      Node startNode = new Node(start.toUpperCase());
      Node endNode = new Node(finish.toUpperCase());
      Node current = new Node();
      LinkedList<String> returned = new LinkedList<String>();
      LinkedList<String> returnedTemp = new LinkedList<String>();
      LinkedList<Node> children = new LinkedList<Node>();
      LinkedList<Node> queue = new LinkedList<Node>();
      queue.add(startNode);
      startNode.visited = true;
      while (!queue.isEmpty()) {
         current = queue.poll();
         if (current.element.equals(finish.toUpperCase())) {
            while (current != null) {
               returnedTemp.add(current.element);
               current = current.prev;
            }
            while (!returnedTemp.isEmpty()) {
               returned.add(returnedTemp.pollLast().toLowerCase());
            }
            resetVisitedNodes();
            return returned;
         }
         
         children = findChildren(current);
         while(!children.isEmpty()) {
            queue.add(children.poll());
         }
      }
      resetVisitedNodes();
      return new LinkedList<String>();
   }
      /**
 * Checks the provided sequence of words to see if it
 * is a valid Dodgson sequence.
 *
 * @param seq the word ladder to test
 * @return true if ladder is a Dodgson sequence, false otherwise
 *
 */
   public boolean isValidSequence(List<String> seq) {
      if (seq.isEmpty()) {
         return false;
      }
      if (seq.size() == 1) {
         return true;
      }
      Iterator<String> itr = seq.iterator();
      String first, second = "";
      while (itr.hasNext()) {
         first = itr.next();
         if (!isWord(first)) {
            return false;
         }
         if (itr.hasNext()) {
            second = itr.next();
            if (!isWord(second)) {
               return false;
            }
         }
         if (hammingDistance(first, second) != 1) {
            return false;
         }
      }
      return true;
   }   
   
/**
 * Returns the Hamming distance between the two
 * given strings. The Hamming distance is the number of 
 * corresponding characters in the two strings that 
 * are different. If the two strings do not have the 
 * same length, the Hamming distance is defined to be -1.
 *
 * @param s1 the first string
 * @param s2 the second string
 * @return the Hamming distance between s1 and s2
 *
 */   
   public int hammingDistance(String s1, String s2) {
      if (s1.length() != s2.length()) {
         return -1;
      }
   	// compute hamming distance
      int distance = 0;
      for (int i = 0; i < s1.length(); i++) {
         if (s1.charAt(i) != s2.charAt(i)) {
            distance++;
         }
      }
      return distance;
   }

 
/**
 * Checks to see if the given string is a word;
 * that is, if it is contained in the current lexicon.
 *
 * @param s the string to test
 * @return true if s is in the lexicon, false otherwise
 *
 */
   public boolean isWord(String s) {
      String sCapital = s.toUpperCase();
      if (fullWordList.contains(new Node(sCapital))) {
         return true;
      }
      return false;
      
   }   
   
   
/**
 * Returns the number of words in the current lexicon.
 *
 * @return the number of words in the lexicon
 *
 */
   public int wordCount() {
      return size;
   }
   
   public LinkedList<Node> findChildren(Node inputNode) {
      LinkedList<Node> returned = new LinkedList<Node>();
      Node current;
      Iterator<Node> itr = fullWordList.iterator();
      while(itr.hasNext()) {
         current = itr.next();
         while(itr.hasNext() && current.visited == true) {
            current = itr.next();
         }
         if (hammingDistance(inputNode.element, current.element) == -1) {
            current.visited = true;
         }
         if (hammingDistance(inputNode.element, current.element) == 1) {
            current.visited = true;
            returned.add(current);
            current.prev = inputNode;
         }
      }
      return returned;
   }
   
   public void resetVisitedNodes() {
      Iterator<Node> itr = fullWordList.iterator();
      while(itr.hasNext()) {
         Node current = itr.next();
         current.visited = false;
      }
   }

}


