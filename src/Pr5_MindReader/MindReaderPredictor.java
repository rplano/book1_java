import java.util.HashMap;
import java.util.Map;

import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: MindReaderPredictor
 * 
 * This is the same program as the MindReader program but now uses AI to make
 * its predications.
 * 
 * Time series prediction; rudimentary AI technique in the flavor of case-based
 * reasoning based on maps. The program builds a "user profile" in making its
 * predictions. Until a sufficiently rich profile is built (in the map) it will
 * make random guesses.
 * 
 * The program builds a map capturing the users guessing pattern. The key of the
 * map is the last four guesses made by the user. The value is a count of the
 * number of times either heads or tails is picked by the user given a
 * particular pattern of last 4 guesses.
 * 
 * The user needs to pick either heads or tails. Before the user makes his/her
 * pick the program will make a prediction as to whether the user is going to
 * pick head or tail. The programs prediction is hidden from the user until he
 * makes his actual pick. Once the user makes his pick the programs prediction
 * is revealed. If the program correctly predicted the users pick it gets a
 * point otherwise if the program misses the user gets a point. Who ever
 * (program or user) gets 25 points first is deemed the winner.
 * 
 * @see: http://nifty.stanford.edu/2007/raja-mindreader/
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class MindReaderPredictor {
	private final int NUMBER_OF_GUESSES = 4;

	/** we want to remember the last four guesses of the user */
	private String lastGuesses = "";
	/** map that keeps track of all the old guesses of the user */
	private Map<String, HTCounter> guessingPattern = new HashMap<String, HTCounter>();

	private RandomGenerator rgen = new RandomGenerator();

	/**
	 * A simple data container for heads and tails counts.
	 * 
	 * @author ralph
	 */
	class HTCounter {
		public int heads;
		public int tails;
	}

	/**
	 * Constructor initializes data structures.
	 */
	public MindReaderPredictor() {
		lastGuesses = "";
		guessingPattern = new HashMap<String, HTCounter>();
	}

	/**
	 * Adds a new guess from the human to the map of previous guesses.
	 * 
	 * @param humanGuess
	 *            a char, either 'h' or 't' for head or tail.
	 */
	public void addNewGuess(char humanGuess) {
		lastGuesses += humanGuess;
		if (lastGuesses.length() > NUMBER_OF_GUESSES) {
			String key = lastGuesses.substring(0, NUMBER_OF_GUESSES);

			HTCounter counter = new HTCounter();
			if (guessingPattern.containsKey(key)) {
				counter = guessingPattern.get(key);
			}

			if (humanGuess == 'h') {
				counter.heads++;
			} else {
				counter.tails++;
			}
			guessingPattern.put(key, counter);

			// update lastGuesses
			lastGuesses = lastGuesses.substring(1);
		}
	}

	/**
	 * Return the prediction of the computer. If historical data is available
	 * return the most likely answer, if not return a random guess.
	 * 
	 * @return a char, either 'h' or 't' for head or tail.
	 */
	public char makePrediction() {
		// first check if we have history
		if (guessingPattern.containsKey(lastGuesses)) {
			return makeGuessBasedOnHistoricalData();
		} else {
			return makeRandomGuess();
		}
	}

	/**
	 * Looks in the map of what the answers of the user were in the past, and
	 * based on that returns the most likely answer.
	 * 
	 * @return a char, either 'h' or 't' for head or tail.
	 */
	private char makeGuessBasedOnHistoricalData() {
		HTCounter counter = guessingPattern.get(lastGuesses);
		if (counter.heads > counter.tails) {
			return 'h';
		} else {
			return 't';
		}
	}

	/**
	 * Returns randomly, either 'h' or 't'.
	 * 
	 * @return a char, either 'h' or 't' for head or tail.
	 */
	private char makeRandomGuess() {
		if (rgen.nextBoolean()) {
			return 'h';
		} else {
			return 't';
		}
	}
}
