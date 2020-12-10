   import java.util.Scanner;
   import java.util.ArrayList;
   
   /**
    * Obtains a set of numbers from the user until the user enters
    * 0. Information is then printed about each number that was entered 
    * including whether it was even or odd, and positive or negative.
    *
    * @author Tyler Rabren
    * @version 9/27/11
	 **/
   public class NumberList {
   
      /**
       * Obtains a set of numbers from the user until the user enters
   	 * 0. Information is then printed about each number that was entered 
    	 * including whether it was even or odd, and positive or negative.
   	 *
       * @param args - Standard commandline arguments
       */
     public static void main(String[] args) {
                
         String input = "";
         Scanner in = new Scanner(System.in);
      String number;
      ArrayList<String> myArr = new ArrayList<String>();
      int index = 0;
      
      System.out.print("Enter a set of non-zero"
      + " numbers (Press 0 to end): \n");
      number = in.nextLine();

      while (Integer.parseInt(number) != 0) {
      myArr.add(number);
      number = in.nextLine();
      
      }
      while (index < myArr.size())
      {
      NumberOperations numberOp;
      numberOp = new NumberOperations(Integer.parseInt(myArr.get(index)));
      System.out.println(numberOp);
      index++;
     }
         
         /**declare and instantiate ArrayList with generic type
         *<NumberOperations>. Prompt user for set of numbers.
         *get first line of user input.
         *while the input is not "0", and add NumberOperations object 
         *to array based on user input. Get new user input.
         *Iterate through ArrayList from beginning to end and print each object.
         */
      }
   }
