   public class InventoryItem {
   
      protected double price;
      protected String name;
      private static double taxRate = 0;
   
   
      public InventoryItem(String nameIn, double priceIn) {
         name = nameIn;
         price = priceIn;
      }
   
   
   
      public String getName() {
         return name;
      }
   
      public double calculateCost() {
         double cost = price * (1 + taxRate);
         return cost;
      }
   
      public static void setTaxRate(double taxRateIn) {
         taxRate = taxRateIn;
      }
   
      public String toString() {
         return name + ": $" + calculateCost();
      }
   
   
   
   }