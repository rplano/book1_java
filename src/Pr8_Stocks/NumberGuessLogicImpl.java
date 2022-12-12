import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: NumberGuessLogicImpl
 * 
 * This class implements the NumberGuessLogic interface.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class NumberGuessLogicImpl implements NumberGuessLogic {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int number = rgen.nextInt(0, 99);

	/**
	 * guess should be number between 0 and 99 return 0 if guess was correct
	 * return +1 if guess was higher return -1 if guess was lower
	 * 
	 * @param guess
	 * @return
	 */
	public int makeGuess(int guess) {
		if (guess == number) {
			return 0;
		}
		if (guess > number) {
			return +1;
		} else {
			return -1;
		}
	}

}
