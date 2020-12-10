/**
*
*
* @author Nick DiChiara
* @version 08-21-2012
*/

   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;

   public class AppletTest extends Applet implements ActionListener
   {
      /**
       * Prints course information to std output.
       *
       * @param args Command line arguments (not used).
       */
    
      Button convertButton; 
      Button resetButton;
      TextField nameField;
      
   
   	
      public void init()
      {
      
         setLayout(new FlowLayout()); 
         convertButton = new Button("Convert!"); 
         resetButton = new Button("Reset");
         nameField = new TextField("Enter a number",35); 
         add(nameField); 
         add(convertButton); 
         add(resetButton);
           
      	
         Color gry = new Color(250,250,250);
         setBackground(gry); 
      
      // Attach actions to the components 
         convertButton.addActionListener(this); 
         resetButton.addActionListener(this);
      }
      
      public void paint(Graphics g) 
      { 
         Image img1 = Toolkit.getDefaultToolkit().getImage("c.png");
         g.drawImage(img1, 0, 0, this); 
         g.drawString("APPLET HELLO.WORLD",100,100);
         g.drawString(nameField.getText(),100,200);
      }		 	
   
      
      public void actionPerformed(ActionEvent evt)  
      { 
         if (evt.getSource() == convertButton)  
         
            repaint();
            
         else if (evt.getSource() == resetButton)  
         {
         // Changes the text in the TextField 
            nameField.setText("Enter a number"); 
         // Lets the applet show that message. 
            repaint(); 
         } 
      }
   
   }