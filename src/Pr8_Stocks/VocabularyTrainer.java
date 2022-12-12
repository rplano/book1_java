import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: VocabularyTrainer
 * 
 * Checks if you learned your vocabulary, and lists the words you did not know.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class VocabularyTrainer extends ConsoleProgram {

	private HashMap<String, String> vocabulary = new HashMap<String, String>();
	private ArrayList<String> unknownWords = new ArrayList<String>();

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		readWordsFromFile("Vocabulary.txt");
		doTraining();
		listUnknownWords();
	}

	private void listUnknownWords() {
		println("\nYou need to study these words:");
		for (String word : unknownWords) {
			println(word + ": " + vocabulary.get(word));
		}
	}

	private void doTraining() {
		for (String word : vocabulary.keySet()) {
			String correct = vocabulary.get(word).toLowerCase();
			String guess = readLine("What is the translation of " + word + "? ");
			if (guess.length() == 0)
				break;
			guess = guess.toLowerCase();
			if (guess.equals(correct)) {
				println("good job!");
			} else {
				println("sorry, not correct");
				unknownWords.add(word);
			}
		}
	}

	private void readWordsFromFile(String fileName) {
		BufferedReader rd;
		try {
			rd = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				// println(line);
				putWordsInHashMap(line);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void putWordsInHashMap(String line) {
		String[] words = line.split(",");
		vocabulary.put(words[0], words[1]);
	}

}
