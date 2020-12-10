   public class TernaryOperatorBadExample
   {
      public static int makeChocolate(int sm, int big, int goal) {
         return sm-(goal-(big*5>goal?goal/5:big)*5)>=0?(goal-(big*5>goal?goal/5:big)*5):-1;
      }
      
      public static int makeChocolateAlt(int sm, int big, int goal) {
         return sm-(goal-(big*5>goal?goal/5:big)*5)>=0?(goal-(big*5>goal?goal/5:big)*5):-1;
      }
   
   }