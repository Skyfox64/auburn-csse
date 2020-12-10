   import java.util.Scanner;
   
	/**
	* This program will recieve a message from the user 
	* and peform an action based on the entered value.
	*
	* @author Nick DiChiara
	* @version 9-5-2012
	*/


   public class MessageConverter {
   /**
   *
   * This class takes the user's input and alters the 
   * output based on their choice.
   *
   * @param args User-defined Command line arguments (not used).
   */
   
   
      public static void main(String[] args) {
      
         String message;
         String result = "";
         int outputType;
         Scanner userInput = new Scanner(System.in);
      
         System.out.print("Type in a message and press enter:\n\t> ");
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
         }
         else if (outputType == 2) { // lower case
            result = message.toLowerCase();
         }
         else if (outputType == 3) { // upper case
            result = message.toUpperCase();
         }
         
         else if (outputType == 4) { // replace vowels
            result = message.replace("a", "_");
            result = result.replace("e", "_");
            result = result.replace("i", "_");
            result = result.replace("o", "_");
            result = result.replace("u", "_");
            result = result.replace("A", "_");
            result = result.replace("E", "_");
            result = result.replace("I", "_");
            result = result.replace("O", "_");
            result = result.replace("U", "_");
         }
         else { //invalid input
            result = "Error: Invalid choice input.";
         }
      	
         System.out.print("\n" + result);
      }
   
   
   
   
   }