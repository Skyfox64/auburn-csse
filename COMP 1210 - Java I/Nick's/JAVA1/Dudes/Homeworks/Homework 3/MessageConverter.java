import java.util.Scanner;

/**
*This program takes user input and alters it depending on what decisions they make with it.
*
*@author Tyler Rabren
*@version 9/7/11
*
**/

public class MessageConverter
	{
	/**
	*This class takes the user's input and changes the output based on
	*five choices available.
	*
	*@param args User-defined command line arguments (not used).
	**/
	public static void main(String[] arg) {
	String message;
	String result = "";
	int outputType;
	Scanner userInput = new Scanner(System.in);
	
	System.out.print("Type in a message and press enter:\r\n\t> ");
	message = userInput.nextLine();
	System.out.print("\r\nOutput types:"
	+ "\r\n\t1: As is"
	+ "\r\n\t2: lower case"
	+ "\r\n\t3: UPPER CASE"
	+ "\r\n\t4: v_w_ls r_pl_o_d"
	+ "\r\nEnter your choice: ");
	
	outputType = Integer.parseInt(userInput.nextLine());
	
	if (outputType == 1) { // as is
		result = message;
		System.out.println("\r\n" + result);
	}
	else if(outputType == 2) { //lower case
		result = message.toLowerCase();
		System.out.println("\r\n" + result);
	}
	else if(outputType == 3) { //upper case
		result = message.toUpperCase();
		System.out.println("\r\n" + result);
	}
	else if(outputType == 4) { // replace vowels
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
		System.out.println("\r\n" + result);
	}
	else { //invalid input
		result = ("Error: Invalid choice input.");
		System.out.println("\r\n" + result);
	}
	}
}

