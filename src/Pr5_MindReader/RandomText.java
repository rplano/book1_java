import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: RandomText
 * 
 * Creates a text out of random words.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class RandomText extends ConsoleProgram {

	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String sentence = createRandomSentence();
		println(sentence);
	}

	private String createRandomSentence() {
		String sentence = "";
		int nrOfWordsInSentence = rgen.nextInt(2, 5);
		for (int i = 0; i < nrOfWordsInSentence; i++) {
			sentence += createRandomWord() + " ";
		}
		sentence += createRandomWord() + ".";
		return sentence;
	}

	private String createRandomWord() {
		String word = "";
		int nrOfCharsInWord = rgen.nextInt(3, 8);
		for (int i = 0; i < nrOfCharsInWord; i++) {
			word += (char)('a' + rgen.nextInt(26));
		}
		return word;
	}

}
