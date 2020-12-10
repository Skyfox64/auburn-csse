import java.util.Arrays;

public class RectangleSorter {

   public static void main(String[] args) {
      Rectangle[] rList = new Rectangle[5];
      
      rList[0] = new Rectangle(2, 5);
      rList[1] = new Rectangle(20, 50);
      rList[2] = new Rectangle(5, 6);
      rList[3] = new Rectangle(1, 4);
      rList[4] = new Rectangle(6, 4);
   
      for (Rectangle r : rList) {
         System.out.println(r);
      }  
      
      Arrays.sort(rList);
      
      System.out.println("- - - - - Sorted retangles  - - - - - - ");
      
      for (Rectangle r : rList) {
         System.out.println(r);
      }  
   }
}