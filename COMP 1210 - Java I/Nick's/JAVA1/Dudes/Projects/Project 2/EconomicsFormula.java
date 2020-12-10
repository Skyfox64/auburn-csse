import java.util.Scanner;

/**
*
*calculates the midpoint elasticity between two items inputted by the user 
*that results in a percentage.
*
*@author Tyler Rabren
*@version 8/31/11
**/
public class EconomicsFormula
{
/**
*
*This program calculates the midpoint elasticity between two items whose 
*two values is determined via user input. The program takes the user input,
*puts it into the equation, and determines the midpoint elasticity
*
*@param args User-defined command line arguments (not used).
**/

public static void main(String [] args)
	{
	int initialPrice1 = 0;
	int initialPrice2 = 0;
	int finalPrice1 = 0;
	int finalPrice2 = 0;
	int midpointElasticity;
	Scanner userIn = new Scanner(System.in);
	
	System.out.print("The final price of "
	+ "item 1 (Price1final): "); finalPrice1 = userIn.nextInt();
	
	System.out.print("The inital price of "
	+ "item 1 (Price1initial): "); initialPrice2 = userIn.nextInt();
	
	System.out.print("\nThe final price of "
	+ "item 2 (Price1final: "); finalPrice2 = userIn.nextInt();
	
	System.out.print("The initial price of "
	+ "item 2 (Price1initial): "); initialPrice2 = userIn.nextInt();
	
	midpointElasticity = ((finalPrice1 - initialPrice1) 
	/ ((finalPrice1 + initialPrice1) / 2))
	 / ((finalPrice2 - initialPrice2) 
	 / ((finalPrice2 + initialPrice2) / 2));
	
	System.out.println("\nThe midpoint elasticity is "
	+ midpointElasticity + " %.");
	}
}