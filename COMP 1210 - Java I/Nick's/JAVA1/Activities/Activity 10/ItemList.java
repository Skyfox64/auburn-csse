   import java.util.ArrayList;
   
	
	/**
	* This class will store an ArrayList of inventory items.
	*
	* @author Nick DiChiara
	* @version 11-5-2012
	*/
   public class ItemList {
   
      private ArrayList<InventoryItem> inventory;
      
      /**
   	* Blah.
   	* @param args sprcifies string arguments.
   	*/
   
      public static void main(String[] args) {
         ItemList itemList = new ItemList();
         InventoryItem.setTaxRate(0.05);
         
         itemList.addItem(new ElectronicsItem("Laptop", 1234.56, 10));
         itemList.addItem(new InventoryItem("Motor Oil", 9.80));
         itemList.addItem(new OnlineBook("All Things Java", 12.3));
         itemList.addItem(new OnlineArticle("Off-Color Acronyms", 3.4));
         
         System.out.print(itemList);
         
         System.out.println("Total Price: " 
            + itemList.getTotalPrice(1.5) + "\r\n");
      }
   
   	/**
   	* Default constructor ItemList.
   	*/
      public ItemList() {
         inventory = new ArrayList<InventoryItem>();
      }
   
   	/**
   	* Method addItem adds items to the inventory.
   	* @param itemIn is the added item.
   	*/   
      public void addItem(InventoryItem itemIn) {
         inventory.add(itemIn);
      }
   
   
   	/**
   	* Method getTotalPrice adds the prices of the items.
   	* @param shipRate specifies the rate to ship.
   	* @return price specifies the total price.
   	*/   
      public double getTotalPrice(double shipRate) {
         double price = 0;
         for (InventoryItem item : inventory) {
            if (item instanceof ElectronicsItem) {
               price += ((ElectronicsItem) item).calculateCost() + shipRate;
            }
            
            else {
               price += item.calculateCost();
            }
         }
         return price;
      }
   
      /**
   	* Method toString ouputs data.
   	* @return output specifies the output data.
   	*/
      public String toString() {
         String output = "All inventory:\r\n\r\n";
      	
         for (InventoryItem item : inventory) {
            output += item.toString() + "\r\n";
         } 
      	
      	
         return output + "\n";
      }
   
   
   }