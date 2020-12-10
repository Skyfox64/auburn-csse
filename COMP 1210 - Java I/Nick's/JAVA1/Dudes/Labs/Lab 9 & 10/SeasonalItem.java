public class SeasonalItem extends InventoryItem
{
	private boolean season;
	
	public SeasonalItem(String nameIn, double priceIn)
	{
		super(nameIn, priceIn);
		season = false;
	}
	
	public void setInSeason(boolean inSeason)
	{
		season = inSeason;
	}
	
	public boolean isInSeason()
	{
		return season;
	}
	
	public double calculateCost()
	{
		if (season == true)
		{
			return super.calculateCost();
		}
		else
		{
			double discount = 0.9;
			return price * discount;
		}
	}
	
	public String toString()
	{
		String output = name + ": $" 
		+ calculateCost() + "In Stock";
		return output;
	}
	



}