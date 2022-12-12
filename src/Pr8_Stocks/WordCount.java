import java.io.BufferedReader;
import java.io.FileReader;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: WordCount
 * 
 * Reads a file and counts how many lines, words, and characters are in it.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class WordCount extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int counterLines = 0;
		int counterWords = 0;
		int counterChars = 0;

		BufferedReader rd;
		try {
			rd = new BufferedReader(new FileReader("Faust.txt"));

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;

				counterLines++;
				counterWords += countWords(line);
				counterChars += line.length();
			}
			rd.close();

			println("lines = " + counterLines);
			println("words = " + counterWords);
			println("chars = " + counterChars);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int countWords(String line) {
		String[] words = line.split(" ");
		return words.length;
	}
}
