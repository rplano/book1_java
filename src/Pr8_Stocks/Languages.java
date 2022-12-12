import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Language
 * 
 * Translates from English into 14 languages.
 * 
 * @see http://introcs.cs.princeton.edu/java/data/
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Languages extends ConsoleProgram {

	private ArrayList<String> languages;
	private Map<String, List<String>> dictionary = new TreeMap<String, List<String>>();

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");
		readDictionaryFromFile();

		printLanguages();
		int lang = readInt("Enter language: ");
		while (true) {
			String english = readLine("Enter English word: ");
			if (english.length() == 0)
				break;
			String word = translate(english.toLowerCase(), lang);
			println(word);
		}

		println("Done.");
	}

	private String translate(String english, int lang) {
		List<String> words = dictionary.get(english);
		if (words != null) {
			return words.get(lang);
		}
		return null;
	}

	private void printLanguages() {
		for (int i = 0; i < languages.size(); i++) {
			print("" + i + ": " + languages.get(i) + ", ");
		}
		println();
	}

	private void readDictionaryFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"Languages.csv"));

			// first line contains languages:
			String languageLine = br.readLine();
			languages = parseLine(languageLine);

			// next lines contain word tuplets:
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				ArrayList<String> translations = parseLine(line);
				dictionary.put(translations.get(0), translations);
			}

			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<String> parseLine(String line) {
		ArrayList<String> translations = new ArrayList<String>();
		while (true) {
			int begin = line.indexOf("\"");
			if (begin < 0)
				break;
			int end = line.indexOf("\"", begin + 1);
			if (end < 0) {
				System.out.println("***** this should never happen! *****");
			}
			String s = line.substring(begin + 1, end);
			line = line.substring(end + 1);
			translations.add(s);
		}
		return translations;
	}

}
