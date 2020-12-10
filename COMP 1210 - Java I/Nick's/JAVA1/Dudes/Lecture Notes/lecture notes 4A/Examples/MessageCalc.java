   public class MessageCalc
   {
   
      char calc (int num1, int num2, String message)
      {
         int sum = num1 + num2;
         char result = message.charAt (sum);
      
         return result;
      }
   }
