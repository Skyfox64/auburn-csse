   public class Item26
   {
      public static void main(String[] args)
      {
         int x = 5;
         switch(x) {
            case 4: 
               x += 3;
            case 5: 
               x += 2;
            case 2:
               x += 1;
            default:
               x += 5;
         }
      }
   }