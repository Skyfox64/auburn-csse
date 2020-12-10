	/**
	* This program will enter profile information.
	*
	* @author Nick DiChiara
	* @version 9-5-2012
	*/

   public class Activity4A {
   
   /**
   *
   * This class takes the user's input and interfaces with the
   * ProfileInformation Class.
   *
   * @param args User-defined Command line arguments (not used).
   */
   
      public static void main(String[] args) {
      	
         ProfileInformation p = new ProfileInformation("Nick", "DiChiara");
         p.setAge(19);
         
      	
         p.setLocation("Auburn");
         p.logOn();
         System.out.print(p);
      
      }
   }