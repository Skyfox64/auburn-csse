import java.util.Scanner;

   /**
   *
   * @author: John Carroll
   * @version: 9-9-2013
   * 
   */

public class MessageConverter
{
     /**
     * @param args Command line arguments (not used).
     */
     
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String message = "";
      int outputType = 0;
      String result = "";
     
      System.out.print("Type in a message and press:\n\t> ");
      message = userInput.nextLine();
     
      System.out.print("\nOutput types:"
         + "\n\t1: As is"
         + "\n\t2: lower case"
         + "\n\t3: UPPER CASE"
         + "\n\t4: v_w_ls r_pl_c_d"
         + "\nEnter your choice: ");
      
      outputType = Integer.parseInt(userInput.nextLine());
     
      if (outputType == 1) { // as is
         result = message;
         System.out.print("\n" + result);
      }
      else if (outputType == 2) { // lower case
         result = message.toLowerCase();
         System.out.print("\n" + result);
      }
      else if (outputType == 3) { // upper case
         result = message.toUpperCase();
         System.out.print("\n" + result);
      }
      else if (outputType == 4) { //replace vowels
         result = message.replace("a", "_");
         result = result.replace("e", "_");
         result = result.replace("i", "_");
         result = result.replace("o", "_");
         result = result.replace("u", "_");
         
         System.out.print("\n" + result);
      }
      else { // invalid input
         result = "Error: Invalid choice input.";
         System.out.print("\n" + result);
      }
   }    
}