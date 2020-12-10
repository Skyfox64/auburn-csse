public class InventoryItem
{
	protected double price;
	protected String name;
	private static double taxRate = 0.0;
	
	public InventoryItem(String nameIn, double priceIn)
	{
		price = priceIn;
		name = nameIn;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double calculateCost()
	{
		double cost = 0.0;
		cost = price * (1 + taxRate);
		return cost;
	}
	
	public static void setTaxRate(double taxRateIn)
	{
		taxRate = taxRateIn;
	}
	
	public String toString()
	{
		String output = name + ": $" 
		+ calculateCost();
		return output;
	}

}
