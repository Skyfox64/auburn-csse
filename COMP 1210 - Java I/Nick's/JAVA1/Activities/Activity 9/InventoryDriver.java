   public class InventoryDriver {
   
   
      public static void main(String args[]) {
         InventoryItem.setTaxRate(0.05);
         InventoryItem ock = new InventoryItem("Oil change kit", 3.99);
      
         ElectronicsItem cp = new ElectronicsItem("Cordless phone", 80, 1.8);
      
         OnlineArticle jn = new OnlineArticle("Java News", 8.50);
         jn.setWordCount(700);
      
         OnlineBook jfn = new OnlineBook("Java for Noobs", 13.37);
         jfn.setAuthor("L.G. Jones");
      
      
      
         System.out.println(ock.toString());
         System.out.println(cp.toString());
         System.out.println(jn.toString());
         System.out.println(jfn.toString());
      
      
      }
   
   
   }