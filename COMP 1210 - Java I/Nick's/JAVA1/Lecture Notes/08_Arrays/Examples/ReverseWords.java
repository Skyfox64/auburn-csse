   import java.util.Scanner;
   
/**
 * Reads in a sentence and prints out words
 * in reverse order.
 */
   public class ReverseWords
   {
   /**
    * Reads in sentence, breaks it into words,
    * prints out words in reverse order.
    */
      public static void main(String[]args)
      {	
         Scanner scan = new Scanner (System.in);
      
         System.out.println ("Enter a sentence (max 20 words): ");
         String sentence = scan.nextLine();
         
         Scanner scanSentence = new Scanner(sentence); 
         //scanSentence.useDelimiter("\\W");
         String[] words = new String[20];
         int wc = 0;
         while (scanSentence.hasNext())
         {
            words[wc] = scanSentence.next();
            wc++; 
         }
         for (int j = wc-1; j >= 0; j--)
            System.out.print(words[j] + " ");
      }
   }