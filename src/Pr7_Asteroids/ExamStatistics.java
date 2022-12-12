import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: ExamStatistics
 * 
 * A simple ConsoleProgram that lets the user enter exam scores and calculates
 * max, min, average.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ExamStatistics extends ConsoleProgram {

	private final int SENTINEL = -1;
	private final int MAX_SIZE = 100;
	private final int MAX_SCORE = 100;

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		int[] scores = new int[MAX_SIZE];

		println("Enter grades: ");
		int counter = 0;
		int max = 0;
		int min = MAX_SCORE;
		int sum = 0;
		while (true) {
			int score = readInt("?");
			if (score == SENTINEL)
				break;
			if (score > max)
				max = score;
			if (score < min)
				min = score;
			sum += score;
			scores[counter++] = score;
		}

		// statistics:
		println("Number of exams:" + counter);
		println("Lowest grade: " + min);
		println("Highest grade: " + max);
		println("Average: " + sum / counter);
	}
}
