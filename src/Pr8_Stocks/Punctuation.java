import java.io.BufferedReader;
import java.io.FileReader;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Punctuation
 * 
 * A console program displaying punctuation as a histogram. Can be used to
 * identify language and or authorship.
 * 
 * @see Charting Literary Classics’ Punctuation, From Austen to Twain,
 *      www.wired.com/2016/02/charting-punctuation-usage-in-literary-classics/
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Punctuation extends ConsoleProgram {
	private String punctuation = ";:'\",!?.";

	private int[] histogramData = new int[punctuation.length()];
	private int totalNrOfPunctuations = 0;
	private String fileName;

	public void run() {
		setSize(400, 350);
		setFont("monospaced-18");

		fileName = readLine("Enter file to analyze: ");
		readData();
		printHistogram();
	}

	private void readData() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				analyzeForPunctuation(line);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void analyzeForPunctuation(String line) {
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (punctuation.contains("" + c)) {
				int index = punctuation.indexOf(c);
				histogramData[index]++;
				totalNrOfPunctuations++;
			}
		}
	}

	private void printHistogram() {
		println();
		for (int i = 0; i < histogramData.length; i++) {
			print("" + punctuation.charAt(i) + ": ");
			int nrOfStars = histogramData[i] * 50 / totalNrOfPunctuations;
			println(convertToStars(nrOfStars));
		}
	}

	private String convertToStars(int i) {
		String stars = "";
		for (int j = 0; j < i; j++) {
			stars += "*";
		}
		return stars;
	}

}
