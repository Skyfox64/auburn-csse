/**
* This class contains statements that create and print instances of
* FlipPhone, SmartPhone, IPhone, and Android. 
* @author John Carroll
* @version 11-10-2013
*/
public class CellPhonesPart1
{
   /**
   * @param args Command line arguments (not used).
   */
   public static void main(String[] args)
   {
      FlipPhone flip1 = new FlipPhone("123-456-7890", 100, 50);
      SmartPhone smart1 = new SmartPhone("123-456-7891", 40, 21, 10);
      IPhone iPhone1 = new IPhone("123-456-7892", 20, 548, 220, 55);         
      Android android1 = new Android("123-456-7893", 500, 400, 1000, 30);
      System.out.println(flip1);
      System.out.println("\n" + smart1);
      System.out.println("\n" + iPhone1);
      System.out.println("\n" + android1);
   }
}