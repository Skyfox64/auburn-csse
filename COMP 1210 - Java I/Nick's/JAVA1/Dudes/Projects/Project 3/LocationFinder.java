import java.util.Scanner;
import java.text.NumberFormat;
/**
*
*This program allows the user to give x and y coordinates
*for their location and a target location, the speed at
*which they are travelling, and the name of the location.
*The program will print the distance between the user and their
*location, the angle at which they need to turn to get to their
*location (based on the x-axis), and their estimated ETA.
*
*@author Tyler Rabren
*@version 9/7/11
**/
public class LocationFinder
{

/**
*
*This class uses their starting point and their ending
*point and tells the user the distance between the points.
*It also takes the speed, which is inputted by the user,
*and tells the estimated ETA and the angle at which they need to
*turn to.
*
*
*@param args User-defined command line arguments (not used).
**/
	public static void main(String[] args)
	{
	
	double distance;
	double x1 = 0;
	double x2 = 0; 
	double y1 = 0;
	double y2 = 0;
	double theta;
	String targetName = "";
	double speed = 0;
	double estimatedTA;
	
	Scanner userInput = new Scanner(System.in);
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Current location coordinates:");
	
	System.out.print("\tx1 = ");
	x1 = Double.parseDouble(scan.nextLine());
	
	System.out.print("\ty1 = ");
	y1 = Double.parseDouble(scan.nextLine());
	
	System.out.println("Target location coordinates:");
	
	System.out.print("\tx2 = ");
	x2 = Double.parseDouble(scan.nextLine());
	
	System.out.print("\ty2 = ");
	y2 = Double.parseDouble(scan.nextLine());
	
	System.out.print("Speed: ");
	speed = Double.parseDouble(scan.nextLine());
	
	System.out.print("Target location name: ");
	targetName = userInput.nextLine();
	
	distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	
	theta = Math.atan2((y2 - y1), (x2 - x1));
	
	estimatedTA = distance / speed;
	
	System.out.println("Distance to " + targetName + ": " + distance);
	System.out.println("Angle to turn: " 
	+ NumberFormat.getInstance().format(theta));
	
	System.out.println("Estimated time until arrival: " 
	+  NumberFormat.getInstance().format(estimatedTA));
	}
}
