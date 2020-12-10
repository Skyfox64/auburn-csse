   import java.util.Scanner;

/**
*This program takes the user's input, naming the
*grocery item and the category it belongs to
*and calculates the price including tax.
*
*@author Tyler Rabren
*@version 10/2/11
* 
**/

   public class GroceryItem 
   {
   /**
   *One of the categories in which an object is placed.
   **/
      public static final String PRODUCE = "Produce";
   /**
   *another category in which an object is placed.
   **/
      public static final String GENERAL = "General";
   /**
   *another category in which an object is placed.
   **/
      public static final String REFRIGERATED = "Refrigerated";
   /**
   *another category in which an object is placed.
   **/
      public static final String FROZEN = "Frozen";
      private String nameOfItem = "";
      private double basePrice;
      private int priceInput;
      private double taxPercentage;
      private String category;
   /**
   *initializing the Scanner object 'scan'.
   **/
      Scanner scan = new Scanner(System.in);
   
   /**
   *This class takes the grocery item's name and it's
   *category and calculates the total price for the item.
   **/
      public GroceryItem()
      {
         nameOfItem = scan.nextLine();
         category = scan.nextLine();
      }
   /**
   *This method sets and returns the name of the grocery item.
   *If nameOfItem is empty, the method returns "No Name".
   *
   *@return nameOfItem
   *@param nameOfItem double
   **/
      public String setName(String nameOfItem)
      {
         if (nameOfItem == "")
         {
            nameOfItem = "No Name";
         }
         return nameOfItem;
      }
   /**
   *This method returns the name of the item.
   *
   *@return nameOfItem
   **/
      public String getName()
      {
         return nameOfItem;
      }
   /**
   *This method takes the parameter, basePrice,
   *and returns a '1' if the price fits within the boundaries
   *specified. If it is not within the boundaries, a '0' or '-1'
   *is returned.
   *
   *@return basePrice
   *@param basePrice double
   **/
      public double setBasePrice(double basePrice)
      {
         final int MAXPRICE = 500;
         if (basePrice >= 0 && basePrice <= MAXPRICE)
         {
            System.out.println("1");
         }
         if (basePrice > MAXPRICE)
         {
            System.out.println("0");
         }
         if (basePrice < 0)
         {
            System.out.println("-1");
         }
         return basePrice;
      }
   /**
   *This method returns the basePrice previously set.
   *
   *@return basePrice
   **/
      public double getBasePrice()
      {
         return basePrice;
      }
   /**
   *This method calculates the total price of an item based
   *on its base price and the category it belongs to.
   *
   *@param localTaxRate double
   *@return totalPrice
   **/
   
      public double calculateTotalPrice(double localTaxRate)
      {
         double totalPrice = 0;
         double produceTax = .05;
         double refrigeratedTax = 1.5;
         double frozenTax = 3.00;
      
         if (localTaxRate <= 0 || localTaxRate >= 1)
         {
            totalPrice = -1;
         }
         if (category == GENERAL)
         {
            taxPercentage = basePrice * localTaxRate;
            totalPrice = basePrice + taxPercentage;
         }
         if (category == PRODUCE)
         {
            taxPercentage = basePrice * produceTax;
            totalPrice = basePrice + taxPercentage;
         }
         if (category == REFRIGERATED)
         {
            taxPercentage = basePrice * localTaxRate;
            totalPrice = basePrice + taxPercentage + refrigeratedTax;
         }
         if (category == FROZEN)
         {
            taxPercentage = basePrice * localTaxRate;
            totalPrice = basePrice + taxPercentage + frozenTax;
         }
         return totalPrice;
      }
   /**
   *This method returns the category of the item.
   *
   *@return category
   **/
      public String getCategory()
      {
         return category;
      }
   /**
   *This toString method returns the output stating what the name
   *of the grocery item is, the category it belongs to, and its
   *base price.
   *
   *@return output
   **/
      public String toString()
      {
         String output = "Grocery item: " + nameOfItem
            + "Category item belongs to: " + category
            + "Base price: " + basePrice;
         return output;
      }
   
   
   }