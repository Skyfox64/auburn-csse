public class OnlineBook extends OnlineTextItem
{
	protected String author;
	
	public OnlineBook(String nameIn, double priceIn)
	{
		super(nameIn, priceIn);
		author = "Author not listed";
	}
	
	public String setAuthor(String authorIn)
	{
		author = authorIn;
		return author;
	}
	
	public String toString()
	{
		String output = name + " - " + author + ": " + price;
		return output;
	}


}