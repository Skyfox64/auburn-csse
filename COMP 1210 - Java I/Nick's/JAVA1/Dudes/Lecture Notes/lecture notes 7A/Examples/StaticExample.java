   public class StaticExample 
   {
      static int i = 9;
      private static int j = 999;
   
      public static void main(String[] args) {
      
         System.out.println("i = " + i);
         System.out.println("j = " + j);
         
         int i = 2;
         {
            int j = 3;
            System.out.println("i + j = " + (i + j));
            System.out.println("static j = " + StaticExample.j);
         }
         
         System.out.println("i = " + i);
      
         System.out.println("j = " + j);
      }
   }
