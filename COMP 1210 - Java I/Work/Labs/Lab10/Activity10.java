public class Activity10 {

   public static void main(String[] args) {
      ItemsList myItems = new ItemsList();
      InventoryItem.setTaxRate(0.05);
      myItems.addItem(new ElectronicsItem("Laptop", 1234.56, 10));
      myItems.addItem(new InventoryItem("Motor Oil", 9.80));
      myItems.addItem(new OnlineBook("All Things Java", 12.30));
      myItems.addItem(new OnlineArticle("Off-Color Acroynms", 3.40));
      System.out.println(myItems);
   
      System.out.println("Total: " + myItems.calculateTotal(2.0));
   }
}