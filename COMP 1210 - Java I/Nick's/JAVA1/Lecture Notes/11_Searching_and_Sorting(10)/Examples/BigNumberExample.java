import java.math.BigInteger;

public class BigNumberExample 
{
   public static void main(String[] args)
   {
      BigInteger i = new BigInteger("2");
      //BigInteger j = new BigInteger("2");
      BigInteger k = new BigInteger("2");   
      for (Integer j = 0; j < 401; j+=5) {
         k = i.pow(j);
         System.out.println("2^" + j + " " + k);
      }
      
      int length = k.toString().length();
      System.out.println(length);
   }
}