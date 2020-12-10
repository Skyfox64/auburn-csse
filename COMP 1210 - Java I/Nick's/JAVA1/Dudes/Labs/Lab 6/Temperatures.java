import java.util.ArrayList;

public class Temperatures
{
	
	ArrayList<Integer> temperatures = new ArrayList<Integer>();
	
	public Temperatures(ArrayList<Integer> temperaturesIn)
	{
	temperatures = temperaturesIn;
	}

	public int getLowValue()
	{
		int low = temperatures.get(0);
		if(temperatures.isEmpty()) {
		return 0;
		}
		for (int i = 0; i < temperatures.size(); i++) {
			if (temperatures.get(i) < low) {
				low = temperatures.get(i);
			}
		}
		return low;
	}
	
	public int getHighValue()
	{
		if(temperatures.isEmpty()) {
			return 0;
		}
		
		int high = temperatures.get(0);
		for (Integer currentTemp : temperatures) { // read as " finds the integer current temp that belongs to the Integer class in the array list temperatures.
			if (currentTemp > high) {
				high = currentTemp;
			}
		}
		return high;
	}
	
	public int lowerMinimum(int lowIn)
	{
		return lowIn < getLowValue() ? lowIn : getLowValue();
	}
	
	public int HigherMaximum(int highIn)
	{
		return highIn > getHighValue() ? highIn : getHighValue();
	}
	
	public String toString()
	{
		return "Low: " + getLowValue()
			+ "\r\rHigh: " + getHighValue();
	}

}