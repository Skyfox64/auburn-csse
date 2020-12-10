import java.util.Scanner;

/**
*
*calculates the volume of the box, the amount of peanuts it needs, and
*the amount of material needed.
*
*@author Tyler Rabren
*@version 9/4/2011
*
**/

public class GiftBoxes
/**
*
*calculates the volume of the box, the amount of peanuts it needs, and
*the amount of material needed.
*
*@param args User-defined command line arguments (not used).
**/
{
	public static void main(String [] args)
	
	{
	double length = 0;
	double width = 0;
	double height = 0;
	double volumeGift = 0;
	double volumeBox = 0;
	double material = 0;
	double peanuts = 0;
	Scanner userIn = new Scanner(System.in);
	
	System.out.print("The length of the box in inches: "); 
	length = userIn.nextInt();
	System.out.print("The width of the box in inches: "); 
	width = userIn.nextInt();
	System.out.print("The height of the box in inches: "); 
	height = userIn.nextInt();
	System.out.print("The volume of the gift in cubic inches: "); 
	volumeGift = userIn.nextInt();
	
	
	material = (2 * length * width + 2 * height * width + 2 * length * height);
	
	volumeBox = (length * width * height);
	
	peanuts = (volumeBox - volumeGift);
	
	if (volumeGift <= volumeBox) {
	System.out.println("\nThe amount of material needed for the "
	+ "box is " + material + " square inches."); 
	System.out.println("The volume of the box is " + volumeBox 
	+ " cubic inches.");
	System.out.println("The box will need " + peanuts +  " cubic"
	+ " inches of \"peanuts\" for shipping.");
	System.out.println("");
	}
	
	else {
	System.out.println("\nThe gift is too large for the box.");
	}
	
	}
}
	