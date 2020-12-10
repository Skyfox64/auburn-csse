import java.util.Scanner;

public class AgeStatistics {

	public static void main(String[] args)
	{
	String name;
	int ageInYears;
	int gender = 0; // 1 for female
	double maxHeartRate = 0;
	
	Scanner userInput = new Scanner(System.in);
	
	System.out.print("Enter your name: ");
	name = userInput.nextLine();
	
	System.out.print("Enter your age in years: ");
	ageInYears = userInput.nextInt();
	
	System.out.print("Enter your gender (1 for female, 0 for male): ");
	gender = userInput.nextInt();
	
	// convert age
	System.out.println("\t Your age in minutes is "
		+ ageInYears * 525600 + " minutes.");
	System.out.println("\t Your age in centuries is "
		+ (double)19 / 100 + " centuries.");

	// display max heart rate
	System.out.print("Your max heart rate is: ");
	
	if (gender == 1) {
	maxHeartRate = 209 - (0.7 * ageInYears);
	}
	else {
	maxHeartRate = 214 - (0.8 *ageInYears);
	}
	System.out.println(maxHeartRate + " beats per minute.");
	}
}