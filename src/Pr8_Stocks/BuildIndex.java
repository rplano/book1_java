import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: BuildIndex
 * 
 * Reads a text file and counts unique words, after filtering by length, ending
 * and plural. Writes result to a csv file.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class BuildIndex extends ConsoleProgram {

	private Map<String, Integer> words = new TreeMap<String, Integer>();

	public void run() {
		setSize(400, 200);
		setFont("monospaced-18");

		readTextAndBuildIndex();
		writeIndexToCSV();
	}

	private void writeIndexToCSV() {
		try {
			FileWriter fw = new FileWriter("Index.csv");
			for (String word : words.keySet()) {
				int count = words.get(word);
				fw.write(word + "," + count + "\n");
				println(word + "," + count);
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readTextAndBuildIndex() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("TomSawyer.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,
						"[]\"',;:.!?()-/ \t\n\r\f");
				while (st.hasMoreTokens()) {
					String word = st.nextToken();
					word = word.toLowerCase();
					word = filterStringsLessThan(word, 8);
					word = filterBadEndings(word);
					word = filterPlural(word);
					addWordToHashMap(word);
				}
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String filterPlural(String word) {
		if (word != null) {
			if (word.endsWith("s")) {
				word = word.substring(0, word.length() - 1);
			}
			return word;
		}
		return null;
	}

	// private String[] badEndings = { "ly", "ial", "ive", "ous", "ed" };
	private String filterBadEndings(String word) {
		if (word != null) {
			String w = word.toLowerCase();
			if (!w.endsWith("ly") && !w.endsWith("ial") && !w.endsWith("ive")
					&& !w.endsWith("ous") && !w.endsWith("ed")) {
				return word;
			}
		}
		return null;
	}

	private String filterStringsLessThan(String word, int len) {
		if (word != null && word.length() >= len) {
			return word;
		}
		return null;
	}

	private void addWordToHashMap(String word) {
		if (word != null) {
			if (words.containsKey(word)) {
				int count = words.get(word);
				words.put(word, ++count);
			} else {
				words.put(word, 1);
			}
		}
	}
}
