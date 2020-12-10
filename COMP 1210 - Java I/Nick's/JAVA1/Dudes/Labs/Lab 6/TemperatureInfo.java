import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureInfo
{

public static void main(String[] args)
{

	ArrayList<Integer> tempList = new ArrayList<Integer>();
	Scanner userInput = new Scanner(System.in);
	
	int tempInput = -1;
	do {
		System.out.print("Enter a positive temperature (-1 to stop) : ");
		tempInput = userInput.nextInt();
		if (tempInput > 1) {
			tempList.add(tempInput);
		}
	} while (tempInput > -1);
	
	Temperatures temps = new Temperatures(tempList);
	System.out.println("Low: " + temps.getLowValue());
	System.out.println("High: " + temps.getHighValue());


}



}