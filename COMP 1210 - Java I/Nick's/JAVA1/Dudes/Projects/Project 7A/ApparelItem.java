 /**
 *This program records the kind of items sold, how many were sold.
 * and their id number. It then records the amount sold per item
 * and then the total amount sold of all items.
 *
 *@author Tyler Rabren
 *@version 10/22/11
 **/  
	
	public class ApparelItem
   {
		private static double allItemSales;
      private String itemInfo1;
      private double itemSales;
		private String[] item;
		/**
		*this object, highItem, is originally set to null.
		**/
		private static ApparelItem highItem = null;
		private String name = "";
		private int id = 0;
		private double price = 0;

   
	
		/**
		*This constructor sets the object parameters and its info.
		*
		*@param itemInfo is the string representing the information for the item.
		**/
      public ApparelItem(String itemInfo)
      {	
			itemInfo.trim();
         itemInfo1 = itemInfo;
			setItemCode(itemInfo1);
      }
   	/**
		*This method splits the itemInfo string into 3 different
		*manageable parts inside a String array.
		*@return boolean returns whether the item code was valid or not.
		*@param code represents the string of the item.
		**/
      public boolean setItemCode(String code)
      {

			code.trim();
      	item = code.split(",");
			String string;
         boolean isSet = false;
			for (int index = 0; index < item.length; index++)
			{
				item[index] = item[index].trim();
			}
			name = item[0];
			id = Integer.parseInt(item[1]);
			price = Double.parseDouble(item[2]); 
			
			int amountOfCommas = 0;
			for (int index = 0; index < item.length; index++)
			{
				amountOfCommas++;
				if (amountOfCommas == 3)
				{
					isSet = true;
				}
				else
				{
					isSet = false;
				}
			}
         return isSet;
      }
   	/**
		*This method returns the name of the item object.
		*@return name is the string returned.
		**/
      public String getName()
      {
         return name;
      }
   	/**
		*This method returns the id number.
		*@return id is the int returned.
		**/
      public int getId()
      {
         return id;
      }
   	/**
		*This method returns the price of the item object.
		*@return price is the double, representing the price of the object 
		*returned.
		**/
      public double getPrice()
      {
         return price;
      }
   	/**
		*This method makes one purchase of an item object.
		*It also includes the code to return totalItemSales and 
		*allItemSales.
		**/
      public void sellItem()
      {
      	itemSales += price;
			allItemSales += price;
			if (highItem == null)
			{
				highItem = this;
			}
			else if (this.allItemSales > highItem.allItemSales())
			{
				highItem = this;
			}
      }
   	/**
		*This method returns the totalItemSales.
		*@return itemSales is the double representing the total item sales
		*of a particular type of item.
		**/
      public double totalItemSales()
      {
         return itemSales;
      }
   	/**
		*This method is static and returns the sales of all items.
		@return allItemSales is the double returned.
		**/
      public static double allItemSales()
      {
   		return allItemSales;
      }
   	/**
		*This method returns the highest selling item.
		@return highItem is the ApparelItem object returned.
		**/
      public static ApparelItem highestSeller()
      {
         return highItem;
      }
   	/**
		*This method gives necessary output of the program.
		*@return output is the string returned.
		**/
      public String toString()
      {
			String output = "Item name: " + getName() + " Item id: " + getId()
			+ " Item price: " + getPrice() + " Total item sales: " 
			+ totalItemSales();
         return output;
      }
   
   
   
   }