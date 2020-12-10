   import javax.swing.ImageIcon;
   import javax.swing.JFrame;
   import javax.swing.JPanel;
   import javax.swing.JLabel;
   import java.util.Scanner;

  /**
   * Shows a user-selected picture of AU's logo.
   */
   public class Pictures {
      /**
       * Shows a user-selected picture of AU's logo.
       *
       * @param args Command-line arguments (unused). 
       */
      public static void main(String[] args) {
         String logo;
         int selection; 
         Scanner input = new Scanner(System.in);  
      	
      	// initialize GUI components
         JFrame window = new JFrame("AU Logo");
         JPanel pane = new JPanel();
      
         // declare image & label that will display image
         ImageIcon picture;
         JLabel picHolder;
      
         System.out.print("Enter 1 to see a simple AU logo "
            + "\n   or 2 to see a detailed AU logo: ");
         selection = input.nextInt();
      
         if (selection == 1) {
            logo = "au_logo_1.jpg";
         }
         else {
            logo = "au_logo_2.jpg";
         }
         
         System.out.println("\r\nDisplaying " + logo + "...");
      
      	// retrieve picture, add to label, & add to panel
         picture = new ImageIcon(logo);
         picHolder = new JLabel(picture);
         pane.add(picHolder);
      	
         // configure window to end program on exit
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	
      	// add panel, then configure and show frame
         window.getContentPane().add(pane);
         window.pack();
         window.setVisible(true);
      }
   }
