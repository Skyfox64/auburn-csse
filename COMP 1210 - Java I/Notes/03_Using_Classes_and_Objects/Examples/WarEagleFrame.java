import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Prints "War Eagle!" and "Go Tigers!" as labels in a 
 * panel in a frame.
 */
public class WarEagleFrame
{
  /**
   * Prints "War Eagle!" and "Go Tigers!" as labels in a 
	* panel in a frame.
   *
   * @param args Command-line arguments (unused). 
   */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Demo of Frame, Panel, and Label");
   
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      JPanel panel = new JPanel();
      panel.setBackground(Color.orange);
      panel.setPreferredSize(new Dimension(800, 300));
   
      JLabel label1 = new JLabel("War Eagle!");
      label1.setFont(new Font("SansSerif", Font.ITALIC, 100));
      JLabel label2 = new JLabel(" Go Tigers!");
      label2.setFont(new Font("Times New Roman", Font.ITALIC, 100));
      label2.setForeground(Color.BLUE);
      panel.add(label1);
      panel.add(label2);
   
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
