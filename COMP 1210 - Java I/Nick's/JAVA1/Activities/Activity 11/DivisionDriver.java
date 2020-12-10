   import javax.swing.JOptionPane;
   
   
   /**
   *
   */
   public class DivisionDriver {
   
   /**
   *
   */
      public static void main(String[] args) {
      
         try { 
            String numInput
               = JOptionPane.showInputDialog("Enter the numerator:");
            int num = Integer.parseInt(numInput);
         
            String denomInput
               = JOptionPane.showInputDialog("Enter the denominator:");	
            int denom = Integer.parseInt(denomInput);
         
            String result = "Integer division: \r\n"
               + Division.intDivide(num, denom)
               + "\r\n\r\nFloating point division: \r\n"
               + Division.decimalDivide(num, denom);
         	
            JOptionPane.showMessageDialog(null, result, 
               "Result", JOptionPane.PLAIN_MESSAGE);
            
         }
         	
            catch (NumberFormatException errorDetail) {
               JOptionPane.showMessageDialog(null, 
                  "Invalid input: enter numerical integer calues only.",
                  "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException errorMessage) {
               JOptionPane.showMessageDialog(null,
                  errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
      }
   
   
   }