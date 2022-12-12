import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Hangman
 * 
 * Implement the classic game of Hangman as a console program.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Hangman extends ConsoleProgram {
	private String guessWord;
	private String hintWord;

	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-24");

		println("Welcome to Hangman");

		guessWord = pickGuessWord();
		hintWord = createHintWord();

		// game loop
		int counter = 0;
		while (true) {
			counter++;
			println(hintWord);
			char c = readChar();
			if (guessWord.contains("" + c)) {
				buildNewHintWord(c);
			}
			if (!hintWord.contains("-"))
				break;
		}
		println(hintWord);
		println("It took you " + counter + " guesses");
	}

	private void buildNewHintWord(char c) {
		String temp = "";
		for (int i = 0; i < hintWord.length(); i++) {
			if (guessWord.charAt(i) == c) {
				temp += c;
			} else {
				temp += hintWord.charAt(i);
			}
		}
		hintWord = temp;
	}

	private char readChar() {
		while (true) {
			String w = readLine("Guess a character: ");
			if (w.length() > 0)
				return w.charAt(0);
		}
	}

	private String createHintWord() {
		String hintWord = "";
		for (int i = 0; i < guessWord.length(); i++) {
			hintWord += "-";
		}
		return hintWord;
	}

	private String pickGuessWord() {
		String[] words = { "dog", "fish", "chicken", "cat", "mother" };
		int index = rgen.nextInt(0, words.length - 1);
		return words[index];
	}
}
