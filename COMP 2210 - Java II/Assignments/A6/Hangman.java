import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Random;
import java.util.ArrayList;

/**
 * Plays both clean and dirty Hangman. With extensions,
 * could be used to hustle.
 *
 * Note: Some fields and methods, as well as the class
 * composition, reflect convenience for testing/grading
 * and not necessarily good game design.
 *
 * @author  John Carroll (jcc0044@tigermail.auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2014-04-26
 *
 */
public class Hangman {

   // maximum number of guesses allowed in any play
   private static final int MAX_GUESSES = 26;
   
   // scanner used for taking input from System.in
   private Scanner stdin;
    
   // secret word for this play
   String secretWord;
   boolean secretWordSet;
   
   // class collection
   HashMap<Integer, TreeSet<String>> lexiconByLengths = new HashMap<Integer, TreeSet<String>>();
   
      
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
            
            // If hashMap has the key/index(wordlength) of this word's wordlength, then 
            // add the word(string) under that key/index(wordlength)
            if (lexiconByLengths.containsKey(wordLength)) {
               lexiconByLengths.get(wordLength).add(word);
            }
            else { 
            //else: if this key(wordlength) does not exist, then add the word to a 
            //new tree that is made at the new key/index(wordlength)
               TreeSet<String> sprout = new TreeSet<String>(); //you "sprout" a new tree
               sprout.add(word);
               lexiconByLengths.put(wordLength, sprout);
            }
            
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
   
