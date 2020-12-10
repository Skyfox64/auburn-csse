
public class Division
{
	
	
	public static int intDivide(int numerator, int denominator)
	{
		try
		{
			return numerator / denominator;
		}
		catch (ArithmeticException error)
		{
			return 0;
		}
	
	}
	
	public static double decimalDivide(int numerator, int denominator)
	{
		if (denominator == 0)
		{
			throw new IllegalArgumentException("The denominator "
				+ "cannot be zero.");
		}	
		return (double) numerator / denominator;
	}




}