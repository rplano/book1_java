import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Abjad
 * 
 * Remove all vowels from a string.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Abjad extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");
		
		String originalText = readLine("Enter text: ");
		String consonantText = removeVowels(originalText);
		println(consonantText);
	}

	private String removeVowels(String originalText) {
		String temp = "";
		for (int i = 0; i < originalText.length(); i++) {
			char c = originalText.charAt(i);
			if (!isVowel(c)) {
				temp += c;
			}
		}
		return temp;
	}

	private boolean isVowel(char c) {
		switch (Character.toLowerCase(c)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
		}
	}
}
