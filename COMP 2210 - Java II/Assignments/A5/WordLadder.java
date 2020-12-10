/**
 * A program to find a word ladder between 2 words, where each word in the
 * ladder is a word found in a dictionary.
 * 
 * Reads a file with words and their neighbors into Word objects and
 * creates an ArrayList<Word> dictionary.
 */
import java.util.*;
import java.io.*;

public class WordLadderSolver {
    
    ArrayList<Word> dict;  // Word is an inner class
    
    /**
     * Construct a WordLadderSolver using the dictionary contained in filename
     * @param filename the name of the dictionary file
     */
    public WordLadderSolver(String filename) throws FileNotFoundException {
        readFile(filename);
    }
    
    /**
     * Read in the dictionary from filename.
     * Each line in the dictionary contains a word followed by its neighbors
     */
    private void readFile(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        String line, wrd;
        ArrayList<String> wordsNeighbors;
        String[] wordsOnLine;
        
        // initialize dict to empty list
        dict = new ArrayList<Word>();
        
        // fill the dictionary with all the words and their neighbors
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            wordsOnLine = line.split("\\s");
            
            // the word is the first thing on the line
            wrd = wordsOnLine[0];
            wordsNeighbors = new ArrayList<String>();
            
            // then come the words that differ by only one character
            for (int i=1; i < wordsOnLine.length; i++) {
                wordsNeighbors.add(wordsOnLine[i]);
            }
            
            // create a Word object and add it to the dictionary
            dict.add(new Word(wrd, wordsNeighbors));
        }
        scan.close();
        
        // sort the dictionary for fast lookup with binary search
        Collections.sort(dict);
    }
    
    /**
     * Find the word ladder between from and to if possible
     * @param from the starting word
     * @param to the resulting word
     * @return an ArrayList<String> containing the words in the ladder, or
     * null if no ladder could be found
     */
    public Stack<String> solve(String from, String to) {
        
        Stack<String> aStack; // to reference stacks removed from the queue
        Stack<String> solution = null; // return value
        boolean done;         // control for main loop
        Word aWord;           // to reference a Word in the dictionary
        String topWord;       // top word as a String
        int topIndex;         // index of top word in the dictionary array
        Stack<String> stackCopy;  // to store a copy of the current stack
        
        // use java's linked list as a queue:
        // add to end with offer method
        // remove from front with poll method
        LinkedList<Stack<String>> queue = new LinkedList<Stack<String>>();
        
        // get indexes of from and to in the dictionary using binary search
        int fromIndex = Collections.binarySearch(dict, new Word(from));
        int toIndex = Collections.binarySearch(dict, new Word(to));
        
        // if from and to are not both in the dictionary return null
        // no ladder is possible
        
        /**********    To Do    **********/
        
        /*
         * Initialize the queue of stacks. Each stack contains <from> on the
         * bottom and one of from's neighbor words on top.
         */
        
        /**********    To Do    **********/
        
        
        /*
         * Loop until we are done (a ladder was found) or
         * the queue is empty (no ladder exists)
         * Make sure no word is contained twice in the same stack.
         */        
        done = false;
        while (!queue.isEmpty() && !done) {
            
            // remove a stack from the queue
            /**********    To Do    **********/
            
            // peek at the top word
            /**********    To Do    **********/
            
            
            // find the top Word in the dictionary (use binary search)
            /**********    To Do    **********/
            
            /* 
             * Create stacks for top word's neighbors and add them to the queue,
             * but first make sure that the neighbor is not already on the stack.
             * We are done if the neighbor is the ending word in the ladder
             */
            /**********    To Do    **********/
            
        }
        return solution;
    }
    
    /*
     * Inner class to store a word in the dictionary and its neighbors
     */
    private class Word implements Comparable<Word> {
        private String word;
        private ArrayList<String> neighbors;
        
        public Word(String aWord) {
            word = aWord;
            neighbors = null;
        }
        
        public Word(String aWord, ArrayList<String> theNeighbors) {
            word = aWord;
            neighbors = theNeighbors;
        }
        
        public boolean equals(Object otherObj) {
            if (otherObj == null) {
                return false;
            }
            if (otherObj.getClass() != getClass()) {
                return false;
            }
            
            Word otherWord = (Word) otherObj;
            return (this.word.equals(otherWord.word));
        }
        
        public int compareTo(Word otherWord) {
            return this.word.compareTo(otherWord.word);
        }
        
        public String toString() {
            String rval = word + " ";
            for (String s : neighbors) {
                rval += s + " ";
            }
            return rval;
        }
    }
    
    
    /*
     * Demo program that takes 2 words of length 4 as arguments
     * and finds the ladder between them.
     */
    public static void main(String[] args) {  
        
        if (args.length != 2) {
            System.out.println("usage: java WordLadderSolver <word> <word>");
            System.out.println("each word should be of length 4");
            System.exit(0);
        }
        
        if ((args[0].length() != 4) || (args[1].length() != 4)) {
            System.out.println("Words must both be 4 letters long!");
            System.exit(0);
        }
        
        try {
            WordLadderSolver ladderSolver = 
                new WordLadderSolver("wordlistWithNeighbors4.txt");
            Stack<String> ladder = ladderSolver.solve(args[0], args[1]);
            
            if (ladder == null) {
                System.out.println("no ladder found :-(");
            } else {
                System.out.println(ladder);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}