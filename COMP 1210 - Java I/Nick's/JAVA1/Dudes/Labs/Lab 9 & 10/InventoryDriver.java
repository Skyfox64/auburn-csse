public class InventoryDriver
{
public static void main(String[] args)
{
	InventoryItem.setTaxRate(0.05);
	InventoryItem item = new InventoryItem("Oil change kit", 39.99);
	
	ElectronicsItem eItem = new ElectronicsItem("Cordless phone", 80.00, 1.8);
	
	OnlineArticle aItem = new OnlineArticle("Java news", 8.50);
	aItem.setWordCount(700);
	
	OnlineBook bItem = new OnlineBook("Java for Noobs", 13.37);
	bItem.setAuthor("Lauren G");
	
	System.out.println(item);
	System.out.println(eItem);
	System.out.println(aItem);
	System.out.println(bItem);
	
	





}
}