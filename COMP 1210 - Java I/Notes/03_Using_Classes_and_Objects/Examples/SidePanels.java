   import javax.swing.ImageIcon;
   import javax.swing.JFrame;
   import javax.swing.JPanel;
   import javax.swing.JLabel;

  /**
   * Shows a picture of AU's logo.
   */
   public class SidePanels {
      /**
       * Shows a picture of AU's logo.
       *
       * @param args Command-line arguments (unused). 
       */
      public static void main(String[] args) {
         String logo = "au_logo_1.jpg";
         int selection; 
      	
      	// initialize GUI components
         JFrame window = new JFrame("AU Logo");
         JPanel mainPanel = new JPanel();
         JPanel leftPanel = new JPanel();
         JPanel rightPanel = new JPanel();
      
         // declare image & label that will display image
         ImageIcon picture = new ImageIcon(logo);
         JLabel picHolder = new JLabel(picture);
       
         leftPanel.add(new JLabel("AU CSSE"));
         rightPanel.add(picHolder);
         mainPanel.add(leftPanel);
         mainPanel.add(rightPanel);
         // configure window to end program on exit
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	
      	// add panel, then configure and show frame
         window.getContentPane().add(mainPanel);
         window.pack();
         window.setVisible(true);
      }
   }
