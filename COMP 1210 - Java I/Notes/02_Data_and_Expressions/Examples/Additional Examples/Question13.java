
   public class Question13
   {
   //-----------------------------------------------------------------
   //  Demonstrates type promotion and casting.
   //-----------------------------------------------------------------
      public static void main (String[] args)
      {           
         double x = 4; 
         int i = 5; 
         int answer = (int)((x/i) * 2);
         System.out.println(answer);
         System.out.println((double)answer);
      	
         int answer2 = (int) x/i * 2;
         System.out.println(answer2);
      }
   }
