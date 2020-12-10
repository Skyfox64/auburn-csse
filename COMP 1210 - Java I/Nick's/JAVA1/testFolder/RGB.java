   import java.awt.*;
   import javax.swing.*;

   public class RGB
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("RGB");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         RGBpanel panel = new RGBpanel();
         frame.getContentPane().add(panel);
         frame.pack();
         frame.setVisible(true);
      }
   }

   class RGBpanel extends JPanel
   {
      public RGBpanel()
      { 
         setPreferredSize(new Dimension(300,300));
         int red = Integer.parseInt(JOptionPane.showInputDialog("Ente r red value"));
         int green = Integer.parseInt(JOptionPane.showInputDialog("Ente r green value"));
         int blue = Integer.parseInt(JOptionPane.showInputDialog("Ente r blue value"));
         Color colr = new Color(red,green,blue);
         setBackground(colr);
      }
   }