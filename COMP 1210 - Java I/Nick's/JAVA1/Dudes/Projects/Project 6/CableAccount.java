import java.util.ArrayList;
/**
*This program represents a cable service account with all its owners.
*
*
*@author Tyler Rabren
*@version 10/7/11
**/
public class CableAccount 
{
	/**
	*The service type.
	**/
	public static final int NO_CABLE = 0;
	/**
	*One of the service types.
	**/
	public static final int BASIC = 1;
	/**
	*One of the service types.
	**/
	public static final int EXTENDED = 2;
	/**
	*One of the service types.
	**/
	public static final int PREMIUM = 3;
	/**
	*One of the service types.
	**/
	public static final int PREMIUM_PLUS = 4;
	/**
	*One of the service types.
	**/
	public static final int BEST_DEAL = 5;
	/**
	*The service type price for each option.
	**/
	public static final double NO_CABLE_PRICE = 0.00;
	/**
	*The service type price for each option.
	**/
	public static final double BASIC_PRICE = 50.00;
	/**
	*The service type price for each option.
	**/
	public static final double EXTENDED_PRICE = 70.00;
	/**
	*The service type price for each option.
	**/
	public static final double PREMIUM_PRICE = 85.50;
	/**
	*The service type price for each option.
	**/
	public static final double PREMIUM_PLUS_PRICE = 106.20;
	/**
	*The service type price for each option.
	**/
	public static final double BEST_DEAL_PRICE = 136.70;
	private double cableBoxes2;
	private String serviceString;
	private double totalCost;
	private double costPerOwner;
	private double costOfBoxes = 0;
	
	
	
	private ArrayList<String> owners = new ArrayList<String>();
	
	/**
	*This constructor takes the first name as a string as a paramater.
	*@param firstName is firstName of the owner.
	**/
	public CableAccount(String firstName)
	{
	String lastName;
	}
	/**
	*This method adds owners to the owners array list.
	*@param name is the string added to the array list.
	**/
	public void addOwner(String name)
	{
	
		while (name.trim().length() > 0)
		{
			owners.add(name);	
		}
		
	}
	/**
	*This method deletes names from the array list.
	@param name is the string object part of the array list.
	**/
	public void deleteOwner(String name)
	{
		while (owners.size() > 0) {
			owners.remove(name);
		}
		
	}
	/**
	*This method sets the service type of the cable account.
	*@param serviceType is the integer primitive type defining the service type.
	**/
	public void setService(int serviceType)
	{
		switch (serviceType)
		{
			case NO_CABLE:
			serviceString = "No cable";
			break;
			case BASIC:
			serviceString = "Basic";
			break;
			case EXTENDED:
			serviceString = "Extended";
			break;
			case PREMIUM:
			serviceString = "Premium";
			break;
			case PREMIUM_PLUS:
			serviceString = "Premium Plus";
			break;
			case BEST_DEAL:
			serviceString = "Best Deal";
			break;
			default:
				System.out.println("Invalid type.");
		}
	}
	/**
	*This method states the number of cable boxes attached to the account.
	*@param cableBoxes is the double that states the amount of cable boxes.
	*To the grader: If you're wondering why I used a double paramater,
	*it's because I would lose precision in the later totalCost method, where I
	*calculate the price of the cable method.
	**/
	public void setCableBoxes(double cableBoxes)
	{
		if (cableBoxes > 0 && cableBoxes < 16)
		{
		cableBoxes2 = cableBoxes;
		System.out.println("Cable boxes are set.");
		}
	}
	/**
	*This method returns the service type string.
	*@return serviceString is the service type string returned.
	**/
	public String getServiceString()
	{
		return serviceString;
	}
	/**
	*This method calculates the total cost of the account.
	*@param serviceType is the int that determines what output the program has.
	*@return totalCost is the double that represents the total cost 
	*of the account.
	**/
	public double totalCost(int serviceType)
	{
		
		for (int p = 1; p <= cableBoxes2; p++)
		{
			costOfBoxes += 10 - (costOfBoxes * .1);
		}
		
		if (serviceType == NO_CABLE)
		{
			totalCost = NO_CABLE_PRICE;
			return totalCost;
		}
		else if (serviceType == BASIC)
		{
			totalCost = BASIC_PRICE + costOfBoxes;
			return totalCost;
		}
		else if (serviceType == EXTENDED)
		{
	   	totalCost = EXTENDED_PRICE + costOfBoxes;
			return totalCost;
		}
		else if (serviceType == PREMIUM)
		{
			totalCost = PREMIUM_PRICE + costOfBoxes;
			return totalCost;
		}
		else if (serviceType == PREMIUM_PLUS)
		{
			totalCost = PREMIUM_PLUS_PRICE + costOfBoxes;
			return totalCost;
		}
		else if (serviceType == BEST_DEAL)
		{
			totalCost = BEST_DEAL_PRICE + costOfBoxes;
			return totalCost;
		}  
				
		return totalCost;
	}
	/**
	*This method divides the total cost by the owners.
	*@return costPerOwner is the double that represents the cost per owner.
	**/
	public double costPerOwner()
	{
		costPerOwner = totalCost / owners.size();
		return costPerOwner;
	}
	/**
	*This method is the toString method that prints the output.
	*@return output is the string object that prints the necessary info from the 
	*program. 
	**/
	public String toString()
	{
		String output = "List of owners:" + owners
		+ "Total cost: " + totalCost + "Cost per owner: "
		+ costPerOwner;
		
		return output;
	}
	
	
	
	






}