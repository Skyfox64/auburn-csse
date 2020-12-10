import java.io.*;
/**
 * Example Hangman client.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2014-04-11
 *
 */
public class A6 {
 
 /**
  * Runs an example game of Hangman.
  */
   public static void main(String[] args) {
      Hangman game = new Hangman();
      game.setSecretWord("cat");
      game.playClean(true);
      
   }
 
   public static void simpleExample() {
      Hangman game = new Hangman();
      game.playClean(true);
      System.out.println();
      //game.playDirty(false);
      // game.playClean(true);
      // System.out.println();
   }
 
 
 /**
  * The following methods will automatically reproduce the handout examples
  * (minus some line feeds). This might be useful to you for testing purposes,
  * just so you won't have to continually type things interactively at the 
  * keyboard. Ignore these methods if you'd like.
  */
 
   public static void cleanSilentExample1() {
      String keyboardInput = "7,10,e,i,x,a,n,g,h,m,";
      keyboardInput = keyboardInput.replaceAll(",", System.getProperty("line.separator").toString());
      InputStream input = new ByteArrayInputStream(keyboardInput.getBytes());
      System.setIn(input);
   
      Hangman game = new Hangman();
      game.setSecretWord("hangman");
      game.playClean(false);
   }
   
   public static void cleanVerboseExample1() {
      String keyboardInput = "7,10,e,i,x,a,n,g,h,m,";
      keyboardInput = keyboardInput.replaceAll(",", System.getProperty("line.separator").toString());
      InputStream input = new ByteArrayInputStream(keyboardInput.getBytes());
      System.setIn(input);
   
      Hangman game = new Hangman();
      game.setSecretWord("hangman");
      game.playClean(true);
   }
   
   public static void dirtySilentExample1() {
      String keyboardInput = "4,10,a,e,i,o,u,b,f,c,l,d,s,";
      keyboardInput = keyboardInput.replaceAll(",", System.getProperty("line.separator").toString());
      InputStream input = new ByteArrayInputStream(keyboardInput.getBytes());
      System.setIn(input);
   
      Hangman game = new Hangman();
      game.playDirty(false);
   }
 
   public static void dirtyVerboseExample1() {
      String keyboardInput = "4,10,a,e,i,o,u,b,f,c,l,d,s,";
      keyboardInput = keyboardInput.replaceAll(",", System.getProperty("line.separator").toString());
      InputStream input = new ByteArrayInputStream(keyboardInput.getBytes());
      System.setIn(input);
   
      Hangman game = new Hangman();
      game.playDirty(true);
   }
 
}