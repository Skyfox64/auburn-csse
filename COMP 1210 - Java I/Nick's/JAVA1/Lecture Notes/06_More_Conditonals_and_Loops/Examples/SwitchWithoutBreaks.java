   public class SwitchWithoutBreaks
   {
      public static void main(String[] args)
      {
         int total = 0;
         int numberIn = 7;
         switch (numberIn) {
            case 3:
               total += 1;
            case 7:
               total += 2;
            case 9:
               total += 4;
            case 11:
               total += 5;
               break;
            default:
               total += 10;
         }
         System.out.println(total);
      }
   }