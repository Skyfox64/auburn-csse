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
 * @author    John Carroll (jcc0044@auburn.edu)
 * @version   2014-04-08
 *
 */
public class Dodgson {

/**
 * Instantiate with words available in the specified
 * InputStream used as the game's lexicon.
 *
 * @param in   InputStream with words for lexicon
 *
 */
 

   // fields
   int size =0;
   TreeSet<Node> lexicon = new TreeSet<Node>();
   
   // constructor
   public Dodgson(InputStream in) {
      Scanner s = new Scanner(new BufferedReader(new InputStreamReader(in)));
      while (s.hasNext()) {
         String str = s.next();
         if (lexicon.add(new Node(str))) {
            size++;
         }
         // store str in the lexicon here
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
      //first check if the start and finish nodes are equal in length
      if (start.length() != finish.length()) {
         return new LinkedList<String>(); }
      
      //initialize iteration Nodes
      Node s = new Node(start.toUpperCase());
      Node f = new Node(finish.toUpperCase());
      Node qCurrent = new Node ();
      Node childCurrent = new Node();
      Iterator<Node> itr = lexicon.iterator();
      
      //initialize LinkedList q and children
      LinkedList<Node> q = new LinkedList<Node>();
      LinkedList<Node> children = new LinkedList<Node>();
   
      //initialize the parent path's LinkedList
      LinkedList<String> path = new LinkedList<String>();
      LinkedList<String> pathTemp = new LinkedList<String>();
      
      //Step 1 in a fundamental way of doing a BST
      q.add(s); //add to q
      s.visited = true; //also mark Node as visited
      
      //Step 2, while q is not empty...
      while (!q.isEmpty()) {
              //dequeue q
         qCurrent = q.poll();
         
             // Step 3. Check if qCurrent is the goal
             //If qCurrent = finish...
         if (qCurrent.element.equals(finish.toUpperCase())) {
               //, then while qCurrent != null
               //This gets the parent, it goes:
               //<---qCurrent,q Current.prev, etc
               //aka <---finish, prev, start<---
            while (qCurrent != null) {
               pathTemp.add(qCurrent.element);
               qCurrent = qCurrent.prev;
            }
               //while the temporary path is not empty,
            while (!pathTemp.isEmpty()) {
                  //add to the path the temporary path's last added.
                  //this reverses pathTemp.
                  //the order is now:
                  //<---start, ..., finish <----
               path.add(pathTemp.pollLast().toLowerCase());
            }
            resetVisitedNodes();
                //print the path that was found
            return path;
         }
         
            //Step 4. find children until it is empty
         //children = findChildren(qCurrent);
         if(qCurrent!= null) {
            while(itr.hasNext()) {
               childCurrent = itr.next();
               while(itr.hasNext() && childCurrent.visited == true) {
                  childCurrent = itr.next();
               }
               if (hammingDistance(qCurrent.element, childCurrent.element) == -1) {
                  childCurrent.visited = true;
               }
               if (hammingDistance(qCurrent.element, childCurrent.element) == 1) {
                  childCurrent.visited = true;
                  children.add(childCurrent);
                  childCurrent.prev = qCurrent;
               }
            }
         }
            
           //Step 5. Dequeue children onto q
         while(!children.isEmpty()) {
            q.add(children.poll());
         }
      }
      
      resetVisitedNodes();
      return new LinkedList<String>();
   }   
       
       
/**
 * Checks the provided sequence of words to see if it
 * is a valid Dodgson sequence.
 *
 * @param ladder the word ladder to test
 * @return true if ladder is a Dodgson sequence, false otherwise
 *
 */
   public boolean isValidSequence(List<String> seq) {
      if (seq.isEmpty()) {
         return false; }
      if (seq.size() == 1) {
         return true; }
      Iterator<String> itr = seq.iterator();
      String first, second = "";
      while (itr.hasNext()) {
         first = itr.next();
         if (!isWord(first)) {
            return false; }
         if (itr.hasNext()) {
            second = itr.next(); 
            if (!isWord(second)) {
               return false; }}        
         if (hammingDistance(first, second) != 1) {
            return false; }
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
 * that is, if it is contained in the qCurrent lexicon.
 *
 * @param s the string to test
 * @return true if s is in the lexicon, false otherwise
 *
 */
   public boolean isWord(String s) {
      String sToUpper = s.toUpperCase();
      if (lexicon.contains(new Node(sToUpper))) {
         return true;
      }
      return false;
      
   }   
   
   
/**
 * Returns the number of words in the qCurrent lexicon.
 *
 * @return the number of words in the lexicon
 *
 */
   public int wordCount() {
      return size;
   }
      
   public LinkedList<Node> findChildren(Node inputNode) {
      LinkedList<Node> returned = new LinkedList<Node>();
      Node childCurrent;
      Iterator<Node> itr = lexicon.iterator();
      while(itr.hasNext()) {
         childCurrent = itr.next();
         while(itr.hasNext() && childCurrent.visited == true) {
            childCurrent = itr.next();
         }
         if (hammingDistance(inputNode.element, childCurrent.element) == -1) {
            childCurrent.visited = true;
         }
         if (hammingDistance(inputNode.element, childCurrent.element) == 1) {
            childCurrent.visited = true;
            returned.add(childCurrent);
            childCurrent.prev = inputNode;
         }
      }
      return returned;
   }
      
   public void resetVisitedNodes() {
      Iterator<Node> itr = lexicon.iterator();
      while(itr.hasNext()) {
         Node qCurrent = itr.next();
         qCurrent.visited = false;
      }
   }

   public class Node implements Comparable<Node> {
      String element = null;
      boolean visited = false;
      Node prev = null;
      
      public Node(){
         element = null;
         prev = null;
         visited = false;
      }
      public Node(String s) {
         element = s;
         prev = null;
         visited = false;
      }
      public int getHamDist(Node a, Node b) {
         return hammingDistance(a.element, b.element);
      }   
      public int compareTo(Node in) {
         return element.compareToIgnoreCase(in.element);
      }
   }
}


