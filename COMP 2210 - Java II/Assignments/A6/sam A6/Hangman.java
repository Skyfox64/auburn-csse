import java.util.*;
import java.io.*;

/**
 * Plays both clean and dirty Hangman. With extensions,
 * could be used to hustle.
 *
 * Note: Some fields and methods, as well as the class
 * composition, reflect convenience for testing/grading
 * and not necessarily good game design.
 *
 * @author  Samuel Weise (saw0025@tigermail.auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2014-04-11
 *
 */
public class Hangman{

   // maximum number of guesses allowed in any play
   private static final int MAX_GUESSES = 26;
   
   // scanner used for taking input from System.in
   private Scanner stdin;
    
   // secret word for this play
   String secretWord;
   boolean secretWordSet;
   
   public Hashtable<Integer, LinkedList<String>> dictionary = new Hashtable<Integer, LinkedList<String>>();
   
  /**
   * Instantiates a new Hangman game with a default lexicon.
   */
   public Hangman() {
      this(null);
   }
   
   
  /**
   * Instantiates a new Hangman game using the provided lexicon,
   * attaches a scanner to System.in using the line separator
   * as the delimiter.
   */
   public Hangman(InputStream in) {
      if (in == null) {
         in = Hangman.class.getResourceAsStream("lowerwords.txt");
      }
   
      try {
         Scanner s = 
            new Scanner(new BufferedReader(new InputStreamReader(in)));
            
         while (s.hasNext()) {
            String word = s.next().toLowerCase();
            int wordLength = word.length();
            
            // Add word to dictionary.
            if (dictionary.get(Integer.valueOf(wordLength)) == null) 
               dictionary.put(Integer.valueOf(wordLength), new LinkedList<String>());
            dictionary.get(Integer.valueOf(wordLength)).add(word);
         
            s.nextLine();
         }
         stdin = new Scanner(System.in);
         stdin.useDelimiter(System.getProperty("line.separator").toString());
         
         secretWordSet = false;
      }
      catch (Exception e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }
   
   
  /**
   * Sets the current secret word and notes that it has
   * been set.
   */
   public void setSecretWord(String word) {
      secretWord = word;
      secretWordSet = true;
   }
   

 /**
  * Plays a clean game of Hangman, as described
  * in the assignment handout.
  */
   public void playClean(boolean verbose)
   {
      boolean winner = false;
      String wrongGuesses = "";
      String mask = "";
   
      // Prompt the user for a word length for this game.
      int wordLength = readWordLength();
      
      for (int i = 0; i < wordLength; i++)
         mask += "-";
      
      // Choose the words of this length from dictionary.
      LinkedList<String> lex = dictionary.get(Integer.valueOf(wordLength));
      LinkedList<String> currentLex = lex;
      
      // If secret word is not set, set it randomly from lex.
      if (!secretWordSet)
      {
         int randWordIndex = (int)(Math.random() * lex.size());
         setSecretWord(lex.get(randWordIndex));
      }
      
      // Prompt the user for a number of guesses.
      int numGuesses = readNumGuesses();
      
      while ((numGuesses > 0) && (!winner))
      {
         // Guess Interface.
         
         System.out.println();
            // Line 1 Output (verbose).
         if (verbose)
            System.out.println("The secret word is:       " + secretWord);
            // Line 2 Output.
         System.out.println("Your progress:            /" + mask + "/");
            // Line 3 Output.
         System.out.println("Wrong guesses:            " + wrongGuesses);
            // Line 4 Output.
         System.out.println("Guesses remaining:        " + numGuesses);
            // Line 5 Output (verbose).
         if (verbose)
            System.out.println("Number of words possible: " + currentLex.size());
            // Line 6 Prompt for guess.
         char guess = readLetterGuess();
         
         // Convert lex into masked form.
         LinkedList<String> tempLex = new LinkedList<String>();
         char[] maskArray = mask.toCharArray();
         for (int i = 0; i < currentLex.size(); i++)
         {
            char[] convWord = currentLex.get(i).toCharArray();
            String maskedWord = "";
            for (int j = 0; j < wordLength; j++)
            {
               if (convWord[j] == guess)
                  maskedWord += String.valueOf(convWord[j]);
               else
                  maskedWord += maskArray[j];
            }
            tempLex.add(maskedWord);
         }
         
         // Generate masked Hashtable.
         Hashtable<String, LinkedList<String>> maskedHash = new Hashtable<String, LinkedList<String>>();
         for (int i = 0; i < tempLex.size(); i++)
         {
            if (maskedHash.get(tempLex.get(i)) == null)
               maskedHash.put(tempLex.get(i), new LinkedList<String>());
            maskedHash.get(tempLex.get(i)).add(currentLex.get(i));
         }
         
         // If letter is in secret word, unmask it.
         boolean right = false;
         String maskTemp = "";
         for (int i = 0; i < wordLength; i++)
         {
            if (secretWord.charAt(i) == guess)
            {
               maskTemp += guess;
               right = true;
            }
            else
               maskTemp += mask.charAt(i);
         }
         mask = maskTemp;
         
         // If letter completes secret word, winner.
         if (mask.compareTo(secretWord) == 0)
         {
            winner = true;
            break;
         }
         
         // Update lex.
         currentLex = maskedHash.get(mask);
         
         // If guess is wrong, add to wrong guesses, etc.
         if (!right)
         {
            wrongGuesses += guess;
            numGuesses--;
         }
         
      }
      
      if (winner)
      {
         System.out.println();
         System.out.println("You won! The secret word was " + secretWord + ".");
      }
      else
      {
         System.out.println("Sorry, but you didn't guess the secret word: " + secretWord + ".");
      }
   }
   
   
 
 /**
  * Plays a dirty game of Hangman, as described
  * in the assignment handout.
  */
   public void playDirty(boolean verbose)
   {
      boolean winner = false;
      String wrongGuesses = "";
      String mask = "";
   
      // Prompt the user for a word length for this game.
      int wordLength = readWordLength();
      
      for (int i = 0; i < wordLength; i++)
         mask += "-";
      
      // Choose the words of this length from dictionary.
      LinkedList<String> lex = dictionary.get(Integer.valueOf(wordLength));
      LinkedList<String> currentLex = lex;
      
      // Select first secret word as lexographically first word.
      setSecretWord(currentLex.get(0));
      for (int i = 0; i < currentLex.size(); i++)
         if (secretWord.compareTo(currentLex.get(i)) > 1)
            setSecretWord(currentLex.get(i));
      
      // Prompt the user for a number of guesses.
      int numGuesses = readNumGuesses();
      
      while ((numGuesses > 0) && (!winner))
      {
         // Guess Interface.
         
         System.out.println();
            // Line 1 Output (verbose).
         if (verbose)
            System.out.println("The secret word is:       " + secretWord);
            // Line 2 Output.
         System.out.println("Your progress:            /" + mask + "/");
            // Line 3 Output.
         System.out.println("Wrong guesses:            " + wrongGuesses);
            // Line 4 Output.
         System.out.println("Guesses remaining:        " + numGuesses);
            // Line 5 Output (verbose).
         if (verbose)
            System.out.println("Number of words possible: " + currentLex.size());
            // Line 6 Prompt for guess.
         char guess = readLetterGuess();
         
         // Convert lex into masked form.
         LinkedList<String> tempLex = new LinkedList<String>();
         char[] maskArray = mask.toCharArray();
         for (int i = 0; i < currentLex.size(); i++)
         {
            char[] convWord = currentLex.get(i).toCharArray();
            String maskedWord = "";
            for (int j = 0; j < wordLength; j++)
            {
               if (convWord[j] == guess)
                  maskedWord += String.valueOf(convWord[j]);
               else
                  maskedWord += maskArray[j];
            }
            tempLex.add(maskedWord);
         }
         
         // Generate masked Hashtable.
         Hashtable<String, LinkedList<String>> maskedHash = new Hashtable<String, LinkedList<String>>();
         for (int i = 0; i < tempLex.size(); i++)
         {
            if (maskedHash.get(tempLex.get(i)) == null)
               maskedHash.put(tempLex.get(i), new LinkedList<String>());
            maskedHash.get(tempLex.get(i)).add(currentLex.get(i));
         }
         
         // Partition and Identify largest wordList from the Hashtable.
         
         @SuppressWarnings("unchecked")
            Iterator<LinkedList<String>> hashItr = (Iterator<LinkedList<String>>) maskedHash.elements();
         @SuppressWarnings("unchecked")
            Iterator<String> keyItr = (Iterator<String>) maskedHash.keys();
         
         if (verbose)
         {
            System.out.println("Possible word families:");
            while (hashItr.hasNext())
            {
               String output = "/" + keyItr.next() + "/ " + hashItr.next().size();
               System.out.println(output);
            }
         }
         
         @SuppressWarnings("unchecked")
            Iterator<LinkedList<String>> hashItr2 = (Iterator<LinkedList<String>>) maskedHash.elements();
         LinkedList<String> largestList = new LinkedList<String>();
         while (hashItr2.hasNext())
         {
            LinkedList<String> nextList = hashItr2.next();
            if (nextList.size() > largestList.size())
               largestList = nextList;
         }
         
         // Update currentLex
         currentLex = largestList;
         
         setSecretWord(currentLex.get(0));
         for (int i = 0; i < currentLex.size(); i++)
            if (secretWord.compareTo(currentLex.get(i)) > 1)
               setSecretWord(currentLex.get(i));
         
         // If letter is in secret word, unmask it.
         boolean right = false;
         String maskTemp = "";
         for (int i = 0; i < wordLength; i++)
         {
            if (secretWord.charAt(i) == guess)
            {
               maskTemp += guess;
               right = true;
            }
            else
               maskTemp += mask.charAt(i);
         }
         mask = maskTemp;
         
         // If letter completes secret word, winner.
         if (mask.compareTo(secretWord) == 0)
         {
            winner = true;
            break;
         }
         
         // If guess is wrong, add to wrong guesses, etc.
         if (!right)
         {
            wrongGuesses += guess;
            numGuesses--;
         }
         
      }
      
      if (winner)
      {
         System.out.println();
         System.out.println("You won! The secret word was " + secretWord + ".");
      }
      else
      {
         System.out.println("Sorry, but you didn't guess the secret word: " + secretWord + ".");
      }
      
   }
   
   
 /**
  * Reads from System.in the word length for the game.
  * Only accepts valid lengths for the current lexicon.
  */  
   private int readWordLength() {
      int len = 0;
      boolean validLength = false;
      do {
         System.out.print("What word length do you want to play with? ");
         try {
            len = stdin.nextInt();
            
         // len needs validating
            if (dictionary.containsKey(Integer.valueOf(len)))
               validLength = true;
         
            stdin.nextLine(); 
         }
         catch (Exception e) {
            stdin.nextLine();
         }
         if (!validLength) {
            System.out.println("Sorry, there are no words of that length.");
         }
      } while (!validLength);
      return len;
   }

   
 /**
  * Reads from System.in the maximum number of guesses.
  */  
   private int readNumGuesses() {
      int numGuesses = 0;
      boolean validNumber = false;
      do {
         System.out.print("How many guesses would you like? [1.." + MAX_GUESSES + "] ");
         try {
            numGuesses = stdin.nextInt();
            
         // numGuesses needs validating
            if ((numGuesses > 0) && (numGuesses <= MAX_GUESSES))
               validNumber = true; 
         
            stdin.nextLine();
         }
         catch (Exception e) {
            stdin.nextLine(); 
         }
         if (!validNumber) {
            System.out.println("You must enter an integer in the range [1.." + MAX_GUESSES + "].");
         }
      } while (!validNumber);
      return numGuesses;
   }

 
 /**
  * Reads from System.in a single letter guess.
  */  
   private char readLetterGuess() {
      int ch = 0;
      boolean validChar = false;
      do {
         System.out.print("Guess a letter: ");
         ch = stdin.next().charAt(0);
         stdin.nextLine();
          
      // ch needs validating
         if (Character.isLetter(ch) && Character.isLowerCase(ch))
            validChar = true;
         if (!validChar) {
            System.out.println("You must enter a lowercase letter in the range ['a'..'z'].");
         }
      } while (!validChar);
      return (char)ch;
   }
}
