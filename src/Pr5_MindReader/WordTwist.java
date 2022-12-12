import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: WordTwist
 * 
 * Take a word, switch some of the letters and let the user guess the original
 * word. Like anagram.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class WordTwist extends ConsoleProgram {

	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int score = 0;
		while (true) {
			String originalWord = pickGuessWord();
			String scrambledWord = scrambleWord(originalWord);
			println(scrambledWord);
			String guess = readLine("Your guess: ");
			if (guess.length() == 0)
				break;
			if (guess.equals(originalWord)) {
				println("correct");
				score++;
			} else {
				println("incorrect");
			}
		}
		println("Your score is: " + score);
	}

	private String scrambleWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			word = randomSwap(word);
		}
		return word;
	}

	private String randomSwap(String word) {
		int i = rgen.nextInt(0, word.length() - 2);
		int j = rgen.nextInt(i + 1, word.length() - 1);
		char ci = word.charAt(i);
		char cj = word.charAt(j);
		String scrWord = word.substring(0, i) + cj + word.substring(i + 1, j)
				+ ci + word.substring(j + 1);
		return scrWord;
	}

	private String randomSwap2(String word) {
		int i = rgen.nextInt(0, word.length() - 1);
		int j = rgen.nextInt(0, word.length() - 1);
		char[] chars = word.toCharArray();
		char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
		word = new String(chars);
		return word;
	}

	private String pickGuessWord() {
		String[] words = { "dog", "fish", "chicken", "cat", "mother" };
		int index = rgen.nextInt(0, words.length - 1);
		return words[index];
	}
}