 //P L A Y    C L E A N
 /**
  * Plays a clean game of Hangman, as described
  * in the assignment handout.
  */
   public void playClean(boolean verbose) {
      // Initializations
      boolean correctGuess = false;
      boolean won = false;
   
      int userSpecifiedLength = 0; //placed outside of condition loops
      char guessChar = ' '; //char read-in of user input         
      String guess = ""; //String of the guessChar
      
     // Updating Collections:
         // Already Guessed/Used Letters
      ArrayList<String> alreadyGuessed = new ArrayList<String>();
         // Progress/Status
      ArrayList<String> progress = new ArrayList<String>();
         // Wrong guesses
      ArrayList<String> wrongGuesses = new ArrayList<String>();      
         // Possible words based on [current] Progress/Status
      HashMap<String,TreeSet<String>> wordsPossible = new HashMap<String,TreeSet<String>>();
   
      
      
    // Print title
      System.out.println("****\tH A N G M A N\t****");
    // Check if in verbose mode; print play type indication
      if (verbose) {
         System.out.println(" (playing clean)");
      }
   
   //(1) Prompt the user for a word length for this game, reprompting as necessary until the user enters
   //     a number such that there is at least one word that's exactly that long.
      userSpecifiedLength = readWordLength();
   
      //Commented out section is for convenience when testing
      //NOT convenient when submitting with Dr.Hendrix's test cases
      //goes from a 14 to a 100 in grade.
      // if (!secretWordSet) {
      //userSpecifiedLength = readWordLength();
      // }
      // else if (secretWordSet) {
         // userSpecifiedLength = secretWord.length();
         // System.out.println("The word length and secret word are already set at: " + userSpecifiedLength);
      // }
   
   //(2) Choose the words of this length from the game lexicon as the set of possible words for this game.
      TreeSet<String> currentWordFamily = lexiconByLengths.get(userSpecifiedLength);
           
      
   //(3) If it has been set already with a call to setSecretWord(), this method is to use the current value of 
   //      the secretWord and assume that it is consistent with the word length chose above. If it has not been set,
   //      this method should pick a secret word at random from the possible set of words for this game play.
   //      In either case, this method must NOT prompt the user for a secret word.
      if (!secretWordSet) {
         Random randomGenerator = new Random();
         int randomIndex = randomGenerator.nextInt(currentWordFamily.size() + 1);
         int i = 0;
         for (String word : currentWordFamily) {
            if (i == randomIndex) {
               setSecretWord(word);
               break;
            }
            i++;
         }
      }
               
   //(4) Prompt the user for a number of guesses, which must be an integer greater than zero and
   //      less than or equal to 26.
      int numGuesses = readNumGuesses();
               
   //(5) Repeat the following steps until the number of guesses allowed is exhausted 
   //      or until the user has correctly guessed the secret word.
            //(a) Display the appropriate information about the current game state, take into account
            //      the value of the parameter verbose.
      while(numGuesses > 0) //While it has guesses left
      {
             // build the inital blank progress array (it will only contain "-" for now)
         if (progress.size() == 0) {
            for (int i = 0; i < userSpecifiedLength; i++) {
               progress.add("-");
            }
         }
              // (re)build strings to print nicely without commas and brackets
         String progressString = rebuild(progress);
         String wrongGuessesString = rebuild(wrongGuesses);
      
              // Game Output:
                  // print out secret word if verbose == true
         if (verbose) { System.out.print("\nThe secret word is:               " + secretWord);
         }
                  // print out progress
         System.out.println("\nYour progress:                    /" + progressString + "/");
         System.out.println("Wrong guesses:                    " + wrongGuessesString);
         System.out.println("Guesses remaining:              " + numGuesses);
                  // print out number of possible words if verbose == true
         if (verbose) { System.out.println("Number of words possible: " +  currentWordFamily.size()); 
         }
         
      //(b) Prompt the user for a single-letter guess, reprompting as nessary until the user enters a
      //      lowercase letter. If the user types more than single character, ignore all but the first. Make
      //      sure the first character is a lowercase English letter.
         guessChar = readLetterGuess();
         guess = "" + guessChar; //convert char to String
         if(alreadyGuessed.contains(guess)) {
            System.out.println("You must enter a lowercase letter in the range ['a'..'z'] that has not been used before.");
         }
         else { alreadyGuessed.add(guess);
         }
            
            
            
       //  W O R D S     P O S S I B L E      C L E A N
       //Generate the new wordsPossible here using the past loop's currentPossibleWords.
            //Reset
         wordsPossible = new HashMap<String, TreeSet<String>>(); // resets wordsPossible
         ArrayList<String> masks = new ArrayList<String>(); // resets masks; only inside game loop
            //Initializations
         String currentWord = "";
         String thisMask = "";
         String largestMask = "";
         char targetChar = '0';
         int familySize = 0;
             //Verbose Mode Strings
         String wordFamilies = "Possible word families: \n";
         String numWords = "Number of words possible: " + currentWordFamily.size() ;
         
      
         for(String word : currentWordFamily){
            currentWord = word;
            thisMask = word;
            for(int i = 0; i < userSpecifiedLength; i++){
               String temp = "" + word.charAt(i);
               if(!alreadyGuessed.contains(temp) && word.charAt(i) != '-'){
                  //ex: abba, and alreadyGuessed contains a
                  targetChar = thisMask.charAt(i);
                  //then thisMask updates to: a--a
                  thisMask = thisMask.replace(targetChar, '-'); // this word's final mask
               }
            }
            if(!wordsPossible.containsKey(thisMask)){
               TreeSet<String> sprout = new TreeSet<String>();                               					
               sprout.add(currentWord);
               wordsPossible.put(thisMask, sprout);
               masks.add(thisMask); //adds: a--a to ArrayList
            }
            else{
               //gets thisMask's value(treeset) and adds the current word to the TreeSet
               wordsPossible.get(thisMask).add(currentWord);
            }	
         }
         
            //Initialize the largest mask
         largestMask = masks.get(0);
         String largestFamily = "";
         
            //Find the largest Mask
         for(int i = 0; i < masks.size(); i++){
         
            if(wordsPossible.get(masks.get(i)).size() > wordsPossible.get(largestMask).size()){
               largestMask = masks.get(i);
            }
            if(wordsPossible.get(masks.get(i)).contains(secretWord)){
               largestFamily = masks.get(i);
            }
         // saves the word families to wordFamilies.
            wordFamilies += "/" + masks.get(i) + "/  " + wordsPossible.get(masks.get(i)).size() + "\n"; 
         }
               
             //update the current word family  
         currentWordFamily = wordsPossible.get(largestFamily);	//for clean
         familySize = wordsPossible.get(largestFamily).size(); //get the size of that family; print "wordsPossible"
          
      //(c) If the guessed letter is in the secret word, change the word"mask:" (the dashes that show 
      //     the user's progress) to reveal this letter in its correct location. If the guessed letter is not in 
      //     the secret word, add this letter to the list that is displayed as incorrect guesses and subtract 
      //     one from the number of guesses remaining. Note that correct letters do not decrease the 
      //     number of guesses remaining.
             //Reset boolean for guess being correct, next we actually check if it is correct
         correctGuess = false;
             // if guess is correct, add it to progress and set correctGuess == true
         for (int i = 0; i < userSpecifiedLength; i++) {
            if (secretWord.charAt(i) == guessChar) {
               progress.set(i, guess);
               correctGuess = true;
               progressString = rebuild(progress);
            }
         }
      
         //If the updated Progress is the secret word, then the user won!
         if (progressString.equals(secretWord)) {
            won = true;
            break;
         }
          
         // if the guess isn't correct and it hasn't been added to wrongGuesses
         // then add it to wrongGuesses, rebuild/format, and decrement.
         if (!correctGuess && !wrongGuesses.contains(guess) && !guess.equals(" ")) {
            wrongGuesses.add(guess);
            wrongGuessesString = rebuild(wrongGuesses);
            numGuesses--; // decrement desiredNumGuesses
         }
      }
      
   //(6) Once the game loop stops, display the appropriate message depending on whether the
   //      user won or lost.
      if (won) {
         System.out.println("\nYou won! The secret word was " + secretWord + ".");
      }
      else {
         System.out.println("Sorry, but you didn't guess the secret word: " + secretWord + ".");
      }
      
   }
   
   
 //P L A Y    D I R T Y
 /**
  * Plays a dirty game of Hangman, as described
  * in the assignment handout.
  */
   public void playDirty(boolean verbose) {
   // Mostly the same as P L A Y    C L E A N
   // Initializations
      boolean correctGuess = false;
      boolean won = false;
   
      int userSpecifiedLength = 0; //placed outside of condition loops
      char guessChar = ' '; //char read-in of user input         
      String guess = ""; //String of the guessChar
      
     // Updating Collections:
         // Already Guessed/Used Letters
      ArrayList<String> alreadyGuessed = new ArrayList<String>();
         // Progress/Status
      ArrayList<String> progress = new ArrayList<String>();
         // Wrong guesses
      ArrayList<String> wrongGuesses = new ArrayList<String>();
         // Possible words based on [current] Progress/Status
      HashMap<String,TreeSet<String>> wordsPossible = new HashMap<String,TreeSet<String>>();
         
   
      
    // Print title
      System.out.println("****\tH A N G M A N\t****");
    // Check if in verbose mode; print play type indication
      if (verbose) {
         System.out.println(" (playing dirty)");
      }
   
   //(1) Prompt the user for a word length for this game, reprompting as necessary until the user enters
   //     a number such that there is at least one word that's exactly that long.
      userSpecifiedLength = readWordLength();
   
      //Commented out section is for convenience when testing
      //NOT convenient when submitting with Dr.Hendrix's test cases
      //goes from a 14 to a 100 in grade.
      // if (!secretWordSet) {
      //userSpecifiedLength = readWordLength();
      // }
      // else if (secretWordSet) {
         // userSpecifiedLength = secretWord.length();
         // System.out.println("The word length and secret word are already set at: " + userSpecifiedLength);
      // }
   
   //(2) Choose the words of this length from the game lexicon as the set of possible words for this game.
      TreeSet<String> currentWordFamily = lexiconByLengths.get(userSpecifiedLength); 
      
   //(3) If it has been set already with a call to setSecretWord(), this method is to use the current value of 
   //      the secretWord and assume that it is consistent with the word length chose above. If it has not been set,
   //      this method should pick a secret word at random from the possible set of words for this game play.
   //      In either case, this method must NOT prompt the user for a secret word.
      if (!secretWordSet) {
         String tempSecretWord = currentWordFamily.first();
         setSecretWord(tempSecretWord);
      }
                     
   //(4) Prompt the user for a number of guesses, which must be an integer greater than zero and
   //      less than or equal to 26.
      int numGuesses = readNumGuesses();
   
   //(5) Repeat the following steps until the number of guesses allowed is exhausted 
   //      or until the user has correctly guessed the secret word.
            //(a) Display the appropriate information about the current game state, take into account
            //      the value of the parameter verbose.
      while(numGuesses > 0) //While it has guesses left
      {
                      // build the inital blank progress array (it will only contain "-" for now)
         if (progress.size() == 0) {
            for (int i = 0; i < userSpecifiedLength; i++) {
               progress.add("-");
            }
         }
      
               // (re)build strings to print nicely without commas and brackets
         String progressString = rebuild(progress);
         String wrongGuessesString = rebuild(wrongGuesses);
      
         // Game Output:
                  // print out secret word if verbose == true
         if (verbose) {
            System.out.print("\nThe secret word is:               " + secretWord);
         }
       
                  // print out progress
         System.out.println("\nYour progress:                    /" + progressString + "/");
         System.out.println("Wrong guesses:                    " + wrongGuessesString);
         System.out.println("Guesses remaining:              " + numGuesses);
                  // print out number of possible words if verbose == true
         if (verbose) {
            System.out.println("Number of words possible: " +  currentWordFamily.size()); 
         }
                  
      //(b) Prompt the user for a single-letter guess, reprompting as nessary until the user enters a
      //      lowercase letter. If the user types more than single character, ignore all but the first. Make
      //      sure the first character is a lowercase English letter.
         guessChar = readLetterGuess();
         guess = "" + guessChar; //convert char to String
         if(alreadyGuessed.contains(guess)) {
            System.out.println("You must enter a lowercase letter in the range ['a'..'z'] that has not been used before.");
         }
         else {
            alreadyGuessed.add(guess);
            
         }
           
            
       //  W O R D S     P O S S I B L E     D I R T Y
       //Generate the new wordsPossible here using the past loop's currentPossibleWords.
            //Reset
         wordsPossible = new HashMap<String, TreeSet<String>>(); // resets wordsPossible
         ArrayList<String> masks = new ArrayList<String>(); // resets masks; only inside game loop
            //Initializations
         String currentWord = "";
         String thisMask = "";
         String largestMask = "";
         String newSecretWord = "";
         char targetChar = '0';
         int familySize = 0;
             //Verbose Mode Strings
         String wordFamilies = "Possible word families: \n";
         String numWords = "Number of words possible: " + currentWordFamily.size() ;
         
      
         for(String word : currentWordFamily){
            currentWord = word;
            thisMask = word;
            for(int i = 0; i < userSpecifiedLength; i++){
               String temp = "" + word.charAt(i);
               if(!alreadyGuessed.contains(temp) && word.charAt(i) != '-'){
                  //ex: abba, and alreadyGuessed contains a
                  targetChar = thisMask.charAt(i);
                  //then thisMask updates to: a--a
                  thisMask = thisMask.replace(targetChar, '-'); // this word's final mask
               }
            }
            if(!wordsPossible.containsKey(thisMask)){
               TreeSet<String> sprout = new TreeSet<String>();                               					
               sprout.add(currentWord);
               wordsPossible.put(thisMask, sprout);
               masks.add(thisMask); //adds: a--a to ArrayList
            }
            else{
               //gets thisMask's value(treeset) and adds the current word to the TreeSet
               wordsPossible.get(thisMask).add(currentWord);
            }	
         }
         
            //Initialize the largest mask
         largestMask = masks.get(0);
         String largestFamily = "";
         
            //Find the largest Mask
         for(int i = 0; i < masks.size(); i++){
         
            if(wordsPossible.get(masks.get(i)).size() > wordsPossible.get(largestMask).size()){
               largestMask = masks.get(i);
            }
            if(wordsPossible.get(masks.get(i)).contains(secretWord)){
               largestFamily = masks.get(i);
            }
         // saves the word families to wordFamilies.
            wordFamilies += "/" + masks.get(i) + "/  " + wordsPossible.get(masks.get(i)).size() + "\n"; 
         }
         
            //update the current word family  
         currentWordFamily = wordsPossible.get(largestMask); //for dirty
         newSecretWord = currentWordFamily.first();
      
            // D I R T Y M O D E - changes secret word here
         setSecretWord(newSecretWord);
            // IF in Verbose Mode, PRINT the wordFamilies
         if(verbose){
            System.out.println(wordFamilies);
         }
         
                      
      //(c) If the guessed letter is in the secret word, change the word"mask:" (the dashes that show 
      //     the user's progress) to reveal this letter in its correct location. If the guessed letter is not in 
      //     the secret word, add this letter to the list that is displayed as incorrect guesses and subtract 
      //     one from the number of guesses remaining. Note that correct letters do not decrease the 
      //     number of guesses remaining.
             //Reset boolean for guess being correct, next we actually check if it is correct
         correctGuess = false;
             // if guess is correct, add it to progress and set correctGuess == true
         for (int i = 0; i < userSpecifiedLength; i++) {
            if (secretWord.charAt(i) == guessChar) {
               progress.set(i, guess);
               correctGuess = true;
               progressString = rebuild(progress);
            }
         }
      
         //If the updated Progress is the secret word, then the user won!
         if (progressString.equals(secretWord)) {
            won = true;
            break;
         }
          
         // if the guess isn't correct and it hasn't been added to wrongGuesses
         // then add it to wrongGuesses, rebuild/format, and decrement.
         if (!correctGuess && !wrongGuesses.contains(guess)) {
            wrongGuesses.add(guess);
            wrongGuessesString = rebuild(wrongGuesses);
            numGuesses--; // decrement desiredNumGuesses
         }
      
      
      
      
      
      
      }
      
               
   //(6) Once the game loop stops, display the appropriate message depending on whether the
   //      user won or lost.
      if (won) {
         System.out.println("\nYou won! The secret word was " + secretWord + ".");
      }
      else {
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
            if (lexiconByLengths.containsKey(len)) {
               validLength = true;
            }
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
            if (numGuesses > 0 && numGuesses <= MAX_GUESSES) {
               validNumber = true;
            }
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
      char ch = ' ';
      char[] validChoices = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
          'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
      boolean validChar = false;
      try{
         do {
            System.out.print("Guess a letter: ");
            ch = stdin.next().charAt(0);
            stdin.nextLine();
         // ch needs validating
            for (int i = 0; i < validChoices.length; i++) {
               if (validChoices[i] == ch) {
                  validChar = true;
               }
            }
            if (!validChar) {
               System.out.println("You must enter a lowercase letter in the range ['a'..'z'].");
            }
         } while (!validChar);
      }
      catch (Exception e) {
         stdin.nextLine(); 
      }
      return ch;
   }
  
   /**
    * Method to rebuild ArrayLists into a formatted string.
    */
   private String rebuild(ArrayList<String> input) {
      String builtString = "";
      StringBuilder builder = new StringBuilder();
      for (String value : input) {
         builder.append(value);
      }
      builtString = builder.toString();
      return builtString;
   }
   
   private String getWordsPossible(ArrayList<String> input) {
   
      return null;
   }
}