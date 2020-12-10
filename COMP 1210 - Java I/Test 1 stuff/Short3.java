import java.text.DecimalFormat;
import java.util.Random;

class Short3{
   public static void main(String[] args) {
   
      DecimalFormat df = new DecimalFormat("0.##");
      double val = 4.12567;
      System.out.println(df.format(val));
      
      Random rand = new Random();
      System.out.println(rand.nextInt(1));
      
   //    double aDouble = rand.nextDouble()*1;
   //    System.out.println(df.format(aDouble));
   
   }
}