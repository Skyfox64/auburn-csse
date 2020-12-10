   import javax.swing.JFrame;

   public class TriangleClassifier {
   
      public static void main(String[] args) {
      
         JFrame frame = new JFrame("Triangle Classification");
      	
         TriangleGUI guiPanel = new TriangleGUI();
         frame.getContentPane().add(guiPanel);
      	
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
      }
   }