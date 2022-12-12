import java.io.BufferedReader;
import java.io.FileReader;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Histogram
 * 
 * A console program that reads the scores of students from a file and displays
 * the result as a histogram.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Histogram extends ConsoleProgram {

	private int[] histogramData = new int[11];

	public void run() {
		setSize(400, 350);
		setFont("monospaced-18");

		readData();
		printHistogram();
	}

	private void readData() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("Scores.txt"));

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				int score = Integer.parseInt(line);
				putScoreInHistogram(score);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void putScoreInHistogram(int score) {
		histogramData[score / 10]++;
	}

	private void printHistogram() {
		for (int i = 0; i < histogramData.length-1; i++) {
			print("" + i + "0-" + i + "9: ");
			println(convertToStars(histogramData[i]));
		}
		print("100  : ");
		println(convertToStars(histogramData[histogramData.length-1]));
	}

	private String convertToStars(int i) {
		String stars = "";
		for (int j = 0; j < i; j++) {
			stars += "*";
		}
		return stars;
	}

}
