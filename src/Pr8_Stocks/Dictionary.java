import java.util.HashMap;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Dictionary
 * 
 * A German-English dictionary with 3 word pairs.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Dictionary extends ConsoleProgram {

	private HashMap<String, String> dictionary = new HashMap<String, String>();

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");
		
		initialzeDictionary();

		while (true) {
			String german = readLine("Enter german word: ");
			String english = dictionary.get(german.toLowerCase());
			println(english);
		}
	}

	private void initialzeDictionary() {
		dictionary.put("hund", "dog");
		dictionary.put("katze", "cat");
		dictionary.put("fisch", "fish");
	}
}