   import javax.swing.JFrame;
	 /**
	  * Displays a GUI that allows user to calculate the cost of
	  * a cable account in the format {lastname firstname cableboxes} 
	  * and calculates the total cost accordingly.
	  * Functionality for service selection has not been added; all
	  * costs will be based on the Basic cable package.
	  *
	  * @author Tyler Rabren
	  * @version 10/9/11
	  */
   public class AccountCalculator {
   
   	 /**
        * Displays the account calculator GUI.
        *
        * @param args Command line arguments (not used).
        */
      public static void main(String[] args) {
      
         JFrame mainFrame = new JFrame("Cable Calculator");
      	
         AccountCalculatorPanel panel = new AccountCalculatorPanel();
         mainFrame.getContentPane().add(panel);
      	
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setResizable(false);
         mainFrame.pack();
         mainFrame.setVisible(true);
      }
   }