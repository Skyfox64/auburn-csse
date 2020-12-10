   import javax.swing.JPanel;
   import javax.swing.JLabel;
   import javax.swing.JTextField;
   import javax.swing.JButton;
   import java.awt.Dimension;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
	import java.util.Scanner;
	import java.text.DecimalFormat;
   
	 /**
	  * Creates a panel that allows users to enter account information
	  * in the format {lastname firstname cableboxes} and calculates the 
	  * total cost accordingly.
	  * Functionality for service selection has not been added; all
	  * costs will be based on the Basic cable package.
	  *
	  * @author Tyler Rabren
	  * @version 10/9/11
	  */
   public class AccountCalculatorPanel extends JPanel {
 			public static final int NO_CABLE = 0, BASIC = 1, EXTENDED = 2,
			PREMIUM = 3, PREMIUM_PLUS = 4, BEST_DEAL = 5;
			private JLabel inputLabel, outputLabel;
			private JTextField input, output;
			private JButton processButton, clearButton;
			private DecimalFormat formatter = new DecimalFormat("#.00");

      
     /**
      * Instantiates a new panel with all of the GUI components,
   	* including input for name and # cable boxes. Includes a 
   	* button for calculating cost and a button for clearing input.
      */
      public AccountCalculatorPanel() {
        // create 3 nested panels
         JPanel topPanel = new JPanel();
         JPanel middlePanel = new JPanel();
         JPanel bottomPanel = new JPanel();
         
      	// instantiate components
         outputLabel = new JLabel("Total Cost: ");
         inputLabel = new JLabel("Account Information: ");
         processButton = new JButton("Calculate Cost");
         clearButton = new JButton("Clear");
         input = new JTextField(30);
         output = new JTextField(20);
         
         output.setEditable(false); // users can't change cost field
         output.setText("$ "); // cost field starts out with a $
         
      	// create a listener for the buttons and add it to each
         ProcessClearListener buttonListener = new ProcessClearListener();
         processButton.addActionListener(buttonListener);
         clearButton.addActionListener(buttonListener);
         
			

      	// add input label & box to top panel
         topPanel.add(inputLabel);
         topPanel.add(input);
      	// add buttons to middle panel
         middlePanel.add(processButton);
         middlePanel.add(clearButton);
         // add output label & box to bottom panel
         bottomPanel.add(outputLabel);
         bottomPanel.add(output);
         
      	// add nested panels to main panel
         this.add(topPanel);
         this.add(middlePanel);
         this.add(bottomPanel);
      	
      	// because there is no layout manager, set the panel size manually
         this.setPreferredSize(new Dimension(475, 150));
      }
      
   	/**
       * Calculates cost and updates cost panel if the calculate cost
   	 * button is pressed. Clears input display and sets cost to a $
   	 * symbol if the clear button is pressed.
       */
      private class ProcessClearListener implements ActionListener {
      
         public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == processButton) {
				
						Scanner scan = new Scanner(input.getText());
						String firstName = scan.next();
						String lastName = scan.next();
						String boxes = scan.next();
						String name = firstName + lastName;
						int boxNumber = Integer.parseInt(boxes);
						CableAccount account = new CableAccount(name);
						account.setService(BASIC);
						account.setCableBoxes(boxNumber);
						output.setText("$ " + formatter.format(account.totalCost()));
            }
            else if (event.getSource() == clearButton) {
            output.setText("$ ");
				input.setText("");
            }
            
         }
      }
   }