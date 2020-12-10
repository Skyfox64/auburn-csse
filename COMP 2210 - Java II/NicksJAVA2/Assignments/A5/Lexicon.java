import java.util.Iterator;
import java.io.File;

/**
 * Defines operations on a lexicon - a collection of strings that 
 * are accepted as words in the English language.
 *
 *	@author	Dean Hendrix (dh@auburn.edu)
 *	@version	2013-03-21
 *	
 */
public interface Lexicon extends Iterable {

/**
 * Associates the lexicon with the words contained
 * in fileName.
 *
 * @param filename	the file containing strings
 * 						to be included in the lexicon
 */
   public void open(File filename);

/**
 * Closes the currently open lexicon. 
 *
 */
   public void close();

/**
 * Determines if str is a word.
 *
 * @param str	the string to be validated as a word
 * @return		true is str is in the lexicon, false
 *					otherwise
 */   
   public boolean isWord(String str);
   
/**
 * Determines if str begins any word.
 *
 * @param str	the string to be validated as a word
 *					prefix
 * @return		true is str begins any word in the
 *					lexicon, false otherwise
 */   
   public boolean isPrefix(String str);
   
/**
 * Instantiates and returns an iterator on this
 * lexicon.
 *
 * @return 	an iterator object for this lexicon
 */	
   public Iterator iterator();

}