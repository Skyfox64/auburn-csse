   import javax.swing.JPanel;
   import javax.swing.JLabel;
   import javax.swing.JTextField;
   import javax.swing.JButton;
   import java.awt.Dimension;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;

   public class TriangleGUI extends JPanel {
   
      private JLabel side1, side2, side3, resultLabel;
      private JTextField side1Input, side2Input, side3Input, output;
      private JButton classifyButton;
   
      public TriangleGUI() {
      	// nested panels
         JPanel upperPanel = new JPanel();
         JPanel lowerPanel = new JPanel();
      
      	// instantiate components
         side1 = new JLabel("Side 1: ");
         side2 = new JLabel("Side 2: ");
         side3 = new JLabel("Side 3: ");
         resultLabel = new JLabel("Result: ");
         
         side1Input = new JTextField(10);
         side2Input = new JTextField(10);
         side3Input = new JTextField(10);
         output = new JTextField(15);
         classifyButton = new JButton("Triangle Classification");
         ClassifyListener buttonListener = new ClassifyListener();
         classifyButton.addActionListener(buttonListener);
      
         upperPanel.add(side1);
         upperPanel.add(side1Input);
         upperPanel.add(side2);
         upperPanel.add(side2Input);
         upperPanel.add(side3);
         upperPanel.add(side3Input);
         lowerPanel.add(classifyButton);
         lowerPanel.add(resultLabel);
         lowerPanel.add(output);
         
         this.add(upperPanel);
         this.add(lowerPanel);
      	// set size of outer panel
         this.setPreferredSize(new Dimension(500, 100));
      }
      
   
      private class ClassifyListener implements ActionListener {
      
         public void actionPerformed(ActionEvent event) {
            if (event.getSource() == classifyButton) {
               String sd1 = side1Input.getText();
               String sd2 = side2Input.getText();
               String sd3 = side3Input.getText();
               
               double sd1Num = Double.parseDouble(sd1);
               double sd2Num = Double.parseDouble(sd2);
               double sd3Num = Double.parseDouble(sd3);
            
               Triangle triangle = new Triangle(sd1Num, sd2Num, sd3Num);
               output.setText(triangle.getClassification());
            }
         }
      }
   }