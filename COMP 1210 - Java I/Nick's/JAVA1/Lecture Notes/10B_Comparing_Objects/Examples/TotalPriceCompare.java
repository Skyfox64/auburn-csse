   import java.util.Comparator;
   
   public class TotalPriceCompare implements Comparator<Product> {
   
      public int compare(Product p1, Product p2) {
         if (p1.totalPrice() > p2.totalPrice()) {
            return -1;
         }
         else if (p1.totalPrice() < p2.totalPrice()) {
            return 1;
         }
         return 0;
      }
   }