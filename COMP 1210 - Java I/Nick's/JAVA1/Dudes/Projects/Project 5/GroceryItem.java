    import java.text.DecimalFormat;
/** 
 *
 * Creates class in which a grocery store could
 * use to calculate total price catagorize goods
 * and to decide weather the input is valid.
 *
 *
 * @author Tyler Rabren.
 * @version 9/28/2011.
 * 
 *
 */
   public class GroceryItem {
      /**
   	*sets all deligations to private.
   	*/
      private String name, category;
      private int basePrice;
      private double calculateTotalPrice, totalPrice, cost;
   	/**
   	* establishes constants for all category type as well
   	* as sets max value to 500.
   	*/
      public static final String GENERAL = "General";
       	/**
   	* establishes constants for the category type.
   	*/
      public static final String PRODUCE = "Produce";
       	/**
   	* establishes constants for the category type.
   	*/
      public static final String REFRIGERATED = "Refrigerated";
       	/**
   	* establishes constants for the category type.
   	*/
      public static final String FROZEN = "Frozen";	
       	/**
   	* sets max value to 500.
   	*/
      private static final int MAXVALUE = 500;	
   	/**
   	* This is the constructor which takes in two
   	* String parameters.
		*
   	* @param grocer for constructor
      * @param type for constructor
   	*/		
      public GroceryItem(String grocer, String type) {
         setName(grocer);
         if (setCategory(type)) {
            category = type;
         }
         else {
            category = GENERAL;
         }
         cost = 0;
      }
   	/**
   	* Sets the name for the grocery item.
   	* @param grocerName String
   	*/
   
      public void setName(String grocerName) {
         if (grocerName.trim().equals("")) {
            name = " No Name";
         
         }
         else {
            name = grocerName;
         }
         
      }
   	/**
   	* Gets the name for the grocery item.
   	* @return name 
   	*/
   
      public String getName() {
         return name;
      }
   	/**
   	* Sets the base cost of the grocery items.
   	* @param price is the base price for the items
   	* @return 1, 0, or -1 according to the boolean
   	* expression
   	*/
   
   
      public int setBasePrice(double price) {
         if (price <= MAXVALUE && price >= 0) {
            cost = price;
            return 1;
         }
         else if (price > MAXVALUE) {
            return 0;
         }
         else {
            return -1;
         }
      }
   	/**
   	* gets the base price of item.
   	* @return cost
   	*/
   
      public double getBasePrice() {
         return cost;
      }
   	
   	/**
   	* calculates total price of each item.
   	* @param taxRate is the tax rate of the store
   	* @return total price or -1.0
   	*/
   
      public double calculateTotalPrice(double taxRate) {
               DecimalFormat decimal = new DecimalFormat("0.###");
         if (taxRate > 0 && taxRate < 1) {
            if (totalPrice > 0 || totalPrice < 1) {
               if (category.equals(PRODUCE)) {
                  totalPrice = (cost * .05) + cost;
                  
               }
               else if (category.equals(REFRIGERATED)) {
                  totalPrice = ((cost + 1.5) * taxRate)
                  + 1.5 + cost;
               }
               else if (category.equals(FROZEN)) {
                  totalPrice = ((cost + 3.0) * taxRate) 
                  + 3.0 + cost;
               }
               else {
                  totalPrice = (cost * taxRate) + cost;
               }
            
               return Double.parseDouble(decimal.format(totalPrice));
            }
            else {
               return -1.0;
            }
         }
         else {
            return -1;
         }
      }
   	/**
   	* Sets the category of the grocery item.
   	* @param typeGrocer is the grocery items catagory
   	* @return boolean true or false
   	*/
   
      public boolean setCategory(String typeGrocer) {
         boolean isSet = false;
         if (typeGrocer.equals("Frozen") 
         || typeGrocer.equals("Refrigerated")
         || typeGrocer.equals("Produce") 
         || typeGrocer.equals("General")) {
            if (typeGrocer.equals("Frozen") 
            || typeGrocer.equals("Refrigerated")
            || typeGrocer.equals("Produce")) {
               category = typeGrocer;
            }
            else {
               category = GENERAL;
            }
            isSet = true;
         }
         return isSet;
      }
   	/**
   	* Gets the catagory for the grocery item.
   	* @return catagory type
   	*/
   
      public String getCategory() {
         return category;
      }
   	/**
   	* toString method establishes the shell of the class.
   	* @return output which consists of name category and
   	* cost
   	*/
   
      public String toString() {
         String output = "Grocery name: " + name
			+ "Category it belongs to: " + category 
			+ "base price: " + cost;
         return output;
      }
   }
