public class OnlineArticle extends InventoryItem
{	
	private int wordCount;
	
	public OnlineArticle(String nameIn, double priceIn)
	{
		super(nameIn, priceIn);
		priceIn =0;
	}
	
	public void setWordCount(int wordCountIn)
	{
		wordCount = wordCountIn;
	}
	


}