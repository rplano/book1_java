import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: PigLatin
 * 
 * Translates an English sentence to a Pig Latin.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PigLatin extends ConsoleProgram {

	private final String vowels = "aeiou";

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String english = readLine("Enter English text: ");
		String pigLatin = translateFromEnglishToPigLatin(english.toLowerCase());
		println(pigLatin);
	}

	private String translateFromEnglishToPigLatin(String english) {
		String yodish = "";
		StringTokenizer st = new StringTokenizer(english);
		while (st.hasMoreTokens()) {
			yodish += translateWord(st.nextToken()) + " ";
		}
		return yodish;
	}

	private String translateWord(String word) {
		String pig = "";
		String firstChar = "" + word.charAt(0);
		if (vowels.contains(firstChar)) {
			pig = word + "ay";
		} else {
			pig = word.substring(1) + firstChar + "ay";
		}
		return pig;
	}

}
