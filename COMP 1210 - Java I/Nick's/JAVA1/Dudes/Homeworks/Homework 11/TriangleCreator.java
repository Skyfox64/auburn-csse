   import javax.swing.JOptionPane;
   
   public class TriangleCreator {
   
      public static void main(String[] args) {
         double side1 = 0;
         double side2 = 0;
         double side3 = 0;
         Triangle triangle;
         
         while(true) {
            //try {
               /* Get input for sides */
            String s1 
               	= JOptionPane.showInputDialog("Side 1 length:");
               //side1 = 
            String s2 
               	= JOptionPane.showInputDialog("Side 2 length:");
               //side2 = 
            String s3 
               	= JOptionPane.showInputDialog("Side 3 length:");
               //side3 = 
            try{
               side1 = Double.parseDouble(s1);
               side2 = Double.parseDouble(s2);
               side3 = Double.parseDouble(s3);
               /* Create triangle object */
               triangle = new Triangle(side1, side2, side3);
               
               /* Show triangle info */
               JOptionPane.showMessageDialog(null, triangle.toString(), 
                  "Triangle", JOptionPane.PLAIN_MESSAGE);
            }
               catch (NumberFormatException errorDetail)
               {
                  JOptionPane.showMessageDialog(null, 
                     "Invalid input: enter numerical integer values only.",
                     "Error", JOptionPane.PLAIN_MESSAGE);
               }
               catch (IllegalArgumentException errorMessage)
               {
                  JOptionPane.showMessageDialog(null, 
                     "Sides: " + side1 + " " + side2 + " " + side3 + " "
                     + "must be greater than zero.",
                     "Error", JOptionPane.ERROR_MESSAGE);
               }
            
               catch (InvalidTriangleException errorMess)
               {
                  JOptionPane.showMessageDialog(null, 
                     "Sides: " + side1 + " " + side2 + " " + side3 + " " 
                     + "are not a triangle.",
                     "Error", JOptionPane.ERROR_MESSAGE);
               } 
            	/* End execution when no exception caught */	
            return;
         }
      }
   }