import java.text.DecimalFormat;
import java.util.Arrays;

public class ScoresTester {

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#.000");

	
		int[] scores = {5, 4, 3, 2, 7, 10};
		
		Scores score = new Scores(scores);
			
		System.out.println(Arrays.toString(score.findEvens()));
		System.out.println(Arrays.toString(score.findOdds()));
		System.out.println(formatter.format(score.calculateAverage()));
		System.out.println(score.toString());
	}
}